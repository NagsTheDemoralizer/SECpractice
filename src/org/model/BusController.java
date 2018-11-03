package org.model;
import java.util.ArrayList;

public class BusController
{
    /**
     * A list of routes, where a route is a list of BusStops.
     */
    private ArrayList<ArrayList<BusStop> > m_routes;

    /**
     * Takes an input of BusStops and calculates a set of routes which attempts to optimize
     * the stops based on the total distance travelled. (?)
     *
     * @param numRoutes: A number in [1,3] which specifies the number of routes to create.
     * @param busStops: A list of Bus Stops.
     */
    public void CalculateRoutes(int numRoutes, ArrayList<BusStop> busStops)
    {
        // Do fancy shit to figure out Routes.
    }
}
