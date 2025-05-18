package BusReservation;

public class Bus {
    int busNo;
    boolean ac;
    int capacity;

    public Bus(int no, boolean ac, int cap) {
        this.busNo = no;
        this.ac = ac;
        this.capacity = cap;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void displayBusInfo() {
        System.out.println("Bus No: " + busNo + " | AC: " + (ac ? "Yes" : "No") + " | Capacity: " + capacity);
    }
}
