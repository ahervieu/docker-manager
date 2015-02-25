package org.diverse.container.manager.javafxui ;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class ContainerDriverApp extends Application {


    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {

        String fxmlFile = "/fxml/ContainerDriverApp.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent rootNode = (Parent) loader.load();
        Scene scene = new Scene(rootNode);
        scene.getStylesheets().add("/styles/styles.css");
        stage.setTitle("Docker Container Resource Manager");
        stage.setScene(scene);
        stage.show();
    }
}
