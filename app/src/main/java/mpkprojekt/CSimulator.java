package mpkprojekt;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class CSimulator {
    CJFrame jFrame = null;
    ArrayList <CTram> trams = new ArrayList<>();
    ArrayList<CAbstractTram> abstractTrams = new ArrayList<>();
    ArrayList<Objects> obj = new ArrayList<>();

    ArrayList<CRepairTram> repairTrams = new ArrayList<>();

    CClock clock = new CClock(0,0,0);
    CStatistics statistics = new CStatistics();
    CMap map = new CMap(obj,clock,abstractTrams,repairTrams,trams);

    public void Sim (){
        jFrame = new CJFrame(abstractTrams);
        jFrame.guiPanel.objects = obj;
        Timer timer = new Timer(10,new CTimer(this));
        timer.start();
        map.createMap();
  }
    public void checkIfWorks(){
        ArrayList<CTram> toremove = new ArrayList<>();
        for(CTram t: trams){
            if(t.isWorking == 0){
                t.timeWaiting--;
                if(t.timeWaiting !=0) continue;
                CRepairTram repairTram = new CRepairTram(t.length+1,t.line, t.map_pos+1,abstractTrams,map.trafficLights);
                abstractTrams.add(repairTram);
                repairTrams.add(repairTram);
                toremove.add(t);
            }
        }
        for(CTram t:toremove){
            t.saveToStats();
            trams.remove(t);
            abstractTrams.remove(t);

        }
        toremove.clear();
    }
    public void destroy (){
        for(CTram t: trams){
            if(t.isWorking==0)continue;
            if(t.map_pos + 2 >= t.line.tracks.size()) continue;
            Random rand = new Random();
            int i = rand.nextInt(2000);
            if(i == 7){
                t.isWorking = 0;
                t.line.failure++;
                t.timeWaiting = t.map_pos;
            }
        }
    }
}

class CTimer implements ActionListener {
    CSimulator simtimer = null;
    CTimer(CSimulator s){
        this.simtimer = s;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(simtimer.clock.getTime());
//        System.out.println(currentTime);
        for(int i = simtimer.abstractTrams.size()-1 ;i>=0;i-- ){
            CAbstractTram t = simtimer.abstractTrams.get(i);
            t.move();
        }
        for(CPlatform s: simtimer.map.platforms){
            s.changetime(simtimer.clock.currentTime);
        }
        for(CTrafficLights s: simtimer.map.trafficLights){
            s.changeTime(simtimer.clock.currentTime);
        }
        simtimer.checkIfWorks();
        for (CLoop l: simtimer.map.loops){
            l.checkifcango(null,null);
        }
        simtimer.destroy();
        if(simtimer.clock.currentTime%1000 == 0){
           String lineF = "";
           String lineD = "";
            for(CLine l: simtimer.map.lines){
                lineF += l.lineNumber+":"+l.failure+";";
                lineD += l.lineNumber+"delay:"+simtimer.statistics.averageDelay(l.delay, l.countTrams)+";";
            }
            simtimer.statistics.failureStatistics.add(lineF);
            simtimer.statistics.delayStat.add(lineD);
            try {
                simtimer.statistics.saveAll();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        simtimer.clock.tikTak();
        simtimer.jFrame.guiPanel.repaint();
    }
}
