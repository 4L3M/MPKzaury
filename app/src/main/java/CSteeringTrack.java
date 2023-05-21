public class CSteeringTrack extends CTrack{
    int tram_line;
    public CSteeringTrack(int occupied, CPosition pos) {
        super(occupied, pos.x,pos.y);
        tram_line = 0;
    }
}
