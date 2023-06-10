package mpkprojekt;

//import org.checkerframework.checker.units.qual.Length;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class CTram extends CAbstractTram implements Objects{
    int isWorking;
    int timeWaiting =0;
    ArrayList<CTrafficLights> trafficLights;
    ArrayList<CPlatform> platforms;
    ArrayList<CRepairTram> repairTrams;
    CClock tramClock = new CClock(0,0,0);
    int randColour;
    public CTram( int length, CLine line, ArrayList<CAbstractTram> abstractTrams, ArrayList<CTrafficLights> trafficLights,
                  ArrayList<CPlatform> platforms,ArrayList<CRepairTram> repairTrams) {
        super(length,0, line, abstractTrams);
        this.trafficLights=trafficLights;
        isWorking = 1;
        this.platforms=platforms;
        this.repairTrams = repairTrams;
        Random rand = new Random();
        this.randColour = rand.nextInt(2);
    }

    @Override
    public void drawMe(Graphics2D G2D) {
        G2D.setColor(Color.cyan);
        if(randColour == 0) G2D.setColor(Color.BLUE);

        for(CPosition p: listToDraw()){
            if(isWorking==0) G2D.setColor(Color.red.darker());
            G2D.fillRect(p.x * 10,p.y * 10,10,10);
        }
        G2D.setColor(Color.black);
        if(randColour == 0){ G2D.setColor(Color.white);}
        G2D.drawString(String.valueOf(line.lineNumber),line.tracks.get(map_pos).pos.x*10 , line.tracks.get(map_pos).pos.y*10+10);

    }
    @Override
    public boolean checkIfCanGo(){
        boolean b = true;
        if (isWorking == 0) {
            return false;
        }
        for(CPlatform platform: platforms){
            if(!platform.checkifcango(headpositionaftermove(),this)) b = false;
        }
        for(CTrafficLights lights: trafficLights){
            if(!lights.checkIfCanGo(headpositionaftermove())) b = false;
        }
        if(b) return true;
        return false;
    }
    @Override
    public boolean checkCollision(){
        //if(isWorking == 0) return true;
        for(CAbstractTram t: abstractTrams){
            if(t == this) continue;
            for(CPosition p: t.listToCheckColision()){
                CPosition myPosition = line.tracks.get(map_pos).pos;
                if(myPosition.x == p.x && myPosition.y == p.y){
                    tramClock.tikTak();
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public void saveToStats() {
        line.delay += tramClock.minute + tramClock.hour * 60 + tramClock.second / 60;
        line.countTrams++;
    }
}