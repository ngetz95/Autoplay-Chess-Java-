import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Grid;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.Direction;
import java.util.ArrayList;
import edu.kzoo.grid.TextCell;
import java.awt.Color;

/**
 * Write a description of class Rook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rook extends ChessPiece
{
    // instance variables - replace the example below with your own
    Grid grid = grid();

    /**
     * Constructor for objects of class Rook
     */
    public Rook(Color team, Grid grid, Location home)
    {
        super("R", team, grid, home);
        
    }

    

    public ArrayList<Location> getPossibleLocations()
    {
        ArrayList locs = new ArrayList<Location>();
        boolean hit1 = false;
        boolean hit2 = false;
        boolean hit3 = false;
        boolean hit4 = false;
        int row1 = this.location().row();
        int row2 = this.location().row();
        int col1 = this.location().col();
        int col2 = this.location().col();
        int form = 0;
        while(hit1 == false && row1 < 8 && form == 0)
        {
            row1++;
            Location loc = new Location(row1, this.location().col());
            if(grid.isEmpty(loc) && grid.isValid(loc))
            {
                locs.add(loc);
            }
            else if(grid.isValid(loc) && !grid().isEmpty(loc))
            {
                locs.add(loc);
                form++;
                hit1 = true;
            }
            else
                form++;
            
        }
        
        
        
        while(hit2 == false && row2 >= 0 && form == 1)
        {
            row2--;
            Location loc = new Location(row2, this.location().col());
            if(grid.isEmpty(loc) && grid.isValid(loc))
            {
                locs.add(loc);
            }
            else if(grid.isValid(loc) && !grid().isEmpty(loc))
            {
                locs.add(loc);
                form++;
                hit2 = true;
            }
            else
                form++;
            
        }
        
        
        while(hit3 == false && col1 >= 0 && form == 2)
        {
            col1--;
            Location loc = new Location(this.location().row(), col1);
            if(grid.isEmpty(loc) && grid.isValid(loc))
            {
                locs.add(loc);
            }
            else if(grid.isValid(loc) && !grid().isEmpty(loc))
            {
                locs.add(loc);
                form++;
                hit3 = true;
            }
            else
                form++;
            
        }
        
        
        
        while(hit4 == false && col2 < 8 && form == 3)
        {
            col2++;
            Location loc = new Location(this.location().row(), col2);
            if(grid.isEmpty(loc) && grid.isValid(loc))
            {
                locs.add(loc);
            }
            else if(grid.isValid(loc) && !grid().isEmpty(loc))
            {
                locs.add(loc);
                form++;
                hit4 = true;
            }
            else
                form++;
        }
        
        
        return locs;
    }
}
