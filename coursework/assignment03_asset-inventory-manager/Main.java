import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    static int passed = 0;
    static int total = 0;

    static void check(String what, boolean ok) {
        total++;
        if (ok) {
            passed++;
        }
        System.out.println((ok ? "[PASS] " : "[FAIL] ") + what);
    }

    static void show(String title, Collection<? extends Asset> list) {
        System.out.println();
        System.out.println("--- " + title + " (" + list.size() + ") ---");
        for (Asset a : list) {
            System.out.println("  " + a);
        }
    }

    public static void main(String[] args) {
        LocalDate today = LocalDate.of(2026, 10, 12);
        AssetManager<Asset> inv = new AssetManager<>();

        HardwareAsset h1 = new HardwareAsset("H101", "Dell Latitude 5440", "DL5440-8821", "Dell",
                LocalDate.of(2024, 3, 15), 72000, "laptop", "office");
        HardwareAsset h2 = new HardwareAsset("H102", "HP LaserJet Pro M404", "HPM404-1130", "HP",
                LocalDate.of(2022, 7, 1), 21500, "printer", "office");
        HardwareAsset h3 = new HardwareAsset("H103", "Lenovo ThinkPad E14", "LNE14-4410", "Lenovo",
                LocalDate.of(2023, 11, 20), 65000, "laptop", "dev");
        HardwareAsset h4 = new HardwareAsset("H104", "Cisco Catalyst 1000", "CSC1000-0912", "Cisco",
                LocalDate.of(2021, 5, 10), 48000, "network");
        SoftwareAsset s1 = new SoftwareAsset("S201", "Microsoft 365 Business", "MS365-AQ1-77X2", 25,
                LocalDate.of(2024, 1, 1), LocalDate.of(2025, 12, 31), 160000, "office", "subscription");
        SoftwareAsset s2 = new SoftwareAsset("S202", "IntelliJ IDEA Ultimate", "JB-IDEA-7781", 10,
                LocalDate.of(2025, 2, 10), LocalDate.of(2027, 2, 9), 85000, "dev", "ide");
        SoftwareAsset s3 = new SoftwareAsset("S203", "Adobe Photoshop", "ADPS-5520-QW", 3,
                LocalDate.of(2023, 6, 15), LocalDate.of(2027, 6, 14), 60000, "design");
        SoftwareAsset s4 = new SoftwareAsset("S204", "Zoom Pro", "ZM-PRO-3391", 15,
                LocalDate.of(2025, 7, 1), LocalDate.of(2026, 6, 30), 30000, "office", "subscription");

        System.out.println("===== 1. ADD ASSETS =====");
        check("add H101", inv.add(h1));
        check("add H102", inv.add(h2));
        check("add H103", inv.add(h3));
        check("add H104", inv.add(h4));
        check("add S201", inv.add(s1));
        check("add S202", inv.add(s2));
        check("add S203", inv.add(s3));
        check("add S204", inv.add(s4));
        check("size is 8", inv.size() == 8);

        System.out.println("\n===== 2. DUPLICATE PREVENTION =====");
        check("same id H101 rejected",
                !inv.add(new HardwareAsset("H101", "Asus Vivobook", "AS-0001", "Asus", today, 50000)));
        check("same serial DL5440-8821 rejected",
                !inv.add(new HardwareAsset("H105", "Dell Latitude copy", "DL5440-8821", "Dell", today, 72000)));
        check("same license ADPS-5520-QW rejected",
                !inv.add(new SoftwareAsset("S205", "Photoshop again", "ADPS-5520-QW", 1, today, today.plusYears(1), 20000)));
        check("size still 8", inv.size() == 8);

        System.out.println("\n===== 3. SEARCH =====");
        check("findById H103 found", inv.findById("H103").isPresent());
        check("findById X999 not found", !inv.findById("X999").isPresent());

        List<Asset> byName = inv.searchByName("thinkpad");
        show("searchByName(\"thinkpad\")", byName);
        check("1 result for thinkpad", byName.size() == 1);

        List<Asset> office = inv.findByTag("office");
        show("findByTag(\"office\")", office);
        check("4 assets tagged office", office.size() == 4);

        List<Asset> software = inv.findByType("software");
        show("findByType(\"software\")", software);
        check("4 software assets", software.size() == 4);

        System.out.println("\n===== 4. UPDATE =====");
        check("update H103", inv.update("H103", "Lenovo ThinkPad E14 Gen 5", 67500));
        check("new name saved", inv.findById("H103").get().getName().equals("Lenovo ThinkPad E14 Gen 5"));
        check("new cost saved", inv.findById("H103").get().getCost() == 67500);
        check("update of missing id fails", !inv.update("H999", "Nothing", 0));

        System.out.println("\n===== 5. LISTING / SORTING =====");
        Comparator<Asset> byCost = Comparator.comparingDouble(Asset::getCost);
        show("All assets (insertion order)", inv.listAll());
        show("Sorted by id (TreeSet)", inv.sortedById());
        show("Sorted by cost high to low", inv.sortedBy(byCost.reversed()));
        show("Sorted by purchase date", inv.sortedBy(Comparator.comparing(Asset::getPurchaseDate)));
        System.out.println("\nAll tags (TreeSet): " + inv.allTags());
        check("first in TreeSet is H101", inv.sortedById().first().getId().equals("H101"));
        check("costliest is S201", inv.sortedBy(byCost.reversed()).get(0).getId().equals("S201"));

        System.out.println("\n===== 6. REMOVE =====");
        check("remove H104", inv.remove("H104"));
        check("H104 not found after remove", !inv.findById("H104").isPresent());
        check("remove missing id fails", !inv.remove("H999"));
        check("serial of removed H104 can be reused",
                inv.add(new HardwareAsset("H105", "Cisco Catalyst 1000 (new)", "CSC1000-0912", "Cisco", today, 49000, "network")));
        check("size is 8", inv.size() == 8);

        System.out.println("\n===== 7. STREAM REPORTS =====");
        System.out.println("Count by type: " + inv.countByType());
        System.out.printf("Total value: %.2f%n", inv.totalCost());
        show("Bought before 2023", inv.boughtBefore(LocalDate.of(2023, 1, 1)));

        List<String> top3 = inv.listAll().stream()
                .sorted(byCost.reversed())
                .limit(3)
                .map(a -> a.getName() + " (" + (long) a.getCost() + ")")
                .collect(Collectors.toList());
        System.out.println("\nTop 3 costliest: " + top3);

        Map<Integer, List<Asset>> byYear = inv.groupBy(a -> a.getPurchaseDate().getYear());
        System.out.println("Grouped by purchase year:");
        for (Map.Entry<Integer, List<Asset>> e : byYear.entrySet()) {
            List<String> ids = e.getValue().stream().map(Asset::getId).collect(Collectors.toList());
            System.out.println("  " + e.getKey() + " -> " + ids);
        }
        check("totalCost is correct", inv.totalCost() == 72000 + 21500 + 67500 + 49000 + 160000 + 85000 + 60000 + 30000);

        System.out.println("\n===== 8. TYPE SAFE MANAGERS (GENERICS) =====");
        AssetManager<HardwareAsset> hwManager = new AssetManager<>();
        hwManager.add(h1);
        hwManager.add(h2);
        hwManager.add(h3);
        HardwareAsset dell = hwManager.findById("H101").get();
        System.out.println("Brand of H101 (no cast needed): " + dell.getBrand());

        List<HardwareAsset> laptops = hwManager.filter(h -> h.hasTag("laptop"));
        show("Laptops in hardware manager", laptops);
        check("2 laptops", laptops.size() == 2);
        show("Hardware sorted by cost (same Comparator<Asset> reused)", hwManager.sortedBy(byCost));

        AssetManager<SoftwareAsset> licenses = new AssetManager<>();
        licenses.add(s1);
        licenses.add(s2);
        licenses.add(s3);
        licenses.add(s4);
        int expired = licenses.removeIf(s -> s.isExpired(today));
        check("2 expired licenses removed", expired == 2);
        show("Active licenses", licenses.listAll());

        int seats = 0;
        for (SoftwareAsset s : licenses.listAll()) {
            seats += s.getSeats();
        }
        System.out.println("Total active seats: " + seats);
        check("13 active seats", seats == 13);

        System.out.println("\n===== 9. RECENT ACTIVITY (LinkedList, last 10) =====");
        for (String h : inv.getHistory()) {
            System.out.println("  " + h);
        }

        System.out.println("\nTests passed: " + passed + "/" + total);
    }
}
