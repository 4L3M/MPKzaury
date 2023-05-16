import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CGuiPanel extends JPanel {
    int width = 1000;
    int heigth = 1000;
    char [][] array = new char[6][9];
    public CGuiPanel(){
        this.setPreferredSize(new Dimension(width,heigth));
    }
    public void readMap(){
        File file = new File("TestMap.txt"); // Otwieranie pliku o podanej nazwie
        Scanner scanner = null; // Tworzy obiekt typu Scanner
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("Niewlasciwy plik");
        }
        List<String> list = new ArrayList<>(); // Utworzenie listy
        for(;scanner.hasNextLine();){ // Tak dlugo dodawaj do listy, dopóki w pliku są kolejne linie
            list.add(scanner.nextLine()); // Wczytanie do listy poszczególnych wierszy
        }
        /*for(String str: list){
            System.out.println(str);
        }*/
        // wiersze = 5, kolumny = 8

        for(int i = 0; i<6;i++){
            for (int j = 0; j<9;j++){
                array[i][j] = list.get(i).charAt(j);
            }
        }
        for(int i = 0; i<6;i++){
            for (int j = 0; j<9;j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
        System.out.println((Arrays.deepToString(array)));
    }
    public void paint(Graphics G){
        Graphics2D G2D = (Graphics2D) G;
       /* G2D.setColor(Color.PINK);
        G2D.fillRect(10,10,100,100);
        G2D.setColor(Color.BLUE);
        G2D.fillRect(110,10,100,100);
        G2D.setColor(Color.ORANGE);
        G2D.fillRect(110,110,100,100);
        G2D.setColor(Color.GREEN);
        G2D.fillRect(10,110,100,100);*/

        int x = 10, y = 10;
        for(int i = 0; i<6;i++){
            for (int j = 0; j<9;j++){
                if(array[i][j]=='B'){
                    G2D.setColor(Color.PINK);}
                if(array[i][j]==' '){
                    G2D.setColor(Color.GREEN);}
                if (array[i][j]=='T'){
                    G2D.setColor(Color.BLUE);}
                G2D.fillRect(y+j*100,y+i*100,100,100);
            }
        }
    }
    }
