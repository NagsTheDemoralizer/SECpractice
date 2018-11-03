package org.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class GuiController
{
    @FXML
    private TextArea routeText;
    @FXML
    private TextArea routeInformation;

    @FXML
    public void route1Pressed(ActionEvent e)
    {
        String s = BusController.getInstance().DrivingInstructions(0);

        System.out.println("Route 1 pressed");
        routeText.setText(s);
    }

    @FXML
    public void route2Pressed(ActionEvent e)
    {
        String s = BusController.getInstance().DrivingInstructions(1);

        System.out.println("Route 2 pressed");
        routeText.setText(s);
    }

    @FXML
    public void route3Pressed(ActionEvent e)
    {
        String s = BusController.getInstance().DrivingInstructions(2);

        System.out.println("Route 1 pressed");
        routeText.setText(s);
    }

    @FXML
    public void routeInfoPressed(ActionEvent e)
    {
        String s = BusController.getInstance().DrivingInstructions(1);

        System.out.println("Route 1 pressed");
        routeText.setText(s);
    }

    @FXML
    public void changeValuesPressed(ActionEvent e)
    {


//        System.out.println("Route 1 pressed");
//        String s = "what is this";
//        routeText.setText(s);
    }

    @FXML
    public void showRouteInfo(ActionEvent e)
    {
        routeInformation.setText(BusController.getInstance().PrintInfo());
    }

}
