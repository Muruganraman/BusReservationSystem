package BusReservation;
import java.util.*;

public class BusReservationSytem {
    static List<Bus> buses = new ArrayList<>();
    static List<Booking> bookings = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeBuses();
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> showBuses();
                case 2 -> bookTicket();
                case 3 -> viewBookings();
                case 4 -> cancelTicket();
                case 5 -> System.out.println("Thank you for using the system.");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    static void showMenu() {
        System.out.println("\n--- Bus Reservation System ---");
        System.out.println("1. View Available Buses");
        System.out.println("2. Book Ticket");
        System.out.println("3. View Bookings");
        System.out.println("4. Cancel Ticket");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    static void initializeBuses() {
        buses.add(new Bus(101, true, 2));
        buses.add(new Bus(102, false, 3));
    }

    static void showBuses() {
        for (Bus bus : buses) {
            bus.displayBusInfo();
        }
    }

    static void bookTicket() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter bus number: ");
        int busNo = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Bus bus = getBus(busNo);
        if (bus != null && bus.getCapacity() > 0) {
            bookings.add(new Booking(name, busNo));
            bus.setCapacity(bus.getCapacity() - 1);
            System.out.println("Booking confirmed.");
        } else {
            System.out.println("Booking failed. Either invalid bus number or bus is full.");
        }
    }

    static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
        } else {
            for (Booking b : bookings) {
                System.out.println("Passenger: " + b.getPassengerName() + " | Bus No: " + b.getBusNo());
            }
        }
    }

    static void cancelTicket() {
        System.out.print("Enter your name to cancel: ");
        String name = scanner.nextLine();

        Iterator<Booking> iterator = bookings.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Booking b = iterator.next();
            if (b.getPassengerName().equalsIgnoreCase(name)) {
                Bus bus = getBus(b.getBusNo());
                if (bus != null) {
                    bus.setCapacity(bus.getCapacity() + 1);
                }
                iterator.remove();
                found = true;
                System.out.println("Booking cancelled.");
                break;
            }
        }

        if (!found) {
            System.out.println("No booking found under that name.");
        }
    }

    static Bus getBus(int busNo) {
        for (Bus bus : buses) {
            if (bus.getBusNo() == busNo) return bus;
        }
        return null;
    }
}


