package mpkprojekt;

import javax.sound.midi.Track;
import java.awt.*;
import java.util.ArrayList;

public class CLine implements Objects {

    public ArrayList <CTrack> tracks = new ArrayList<>();

    public CLine (String line){
       String [] lines = line.split(";"); //zwraca tablice
        for (String s: lines){
            CTrack track = new CTrack(s);
            tracks.add(track);
        }
    }
    @Override
    public void drawMe(Graphics2D G2D) {
        for(CTrack t:tracks){
            t.drawMe(G2D);
        }
    }
}
