package com.examples.helloseries;
/*
Creator: Nighthawk Coding Society
Mini Lab Name: Monkey Jumpers
Level: Easy
*/

/*
How to build Monkey Jumper rhyme in code (Imperative Programming Style)
1. Build the entire rhyme Ten to One monkey in countdown, see sample
2. Look at and learn about variable assignments
3. Study loops and zero based counting
4. The challenge is to understand how to create a two-dimensional structure and referencing elements
*/

public class MonkeyJumpersL1Loopy {

    public static void main(String[] args) {
        iterative();  // introduction to method (this example is more like a function, why?)
        //how would you print them horizontally?
        //think about monkeys as an object and jumping as an action
        //each monkey needs static, action, falling off state
    }

    public static void iterative()
    {

    // Setup 10 monkeys in the characters in a structure, be creative

        //Storing Data in 2D arrays
        String[][] monkeys = {
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
                        "(◕‿◕✿) ",          //[4][0]
                        "\\_⍾_/ ",          //[4][1]
                        "==4==  ",          //[4][2]
                        "_/ \\_ "           //[4][3]
                },

        };

    /*
    loop pull first element out of each slot
    logic 0,0, 0,1, 0,2, 0,3, 1,0, 1,1, 1,2, 1,3, 2,0, 2,1, 2,2, 2,3, ....
    */

        //begin the poem
        System.out.println();
        System.out.println("Monkey Jumpers Poem in Java Loopy");

        int num = 0;

        int monkeyCount = monkeys.length;        //how many monkeys do we have defined above?
        for (int i = monkeyCount; i >= 1; i--)   //loop through logic of code according to the monkey count
        {

            //this print statement shows current count of Monkeys
            //   Two key concepts:
            //   1. A concatenation (+) of the loop variable and string to form a countdown message
            System.out.println(i + " little monkeys jumping on the bed...");

            //how many separate parts are there in a monkey monkey?
            for (int row = 0; row < monkeyCount; row++)  //cycles through rows of 2d array
            {

            /*cycles through columns to print
            each monkey part by part, will eventually print entire column*/
                for (int col = 0; col < monkeys[row].length; col++)

                {

                    // prints specific part of the monkey from the column
                    System.out.print(monkeys[row][col] + " ");

                    //this is new line between separate parts
                    System.out.println();
                }

                //this new line gives separation between stanza of poem
                System.out.println();
            }

            //countdown for poem, changes output and loop control by decrementing monkeyCount variable
            monkeyCount -= 1;
        }

        //out of all the loops, prints finishing messages
        System.out.println("No more monkeys jumping on the bed");
        System.out.println("0000000000000000000000000000000000");
        System.out.println("             THE END              ");
    }

    //testing

}
