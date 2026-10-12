import java.time.LocalDate;

public class SoftwareAsset extends Asset {
    private final String licenseKey;
    private final int seats;
    private final LocalDate expiryDate;

    public SoftwareAsset(String id, String name, String licenseKey, int seats,
                         LocalDate purchaseDate, LocalDate expiryDate, double cost, String... tags) {
        super(id, name, purchaseDate, cost, tags);
        this.licenseKey = licenseKey;
        this.seats = seats;
        this.expiryDate = expiryDate;
    }

    @Override
    public String getType() {
        return "SOFTWARE";
    }

    @Override
    public String getKey() {
        return licenseKey;
    }

    public int getSeats() {
        return seats;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean isExpired(LocalDate today) {
        return expiryDate.isBefore(today);
    }
}
