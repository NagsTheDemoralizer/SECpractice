package org.model;
import java.util.ArrayList;

public class BusController
{
    /**
     * A list of routes, where a route is a list of BusStops.
     */
    private ArrayList<ArrayList<BusStop> > m_routes;
    /**
     * A list of bus stops.
     */
    private ArrayList<BusStop> m_stops;
    /**
     * A number in [1,3] which specifies the number of routes to create.
     */
    private int m_numRoutes;

    public BusController(int numRoutes)
    {
        m_stops = new ArrayList<BusStop>();
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
     */
    public void CalculateRoutes()
    {
        ArrayList<BusStop> busStops = m_stops;
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

    /**
     * Does shit.
     * @param rawData
     */
    public void ParseDataIntoBusStops(ArrayList<Long> rawData)
    {
        for(int i = 0; i < rawData.size(); i++)
        {
            long data = rawData.get(i);
            int numPeople = (int)data % 100;
            data /= 100;
            int destCol = (int)data % 100;
            data /= 100;
            int destRow = (int)data % 100;
            data /= 100;
            int startCol = (int)data % 100;
            data /= 100;
            int startRow = (int)data % 100;

            m_stops.add(new BusStop(numPeople, new Location(startRow, startCol), new Location(destRow, destCol)));
        }
    }

    /**
     * Just a test function to print the info after parsing.
     */
    public void PrintInfo()
    {
        System.out.println("Parsed Bus Data:");
        for(int i = 0; i < m_routes.size(); i++)
        {
            System.out.println("Route #1");
            for(int j = 0; j < m_routes.get(i).size(); j++)
            {
                System.out.println("\tStop #:" + (j+1));
                BusStop s = m_routes.get(i).get(j);
                System.out.println("\tPeople: " + s.getPeople());
                System.out.println("\tStartLoc: (" + s.getStartLoc().getRow() + ", " + s.getStartLoc().getCol() + ")");
                System.out.println("\tEndLoc  : (" + s.getEndLoc().getRow() + ", " + s.getEndLoc().getCol() + ")");
            }
        }
    }

    public void drivingInstruct(int routeNum){
        System.out.println("Printing driving instructions for Route #" +routeNum);
        for(int j = 0; j < m_routes.get(routeNum).size(); j++)
        {
            System.out.println("\tStop #:" + (j+1));
            BusStop s = m_routes.get(routeNum).get(j);
            System.out.println("\tStartLoc: (" + s.getStartLoc().getRow() + ", " + s.getStartLoc().getCol() + ")");
            System.out.println("\tEndLoc  : (" + s.getEndLoc().getRow() + ", " + s.getEndLoc().getCol() + ")");
        }
    }
}

