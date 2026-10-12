import java.time.LocalDate;

public class HardwareAsset extends Asset {
    private final String serialNo;
    private final String brand;

    public HardwareAsset(String id, String name, String serialNo, String brand,
                         LocalDate purchaseDate, double cost, String... tags) {
        super(id, name, purchaseDate, cost, tags);
        this.serialNo = serialNo;
        this.brand = brand;
    }

    @Override
    public String getType() {
        return "HARDWARE";
    }

    @Override
    public String getKey() {
        return serialNo;
    }

    public String getBrand() {
        return brand;
    }
}
