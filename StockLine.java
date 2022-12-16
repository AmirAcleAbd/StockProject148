package fullapp.stockprojecttwo;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StockLine extends LineChart {

    String name;
    String symbol;
    String exchange;
    String currency;
    double[][] dataStock;

    XYChart.Series<String, Number> data;

    public StockLine(String name, String symbol, String exchange, String currency, String path) {
        super(new CategoryAxis(), new NumberAxis());
        this.name = name;
        this.symbol = symbol;
        this.exchange = exchange;
        this.currency = currency;
        dataStock = getStockData(path);

        data = new Series<>();
        String date;
        for(int i = 0; i < 100; i++){
            date = dateToDate((int)dataStock[i][0]);
            data.getData().add(new XYChart.Data<>(date, dataStock[i][4]));
        }
        data.setName(name);
    }

    public LineChart createChart(){

        int lowestValue = (int)dataStock[0][4];
        int highestValue = (int)dataStock[0][4];
        int range = 200;

        for(int i = 0; i < range; i++){
            if(dataStock[i][4] < lowestValue){
                lowestValue = (int) dataStock[i][4];
            }
            if(dataStock[i][4] > highestValue){
                highestValue = (int) dataStock[i][4];
            }
        }

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Day");
        yAxis.setLabel("Price");
        yAxis.setLowerBound(lowestValue - 1000);
        yAxis.setUpperBound(highestValue + 1000);

        LineChart<String, Number> lineChart = new LineChart<String,Number>(xAxis, yAxis);

        lineChart.getData().add(data);
        lineChart.setTitle("Big STOCKS");

        return lineChart;
    }

    public static double[][] getStockData(String path) {

        int countLine = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            int lineCount = 0;

            // Read each line until the end of the file is reached
            while ((line = reader.readLine()) != null) {
                lineCount++;
            }

            countLine = lineCount;

        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }

        double[][] stockData = new double[countLine][7];

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            int lineCount = 0;

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                for (int i = 0; i < tokens.length; i++) {
                    double dateInt = Double.parseDouble(tokens[0].replace("-", ""));
                    stockData[lineCount][0] = dateInt;
                    if(i > 0){
                        stockData[lineCount][i] = Double.parseDouble(tokens[i]);
                    }
                }
                lineCount++;
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        return stockData;
    }

    public String dateToDate(int dateToConvert){
        String dateString = String.format("%04d-%02d-%02d", dateToConvert / 10000, (dateToConvert / 100) % 100, dateToConvert % 100);
        return dateString;
    }

}
