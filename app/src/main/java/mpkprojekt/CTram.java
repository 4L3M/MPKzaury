package mpkprojekt;

//import org.checkerframework.checker.units.qual.Length;

import java.awt.*;
import java.util.ArrayList;
public class CTram extends CAbstractTram implements Objects{

    int isWorking;
    Double delay;
    int timewaiting=0;
    ArrayList<CTrafficLights> trafficLights;
    ArrayList<CPlatform> platforms;
    ArrayList<CRepairTram> repairTrams;
    public CTram( int length, CLine line, int map_pos, ArrayList<CAbstractTram> abstractTrams, ArrayList<CTrafficLights> trafficLights, ArrayList<CPlatform> platforms,ArrayList<CRepairTram> repairTrams) {
        super(length, map_pos, line, abstractTrams);
        this.trafficLights=trafficLights;
        isWorking = 1;
        delay = 0.0;
        this.platforms=platforms;
        this.repairTrams = repairTrams;
    }

    @Override
    public void drawMe(Graphics2D G2D) {
        for(CPosition p: listtodraw()){
            G2D.setColor(Color.BLUE);
            G2D.fillRect(p.x * 10,p.y * 10,10,10);
        }
    }
    @Override
    public boolean checkIfCanGo(){
      /*  if(isWorking==1) {
            if (map_pos == 30) {
                this.isWorking = 0;
                this.timewaiting = map_pos;
            }
        }*/


        boolean b = true;
        if (isWorking == 0) {
            if(map_pos == line.tracks.size()-2){
                abstractTrams.remove(this);
            }
            b = false;
            for (CRepairTram r: repairTrams){
                if (r.map_pos == map_pos + 1 || r.map_pos == map_pos + 2) b = true;
                if (b) return true;
            }
        }
        for(CTrafficLights lights: trafficLights){
            if(!lights.checkifcango(headpositionaftermove())) b = false;
        }
        for(CPlatform platform: platforms){
            if(!platform.checkifcango(headpositionaftermove(),this)) b = false;
        }
        if(b) return true;
        return false;
    }
    @Override
    public boolean checkCollision(){
        for(CAbstractTram t: abstractTrams){
            if(t == this) continue;
            for(CPosition p: t.listtodraw()){
                CPosition myPosition = line.tracks.get(map_pos).pos;
                if(myPosition.x == p.x && myPosition.y == p.y) return false;
            }
        }
        return true;
    }
}