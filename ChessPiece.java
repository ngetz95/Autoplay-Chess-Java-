import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Grid;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.Direction;
import java.util.ArrayList;
import java.util.Random;
import edu.kzoo.grid.TextCell;
import java.awt.Color;
import java.lang.Math;
//import edu.kzoo.util.Debug;

/**
 * Write a description of class ChessPiece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class ChessPiece extends TextCell
{
    // instance variables - replace the example below with your own

    protected Color teamColor;
    protected TextCell member;
    private String letter;
    Location yo;

    public Color getTeamColor()
    {
        return teamColor;
    }

    //Grid grid = grid();

    /**
     * Constructor for objects of class ChessPiece
     */
    public ChessPiece(String letter, Color team, Grid grid, Location home)
    {
        // initialise instance variables
        super(letter, team, grid, home);
        teamColor = team;
        yo = home;
        this.letter = letter;
        //grid = getGrid();
        //System.out.println(yo);
    }

    public boolean sameTeam(ChessPiece piece)
    {
        if(teamColor.equals(piece.getTeamColor()))
            return true;
        else
            return false;
    }
    
    public String toString()
    {
        return letter;
    }

    //TextCell(java.lang.String text, java.awt.Color textColor, Grid grid, Location loc)
    /**
     */
    //private static Random generator = new Random();
    public ArrayList<ChessPiece> moveTo(ArrayList<Location> list)
    {
        ArrayList<ChessPiece> dead = new ArrayList<ChessPiece>();
        ArrayList<Location> attack = new ArrayList<Location>();
        ArrayList<Location> move = new ArrayList<Location>();
        int choice;
        Location turn;
        for(int i = 0; i < list.size(); i++)
        {

            Location place = list.get(i);

            if(grid().isValid(place))
            {
                if(grid().isEmpty(place) == false && sameTeam((ChessPiece)grid().objectAt(place)) == false)
                {
                    attack.add(place);
                }

                else if(grid().isEmpty(place) == true)
                {
                    move.add(place);
                }
            }
        }
        if(attack.size() > 0)
        {
            choice = (int) (Math.random() * attack.size());
            turn = attack.get(choice);
            dead.add((ChessPiece)grid().objectAt(turn));
            grid().remove(turn);
            this.changeLocation(turn);
            return dead;
        }
        else if(move.size() > 0)
        {
            choice = (int) (Math.random() * move.size());
            turn = move.get(choice);
            this.changeLocation(turn);
            return dead;
        }
        else
        {
            return dead;
        }
        
    }

    public abstract ArrayList<Location> getPossibleLocations();
}
