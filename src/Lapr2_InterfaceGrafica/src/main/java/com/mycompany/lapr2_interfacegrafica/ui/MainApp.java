package com.mycompany.lapr2_interfacegrafica.ui;

import com.mycompany.lapr2_interfacegrafica.authorization.FacadeAuthorization;
import com.mycompany.lapr2_interfacegrafica.controller.POTApplication;
import com.mycompany.lapr2_interfacegrafica.model.Constants;
import com.mycompany.lapr2_interfacegrafica.model.Platform;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainApp extends Application {

    public static final String TITULO_APLICACAO = "  ";

    private Stage stage;
    private final double MINIMUM_WINDOW_WIDTH = 400.0;
    private final double MINIMUM_WINDOW_HEIGHT = 300.0;
    private final double SCENE_WIDTH = 450.0;
    private final double SCENE_HEIGHT = 350.0;
    private POTApplication potApplication = new POTApplication();

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoginWindow.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setTitle(TITULO_APLICACAO);
        stage.setScene(scene);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alert = AlertUI.createAlert(Alert.AlertType.CONFIRMATION, TITULO_APLICACAO, "Exit Confirmation", "Are you sure you want to leave the app?");

                if (alert.showAndWait().get() == ButtonType.CANCEL) {
                    event.consume();
                } else {
                    try {
                        serializeData();
                    } catch (IOException ex) {
                        Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        readFromBinaryFile();
        JanelaLogin_1_UI loginUI = loader.getController();
        loginUI.setStage(stage);
        stage.show();
//        this.stage = stage;
//        stage.setTitle("Demo Maven and JavaFX Application");
//        stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
//        stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
//        toMainScene();
//        this.stage.show();
//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
//
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add("/styles/Styles.css");
//
//        stage.setTitle("JavaFX and Maven");
//        stage.setScene(scene);
//        stage.show();
    }

    private void readFromBinaryFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        File platformData = new File("PlatformData.bin");
        if (platformData.length() != 0) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("PlatformData.bin"));
            Platform plat = (Platform) in.readObject();
            POTApplication.setPlatform(plat);
        }
        File loginData = new File("LoginData.bin");
        if(loginData.length()==0){
            POTApplication.getFacadeAuthorization().registesUserWithRole("Rui", "ruiadmin@t4j.com", Constants.ADMINISTRATOR_ROLE);
        } else{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("LoginData.bin"));
            FacadeAuthorization facadeAuthorization = (FacadeAuthorization) in.readObject();
            POTApplication.setAuthorizationFacade(facadeAuthorization);
        }
    }

    public void serializeData() throws FileNotFoundException, IOException{
        ObjectOutputStream platData = new ObjectOutputStream(new FileOutputStream("PlatformData.bin"));
        platData.writeObject(POTApplication.getPlatform());
        ObjectOutputStream loginData= new ObjectOutputStream (new FileOutputStream("LoginData.bin"));
        loginData.writeObject(POTApplication.getFacadeAuthorization());
        
        
    }
    
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
