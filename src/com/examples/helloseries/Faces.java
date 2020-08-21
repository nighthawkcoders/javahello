package com.examples.helloseries;
/*
Creator: Nighthawk Coding Society
Mini Lab Name: Hello Series, featuring Monkey Jumpers
Level: Easy
*/

/* Faces - Monkey Faces using System.out.println()
This is just a little increment from Hello World, only differences is we are representing an "object" that requires multiple lines.
1. This contains one line of the Monkey Jumpers poem
2. It contains ASCII and more, Unicode is superset to ASCII
*/
public class Faces {

    public static void main(String[] args) {
        new Faces();  // introduction to method (this example is more like a function, why?)
        //make up to 10 characters of your own
        //how would you store monkeys in variables?
        //explore variables and see where you can get building a poem
    }

    public Faces()
    {
        /*Lookup and learn about ascii and unicode
        a lot of ascii is on keyboard a lot of the extended characters (unicode) are less known
        for unicode press control-command-space on Mac */
        //Print statements showing a concatenation of strings with uniform spacing, notice the \'s
        System.out.println("Begin Sample");
        System.out.println("4 little monkeys jumping on the bed...");
        System.out.println("ʕง ͠° ͟ل͜ ͡°)ʔ " + "\t" + "ʕ༼ ◕_◕ ༽ʔ" + "\t" + "ʕ(▀ ⍡ ▀)ʔ"  + "\t" + " ʕ ͡° ͜ʖ ° ͡ʔ");
        System.out.println("  ⌊_⏄_⌋   " + "\t" + " 〈_⎏_〉 " + "\t" + "  ⎮_⎐_⎮  "  + "\t" + "  ⍀ _⍾_ ⌿ ");
        System.out.println("  --0--    " + "\t" + " ++1++  " + "\t" + "  <-2->  "  + "\t" + "    ==3==  ");
        System.out.println("  ⎛   ⎞    " + "\t" + "  ⌋ ⌊   " + "\t" + "  〈  〉  "  + "\t" + "   _/ \\_   ");
        System.out.println("End Sample");
    }

}