package mpkprojekt;

import java.util.ArrayList;

public abstract class CAbstractTram implements Objects {

    int map_pos;
    CLine line;
    int length=-1;

    ArrayList<CAbstractTram> abstractTrams;

    public CAbstractTram(int length, int map_pos, CLine line, ArrayList<CAbstractTram> abstractTrams) {
        this.length = length;
        this.map_pos = map_pos;
        this.line = line;
        this.abstractTrams=abstractTrams;
    }

    CPosition headpositionaftermove(){
        int pos = map_pos%line.tracks.size();
        CPosition position = line.tracks.get(pos).pos;
        return position;
    }
    public boolean checkCollision(){
        for(CAbstractTram t: abstractTrams){
            if(t == this) continue;
            for(CPosition p: t.listToCheckColision()){
                CPosition myPosition = line.tracks.get(map_pos).pos;
                if(myPosition.x == p.x && myPosition.y == p.y) return false;
            }
        }
        return true;
    }
    boolean checkIfCanGo(){
        return true;
    }
    public void move (){
        if(!checkIfCanGo())return;
        int current = map_pos;
        if(map_pos+1>=line.tracks.size()){
            abstractTrams.remove(this);
            saveToStats();
            return;
        }
        map_pos=(map_pos+1)%line.tracks.size();
        if (!checkCollision()) map_pos = current;
    }
    public void saveToStats(){
    }
    public ArrayList<CPosition> listToDraw() {
        ArrayList<CPosition> positions = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int x = (map_pos - i+line.tracks.size())%line.tracks.size();
            positions.add(line.tracks.get(x).pos);
        }
        return positions;
    }
    public ArrayList<CPosition> listToCheckColision() {
        ArrayList<CPosition> positions = new ArrayList<>();
        for (int i = 0; i <= length; i++) {
            int x = (map_pos - i+line.tracks.size())%line.tracks.size();
            positions.add(line.tracks.get(x).pos);
        }
        return positions;
    }


}
