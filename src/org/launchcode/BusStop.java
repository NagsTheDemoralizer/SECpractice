package org.launchcode;

<<<<<<< HEAD
public class BusStop {
=======
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
>>>>>>> 3fe91b38c5e0ead7c8483e1df94451f42310d431
}
