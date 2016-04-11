import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Grid;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.Direction;
import java.util.ArrayList;
import edu.kzoo.grid.TextCell;
import java.awt.Color;

/**
 * Write a description of class Bishop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bishop extends ChessPiece
{
    

    /**
     * Constructor for objects of class Bishop
     */
    public Bishop(Color team, Grid grid, Location home)
    {
        super("B", team, grid, home);
        //member = new TextCell("B", this.teamColor,grid,home);
    }
    
    Grid grid = grid();
    

    public ArrayList<Location> getPossibleLocations()
    {
        ArrayList locs = new ArrayList<Location>();
        
        boolean hit5 = false;
        boolean hit6 = false;
        boolean hit7 = false;
        boolean hit8 = false;
        
        int row3 = this.location().row();
        int row4 = this.location().row();
        int col3 = this.location().col();
        int col4 = this.location().col();
        
        int row5 = this.location().row();
        int row6 = this.location().row();
        int col5 = this.location().col();
        int col6 = this.location().col();
        int form = 4;
        
        while(hit5 == false && row5 < 8 && col5 < 8 && form == 4)
        {
            row5++;
            col5++;
            Location loc = new Location(row5, col5);
            if(grid.isEmpty(loc) && grid.isValid(loc))
            {
                locs.add(loc);
            }
            else if(grid.isValid(loc) && !grid().isEmpty(loc))
            {
                locs.add(loc);
                form++;
                hit5 = true;
            }
            else
                form++;
            
        }
        
        while(hit6 == false && row6 >= 0 && col6 >= 0 && form == 5)
        {
            row6--;
            col6--;
            Location loc = new Location(row6, col6);
            if(grid.isEmpty(loc) && grid.isValid(loc))
            {
                locs.add(loc);
            }
            else if(grid.isValid(loc) && !grid().isEmpty(loc))
            {
                locs.add(loc);
                form++;
                hit6 = true;
            }
            else
                form++;
            
        }
        
        while(hit7 == false && col3 >= 0 && row3 < 8 && form == 6)
        {
            col3--;
            row3++;
            Location loc = new Location(row3, col3);
            if(grid.isEmpty(loc) && grid.isValid(loc))
            {
                locs.add(loc);
            }
            else if(grid.isValid(loc) && !grid().isEmpty(loc))
            {
                locs.add(loc);
                form++;
                hit7 = true;
            }
            else
                form++;
            
        }
        
        while(hit8 == false && col4 < 8 && row4 >= 0 && form == 7)
        {
            col4++;
            row4--;
            Location loc = new Location(row4, col4);
            if(grid.isEmpty(loc) && grid.isValid(loc))
            {
                locs.add(loc);
            }
            else if(grid.isValid(loc) && !grid().isEmpty(loc))
            {
                locs.add(loc);
                form++;
                hit8 = true;
            }
            else
                form++;
        }
        

        
        return locs;

    }
}
