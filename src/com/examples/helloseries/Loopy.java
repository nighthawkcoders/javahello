package com.examples.helloseries;
/*
 * Creator: Nighthawk Coding Society
 * Mini Lab Name: Hello Series, featuring Monkey Jumpers
 * Level: Medium
 *
 * Exploration Ideas
 * 1. Build more or entire rhyme for the "Monkey Jumpers" countdown poem
 * 2. Add names or other properties to the monkeys
 * 3. Print these monkeys horizontally
 *
 * Learning Considerations
 * Note: Loopy (Imperative Programming Style)
 * Project Focus: Animated Monkey Jumpers
 * A. Observe variable assignments
 * B. Study loops and zero based counting
 * C. Study two-dimensional (2D) arrays
 * D. Learn about and describe Imperative and Procedural Programming
 * E. Build a design diagram on a monkey as an object versus two-dimensional array
 */

/**
 * A Java utility Class that supports entry point for execution
 */
public class Loopy {
    /** main
     * entry point when testing independently
     */
    public static void main(String[] args)  {
        new MonkeyLoop().printPoem();   //a new monkey list and output in one step
    }

    /** Loop
     * constructor and entry point when instantiating from another class
     */
    public Loopy() {
        new MonkeyLoop().printPoem();
    }
}

/**
 * Class for Monkeys: a 2D array of Monkeys
 * As well as method to print the Poem
 */
class MonkeyLoop {
    //The area between class definition and the 1st method is where we keep data for object in Java
    String [][] monkeys;    //2D Array: AP CSA Unit 8: 2D array of strings
                            //2D array is like a grid [x][y]
                            // or like a spreadsheet [row][column]

    /**
     * Constructor initializes a 2D array of Monkeys
     */
    public MonkeyLoop() {
        //Storing Data in 2D arrays
        monkeys = new String[][]{   //2D array above is just a name, "new" makes a container ("object")
                //Monkey 0
                {
                        "ʕง ͠° ͟ل͜ ͡°)ʔ ",      //[0][0] eyes
                        "  \\_⏄_/  ",      //[0][1] chin
                        "  --0--   ",       //[0][2] body
                        "  ⎛   ⎞   "        //[0][3] legs
                },
                //Monkey 1
                {
                        " ʕ༼ ◕_◕ ༽ʔ",       //[1][0]
                        "  \\_⎏_/  ",
                        "  ++1++  ",
                        "   ⌋ ⌊   "
                },
                //Monkey 2
                {
                        " ʕ(▀ ⍡ ▀)ʔ",       //[2][0]
                        "  \\_⎐_/ ",
                        "  <-2->  ",
                        "  〈  〉 "
                },
                //Monkey 3
                {
                        "ʕ ͡° ͜ʖ ° ͡ʔ",        //[3][0]
                        "  \\_⍾_/  ",
                        "  ==3==  ",
                        "  _/ \\_  "
                },
                //Monkey 4
                {
                        "  (◕‿◕✿) ",          //[4][0]
                        "  \\_⍾_/ ",          //[4][1]
                        "  ==4==  ",          //[4][2]
                        "  _/ \\_ "           //[4][3]
                },

        };
    }

    /**
     * Loop and print monkeys in array
     * logic sequence as follows:
     * println 5,0, println 5,1, println 5,2, println 5,3
     * print blank line
     * println 4,0, println 4,1, println 4,2, println 4,3
     * print blank line
     * ... repeat until you reach zero  ...
     * println 0,0, println 0,1, println 0,2, println 0,3
     */
    public void printPoem() {
        //begin the poem
        System.out.println();
        System.out.println("Monkey Jumpers Poem in Java Loopy");

        // cycles through 2D array backwards
        for (int i = monkeys.length; i >= 1; i--) {

            //this print statement shows current count of Monkeys
            //  concatenation (+) of the loop variable and string to form a countdown message
            System.out.println(i + " little monkeys jumping on the bed...");

            // cycle through monkeys that are left in poem countdown
            for (int row = 0; row < i; row++) {

                // cycles through monkey part by part
                for (int col = 0; col < monkeys[row].length; col++) {
                    // prints specific part of the monkey from the 2D cell
                    System.out.println(monkeys[row][col] + " ");
                }

                //this new line gives separation between stanza of poem
                System.out.println();
            }
        }

        //out of all the loops, prints finishing messages
        System.out.println("No more monkeys jumping on the bed");
        System.out.println("0000000000000000000000000000000000");
        System.out.println("             THE END              ");
    }

}