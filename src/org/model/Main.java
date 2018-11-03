package org.model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application
{
    private BusController m_busController;
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


        launch(args);
    }

    private ArrayList<Integer> inputParser(String file){


        String fileName = "C:\\Users\\anagr\\OneDrive\\Documents\\Github\\SECpractice\\src\\org\\model\\test.txt";
        Scanner inputStream = null;
        System.out.println("The file " + fileName +
                "\ncontains the following lines:\n");

        try
        {
            inputStream = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file " +
                    fileName);
            System.exit(0);
        }

        //ArrayList<String> alist = new ArrayList<>();
        ArrayList<Integer> intlist = new ArrayList<Integer>();

        for (int x = 0; inputStream.hasNextLine(); x++) {
            intlist.add(inputStream.nextInt());
        }
        inputStream.close();

        /*
        for (int x = 0; x < intlist.size(); x++){
            System.out.println(intlist.get(x));
        }*/

        return intlist;

    }

    public void buttonPressed(ActionEvent e)
    {
        System.out.println("Button has been pressed");
    }
}