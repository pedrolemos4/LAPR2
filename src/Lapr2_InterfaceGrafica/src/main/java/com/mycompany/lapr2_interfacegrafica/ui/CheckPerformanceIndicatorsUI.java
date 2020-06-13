package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.CheckPerformanceIndicatorsController;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author beatr
 */
public class CheckPerformanceIndicatorsUI implements Initializable {
    //private final MainApp mainApp;
    private  CheckPerformanceIndicatorsController controller;
    
    @FXML
    private Label lblCheckPerformance;
    @FXML
    private Button btnDeviationDelay;
    @FXML
    private Button btnClean;
    @FXML
    private ListView< TreeMap<String, Double> > lstFreelancerAndInfo;
    @FXML
    private BarChart<?, ?> barChartHistograms;
    @FXML
    private CategoryAxis intervals;
    @FXML
    private Button btnShowHdelays;
    @FXML
    private Button btnReturn;
    @FXML
    private TextField txtProbability;
    @FXML
    private NumberAxis numberOfFreelancers;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controller = new CheckPerformanceIndicatorsController();
        txtProbability.setText(String.format("The probability of the execution delay time of the freelancers that higher than 3 hours is %.4f\n"
                + "All Freelancers: Mean Delay is %.2f , Deviation Delay is %.2f\n"
                + "Mean Payment is %.2f , Deviation Payment is %.2f", controller.determinateNormalDistribution(),
                controller.determinateIntervalsMean(controller.determinateDelayPlatform()),controller.determinateIntervalsDeviation(controller.determinateDelayPlatform())
                ,controller.determinateIntervalsMean(controller.determinatePayPlatform()),controller.determinateIntervalsDeviation(controller.determinatePayPlatform())));
    }
    
    @FXML
    private void cleanAll(ActionEvent event) {
        barChartHistograms.getData().clear();
        lstFreelancerAndInfo.getItems().clear();
    }

    
    private double getInferiorLimitPayment(){
        return controller.determinateIntervalsMean(controller.determinatePayPlatform())
                - controller.determinateIntervalsDeviation(controller.determinatePayPlatform());
    }
    
    private double getInferiorLimitDelay(){
        return controller.determinateIntervalsMean(controller.determinateDelayPlatform())
                - controller.determinateIntervalsDeviation(controller.determinateDelayPlatform());
    }
    
    private double getSuperiorLimitPayment(){
        return controller.determinateIntervalsMean(controller.determinatePayPlatform())
                + controller.determinateIntervalsDeviation(controller.determinatePayPlatform());        
    }
    
    private double getSuperiorLimitDelay(){
        return controller.determinateIntervalsMean(controller.determinateDelayPlatform())
                + controller.determinateIntervalsDeviation(controller.determinateDelayPlatform());        
    }
    
    private String calcFirstIntervalDelay(){
        String interval = null, infinity;
        try{
            double firstInterval = getInferiorLimitDelay();
            infinity = new String(String.valueOf(Character.toString('\u221E')).getBytes("UTF-8"), "UTF-8");
            interval = String.format("] -%s, %2f [", infinity, firstInterval);
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
            interval = String.format("] -%s, %.2f [", infinity, firstInterval);
        }catch (UnsupportedEncodingException ex){
            infinity = "inf";
            ex.printStackTrace();
        }
        return interval;
    }
    
    private String calcSecondIntervalPayment(){
            double firstInterval = getInferiorLimitPayment();
            double secondInterval = getSuperiorLimitPayment();
        return String.format("] %.2f, %.2f [", firstInterval, secondInterval);
    }
    
    private String calcSecondIntervalDelay(){
            double firstInterval = getInferiorLimitDelay();
            double secondInterval = getSuperiorLimitDelay();
        return String.format("] %.2f, %.2f [", firstInterval, secondInterval);
    }
    
    private String calcThirdIntervalPayment(){
        String interval = null, infinity;
        try{
            double secondInterval = getSuperiorLimitPayment();
            infinity = new String(String.valueOf(Character.toString('\u221E')).getBytes("UTF-8"), "UTF-8");
            interval = String.format("] %.2f, +%s [", secondInterval, infinity);
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
            interval = String.format("] %.2f, +%s [", secondInterval, infinity);
        }catch (UnsupportedEncodingException ex){
            infinity = "inf";
            ex.printStackTrace();
        }
        return interval;
    }
    
    private int valuesFirstIntervalPayment(TreeMap<String, List<Double>> map){
        int counter = 0;
        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (entry.getValue().get(i) <= getInferiorLimitPayment()) {
                    System.out.println(entry.getValue().get(i));
                    counter++;
                }
            }
        }
        return counter;
    }
    
    private int valuesFirstIntervalDelay(TreeMap<String, List<Double>> map){
        int counter = 0;
        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (entry.getValue().get(i) <= getInferiorLimitDelay()) {
                    counter++;
                }
            }
        }
        return counter;
    }
    
    private int valuesSecondIntervalPayment(TreeMap<String, List<Double>> map){
        int counter = 0;
        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (entry.getValue().get(i) > getInferiorLimitPayment() && entry.getValue().get(i)< getSuperiorLimitPayment()) {
                    counter++;
                }
            }
        }
        return counter;
    }
    
    private int valuesSecondIntervalDelay(TreeMap<String, List<Double>> map){
        int counter = 0;
        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (entry.getValue().get(i) > getInferiorLimitDelay() && entry.getValue().get(i)< getSuperiorLimitDelay()) {
                    counter++;
                }
            }
        }
        return counter;
    }
    
    private int valuesThirdIntervalPayment(TreeMap<String, List<Double>> map){
        int counter = 0;
        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (entry.getValue().get(i) >= getSuperiorLimitPayment()) {
                    counter++;
                }
            }
        }
        return counter;
    }
    
    private int valuesThirdIntervalDelay(TreeMap<String, List<Double>> map){
        int counter = 0;
        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (entry.getValue().get(i) >= getSuperiorLimitDelay()) {
                    counter++;
                }
            }
        }
        return counter;
    }
    
    public void goToScene(ActionEvent event, String fxml) throws IOException {
        Parent button = FXMLLoader.load(getClass().getResource(fxml));
        Scene buttonScene = new Scene(button);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(buttonScene);
        window.show();
        setController();
    }
    
    public void setController() {
        this.controller = new CheckPerformanceIndicatorsController();
    }

    @FXML
    private void showHdelays(ActionEvent event) {
        barChartHistograms.getData().clear();
        lstFreelancerAndInfo.getItems().clear();
        
        TreeMap<String, Double> lstMeanDelay;
        lstMeanDelay = this.controller.calcMeanDelay();
        TreeMap<String, Double> lstDeviationDelay;
        lstDeviationDelay = this.controller.calcDeviationDelay();
        lstFreelancerAndInfo.getItems().addAll(lstMeanDelay,lstDeviationDelay);
        
        XYChart.Series barDeviationDelay = new XYChart.Series<>();
        barChartHistograms.setTitle("Delays");
        
        barDeviationDelay.getData().add(new XYChart.Data(calcFirstIntervalDelay(),
                valuesFirstIntervalDelay(controller.determinateDelayPlatform())));
        barDeviationDelay.getData().add(new XYChart.Data(calcSecondIntervalDelay(),
                valuesSecondIntervalDelay(controller.determinateDelayPlatform())));
        barDeviationDelay.getData().add(new XYChart.Data(calcThirdIntervalDelay(),
                valuesThirdIntervalDelay(controller.determinateDelayPlatform())));
        
        System.out.println(valuesFirstIntervalDelay(controller.determinateDelayPlatform()));
        
        barChartHistograms.getData().add(barDeviationDelay);
    }

    @FXML
    private void showHpayments(ActionEvent event) {
        barChartHistograms.getData().clear();
        lstFreelancerAndInfo.getItems().clear();
        
        TreeMap<String, Double> lstMeanPayments;
        lstMeanPayments = this.controller.calcMeanPayment();
        TreeMap<String, Double> lstDeviationPayments;
        lstDeviationPayments = this.controller.calcDeviationPayment();
        lstFreelancerAndInfo.getItems().addAll(lstMeanPayments,lstDeviationPayments);

        XYChart.Series barDeviationPayment = new XYChart.Series<>();
        barChartHistograms.setTitle("Payments");
        
        barDeviationPayment.getData().add(new XYChart.Data(calcFirstIntervalPayment(),
                valuesFirstIntervalPayment(controller.determinatePayPlatform())));
        barDeviationPayment.getData().add(new XYChart.Data(calcSecondIntervalPayment(),
                valuesSecondIntervalPayment(controller.determinatePayPlatform())));
        barDeviationPayment.getData().add(new XYChart.Data(calcThirdIntervalPayment(),
                valuesThirdIntervalPayment(controller.determinatePayPlatform())));        
        
        System.out.println(valuesFirstIntervalPayment(controller.determinatePayPlatform()));
        
        barChartHistograms.getData().add(barDeviationPayment);
        
    }

    @FXML
    private void returnAction(ActionEvent event) throws IOException {
        goToScene(event, "/fxml/OptionsAdmin.fxml");
    }  
}
