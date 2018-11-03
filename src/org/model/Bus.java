package org.model;
import java.util.ArrayList<E>;

public class Bus {

    private static int cost;
    private static int capacity;
    private static ArrayList<BusStop> route = new ArrayList<BusStop>();
    private static int currentCap = 0;

    /*
    default constructor for Bus class
     */
    public Bus(){
        this.cost = 4;
        this.capacity = 20;
        this.route = null;
    }

    public Bus(ArrayList<BusStop> busStops){
        // change route
    }

    public static int getCurrentCap(){
        return this.currentCap;
    }

    public static void setCurrentCap(int curCap){
        currentCap += curCap;
    }

    public static int getCapacity(){
        return this.capacity;
    }

    public static void setCapacity(int cap){
        capacity = cap;
    }
}