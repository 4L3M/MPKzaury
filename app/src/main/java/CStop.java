import java.util.ArrayList;
import java.util.List;

public class CStop {
    int stop_number;
    List<Double> schedule = new ArrayList<>();
    CPosition pos;
    public CStop(int stop_number, List<Double> schedule, int x, int y) {
        this.stop_number = stop_number;
        this.schedule = schedule;
        this.pos = new CPosition(x, y);
    }



}
