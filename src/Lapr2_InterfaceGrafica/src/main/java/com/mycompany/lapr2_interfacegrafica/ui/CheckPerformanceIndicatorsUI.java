package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.controller.CheckPerformanceIndicatorsController;
import com.mycompany.lapr2_interfacegrafica.ui.MainApp;
import java.io.UnsupportedEncodingException;
import java.net.URL;
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
import javafx.scene.control.TextField;

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
    private TextField txtNormalDistribution;
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
        
        //falta outros intervalos!!
        
        
        barChartHistograms.getData().addAll(barMeanDelay);
    }

    @FXML
    private void deviationDelay(ActionEvent event) {
        TreeMap<String, Double> lstDeviationDelay;
        lstDeviationDelay = this.controller.calcDeviationDelay();
        lstFreelancerAndInfo.getItems().setAll(lstDeviationDelay);
    }

    @FXML
    private void meanPayment(ActionEvent event) {
        TreeMap<String, Double> lstMeanPayment;
        lstMeanPayment = this.controller.calcMeanPayment();
        lstFreelancerAndInfo.getItems().setAll(lstMeanPayment);
    }

    @FXML
    private void deviationPayment(ActionEvent event) {
        TreeMap<String, Double> lstDeviationPayment;
        lstDeviationPayment = this.controller.calcMeanPayment();
        lstFreelancerAndInfo.getItems().setAll(lstDeviationPayment);
    }

    @FXML
    private void cleanAll(ActionEvent event) {
        lstFreelancerAndInfo.getItems().clear(); 
    }

    @FXML
    private void normalDistribution(ActionEvent event) {
        this.controller.determinateNormalDistribution();
    }
    
    private double getInferiorLimitPayment(){
        return controller.determinateIntervals(controller.calcDeviationPayment())
                - controller.determinateIntervals(controller.calcDeviationPayment());
    }
    
    private double getInferiorLimitDelay(){
        return controller.determinateIntervals(controller.calcDeviationDelay())
                - controller.determinateIntervals(controller.calcDeviationDelay());
    }
    
    private double getSuperiorLimitPayment(){
        return controller.determinateIntervals(controller.calcDeviationPayment())
                + controller.determinateIntervals(controller.calcDeviationPayment());        
    }
    
    private double getSuperiorLimitDelay(){
        return controller.determinateIntervals(controller.calcDeviationDelay())
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
    
    private int valuesFirstIntervalDelay(TreeMap<String, Double> map){
        return 0;
    }
    
}
