import edu.kzoo.grid.display.DisplayMap;
import edu.kzoo.grid.display.TextCellDisplay;

// Class: Chess110App
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

/**
 *  Chess 110:<br>
 *
 *  The <code>Chess110App</code> class provides the <code>main</code>
 *  method for a Chess 110 chess program.
 *
 *  @author Alyce Brady
 *  @version Feb 26, 2004
 **/
public class Chess110App
{
    public static void main(String[] args)
    {
        // Create the object that will control the game.
        Chess110Controller controller = new Chess110Controller();

        // Create the object that will provide the Graphical User Interface.
        // Chess pieces will be represented by single letters (e.g., K, Q, P).
        DisplayMap.associate("edu.kzoo.grid.TextCell", new TextCellDisplay());
        Chess110GUI gui = new Chess110GUI(controller);
    }
}
