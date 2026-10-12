import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AssetManager<T extends Asset> {
    private static final int MAX_HISTORY = 10;

    private final Map<String, T> assets = new LinkedHashMap<>();
    private final Map<String, List<T>> byType = new HashMap<>();
    private final Set<String> keys = new HashSet<>();
    private final LinkedList<String> history = new LinkedList<>();

    public boolean add(T asset) {
        if (asset == null) {
            return false;
        }
        if (assets.containsKey(asset.getId())) {
            log("REJECTED duplicate id " + asset.getId());
            return false;
        }
        if (keys.contains(asset.getKey())) {
            log("REJECTED duplicate serial/license " + asset.getKey());
            return false;
        }
        assets.put(asset.getId(), asset);
        keys.add(asset.getKey());
        byType.computeIfAbsent(asset.getType(), k -> new ArrayList<>()).add(asset);
        log("ADDED " + asset.getId());
        return true;
    }

    public boolean remove(String id) {
        T asset = assets.remove(id);
        if (asset == null) {
            log("REMOVE failed, no asset " + id);
            return false;
        }
        keys.remove(asset.getKey());
        List<T> list = byType.get(asset.getType());
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(id)) {
                it.remove();
                break;
            }
        }
        if (list.isEmpty()) {
            byType.remove(asset.getType());
        }
        log("REMOVED " + id);
        return true;
    }

    public int removeIf(Predicate<? super T> condition) {
        int count = 0;
        Iterator<T> it = assets.values().iterator();
        while (it.hasNext()) {
            T a = it.next();
            if (condition.test(a)) {
                it.remove();
                keys.remove(a.getKey());
                byType.get(a.getType()).remove(a);
                log("REMOVED " + a.getId());
                count++;
            }
        }
        byType.values().removeIf(List::isEmpty);
        return count;
    }

    public boolean update(String id, String newName, double newCost) {
        T a = assets.get(id);
        if (a == null) {
            log("UPDATE failed, no asset " + id);
            return false;
        }
        a.setName(newName);
        a.setCost(newCost);
        log("UPDATED " + id);
        return true;
    }

    public Optional<T> findById(String id) {
        return Optional.ofNullable(assets.get(id));
    }

    public List<T> searchByName(String text) {
        List<T> result = new ArrayList<>();
        String q = text.toLowerCase();
        for (T a : assets.values()) {
            if (a.getName().toLowerCase().contains(q)) {
                result.add(a);
            }
        }
        return result;
    }

    public List<T> findByType(String type) {
        List<T> list = byType.get(type.toUpperCase());
        if (list == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(list);
    }

    public List<T> findByTag(String tag) {
        return assets.values().stream()
                .filter(a -> a.hasTag(tag))
                .collect(Collectors.toList());
    }

    public List<T> filter(Predicate<? super T> condition) {
        return assets.values().stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    public List<T> listAll() {
        return new ArrayList<>(assets.values());
    }

    public TreeSet<T> sortedById() {
        return new TreeSet<>(assets.values());
    }

    public List<T> sortedBy(Comparator<? super T> cmp) {
        List<T> list = new ArrayList<>(assets.values());
        list.sort(cmp);
        return list;
    }

    public Set<String> allTags() {
        Set<String> tags = new TreeSet<>();
        for (T a : assets.values()) {
            tags.addAll(a.getTags());
        }
        return tags;
    }

    public <K> Map<K, List<T>> groupBy(Function<? super T, ? extends K> keyFn) {
        Map<K, List<T>> groups = new LinkedHashMap<>();
        for (T a : assets.values()) {
            groups.computeIfAbsent(keyFn.apply(a), k -> new ArrayList<>()).add(a);
        }
        return groups;
    }

    public Map<String, Long> countByType() {
        return assets.values().stream()
                .collect(Collectors.groupingBy(Asset::getType, TreeMap::new, Collectors.counting()));
    }

    public double totalCost() {
        return assets.values().stream()
                .mapToDouble(Asset::getCost)
                .sum();
    }

    public List<T> boughtBefore(LocalDate date) {
        return filter(a -> a.getPurchaseDate().isBefore(date));
    }

    public int size() {
        return assets.size();
    }

    public List<String> getHistory() {
        return new ArrayList<>(history);
    }

    private void log(String msg) {
        history.addLast(msg);
        if (history.size() > MAX_HISTORY) {
            history.removeFirst();
        }
    }
}
