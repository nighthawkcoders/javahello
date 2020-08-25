package com.examples.helloseries;
/*
 * Creator: Nighthawk Coding Society
 * Mini Lab Name: Hello Series, featuring Monkey Jumpers
 * Level: Easy
 *
 * Exploration Ideas
 * 1. Add methods or logic to print another line of Faces
 * 2. Start looking at ASCII versus Unicode references
 * 3. Add or create your own Anime
 *
 * Learning Considerations
 * Note: Linear program style
 * Project Focus: Stationary Monkeys
 * A. Learn about Java fundamental structure
 * B. Learn about how to transition between methods
 * C. Learn about data type String (non-primitive) )and Concatenation
 * D. Lookup and learn about ascii and unicode
 * D1. A lot of ascii is on keyboard, unicode extends ascii
 * D2. To see unicode press control-command-space on a Mac
 * E. Learn about non-primitive String data type and Concatenation
 */

/**
 * A Java utility Class that supports entry point for execution
*/
public class Stringy {
    /** main
     * entry point when testing independently
     */
    public static void main(String[] args)  {
        new MonkeyPrint();   //Using Objects: AP CSA Unit 2
    }
}

/**
 * Class for lin·e·ar·ly printing list of Monkeys
 * Writing a Class: AP CSA Unit 5
 */
class MonkeyPrint {
    public MonkeyPrint() {
        //Using Objects: AP CSA Unit 2, why is this not Primitives: AP CSA Unit 1?
        String poemMsg = "little monkeys jumping on the bed...";
        //Print statements showing a concatenation of strings with uniform spacing, notice the backslashes \'s
        System.out.println("Begin Sample");
        System.out.println(4 + poemMsg);
        System.out.println("ʕง ͠° ͟ل͜ ͡°)ʔ " + "\t" + "ʕ༼ ◕_◕ ༽ʔ" + "\t" + "ʕ(▀ ⍡ ▀)ʔ" + "\t" + " ʕ ͡° ͜ʖ ° ͡ʔ");
        System.out.println("  ⌊_⏄_⌋   " + "\t" + " 〈_⎏_〉 " + "\t" + "  ⎮_⎐_⎮  " + "\t" + "  ⍀ _⍾_ ⌿ ");
        System.out.println("  --0--    " + "\t" + " ++1++  " + "\t" + "  <-2->  " + "\t" + "    ==3==  ");
        System.out.println("  ⎛   ⎞    " + "\t" + "  ⌋ ⌊   " + "\t" + "  〈  〉  " + "\t" + "   _/ \\_   ");
        System.out.println("End Sample");
    }
}