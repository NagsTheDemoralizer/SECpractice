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
     * Attempt to pick up all people from the Bus Stop. This should happen when a Bus arrives at the stop.
     * The calling Bus should probably add the return value to their recorded capacity.
     *
     * @param capacity: The available capacity of the Bus.
     * @return The number of people picked up from the stop.
     */
    public int pickup(int capacity)
    {
        int pickup = (capacity >= m_people)? m_people : capacity;
        m_people -= pickup;
        return pickup;
    }

    /**
     * Drop off @capacity people at the Bus Stop. A Bus Stop does not have a maximum capacity so
     * it should be this straightforward.
     * @param capacity: The number of people being dropped off.
     */
    public void dropoff(int capacity)
    {
        m_people += capacity;
    }

}
