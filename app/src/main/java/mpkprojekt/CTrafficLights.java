package mpkprojekt;
import java.awt.*;
import java.util.ArrayList;

public class CTrafficLights extends CStop implements Objects{
    boolean colour = false;
    int offSetTime = 0;
    public CTrafficLights(String position, String controlPosition, int offSetTime/*, ArrayList<CAbstractTram> abstractTrams*/) {
        super(position, controlPosition/*,  abstractTrams*/);
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
    boolean checkIfCanGo(CPosition position){
        if((position.x==controlPos.x)&&(position.y==controlPos.y)){
            if (colour) return true;
            return false;
        }
        return true;
    }
    public void changeTime(int currentTime) {
        if ((currentTime + offSetTime) % 60 < 30) {
            colour = false;
        } else {
            colour = true;
        }
    }
}
