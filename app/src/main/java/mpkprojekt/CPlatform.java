package mpkprojekt;

import java.awt.*;
import java.util.ArrayList;

public class CPlatform extends CStop{
    ArrayList <CPosition> platformPositions = new ArrayList<>();
    public CPlatform(String position, String controlPosition, ArrayList<CTram> tramsList) {
        super(controlPosition, controlPosition, tramsList);
        String [] platform = position.split(";");
        for(String s: platform){
           System.out.println(s);
           CPosition platformPos = new CPosition(s);
           platformPositions.add(platformPos);
        }
    }
    @Override
    public void drawMe (Graphics2D G2D) {
        G2D.setColor(Color.orange);
        for (CPosition p : platformPositions) {
            G2D.fillRect(p.x * 10, p.y * 10, 10, 10);
        }
    }
}
