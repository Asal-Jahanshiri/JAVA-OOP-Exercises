import java.util.*;

public class  Main3 {
    private static Scanner scanner = new Scanner(System.in);
    private static Admin3 admin = new Admin3();
    private static List<Player> players = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Sports Court Booking ---");
            System.out.println("1. Add Court (Admin)");
            System.out.println("2. View Courts");
            System.out.println("3. Book Court (Player) ");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addCourt();
                    break;
                case 2:
                    viewCourts();
                    break;
                case 3:
                    bookCourt();
                    break;
                case 4:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void addCourt() {
        System.out.print("Enter court type (e.g., Basketball, Tennis): ");
        String type = scanner.nextLine();
        admin.add_Court(new Court(type));
    }

    private static void viewCourts() {
        List <Court> courts = admin.get_Courts();
        if (courts.isEmpty()) {
            System.out.println("No courts added yet.");
            return;
        }
        int i = 1;
        for (Court court : courts) {
            System.out.println(i++ + ". " + court.getSportType() + " - " + (court.isAvailable() ? "Available" : "Booked"));
        }
    }

    private static void bookCourt() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        Player player = new Player(name);
        players.add(player);

        List<Court> courts = admin.get_Courts();
        if (courts.isEmpty()) {
            System.out.println("No courts available.");
            return;
        }

        int i = 1;
        for (Court court : courts) {
            if (court.isAvailable()) {
                System.out.println(i + ". " + court.getSportType());
            }
            i++;
        }

        System.out.print("Enter court number to book: ");
        int CrtIndx = Integer.parseInt(scanner.nextLine()) - 1;

        if (CrtIndx >= 0 && CrtIndx < courts.size()) {
            Court selected = courts.get(CrtIndx);
            if (selected.isAvailable()) {
                player.bookCourt(selected);
            } else {
                System.out.println("That court is already booked.");
            }
        } else {
            System.out.println("Invalid court number.");
        }
    }
}