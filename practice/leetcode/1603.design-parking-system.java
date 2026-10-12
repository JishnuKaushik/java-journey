class ParkingSystem {
    int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        slots = new int[4];
        slots[1] = big;
        slots[2] = medium;
        slots[3] = small;
    }

    public boolean addCar(int carType) {
        if(slots[carType] == 0) return false;
        slots[carType]--;
        return true;
    }
}
