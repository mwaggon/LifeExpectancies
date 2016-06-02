/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//mia is amazing
package lifeexpectancies;

import com.google.gson.Gson;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author miawaggoner
 */
public class LifeExpectanciesFXMLController implements Initializable {
    
    private Dataset data;
      
    @FXML
    private BorderPane bPane;
    
    @FXML
    private AnchorPane baller;
    
    @FXML
    private BarChart barChart;
    
    @FXML
    private MenuBar menu;
    
    @FXML
    private Menu filters;
    
    @FXML
    private MenuItem africa;
    
    @FXML
    private MenuItem westernPacific;
    @FXML
    private MenuItem europe;
    @FXML
    private MenuItem easternMed;
    @FXML
    private MenuItem southEastAsia;
    @FXML
    private MenuItem americas;
    
    
    @FXML
    private Menu file;
     
    @FXML
    private Menu help;
    
    @FXML
    private MenuItem close;
    
    @FXML
    private MenuItem info;
    
    @FXML
    public void close(ActionEvent event){
        System.exit(0);
    }
    
    @FXML
    public void printAbout(ActionEvent event){
        Alert message = new Alert(Alert.AlertType.INFORMATION);
        message.setTitle("Information about my graph");
        message.setHeaderText(null);
        message.setContentText("This graph was made by Mia Swaggoner. It graphs life expectancies for females by country");
        message.showAndWait();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String s = "http://apps.who.int/gho/athena/data/GHO/WHOSIS_000001,WHOSIS_000002.json?profile=simple&filter=COUNTRY:*;REGION:*;YEAR:2015;";
        URL ur = null;
        try{
            ur = new URL(s);
        } catch (Exception e){
            System.out.println("Improper URL " + s);
            System.exit(-1);
        }
        
        Scanner scan = null;
        try {
            scan = new Scanner(ur.openStream());
        } catch (Exception e) {
            System.out.println("Could not connect to " + s);
            System.exit(-1);
        }
        
        String str = new String();
        while (scan.hasNext()) {
            str += scan.nextLine() + "\n";
        }
        scan.close();
        //System.out.println(str);
        
        Gson gson = new Gson();
        data = gson.fromJson(str, Dataset.class);
        
        
        DataPoint[] points = data.getDataPoint();
        
        XYChart.Series<String, Number> dataSeries = new XYChart.Series();
        dataSeries.setName("Life Expectancy");
        for(DataPoint point : points){
            if((point.getPointInfo().getCountry() != null) && (point.getPointInfo().getSex().equals("Female"))){
                dataSeries.getData().add(new XYChart.Data(point.getPointInfo().getCountry(), point.getValue()));
            }
        }
        barChart.getData().add(dataSeries);
    }
        
        
    @FXML
    public void handlChangeFilterAfrica(MouseEvent event){
        barChart.getData().clear();
        DataPoint[] points = data.getDataPoint();
        XYChart.Series<String, Number> dataSeries = new XYChart.Series();
        for(DataPoint point : points){
            if((point.getPointInfo().getCountry()!= null) && (point.getPointInfo().getRegion() !=null) && (point.getPointInfo().getSex().equals("Female"))){
                if(point.getPointInfo().getRegion().equals("Africa")){
                    dataSeries.getData().add(new XYChart.Data(point.getPointInfo().getCountry(), point.getValue()));
                }
            }
        }
        barChart.getData().add(dataSeries);
    }
        
    @FXML
    public void handlChangeFilterEurope(MouseEvent event){
        barChart.getData().clear();
        DataPoint[] points = data.getDataPoint();
        XYChart.Series<String, Number> dataSeries = new XYChart.Series();
        for(DataPoint point : points){
            if((point.getPointInfo().getCountry()!= null) && (point.getPointInfo().getRegion() !=null) && (point.getPointInfo().getSex().equals("Female"))){
                if(point.getPointInfo().getRegion().equals("Europe")){
                    dataSeries.getData().add(new XYChart.Data(point.getPointInfo().getCountry(), point.getValue()));
                }
            }
        }
        barChart.getData().add(dataSeries);
    }

    @FXML
    public void handlChangeFilterAmericas(MouseEvent event){
        barChart.getData().clear();
        DataPoint[] points = data.getDataPoint();
        XYChart.Series<String, Number> dataSeries = new XYChart.Series();
        for(DataPoint point : points){
            if((point.getPointInfo().getCountry()!= null) && (point.getPointInfo().getRegion() !=null) && (point.getPointInfo().getSex().equals("Female"))){
                if(point.getPointInfo().getRegion().equals("Americas")){
                    dataSeries.getData().add(new XYChart.Data(point.getPointInfo().getCountry(), point.getValue()));
                }
            }
        }
        barChart.getData().add(dataSeries);
    }

    @FXML
    public void handlChangeFilterSouthEastAsia(MouseEvent event){
        barChart.getData().clear();
        DataPoint[] points = data.getDataPoint();
        XYChart.Series<String, Number> dataSeries = new XYChart.Series();
        for(DataPoint point : points){
            if((point.getPointInfo().getCountry()!= null) && (point.getPointInfo().getRegion() !=null) && point.getPointInfo().getSex().equals("Female")){
                if(point.getPointInfo().getRegion().equals("South-East Asia")){
                    dataSeries.getData().add(new XYChart.Data(point.getPointInfo().getCountry(), point.getValue()));
                }
            }
        }
        barChart.getData().add(dataSeries);
    }
    
    @FXML
    public void handlChangeFilterWesternPacific(MouseEvent event){
        barChart.getData().clear();
        DataPoint[] points = data.getDataPoint();
        XYChart.Series<String, Number> dataSeries = new XYChart.Series();
        for(DataPoint point : points){
            if((point.getPointInfo().getCountry()!= null) && (point.getPointInfo().getRegion() !=null) && point.getPointInfo().getSex().equals("Female")){
                if(point.getPointInfo().getRegion().equals("Western Pacific")){
                    dataSeries.getData().add(new XYChart.Data(point.getPointInfo().getCountry(), point.getValue()));
                }
            }
        }
        barChart.getData().add(dataSeries);
    }
    
    @FXML
    public void handlChangeFilterEasternMed(MouseEvent event){
        barChart.getData().clear();
        DataPoint[] points = data.getDataPoint();
        XYChart.Series<String, Number> dataSeries = new XYChart.Series();
        for(DataPoint point : points){
            if((point.getPointInfo().getCountry()!= null) && (point.getPointInfo().getRegion() !=null) && point.getPointInfo().getSex().equals("Female")){
                if(point.getPointInfo().getRegion().equals("Eastern Mediterranean")){
                    dataSeries.getData().add(new XYChart.Data(point.getPointInfo().getCountry(), point.getValue()));
                }
            }
        }
        barChart.getData().add(dataSeries);
    }
    
    

}
