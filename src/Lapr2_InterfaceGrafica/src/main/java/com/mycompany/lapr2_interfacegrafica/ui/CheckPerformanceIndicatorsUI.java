package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.CheckPerformanceIndicatorsController;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author beatr
 */
public class CheckPerformanceIndicatorsUI implements Initializable {
    private final MainApp mainApp;
    private final CheckPerformanceIndicatorsController controller;
    
    @FXML
    private Label lblCheckPerformance;
    @FXML
    private Button btnMeanDelay;
    @FXML
    private Button btnDeviationDelay;
    @FXML
    private Button btnMeanPayment;
    @FXML
    private Button btnDeviationPayment;
    @FXML
    private Button btnClean;
    @FXML
    private Label lblProbability;
    @FXML
    private ListView< TreeMap<String, Double> > lstFreelancerAndInfo;
    @FXML
    private BarChart<?, ?> barChartHistograms;
    @FXML
    private NumberAxis numberOfFreelancers;
    @FXML
    private CategoryAxis intervals;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public CheckPerformanceIndicatorsUI(MainApp mainApp) {
        this.mainApp = mainApp;
        this.controller = new CheckPerformanceIndicatorsController();
    }

    public MainApp getMainApp() {
        return this.mainApp;
    }

    public CheckPerformanceIndicatorsController getOrganizationRecordController() {
        return this.controller;
    }

    @FXML
    private void meanDelay(ActionEvent event) {
        TreeMap<String, Double> lstMeanDelay;
        lstMeanDelay = this.controller.calcMeanDelay();
        lstFreelancerAndInfo.getItems().setAll(lstMeanDelay);
        intervals = new CategoryAxis();
        numberOfFreelancers = new NumberAxis();
        barChartHistograms = new BarChart<>(intervals,numberOfFreelancers);
        XYChart.Series barMeanDelay = new XYChart.Series<>();
        
        barMeanDelay.getData().add(new XYChart.Data(calcFirstIntervalDelay(),
                valuesFirstIntervalDelay(lstMeanDelay)));
        barMeanDelay.getData().add(new XYChart.Data(calcSecondIntervalDelay(),
                valuesSecondIntervalDelay(lstMeanDelay)));
        barMeanDelay.getData().add(new XYChart.Data(calcThirdIntervalDelay(),
                valuesThirdIntervalDelay(lstMeanDelay)));        
        
        barChartHistograms.getData().addAll(barMeanDelay);
    }

    @FXML
    private void deviationDelay(ActionEvent event) {
        TreeMap<String, Double> lstDeviationDelay;
        lstDeviationDelay = this.controller.calcDeviationDelay();
        lstFreelancerAndInfo.getItems().setAll(lstDeviationDelay);
        intervals = new CategoryAxis();
        numberOfFreelancers = new NumberAxis();
        barChartHistograms = new BarChart<>(intervals,numberOfFreelancers);
        XYChart.Series barDeviationDelay = new XYChart.Series<>();
        
        barDeviationDelay.getData().add(new XYChart.Data(calcFirstIntervalDelay(),
                valuesFirstIntervalDelay(lstDeviationDelay)));
        barDeviationDelay.getData().add(new XYChart.Data(calcSecondIntervalDelay(),
                valuesSecondIntervalDelay(lstDeviationDelay)));
        barDeviationDelay.getData().add(new XYChart.Data(calcThirdIntervalDelay(),
                valuesThirdIntervalDelay(lstDeviationDelay)));        
        
        barChartHistograms.getData().addAll(barDeviationDelay);
    }

    @FXML
    private void meanPayment(ActionEvent event) {
        TreeMap<String, Double> lstMeanPayment;
        lstMeanPayment = this.controller.calcMeanPayment();
        lstFreelancerAndInfo.getItems().setAll(lstMeanPayment);
        intervals = new CategoryAxis();
        numberOfFreelancers = new NumberAxis();
        barChartHistograms = new BarChart<>(intervals,numberOfFreelancers);
        XYChart.Series barMeanPayment = new XYChart.Series<>();
        
        barMeanPayment.getData().add(new XYChart.Data(calcFirstIntervalPayment(),
                valuesFirstIntervalPayment(lstMeanPayment)));
        barMeanPayment.getData().add(new XYChart.Data(calcSecondIntervalPayment(),
                valuesSecondIntervalPayment(lstMeanPayment)));
        barMeanPayment.getData().add(new XYChart.Data(calcThirdIntervalPayment(),
                valuesThirdIntervalPayment(lstMeanPayment)));        
        
        barChartHistograms.getData().addAll(barMeanPayment);
    }

    @FXML
    private void deviationPayment(ActionEvent event) {
        TreeMap<String, Double> lstDeviationPayment;
        lstDeviationPayment = this.controller.calcMeanPayment();
        lstFreelancerAndInfo.getItems().setAll(lstDeviationPayment);
        intervals = new CategoryAxis();
        numberOfFreelancers = new NumberAxis();
        barChartHistograms = new BarChart<>(intervals,numberOfFreelancers);
        XYChart.Series barDeviationPayment = new XYChart.Series<>();
        
        barDeviationPayment.getData().add(new XYChart.Data(calcFirstIntervalPayment(),
                valuesFirstIntervalPayment(lstDeviationPayment)));
        barDeviationPayment.getData().add(new XYChart.Data(calcSecondIntervalPayment(),
                valuesSecondIntervalPayment(lstDeviationPayment)));
        barDeviationPayment.getData().add(new XYChart.Data(calcThirdIntervalPayment(),
                valuesThirdIntervalPayment(lstDeviationPayment)));        
        
        barChartHistograms.getData().addAll(barDeviationPayment);
        
        lblProbability.setText("The probability of the execution delay time of the freelancers that higher than 3 hours is" + normalDistribution());
    }

