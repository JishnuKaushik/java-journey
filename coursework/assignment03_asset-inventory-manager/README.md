# Assignment 3 - Asset Inventory Manager (Collections & Generics)

Name: Jishnu Kaushik
Course: CSL215 Intro to Java

## Files

| File | What it has |
|---|---|
| Asset.java | abstract base class (id, name, purchaseDate, cost, tags) |
| HardwareAsset.java | hardware asset, unique key = serial number |
| SoftwareAsset.java | software asset, unique key = license key, seats, expiry date |
| AssetManager.java | generic manager `AssetManager<T extends Asset>` that stores and indexes assets |
| Main.java | test harness, runs all features and prints PASS/FAIL for each check |

## How to run

Needs JDK 8 or later. No external libraries.

From command line (cmd / PowerShell), inside this folder:

```
javac *.java
java Main
```

In IntelliJ / VS Code: put all .java files in the src folder (default package) and run `Main`.

## Design

- `Asset` is abstract. Every asset has a unique `id` and a unique `key` (serial number for hardware, license key for software).
- `equals()` and `hashCode()` use only the id, and `compareTo()` compares ids, so sets and sorted sets treat two assets with the same id as the same asset.
- `AssetManager<T extends Asset>` is generic so the same class works as a mixed inventory (`AssetManager<Asset>`) or as a type safe one (`AssetManager<HardwareAsset>`, `AssetManager<SoftwareAsset>`). With the typed ones, `findById()` gives back a `HardwareAsset` directly and `removeIf(s -> s.isExpired(today))` works without any casting.
- Operations: add, remove, removeIf, update, findById, searchByName, findByType, findByTag, filter, listAll, sortedById, sortedBy(comparator), allTags, groupBy, countByType, totalCost, boughtBefore, getHistory.

## Why these collections

| Where | Collection | Why |
|---|---|---|
| main store (id -> asset) | `LinkedHashMap<String, T>` | O(1) lookup by id and it also keeps insertion order, so listing all assets comes out in the order they were added |
| type index (type -> assets) | `HashMap<String, List<T>>` | O(1) to get all assets of one type, order of types does not matter |
| assets inside each type bucket, and all returned results | `ArrayList<T>` | fast add at end, fast index access, easy to sort with `list.sort()` |
| unique serial / license keys | `HashSet<String>` | O(1) contains check, used for duplicate prevention |
| tags of one asset | `HashSet<String>` | no duplicate tags, O(1) `hasTag()` |
| sorted listing by id | `TreeSet<T>` | keeps assets sorted by natural order (id) and no duplicates |
| all distinct tags | `TreeSet<String>` | removes duplicate tags and gives them in alphabetical order |
| recent activity log | `LinkedList<String>` | `addLast()` and `removeFirst()` are both O(1), log keeps only the last 10 entries |
| group by any key | `LinkedHashMap<K, List<T>>` | groups come out in the order they were first seen |

`countByType()` uses `Collectors.groupingBy` with a `TreeMap` just so the counts print in sorted order.

## Generics used

- bounded type parameter: `AssetManager<T extends Asset>`
- `Predicate<? super T>` in `filter()` and `removeIf()`, and `Comparator<? super T>` in `sortedBy()`, so a `Comparator<Asset>` can be reused for an `AssetManager<HardwareAsset>` (done in Main section 8)
- generic method: `<K> Map<K, List<T>> groupBy(Function<? super T, ? extends K> keyFn)`, used in Main to group by purchase year
- `Optional<T>` from `findById()` instead of returning null

## Iteration used

- explicit `Iterator` with `it.remove()`: `AssetManager.remove()` (removing from the type list) and `AssetManager.removeIf()` (removing from the map values while looping)
- enhanced for loop: `searchByName()`, `allTags()`, `groupBy()`, and printing in Main
- streams: `findByTag()`, `filter()`, `countByType()`, `totalCost()`, `boughtBefore()` (through filter), and the top 3 costliest / group by year report in Main

## Duplicate prevention

`add()` rejects an asset if:
1. the id already exists (checked with `containsKey` on the LinkedHashMap), or
2. the serial number / license key already exists (checked with the HashSet of keys).

