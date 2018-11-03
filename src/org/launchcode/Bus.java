package org.launchcode;
import java.util.ArrayList<E>;

public class Bus {

    private int cost;
    private int capacity;
    private ArrayList<BusStop> route = new ArrayList<BusStop>();
    private int currentCap = 0;

    public Bus(){
        this.cost = 4;
        this.capacity = 20;
        this.route = null;
    }

    public Bus(ArrayList<BusStop> busStops){
        // change route
    }
}
