package simulator;

/**
 * Represent a location in a rectangular grid.
 * 
 * @author ZHANG YUXIN
 * @version 1.0
 */
public class Location
{
    // Row and column positions.
    private int row;
    private int col;

    public Location(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
    public boolean equals(Object obj)
    {
        if(obj instanceof Location) {
            Location other = (Location) obj;
            return row == other.getRow() && col == other.getCol();
        }
        else {
            return false;
        }
    }
    
    /**
     * Return a string of the form row,column
     * @return A string representation of the location.
     */
    public String toString()
    {
        return row + "," + col;
    }

    public int hashCode()
    {
        return (row << 16) + col;
    }

    public int getRow()
    {
        return row;
    }
    

    public int getCol()
    {
        return col;
    }
}