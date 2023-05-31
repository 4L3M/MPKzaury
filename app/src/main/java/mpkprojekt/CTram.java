package mpkprojekt;

//import org.checkerframework.checker.units.qual.Length;

import java.awt.*;
import java.util.ArrayList;
public class CTram extends CAbstractTram implements Objects{

    ArrayList <CTram> trams;
    int isWorking;
    Double delay;
    int map_pos;
    CLine line;
    int drive = 1;
    public CTram( int length, CLine line, int map_pos, ArrayList <CTram> trams) {
        super();
        this.trams = trams;
        this.length = length;
        this.map_pos = map_pos;
        this.line = line;
        isWorking = 0;
        delay = 0.0;
    }

    @Override
    public void drawMe(Graphics2D G2D) {
        for(CPosition p: checkLength()){
            G2D.setColor(Color.BLUE);
            G2D.fillRect(p.x * 10,p.y * 10,10,10);
        }
    }

    public void move (){
        if(drive == 1){
            int current = map_pos;
            if((map_pos+1)>=line.tracks.size()){
                //System.err.println(trams.size());
                trams.remove(this);
                //System.err.println(trams.size());
              //  return -1;
            }
            map_pos=(map_pos+1)%line.tracks.size();
            if (!checkCollision()) map_pos = current;
        }
     //   return 0;

    }

    public ArrayList<CPosition> checkLength () {
        ArrayList<CPosition> Length = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int x = (map_pos - i+line.tracks.size())%line.tracks.size();
            Length.add(line.tracks.get(x).pos);
        }
    return Length;
    }
    public ArrayList<CPosition> checkLength1 () {
        ArrayList<CPosition> Length = new ArrayList<>();
        for (int i = 0; i <= length; i++) {
            int x = (map_pos - i+line.tracks.size())%line.tracks.size();
            Length.add(line.tracks.get(x).pos);
        }
        return Length;
    }
    public boolean checkCollision(){
        for(CTram t: trams){
            if(t == this) continue;
            for(CPosition p: t.checkLength1()){
                CPosition myPosition = line.tracks.get(map_pos).pos;
                if(myPosition.x == p.x && myPosition.y == p.y) return false;
            }
        }
        return true;
    }
    public void start(){
        drive = 1;
    }
    public void stop(){
        drive = 0;
    }
}