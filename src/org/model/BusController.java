package org.model;
import java.util.ArrayList;

public class BusController
{
    /**
     * A list of routes, where a route is a list of BusStops.
     */
    private ArrayList<ArrayList<BusStop> > m_routes;
    /**
     * A number in [1,3] which specifies the number of routes to create.
     */
    private int m_numRoutes;

    public BusController(int numRoutes)
    {
        if(numRoutes > 3 || numRoutes < 1)
        {
            // error
            return;
        }
        m_numRoutes = numRoutes;
        for(int i = 0; i < m_numRoutes; i++)
            m_routes.add(new ArrayList<BusStop>());
    }

    /**
     * Takes an input of BusStops and calculates a set of routes which attempts to optimize
     * the stops based on the total distance travelled. (?)
     *
     * @param busStops: A list of Bus Stops.
     */
    public void CalculateRoutes(ArrayList<BusStop> busStops)
    {
        // Do fancy shit to figure out Routes.

        // Naive approach, just create arbitrary routes.
        // Damn this is spaghetti code if i've ever seen it.
        int cur = 0;
        ArrayList<BusStop> route1 = new ArrayList<BusStop>();
        ArrayList<BusStop> route2 = new ArrayList<BusStop>();
        ArrayList<BusStop> route3 = new ArrayList<BusStop>();
        for(int i = 0; i < busStops.size(); i++)
        {
            if(i % m_numRoutes == 0)
            {
                route1.add(busStops.get(i));
            }
            else if(i % m_numRoutes == 1)
            {
                route2.add(busStops.get(i));
            }
            else
            {
                route3.add(busStops.get(i));
            }

        }
        m_routes.add(route1);
        if(m_numRoutes > 1) m_routes.add(route2);
        if(m_numRoutes > 2) m_routes.add(route3);
    }

    /**
     * Calculates distance between two locations.
     * @param start: First location.
     * @param end: Second location
     * @return Distance between start and end.
     */
    private int CalculateDistanceBetweenLocations(Location start, Location end)
    {
        /* Literally just subtracts the rows and columns and then sums them. */
        return (Math.abs(start.getCol() - end.getCol()) + Math.abs(start.getRow() - end.getRow()));
    }

    public int CalculateShortestDistance(BusStop stop)
    {
        return CalculateDistanceBetweenLocations(stop.getStartLoc(), stop.getEndLoc());
    }

    /**
     * This is gonna be way harder. Calculate minimum possible distance of a route.
     *
     * @param route: The route to calculate the distance to traverse.
     * @return Ideally the minimum distance to traverse the route. Or just a small distance if performance is
     *         valued over minimization (doubtful).
     */
    public int CalculateShortestDistance(ArrayList<BusStop> route)
    {
        // Naive approach, just iterate through bus stops, go to all pick up points, then go to all drop off points.
        // This is an absolutely horrendous way to do this. O(n) where n is # of stops. Very bad optimality.

        // idk if this works or not.
        if(route.size() == 0) return 0;
        if(route.size() == 1) return CalculateShortestDistance(route.get(0));

        int totalDist = 0;
        Location current = route.get(0).getStartLoc();
        Location next = current;
        for(int i = 1; i < route.size(); i++)
        {
            next = route.get(i).getStartLoc();
            totalDist += CalculateDistanceBetweenLocations(current, next);
            current = next;
        }
        for(int i = 0; i < route.size(); i++)
        {
            next = route.get(i).getEndLoc();
            totalDist += CalculateDistanceBetweenLocations(current, next);
            current = next;
        }
        return totalDist;
    }
}
