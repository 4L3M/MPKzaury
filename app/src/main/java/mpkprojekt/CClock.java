package mpkprojekt;

public class CClock {
    int second = 0;
    int hour = 0;
    int minute = 0;
    int currentTime = 0;

    public CClock(int hour, int minute, int second) {
        this.second = second;
        this.hour = hour;
        this.minute = minute;
    }

    public String getTime (){
        return hour + ":" + minute + ":" + second;
    }

    public void tikTak (){
        second += 10;
        if(second >= 60){
            second %= 60;
            minute++;
            if(minute >= 60){
                minute %= 60;
                hour++;
                if(hour > 24){
                    hour = 0;
                }
            }
        }
        if(hour < 24){
        currentTime++;
        }
    }
   public boolean isTimeEqual(String departureTime){
      int hC, mC, sC;
      String [] C = departureTime.split(":");
      hC = Integer.parseInt(C[0]);
      mC = Integer.parseInt(C[1]);
      sC = Integer.parseInt(C[2]);

      if(hC > hour) return false;
      if(mC > minute) return false;
      if(sC > second) return false;

      return true;
   }
}