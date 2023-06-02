package mpkprojekt;

import java.awt.*;
import java.util.ArrayList;

public class CRepairTram extends CAbstractTram implements Objects {

    ArrayList<CTrafficLights> trafficLights;
    public CRepairTram( int length, CLine line, int map_pos, ArrayList<CAbstractTram> abstractTrams, ArrayList<CTrafficLights> trafficLights) {
        super(length, map_pos, line, abstractTrams);
        this.trafficLights=trafficLights;
    }
    @Override
    public void drawMe(Graphics2D G2D) {
        for(CPosition p: listtodraw()){
            G2D.setColor(Color.yellow);
            G2D.fillRect(p.x * 10,p.y * 10,10,10);
        }
    }
    @Override
    public boolean checkIfCanGo(){
        boolean b = true;
        for(CTrafficLights lights: trafficLights){
            if(!lights.checkifcango(headpositionaftermove())) b = false;
        }


        if(b) return true;
        return false;
    }

}