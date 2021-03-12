package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.shape.ArcType;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Controller {
    @FXML
    private Canvas mainCanvas;
    @FXML
    public GraphicsContext gc;

    @FXML
    public Canvas otherCanvas;

    @FXML
    public GraphicsContext bc;

//    private static double[] dataArray = {
//            1243.0, 112.0, 4564.0, 1245215.0, 1.0
//    };

    private static double[] avgHousingPricesByYear = {
            247381.0, 264171.4, 287715.3, 294736.1, 308431.4, 322635.9, 340253.0, 363153.7
    };

    private static double[] avgCommercialPricesByYear = {
            1121585.3, 1219479.5, 1246354.2, 1295364.8, 1335932.6, 1472362.0, 1583521.9, 1613246.3
    };

    private static String[] ageGroups​= { "18-25", "26-35", "36-45", "46-55", "56-65", "65+"};

    private static int[] purchaseAgeGroups​= {
            648, 1021, 2453, 3173, 1868, 2247
    };

    private static Color[] pieColors​= {
            Color.AQUA,Color.GOLD,Color.DARKORANGE,Color.DARKSALMON,Color.LAWNGREEN,Color.PLUM

    };

    @FXML
    public void initialize() {
        gc = mainCanvas.getGraphicsContext2D();
        drawGraph(100, 100, avgHousingPricesByYear, avgCommercialPricesByYear, Color.RED, Color.BLUE);
        gc = mainCanvas.getGraphicsContext2D();
        drawChart(gc);
    }

    public void drawGraph(int w, int h, double[] house, double[] Commercial, Color colorRed, Color colorBlue) {

        double maxVal = Double.NEGATIVE_INFINITY, minVal = Double.MAX_VALUE;
        for (int i = 0; i < house.length; i++) {
            if (house[i] > maxVal) {
                maxVal = house[i];
            }
            if (house[i] < minVal) {
                minVal = house[i];
            }
            if (Commercial[i] > maxVal) {
                maxVal = Commercial[i];
            }
            if (Commercial[i] < minVal) {
                minVal = Commercial[i];
            }

        }
//        for (double val : data){
//            if (val > maxVal)
//                maxVal = val;
//            if (val < minVal)
//                minVal = val;
//        }

        double barWidth = w / Commercial.length;
        ;
        double x = 0;
        int indexOfHome = 0;
        int indexOfCommercil = 0;
        boolean blueTurn = false;
        for (int i = 0; i < Commercial.length * 2; i++) {
            if (blueTurn == true) {
                gc.setFill(colorBlue);
                double barHeight = ((Commercial[indexOfCommercil] / maxVal) * h);
                gc.fillRect(x, (h - barHeight), barWidth, barHeight);
                x += barWidth;
                blueTurn = false;
                indexOfCommercil += 1;
            } else {
                x += 0.4 * barWidth;
                gc.setFill(colorRed);
                double barHeightRed = ((house[indexOfHome] / maxVal) * h);
                gc.fillRect(x, (h - barHeightRed), barWidth, barHeightRed);
                x += barWidth;
                indexOfHome += 1;
                blueTurn = true;
            }

        }


    }

    public void drawChart(GraphicsContext gc){
        int totlNumber = 0;
        int i=0;
        while(i!= purchaseAgeGroups​.length) {
            totlNumber = totlNumber + purchaseAgeGroups​[i];
            i+=1;

        }
        i = 0;
        double strtingPoint = 0;
        while(i!=purchaseAgeGroups​.length){
            double slicePercentage = (double) purchaseAgeGroups​[i] / (double) totlNumber;
            double sweepAngle = slicePercentage * 360.0;

            gc.setFill(pieColors​[i]);
            gc.fillArc(350, 150, 300, 300, strtingPoint, sweepAngle, ArcType.ROUND);

            strtingPoint += sweepAngle;
            i+=1;
        }


    }
}
