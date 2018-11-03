package org.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class GuiController
{
    @FXML
    private TextArea routeText;

    @FXML
    public void route1Pressed(ActionEvent e)
    {
        System.out.println("Route 1 pressed");
        routeText.setText("ey");
    }
}
