public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public boolean bookCourt(Court court) {
        if (court.bookCourt()) {
            System.out.println(name + " successfully booked a " + court.getSportType() + " court.");
            return true;
        }
        System.out.println("Court is already booked!");
        return false;
    }
}
