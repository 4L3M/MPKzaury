package mpkprojekt;

public class CPosition {
    int x;
    int y;

    public CPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public CPosition(String xy){
        xy = xy.replace("(","");
        xy = xy.replace(")","");
        String [] s = xy.split(",");
        this.x = Integer.parseInt(s[0]);
        this.y = Integer.parseInt(s[1]);
    }
}