    @FXML
    private void cleanAll(ActionEvent event) {
        lstFreelancerAndInfo.getItems().clear(); 
    }

    private double normalDistribution() {
        return controller.determinateNormalDistribution();
    }
    
    private double getInferiorLimitPayment(){
        return controller.determinateIntervals(controller.calcMeanPayment())
                - controller.determinateIntervals(controller.calcDeviationPayment());
    }
    
    private double getInferiorLimitDelay(){
        return controller.determinateIntervals(controller.calcMeanDelay())
                - controller.determinateIntervals(controller.calcDeviationDelay());
    }
    
    private double getSuperiorLimitPayment(){
        return controller.determinateIntervals(controller.calcMeanPayment())
                + controller.determinateIntervals(controller.calcDeviationPayment());        
    }
    
    private double getSuperiorLimitDelay(){
        return controller.determinateIntervals(controller.calcMeanDelay())
                + controller.determinateIntervals(controller.calcDeviationDelay());        
    }
    
    private String calcFirstIntervalDelay(){
        String interval = null, infinity;
        try{
            double firstInterval = getInferiorLimitDelay();
            infinity = new String(String.valueOf(Character.toString('\u221E')).getBytes("UTF-8"), "UTF-8");
            interval = String.format("] %s, %2f [", infinity, firstInterval);
        }catch (UnsupportedEncodingException ex){
            infinity = "inf";
            ex.printStackTrace();
        }
        return interval;
    }
    
    private String calcFirstIntervalPayment(){
        String interval = null, infinity;
        try{
            double firstInterval = getInferiorLimitPayment();
            infinity = new String(String.valueOf(Character.toString('\u221E')).getBytes("UTF-8"), "UTF-8");
            interval = String.format("] %s, %2f [", infinity, firstInterval);
        }catch (UnsupportedEncodingException ex){
            infinity = "inf";
            ex.printStackTrace();
        }
        return interval;
    }
    
    private String calcSecondIntervalPayment(){
            double firstInterval = getInferiorLimitPayment();
            double secondInterval = getSuperiorLimitPayment();
        return String.format("] %2f, %2f [", firstInterval, secondInterval);
    }
    
    private String calcSecondIntervalDelay(){
            double firstInterval = getInferiorLimitDelay();
            double secondInterval = getSuperiorLimitDelay();
        return String.format("] %2f, %2f [", firstInterval, secondInterval);
    }
    
    private String calcThirdIntervalPayment(){
        String interval = null, infinity;
        try{
            double secondInterval = getSuperiorLimitPayment();
            infinity = new String(String.valueOf(Character.toString('\u221E')).getBytes("UTF-8"), "UTF-8");
            interval = String.format("] %2f, %s [", secondInterval, infinity);
        }catch (UnsupportedEncodingException ex){
            infinity = "inf";
            ex.printStackTrace();
        }
        return interval;
    }
    
    private String calcThirdIntervalDelay(){
        String interval = null, infinity;
        try{
            double secondInterval = getSuperiorLimitDelay();
            infinity = new String(String.valueOf(Character.toString('\u221E')).getBytes("UTF-8"), "UTF-8");
            interval = String.format("] %2f, %s [", secondInterval, infinity);
        }catch (UnsupportedEncodingException ex){
            infinity = "inf";
            ex.printStackTrace();
        }
        return interval;
    }
    
    
    private int valuesFirstIntervalDelay(TreeMap<String, Double> map){
        int counter = 0;
        for(Map.Entry<String, Double> entry : map.entrySet()){
            if(entry.getValue() <= getInferiorLimitDelay()){
                entry.getKey();
                counter++;
            }
        }
        return counter;
    }
    
    private int valuesFirstIntervalPayment(TreeMap<String, Double> map){
        int counter = 0;
        for(Map.Entry<String, Double> entry : map.entrySet()){
            if(entry.getValue() <= getInferiorLimitPayment()){
                entry.getKey();
                counter++;
            }
        }
        return counter;
    }
    
    private int valuesSecondIntervalDelay(TreeMap<String, Double> map){
        int counter = 0;
        for(Map.Entry<String, Double> entry : map.entrySet()){
            if(entry.getValue() > getInferiorLimitDelay() || entry.getValue() < getSuperiorLimitDelay() ){
                entry.getKey();
                counter++;
            }
        }
        return counter;
    }
    
    private int valuesSecondIntervalPayment(TreeMap<String, Double> map){
        int counter = 0;
        for(Map.Entry<String, Double> entry : map.entrySet()){
            if(entry.getValue() > getInferiorLimitPayment() || entry.getValue() < getSuperiorLimitPayment() ){
                entry.getKey();
                counter++;
            }
        }
        return counter;
    }
    
    private int valuesThirdIntervalDelay(TreeMap<String, Double> map){
        int counter = 0;
        for(Map.Entry<String, Double> entry : map.entrySet()){
            if(entry.getValue() >= getSuperiorLimitDelay() ){
                entry.getKey();
                counter++;
            }
        }
        return counter;
    }
    
    private int valuesThirdIntervalPayment(TreeMap<String, Double> map){
        int counter = 0;
        for(Map.Entry<String, Double> entry : map.entrySet()){
            if(entry.getValue() >= getSuperiorLimitPayment() ){
                entry.getKey();
                counter++;
            }
        }
        return counter;
    }
    
}
