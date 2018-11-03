package org.controller;
import java.util.ArrayList;

public class MainController
{
    private org.model.BusController m_busController;

    public MainController()
    {
        m_busController = new org.model.BusController(3);
    }

    public void start(String inputFile)
    {
        ArrayList<Long> rawData = new ArrayList<Long>();
        org.model.Parser p = org.model.Parser.getInstance();
        rawData = p.inputParser(inputFile);
        m_busController.ParseDataIntoBusStops(rawData);

        m_busController.PrintInfo();
    }
}
