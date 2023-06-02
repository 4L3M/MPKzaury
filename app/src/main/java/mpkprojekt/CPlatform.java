package mpkprojekt;

import java.awt.*;
import java.util.ArrayList;

public class CPlatform extends CStop implements Objects{
    ArrayList <CPosition> platformPositions = new ArrayList<>();
    int counter = 0;
    public CPlatform(String position, String controlPosition,  ArrayList<CAbstractTram> abstractTrams) {
        super(controlPosition, controlPosition,  abstractTrams);
        String [] platform = position.split(";");
        for(String s: platform){
           CPosition platformPos = new CPosition(s);
           platformPositions.add(platformPos);
        }
    }

    public void drawMe (Graphics2D G2D) {
        G2D.setColor(Color.orange);
        for (CPosition p : platformPositions) {
            G2D.fillRect(p.x * 10, p.y * 10, 10, 10);
        }
    }

    boolean checkifcango(CPosition position, CTram tram){
        if((position.x==controlPos.x)&&(position.y==controlPos.y)){
            if(stoppedTram == tram&&counter <= 0) return true;
            if(counter>0&&stoppedTram==tram)return false;
            stoppedTram=tram;
            counter=20;
            return false;
        }
        return true;

    }

    public void changetime(int currentTime) {
        counter--;
    }

}
