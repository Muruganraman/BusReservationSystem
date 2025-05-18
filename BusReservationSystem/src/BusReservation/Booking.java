package BusReservation;

public class Booking {
    String passengerName;
    int busNo;

    public Booking(String name, int busNo) {
        this.passengerName = name;
        this.busNo = busNo;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public int getBusNo() {
        return busNo;
    }
}
