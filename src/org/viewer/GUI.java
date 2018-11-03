package org.viewer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class GUI extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {



        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
//        //creating a Group object
//        Group group = new Group();
//
//        //Creating a Scene by passing the group object, height and width
//        Scene scene = new Scene(group ,600, 300);
//
//        //setting color to the scene
//        scene.setFill(Color.BROWN);
//
//        //Setting the title to Stage.
//        primaryStage.setTitle("Sample Application");
//
//        //Adding the scene to Stage
//        primaryStage.setScene(scene);
//
//        //Displaying the contents of the stage
//        primaryStage.show();
    }


}
