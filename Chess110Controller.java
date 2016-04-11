// Class: Chess110Controller
//
// Author: Alyce Brady
//
// Created on Feb 26, 2004
//
// License Information:
//   This class is free software; you can redistribute it and/or modify
//   it under the terms of the GNU General Public License as published by
//   the Free Software Foundation.
//
//   This class is distributed in the hope that it will be useful,
//   but WITHOUT ANY WARRANTY; without even the implied warranty of
//   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//   GNU General Public License for more details.

import java.awt.Color;

import edu.kzoo.grid.BoundedGrid;
import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Grid;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.gui.SteppedGridAppController;
import edu.kzoo.util.Debug;
import edu.kzoo.grid.TextCell;
import java.util.ArrayList;
import java.lang.Math;

/**
 *  Chess 110:<br>
 *
 *  A <code>Chess110Controller</code> object controls the action
 *  of a Chess 110 chess game.
 *
 *  @author Alyce Brady
 *  @version Feb 26, 2004
 **/
public class Chess110Controller extends SteppedGridAppController
{
    private boolean whitesTurn = true;
    private ChessPiece whiteKing = null, blackKing = null;
    private Chess110GUI gui = null;
    private boolean end = false;
    //private boolean revive = false;
    //public Grid grid = getGrid();
    ArrayList<ChessPiece> whiteTeam = new ArrayList<ChessPiece>();
    ArrayList<ChessPiece> blackTeam = new ArrayList<ChessPiece>();
    Grid grid;

    /** Constructs a Chess110Controller to control the progress of a
     *  Chess 110 game.  This should be followed up with a call to
     *  <code>setGUI</code>.
     */
    public Chess110Controller()
    {
    }

    /** Sets the graphical user interface that the controller will
     *  communicate with as the game progresses.
     **/
    public void setGUI(Chess110GUI gui)
    {
        this.gui = gui;
    }

    /* (non-Javadoc)
     * @see edu.kzoo.grid.gui.GridAppController#step()
     */
    public void step()
    {
        // If the game is over, don't do anything.
        if ( hasReachedStoppingState() )
            return;

        //System.out.println(whiteTeam.size());
        //System.out.println(blackTeam.size());

        // Otherwise, move all the pieces that can move for the current player.
        else if(whitesTurn == true && end == false)
        {
            int whiteArmy = whiteTeam.size();
            //for(int i = 0; i < whiteArmy; i++)
            {
                ChessPiece currentPiece = whiteTeam.get((int) (Math.random() * whiteArmy));
                System.out.println("White " + currentPiece + " at " + currentPiece.location());
                ArrayList<ChessPiece> dead = currentPiece.moveTo(currentPiece.getPossibleLocations());
                Location home = currentPiece.location();
                System.out.println(" moves to " + home);
                for(int j = 0; j < dead.size(); j++)
                {
                    ChessPiece deadPiece = dead.get(j);

                    if(deadPiece.toString().equals("K"))
                    {
                        System.out.println("WHITE WINS");
                        end = true;
                    }
                    blackTeam.remove(deadPiece);

                }

                if(currentPiece.location().row() == 0 && currentPiece.toString().equals("P"))
                {
                    grid.remove(home);
                    whiteTeam.remove(currentPiece);
                    Queen revivedWhiteQueen = new Queen(Color.WHITE, grid, home);
                    whiteTeam.add(revivedWhiteQueen);
                    whiteArmy--;
                }

            }
        }
        else if(whitesTurn == false && end == false)
        {
            int blackArmy = blackTeam.size();
            //for(int i = 0; i < blackArmy; i++)
            {
                ChessPiece currentPiece = blackTeam.get((int) (Math.random() * blackArmy));
                System.out.println("Black " + currentPiece + " at " + currentPiece.location());
                ArrayList<ChessPiece> dead = currentPiece.moveTo(currentPiece.getPossibleLocations());
                Location home = currentPiece.location();
                System.out.println(" moves to " + home);
                for(int j = 0; j < dead.size(); j++)
                {
                    ChessPiece deadPiece = dead.get(j);

                    if(deadPiece.toString().equals("K"))
                    {
                        System.out.println("BLACK WINS");
                        end = true;
                    }
                    whiteTeam.remove(deadPiece);

                }

                if(currentPiece.location().row() == 7 && currentPiece.toString().equals("P"))
                {
                    grid.remove(home);
                    blackTeam.remove(currentPiece);
                    Queen revivedBlackQueen = new Queen(Color.BLACK, grid, home);
                    blackTeam.add(revivedBlackQueen);
                    blackArmy--;
                }
            }
        }

        // Next time it should be the other player's turn.

        whitesTurn = ! whitesTurn;
    }

