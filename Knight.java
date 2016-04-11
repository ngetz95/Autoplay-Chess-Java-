import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Grid;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.Direction;
import java.util.ArrayList;
import edu.kzoo.grid.TextCell;
import java.awt.Color;

/**
 * Write a description of class Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight extends ChessPiece
{

    /**
     * Constructor for objects of class Knight
     */
    public Knight(Color team, Grid grid, Location home)
    {
        super("H", team, grid, home);
        //member = new TextCell("H", this.teamColor,grid,home);
    }

    Grid grid = grid();

    /**
     */
    public ArrayList<Location> getPossibleLocations()
    {

        ArrayList locs = new ArrayList<Location>();

        Location locA = new Location(this.location().row() + 2, this.location().col() + 1);
        if(grid.isValid(locA))
        {
            locs.add(locA);
        }

        Location locB = new Location(this.location().row() + 2, this.location().col() - 1);
        if(grid.isValid(locB))
        {
            locs.add(locB);
        }

        Location locC = new Location(this.location().row() - 2, this.location().col() + 1);
        if(grid.isValid(locC))
        {
            locs.add(locC);
        }

        Location locD = new Location(this.location().row() - 2, this.location().col() - 1);
        if(grid.isValid(locD))
        {
            locs.add(locD);
        }

        Location locE = new Location(this.location().row() + 1, this.location().col() + 2);
        if(grid.isValid(locE))
        {
            locs.add(locE);
        }

        Location locF = new Location(this.location().row() + 1, this.location().col() - 2);
        if(grid.isValid(locF))
        {
            locs.add(locF);
        }

        Location locG = new Location(this.location().row() - 1, this.location().col() + 2);
        if(grid.isValid(locG))
        {
            locs.add(locG);
        }

        Location locH = new Location(this.location().row() - 1, this.location().col() - 2);
        if(grid.isValid(locH))
        {
            locs.add(locH);
        }

        
        return locs;
    }
}
