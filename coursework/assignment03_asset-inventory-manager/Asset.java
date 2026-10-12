import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public abstract class Asset implements Comparable<Asset> {
    private final String id;
    private String name;
    private final LocalDate purchaseDate;
    private double cost;
    private final Set<String> tags = new HashSet<>();

    public Asset(String id, String name, LocalDate purchaseDate, double cost, String... tags) {
        this.id = id;
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.cost = cost;
        for (String t : tags) {
            this.tags.add(t.toLowerCase());
        }
    }

    public abstract String getType();

    public abstract String getKey();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Set<String> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    public boolean hasTag(String tag) {
        return tags.contains(tag.toLowerCase());
    }

    @Override
    public int compareTo(Asset other) {
        return id.compareTo(other.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Asset)) return false;
        return id.equals(((Asset) o).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%-5s %-9s %-34s %-16s %10.2f  %s  %s",
                id, getType(), name, getKey(), cost, purchaseDate, new TreeSet<>(tags));
    }
}