    /* (non-Javadoc)
     * @see edu.kzoo.grid.gui.GridAppController#hasReachedStoppingState()
     */
    public boolean hasReachedStoppingState()
    {
        // If the pieces haven't been initialized yet, the game hasn't started.
        if(end == true)
            return true;
        /**
        if (whiteKing == null && blackKing == null)
        return false;

        // Determine if the game is over (one of the kings has been captured).
        else if (whiteKing == null && blackKing != null)
        return true;

        else if (whiteKing != null && blackKing == null)
        return true;
         */

        // Otherwise return false;
        else
            return false;
    }

    /* (non-Javadoc)
     * @see edu.kzoo.grid.gui.GridAppController#init()
     */
    public void init()
    { 
        Debug.turnOn();
        Debug.println("=== Beginning of Game ===");
        gui.setGrid(new BoundedGrid(true, 8, 8));
        grid = getGrid();

        // Initialize the board for the game.

        for(int i = 0; i < 8; i++)
        {
            Location home = new Location(1,i);
            Pawn blackPawn = new Pawn(Color.BLACK, grid, home);
            blackTeam.add(blackPawn);
        }

        for(int i = 0; i < 8; i++)
        {
            Location home = new Location(0,i);

            if(i == 1 || i == 6)
            {
                Knight blackKnight = new Knight(Color.BLACK, grid, home);
                blackTeam.add(blackKnight);
            }

            if(i == 2 || i == 5)
            {
                Bishop blackBishop = new Bishop(Color.BLACK, grid, home);
                blackTeam.add(blackBishop);
            }

            if(i == 3)
            {
                Queen blackQueen = new Queen(Color.BLACK, grid, home);
                blackTeam.add(blackQueen);
            }

            if(i == 4)
            {
                King blackKing = new King(Color.BLACK, grid, home);
                blackTeam.add(blackKing);
            }

            if(i == 0 || i == 7)
            {
                Rook blackRook = new Rook(Color.BLACK, grid, home);
                blackTeam.add(blackRook);
            }
        }

        for(int i = 0; i < 8; i++)
        {
            Location home = new Location(6,i);
            Pawn whitePawn = new Pawn(Color.WHITE, grid, home);
            whiteTeam.add(whitePawn);
        }

        for(int i = 0; i < 8; i++)
        {

            Location home = new Location(7,i);

            if(i == 1 || i == 6)
            {
                Knight whiteKnight = new Knight(Color.WHITE, grid, home);
                whiteTeam.add(whiteKnight);
            }

            if(i == 2 || i == 5)
            {
                Bishop whiteBishop = new Bishop(Color.WHITE, grid, home);
                whiteTeam.add(whiteBishop);
            }

            if(i == 3)
            {
                Queen whiteQueen = new Queen(Color.WHITE, grid, home);
                whiteTeam.add(whiteQueen);
            }

            if(i == 4)
            {
                King whiteKing = new King(Color.WHITE, grid, home);
                whiteTeam.add(whiteKing);
            }

            if(i == 0 || i == 7)
            {
                Rook whiteRook = new Rook(Color.WHITE, grid, home);
                whiteTeam.add(whiteRook);
            }
        }

        whitesTurn = true;
    }

}
