package mpkprojekt;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CStatistics {
    ArrayList<String> failureStatistics = new ArrayList<>();
    ArrayList<String> delayStat = new ArrayList<>();
    public void saveToFile(String fileName, ArrayList <String> Stat) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, false);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for(String s: Stat){
            printWriter.println(s);
        }
        printWriter.close();
    }
    public void saveAll () throws IOException {
        saveToFile("Failures.txt",failureStatistics);
        saveToFile("Delay.txt",delayStat);
    }
    public float averageDelay (float allD, int howManyTrams){
        return allD/(1.0f*howManyTrams);
    }
}
