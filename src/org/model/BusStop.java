package org.model;

/**
 * A class containing information about a bus stop. This includes the # of people waiting at the bus stop,
 * along with the start and end location.
 */
public class BusStop
{
    /**
     * The number of people waiting at the bus stop.
     */
    private int m_people;

    /**
     * The start location.
     */
    private Location m_startLoc;

    /**
     * The destination location.
     */
    private Location m_endLoc;

    public BusStop()
    {
        // error
    }

    public BusStop(int people, Location start, Location end)
    {
        m_people = people;
        m_startLoc = start;
        m_endLoc = end;
    }

    /**
     * Attempt to pick up all people from the Bus Stop onto Bus b. This should happen when a Bus arrives at the stop.
     * This checks the available capacity of the Bus and picks up as many people as possible.
     *
     * @param b: The Bus picking up people.
     */
    public void pickup(Bus b)
    {
        m_people -= (b.getCurrentCap() >= m_people)? m_people : b.getCurrentCap();
        b.setCurrentCap(b.getCurrentCap() - m_people);
    }

    /**
     * Drop off @capacity people at the Bus Stop. A Bus Stop does not have a maximum capacity so
     * it should be this straightforward.
     *
     * @param b: The Bus dropping off people.
     */
    public void dropoff(Bus b)
    {
        m_people += (b.getCapacity() - b.getCurrentCap());
        b.setCurrentCap(0);
    }

    public Location getStartLoc() { return m_startLoc; }
    public Location getEndLoc() { return m_endLoc; }
    public int getPeople() { return m_people; }
}
