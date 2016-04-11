import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Grid;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.Direction;
import java.util.ArrayList;
import edu.kzoo.grid.TextCell;
import java.awt.Color;

/**
 * Write a description of class Pawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pawn extends ChessPiece
{
    //Grid grid;
    //Location home;
    /**
     * Constructor for objects of class Pawn
     */
    public Pawn(Color team, Grid grid, Location yo)
    {
        super("P", team, grid, yo);
        //System.out.println(grid);
        //member = new TextCell("P", this.teamColor,grid,yo);
    }

    /**

     */
    public ArrayList<Location> getPossibleLocations()
    {
        int s = 1;

        if(this.teamColor == Color.WHITE)
        {
            s = -1;
        }

        if(this.teamColor == Color.BLACK)
        {
            s = 1;
        }

        ArrayList locs = new ArrayList<Location>();

        Location locA = new Location(location().row() + s, location().col());

        if(grid().isValid(locA))
        {

            locs.add(locA);
        }

        Location locB = new Location(location().row() + s, location().col() + 1);
        if(grid().isValid(locB) && grid().isEmpty(locB) == false)
        {

            locs.add(locB);
        }

        Location locC = new Location(location().row() + s, location().col() - 1);
        if(grid().isValid(locC)&& grid().isEmpty(locB) == false)
        {

            locs.add(locC);
        }

        Location locD = new Location(location().row() + (2*s), location().col());
        if(grid().isValid(locD))
        {
            if(this.teamColor == Color.WHITE && locD.row() == 4)
            {
                locs.add(locD);
            }
            else if(this.teamColor == Color.BLACK && locD.row() == 3)
            {
                locs.add(locD);
            }    
        }

        return locs;
    }
}
