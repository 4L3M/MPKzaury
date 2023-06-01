package mpkprojekt;

import java.awt.*;
import java.util.ArrayList;

public class CTrafficLights extends CStop{
    boolean colour = false;
    int offSetTime = 0;
    public CTrafficLights(String position, String controlPosition, ArrayList<CTram> tramsList, int offSetTime) {
        super(position, controlPosition, tramsList);
        this.offSetTime = offSetTime;
    }
    public void drawMe (Graphics2D G2D){
        if(colour){
            G2D.setColor(Color.green.darker());
            G2D.fillRect(pos.x * 10,pos.y * 10,10,10);
        } else {
            G2D.setColor(Color.red);
            G2D.fillRect(pos.x * 10,pos.y * 10,10,10);
        }
    }
    @Override
    public void stopTram(int currentTime) {
        if ((currentTime + offSetTime) % 60 < 55) {
            colour = false;
        } else {
            colour = true;
        }

        for (CTram t : trams) {

            for (CPosition p : t.checkLength()) {
                CPosition myPosition = controlPos;
                if (myPosition.x == p.x && myPosition.y == p.y){
                    if(t == stoppedTram) continue;
                    if(!colour) {
                        t.stop();
                        stoppedTram = t;
                    }
                }
                break;
            }
        }
        if(stoppedTram != null && colour) {
            stoppedTram.start();
            stoppedTram = null;
        }
    }
}
