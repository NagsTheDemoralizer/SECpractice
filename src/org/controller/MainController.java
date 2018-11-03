package org.controller;
import java.util.ArrayList;

public class MainController
{

    public MainController()
    {

    }

    public void start(String inputFile)
    {
        ArrayList<Long> rawData = new ArrayList<Long>();
        org.model.Parser p = org.model.Parser.getInstance();
        rawData = p.inputParser(inputFile);
        BusController.getInstance().ParseDataIntoBusStops(rawData);
        BusController.getInstance().CalculateRoutes();

        BusController.getInstance().PrintInfo();
    }

}