When an asset is removed its key is also removed from the HashSet, so the same serial number can be added again later (tested in Main section 6).

## Time complexity

n = total assets, k = assets of one type, m = number of results, L = length of name

| Operation | Time | Reason |
|---|---|---|
| add | O(1) average | HashMap/HashSet checks and put are O(1), ArrayList add is amortized O(1) |
| findById | O(1) average | LinkedHashMap get |
| update | O(1) average | find by id then change fields |
| remove(id) | O(k) | map and set removal is O(1), but finding and removing from the ArrayList of that type is O(k) |
| removeIf | O(n + r*k) | one pass over all assets, each of the r removals also removes from a type list |
| searchByName | O(n * L) | has to check every name |
| findByType | O(k) | direct bucket lookup, then copy the list |
| findByTag | O(n) | stream over all assets, tag check is O(1) because tags are a HashSet |
| filter / boughtBefore | O(n) | stream over all assets |
| listAll | O(n) | copy into ArrayList |
| sortedById | O(n log n) | building a TreeSet |
| sortedBy(comparator) | O(n log n) | ArrayList sort |
| allTags | O(t log g) | t = total tags of all assets, g = distinct tags in TreeSet |
| groupBy / totalCost | O(n) | one pass |
| countByType | O(n) | one pass, only a few types in the TreeMap |
| log activity | O(1) | LinkedList addLast / removeFirst |

### Trade-offs

- LinkedHashMap uses a bit more memory than HashMap (it keeps a linked list of entries) but gives a stable listing order for free. A TreeMap would keep things sorted by id all the time but get/put would be O(log n) instead of O(1).
- The sorted TreeSet is built only when `sortedById()` is called (O(n log n)) instead of being kept updated all the time, so add and remove stay O(1)/O(k).
- The type index makes `findByType()` fast but `remove()` now costs O(k) because of the ArrayList. A LinkedList would not help here because it still needs O(k) to find the element.
- There is no separate tag index, so `findByTag()` is O(n). A `HashMap<String, Set<String>>` from tag to ids would make it O(m), but then every add/remove would need to update it and it uses more memory. For a small inventory a scan is fine.
- Every extra index (type map, key set) uses extra memory and has to be kept in sync on add/remove, which is done inside `add()`, `remove()` and `removeIf()`.

## Testing

`Main.java` is the test harness. It checks:
- adding 8 assets
- duplicate id, duplicate serial and duplicate license key are rejected
- search by id, name, tag, type
- update (and update of a missing id fails)
- listing in insertion order, sorted by id (TreeSet), by cost, by purchase date
- remove (and remove of a missing id fails), serial can be reused after remove
- stream reports (count by type, total value, bought before 2023, top 3, group by year)
- type safe `AssetManager<HardwareAsset>` and `AssetManager<SoftwareAsset>`, removing expired licenses with removeIf
- recent activity log keeping only the last 10 entries

Result: 33/33 checks passed. The "today" date is fixed at 2026-10-12 in Main so the expiry results are always the same.

## Sample run

