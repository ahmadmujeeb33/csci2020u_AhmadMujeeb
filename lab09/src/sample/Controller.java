package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private Canvas mainCanvas;

    @FXML
    public GraphicsContext gc;


    @FXML
    public void initialize() throws IOException {

        gc = mainCanvas.getGraphicsContext2D();
        FileLoader fileLoader = new FileLoader("AAPL.csv");
        fileLoader.downloadStockPrices();
        FileLoader fileLoader1 = new FileLoader("GOOG.csv");
        fileLoader1.downloadStockPrices();
        drawLinePlot(fileLoader.warningColumn,fileLoader1.warningColumn);

    }

    public class FileLoader {

        private String filename;

        // constructor
        public FileLoader(String filename) throws FileNotFoundException, IOException {
            this.filename = filename;
        }
        List<String> warningColumn = new ArrayList<>();
        public void downloadStockPrices(){
            String line = "";

            try {
                BufferedReader br = new BufferedReader(new FileReader(this.filename));
                while ((line = br.readLine()) != null) {
                    // split each word in the line with a comma
                    String[] columns = line.split(",");
                    //test the column added to the list
                    //System.out.println(columns[5]);

                    // add warning type in that column to the array list
                    warningColumn.add(columns[5]);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    public void drawLinePlot(List<String> apple, List<String> Google){
        gc.strokeLine(10,100,10,500);
        gc.strokeLine(10,500,900,500);
        int x  = 10;
        int y = x  + 10;
        String initalY  = apple.get(1);
        String endY = apple.get(2);
        for(int i=2;i<apple.size()-1;i++){
            gc.setStroke(Color.BLUE);
            Double num = Double.parseDouble(initalY)+375;
            Double num1 = Double.parseDouble(endY)+375;
            gc.strokeLine(x,num,y,num1);
            x  = y;
            y = y + 10;
            initalY = endY;
            endY = apple.get(i+1);
        }
        initalY  = Google.get(1);
        endY = Google.get(2);
        x  = 15;
        y = x  + 20;
        for(int i=2;i<Google.size()-1;i++){
            gc.setStroke(Color.RED);
            Double num = -1*Double.parseDouble(initalY)+550;
            Double num1 = -1*Double.parseDouble(endY)+550;
            gc.strokeLine(x,num,y,num1);
            x  = y;
            y = y + 20;
            initalY = endY;
            endY = Google.get(i+1);
        }

    }


}
