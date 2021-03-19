package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    @FXML
    private Canvas mainCanvas;
    @FXML
    public GraphicsContext gc;

    HashMap<String, Integer> wetherWrnings = new HashMap<>();
    public void drawCircle(HashMap items){
        Color[] pieColors​= {
                Color.DARKORANGE,Color.DARKSALMON, Color.AQUA, Color.GOLD,

        };
        wetherWrnings = items;
        drawChart(wetherWrnings,pieColors​);
    }

    @FXML
    public void initialize() {
        gc = mainCanvas.getGraphicsContext2D();
        WordCounter wordCounter = new WordCounter("weatherwarnings-2015.csv");
        wordCounter.loadFile();
        drawCircle(wordCounter.countStormes);


    }

    public void drawChart(HashMap someting, Color[] pieColors​){
        int totlNumber = 0;
        int i=0;
        for (Map.Entry mapElement : wetherWrnings.entrySet()) {
            int value = ((int)mapElement.getValue());
            totlNumber = totlNumber + value;

        }
        double strtingPoint = 0;
        i = 0;
        int count = 150;
        int count1 = 140;
        for(Map.Entry mapElement : wetherWrnings.entrySet()){
            int value = ((int)mapElement.getValue());
            String key = (String)mapElement.getKey();
            double slicePercentage = (double) value / (double) totlNumber;
            double sweepAngle = slicePercentage * 360.0;

            gc.setFill(pieColors​[i]);
            gc.fillArc(350, 150, 300, 300, strtingPoint, sweepAngle, ArcType.ROUND);
            strtingPoint += sweepAngle;
            gc.setFill(pieColors​[i]);
            gc.setStroke(pieColors​[i]);
            gc.strokeRect(50,count1,40,30);
            gc.fillRect(50,count1,40,30);
            i+=1;
            gc.fillText(key,120,count);
            count+=50;
            count1+=50;
            System.out.println("i "+ i);

        }

    }


    public class WordCounter {
        private String filename;

        HashMap<String, Integer> countStormes = new HashMap<>();


        // constructor
        public WordCounter(String filename){
            this.filename = filename;
        }
        // this function returns the array list that contains all of the warning type in the file
        public List<String> loadFile(){
            countStormes.put("FLASH FLOOD", 0);
            countStormes.put("SEVERE THUNDERSTORM", 0);
            countStormes.put("SPECIAL MARINE", 0);
            countStormes.put("TORNADO", 0);
            String line = "";
            List<String> warningColumn = new ArrayList<String>();
            try{
                BufferedReader br = new BufferedReader(new FileReader(this.filename));
                while ((line = br.readLine())!=null){
                    // split each word in the line with a comma
                    String[] columns = line.split(",");
                    //test the column added to the list
                    System.out.println(columns[5]);

                    if(countStormes.containsKey(columns[5])){
                        int num = countStormes.get(columns[5]);
                        countStormes.put(columns[5],num+1);
                    }

                    // add warning type in that column to the array list
                    warningColumn.add(columns[5]);
                }
            } catch (FileNotFoundException e){
                e.printStackTrace();
                System.out.println( "this" + e.getCause());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println( "this" + e.getCause());
            }
            System.out.println("");
            return warningColumn;
        }

    }



}
