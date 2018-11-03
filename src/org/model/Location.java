package org.model;

/**
 * A helper class containing information about a bus stop location.
 */
public class Location
{
    /**
     * The row of the bus stop (0-indexed). Must be <= 8.
     */
    private int m_row;

    /**
     * The column of the bus stop (0-indexed). Must be <= 10.
     */
    private int m_col;

    public Location(int row, int col)
    {
        if(row > 8)
        {
            // error
        }
        if(col > 10)
        {
            // error
        }
        m_row = row;
        m_col = col;
    }

    public Location()
    {
        // exception
    }

    public int getRow() { return m_row; }
    public int getCol() { return m_col; }
}
