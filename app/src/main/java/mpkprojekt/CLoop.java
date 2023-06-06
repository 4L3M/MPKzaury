package mpkprojekt;

import java.beans.beancontext.BeanContextServiceAvailableEvent;
import java.util.ArrayList;
import java.util.Random;

public class CLoop extends CPlatform{
    ArrayList<CTrafficLights> trafficLights;
    CLine line = null;
    CClock clock = null;
    ArrayList <CPlatform> platforms = null;
    ArrayList <CRepairTram> repairTrams = null;
    ArrayList<CTram> trams = null;
    ArrayList <String> schedule = null;
    ArrayList <CAbstractTram> abstractTrams;
    public CLoop(String position, String controlPosition,  CLine line,ArrayList<CAbstractTram> abstractTrams,
                 ArrayList<CTrafficLights> trafficLights, CClock clock, ArrayList<CPlatform> platforms, ArrayList <CRepairTram> repairTrams,
                 ArrayList <String> schedule, ArrayList<CTram> trams) {
        super(position, controlPosition);
        this.line = line;
        this.trafficLights = trafficLights;
        this.clock = clock;
        this.platforms = platforms;
        this.repairTrams = repairTrams;
        this.schedule = schedule;
        this.trams = trams;
        this.abstractTrams = abstractTrams;
    }
    boolean checkifcango(CPosition position, CTram tram){
        if(schedule.size()<=0) return false;
        if(clock.isTimeEqual(schedule.get(0))){
            schedule.remove(0);
            Random random = new Random();
            tram = new CTram (random.nextInt(2)+2,line,abstractTrams,trafficLights,platforms,repairTrams);
            abstractTrams.add(tram);
            trams.add(tram);
        }
        return true;
    }
}
