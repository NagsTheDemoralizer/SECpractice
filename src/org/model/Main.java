package org.model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import org.controller.MainController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application
{
    private static org.controller.MainController m_mainController;
    // others.

    @Override
    public void start(Stage primaryStage) throws Exception
    {



        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
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
    public static void main(String args[])
    {
        // Aight, this is gonna be how this works.
        // 1. Set stuff up that doesn't change (idk what would fit here).
        // 2. Read input from text file.
        //     - Initalize Busses, BusStops, etc.
        //     - Create routes (see BusController).
        //     - Other stuff?
        // 3. Launch GUI.
        System.out.println("numArgs: " + args.length);
        for(int i = 0; i < args.length; i++)
        {
            System.out.println("arg: " + args[i]);
        }
        String inputFile = "test1.txt";
        if(args.length > 0)
            inputFile = args[0];
        m_mainController = new MainController();
        m_mainController.start(inputFile);

        launch(args);
    }

    public void buttonPressed(ActionEvent e)
    {
        System.out.println("Button has been pressed");
    }
}