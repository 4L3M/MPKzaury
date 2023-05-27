package mpkprojekt;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CStop implements Objects {
    int stop_number;
    List<Double> schedule = new ArrayList<>();
    CPosition pos;
    CPosition controlPos;
    ArrayList<CTram> trams;
    int stopTime = 0;
    CTram stoppedTram = null;

    public CStop(int stop_number, List<Double> schedule, int x, int y) {
        this.stop_number = stop_number;
        this.schedule = schedule;
        this.pos = new CPosition(x, y);
    }

    public CStop(String position, String controlPosition, ArrayList<CTram> tramsList) {
        pos = new CPosition(position);
        controlPos = new CPosition(controlPosition);
        trams = tramsList;
    }

    @Override
    public void drawMe(Graphics2D G2D) {
        G2D.setColor(Color.orange);
        G2D.fillRect(pos.x * 10, pos.y * 10, 10, 10);
    }

    public void stopTram(int currentTime) {

        for (CTram t : trams) {

            for (CPosition p : t.checkLength()) {
                CPosition myPosition = controlPos;
                if (myPosition.x == p.x && myPosition.y == p.y){
                    if(t == stoppedTram) continue;
                    t.stop();
                    stoppedTram = t;
                    stopTime = currentTime;
                }
                break;
            }
        }
        if(stoppedTram != null && currentTime-stopTime > 20) {
            stoppedTram.start();
            stoppedTram=null;
        }
    }
}