```
> javac *.java
> java Main
===== 1. ADD ASSETS =====
[PASS] add H101
[PASS] add H102
[PASS] add H103
[PASS] add H104
[PASS] add S201
[PASS] add S202
[PASS] add S203
[PASS] add S204
[PASS] size is 8

===== 2. DUPLICATE PREVENTION =====
[PASS] same id H101 rejected
[PASS] same serial DL5440-8821 rejected
[PASS] same license ADPS-5520-QW rejected
[PASS] size still 8

===== 3. SEARCH =====
[PASS] findById H103 found
[PASS] findById X999 not found

--- searchByName("thinkpad") (1) ---
  H103  HARDWARE  Lenovo ThinkPad E14                LNE14-4410         65000.00  2023-11-20  [dev, laptop]
[PASS] 1 result for thinkpad

--- findByTag("office") (4) ---
  H101  HARDWARE  Dell Latitude 5440                 DL5440-8821        72000.00  2024-03-15  [laptop, office]
  H102  HARDWARE  HP LaserJet Pro M404               HPM404-1130        21500.00  2022-07-01  [office, printer]
  S201  SOFTWARE  Microsoft 365 Business             MS365-AQ1-77X2    160000.00  2024-01-01  [office, subscription]
  S204  SOFTWARE  Zoom Pro                           ZM-PRO-3391        30000.00  2025-07-01  [office, subscription]
[PASS] 4 assets tagged office

--- findByType("software") (4) ---
  S201  SOFTWARE  Microsoft 365 Business             MS365-AQ1-77X2    160000.00  2024-01-01  [office, subscription]
  S202  SOFTWARE  IntelliJ IDEA Ultimate             JB-IDEA-7781       85000.00  2025-02-10  [dev, ide]
  S203  SOFTWARE  Adobe Photoshop                    ADPS-5520-QW       60000.00  2023-06-15  [design]
  S204  SOFTWARE  Zoom Pro                           ZM-PRO-3391        30000.00  2025-07-01  [office, subscription]
[PASS] 4 software assets

===== 4. UPDATE =====
[PASS] update H103
[PASS] new name saved
[PASS] new cost saved
[PASS] update of missing id fails

===== 5. LISTING / SORTING =====

--- All assets (insertion order) (8) ---
  H101  HARDWARE  Dell Latitude 5440                 DL5440-8821        72000.00  2024-03-15  [laptop, office]
  H102  HARDWARE  HP LaserJet Pro M404               HPM404-1130        21500.00  2022-07-01  [office, printer]
  H103  HARDWARE  Lenovo ThinkPad E14 Gen 5          LNE14-4410         67500.00  2023-11-20  [dev, laptop]
  H104  HARDWARE  Cisco Catalyst 1000                CSC1000-0912       48000.00  2021-05-10  [network]
  S201  SOFTWARE  Microsoft 365 Business             MS365-AQ1-77X2    160000.00  2024-01-01  [office, subscription]
  S202  SOFTWARE  IntelliJ IDEA Ultimate             JB-IDEA-7781       85000.00  2025-02-10  [dev, ide]
  S203  SOFTWARE  Adobe Photoshop                    ADPS-5520-QW       60000.00  2023-06-15  [design]
  S204  SOFTWARE  Zoom Pro                           ZM-PRO-3391        30000.00  2025-07-01  [office, subscription]

--- Sorted by id (TreeSet) (8) ---
  H101  HARDWARE  Dell Latitude 5440                 DL5440-8821        72000.00  2024-03-15  [laptop, office]
  H102  HARDWARE  HP LaserJet Pro M404               HPM404-1130        21500.00  2022-07-01  [office, printer]
  H103  HARDWARE  Lenovo ThinkPad E14 Gen 5          LNE14-4410         67500.00  2023-11-20  [dev, laptop]
  H104  HARDWARE  Cisco Catalyst 1000                CSC1000-0912       48000.00  2021-05-10  [network]
  S201  SOFTWARE  Microsoft 365 Business             MS365-AQ1-77X2    160000.00  2024-01-01  [office, subscription]
  S202  SOFTWARE  IntelliJ IDEA Ultimate             JB-IDEA-7781       85000.00  2025-02-10  [dev, ide]
  S203  SOFTWARE  Adobe Photoshop                    ADPS-5520-QW       60000.00  2023-06-15  [design]
  S204  SOFTWARE  Zoom Pro                           ZM-PRO-3391        30000.00  2025-07-01  [office, subscription]

--- Sorted by cost high to low (8) ---
  S201  SOFTWARE  Microsoft 365 Business             MS365-AQ1-77X2    160000.00  2024-01-01  [office, subscription]
  S202  SOFTWARE  IntelliJ IDEA Ultimate             JB-IDEA-7781       85000.00  2025-02-10  [dev, ide]
  H101  HARDWARE  Dell Latitude 5440                 DL5440-8821        72000.00  2024-03-15  [laptop, office]
  H103  HARDWARE  Lenovo ThinkPad E14 Gen 5          LNE14-4410         67500.00  2023-11-20  [dev, laptop]
  S203  SOFTWARE  Adobe Photoshop                    ADPS-5520-QW       60000.00  2023-06-15  [design]
  H104  HARDWARE  Cisco Catalyst 1000                CSC1000-0912       48000.00  2021-05-10  [network]
  S204  SOFTWARE  Zoom Pro                           ZM-PRO-3391        30000.00  2025-07-01  [office, subscription]
  H102  HARDWARE  HP LaserJet Pro M404               HPM404-1130        21500.00  2022-07-01  [office, printer]

--- Sorted by purchase date (8) ---
  H104  HARDWARE  Cisco Catalyst 1000                CSC1000-0912       48000.00  2021-05-10  [network]
  H102  HARDWARE  HP LaserJet Pro M404               HPM404-1130        21500.00  2022-07-01  [office, printer]
  S203  SOFTWARE  Adobe Photoshop                    ADPS-5520-QW       60000.00  2023-06-15  [design]
  H103  HARDWARE  Lenovo ThinkPad E14 Gen 5          LNE14-4410         67500.00  2023-11-20  [dev, laptop]
  S201  SOFTWARE  Microsoft 365 Business             MS365-AQ1-77X2    160000.00  2024-01-01  [office, subscription]
  H101  HARDWARE  Dell Latitude 5440                 DL5440-8821        72000.00  2024-03-15  [laptop, office]
  S202  SOFTWARE  IntelliJ IDEA Ultimate             JB-IDEA-7781       85000.00  2025-02-10  [dev, ide]
  S204  SOFTWARE  Zoom Pro                           ZM-PRO-3391        30000.00  2025-07-01  [office, subscription]

All tags (TreeSet): [design, dev, ide, laptop, network, office, printer, subscription]
[PASS] first in TreeSet is H101
[PASS] costliest is S201

===== 6. REMOVE =====
[PASS] remove H104
[PASS] H104 not found after remove
[PASS] remove missing id fails
[PASS] serial of removed H104 can be reused
[PASS] size is 8

===== 7. STREAM REPORTS =====
Count by type: {HARDWARE=4, SOFTWARE=4}
Total value: 545000.00

--- Bought before 2023 (1) ---
  H102  HARDWARE  HP LaserJet Pro M404               HPM404-1130        21500.00  2022-07-01  [office, printer]

Top 3 costliest: [Microsoft 365 Business (160000), IntelliJ IDEA Ultimate (85000), Dell Latitude 5440 (72000)]
Grouped by purchase year:
  2024 -> [H101, S201]
  2022 -> [H102]
  2023 -> [H103, S203]
  2025 -> [S202, S204]
  2026 -> [H105]
[PASS] totalCost is correct

===== 8. TYPE SAFE MANAGERS (GENERICS) =====
Brand of H101 (no cast needed): Dell

--- Laptops in hardware manager (2) ---
  H101  HARDWARE  Dell Latitude 5440                 DL5440-8821        72000.00  2024-03-15  [laptop, office]
  H103  HARDWARE  Lenovo ThinkPad E14 Gen 5          LNE14-4410         67500.00  2023-11-20  [dev, laptop]
[PASS] 2 laptops

--- Hardware sorted by cost (same Comparator<Asset> reused) (3) ---
  H102  HARDWARE  HP LaserJet Pro M404               HPM404-1130        21500.00  2022-07-01  [office, printer]
  H103  HARDWARE  Lenovo ThinkPad E14 Gen 5          LNE14-4410         67500.00  2023-11-20  [dev, laptop]
  H101  HARDWARE  Dell Latitude 5440                 DL5440-8821        72000.00  2024-03-15  [laptop, office]
[PASS] 2 expired licenses removed

--- Active licenses (2) ---
  S202  SOFTWARE  IntelliJ IDEA Ultimate             JB-IDEA-7781       85000.00  2025-02-10  [dev, ide]
  S203  SOFTWARE  Adobe Photoshop                    ADPS-5520-QW       60000.00  2023-06-15  [design]
Total active seats: 13
[PASS] 13 active seats

===== 9. RECENT ACTIVITY (LinkedList, last 10) =====
  ADDED S203
  ADDED S204
  REJECTED duplicate id H101
  REJECTED duplicate serial/license DL5440-8821
  REJECTED duplicate serial/license ADPS-5520-QW
  UPDATED H103
  UPDATE failed, no asset H999
  REMOVED H104
  REMOVE failed, no asset H999
  ADDED H105

Tests passed: 33/33
```
