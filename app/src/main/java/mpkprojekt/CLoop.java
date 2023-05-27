package mpkprojekt;

import java.util.ArrayList;
import java.util.Random;

public class CLoop extends CPlatform{
    ArrayList <Integer> schedule = new ArrayList<>();
    CLine line = null;

    public CLoop(String position, String controlPosition, ArrayList<CTram> tramsList, CLine line) {
        super(position, controlPosition, tramsList);
        this.line = line;

        schedule.add(0);
        schedule.add(100);
        schedule.add(200);
        schedule.add(300);
        schedule.add(400);
    }
    @Override
    public void stopTram(int currentTime) {
        if(schedule.size()<=0)return;
        if(currentTime > schedule.get(0)){
            schedule.remove(0);
            Random random = new Random();
            CTram tram = new CTram(random.nextInt(3)+3,line,0,trams);
            trams.add(tram);
        }
    }
}
