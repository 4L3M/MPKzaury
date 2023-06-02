package mpkprojekt;

import java.awt.*;
import java.util.ArrayList;

public class CTrafficLights extends CStop implements Objects{
    boolean colour = false;
    int offSetTime = 0;
    public CTrafficLights(String position, String controlPosition, ArrayList<CTram> tramsList, int offSetTime, ArrayList<CAbstractTram> abstractTrams) {
        super(position, controlPosition,  abstractTrams);
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

    boolean checkifcango(CPosition position){
        if((position.x==controlPos.x)&&(position.y==controlPos.y)){
            if (colour) return true;
            //System.out.println(position.x+" "+position.y+ " "+controlPos.x+" "+controlPos.y);
            return false;
        }
        return true;

    }

    public void changetime(int currentTime) {
        if ((currentTime + offSetTime) % 60 < 59) {
            colour = false;
        } else {
            colour = true;
        }
    }
}
