import java.util.ArrayList;
import java.util.List;

public class Admin3 {
    private List<Court> courts;

    public Admin3() {
        this.courts = new ArrayList<>();
    }

    public void add_Court(Court court) {
        courts.add(court);
        System.out.println("Added " + court.getSportType() + " court.");
    }

    public List<Court> get_Courts() {
        return courts;
    }
}
