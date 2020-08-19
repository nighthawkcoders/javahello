package com.examples.helloseries;

import java.util.HashMap;

/*
Primary Class for this file is a driver for the MonkeyList class, which sets up a list of MonkeyObject
 */
public class MonkeyJumpersL2Classy {
    public static void main(String[] args) {
        MonkeyList mlist = new MonkeyList();
        mlist.printPoem();
    }
}

/*
Class manages a list of monkeys
 */
class MonkeyList {
    int count = 0;
    MonkeyObject[] monkeys = new MonkeyObject[10];

    /*
    Constructor initializes a list monkey object
     */
    public MonkeyList() {

        //setup and array of monkeys
        monkeys[count++] = new MonkeyObject();   //Default Monkey
        monkeys[count++] = new MonkeyObject(
                " ʕ༼ ◕_◕ ༽ʔ",
                "  \\_⎏_/  ",
                "  ++1++  ",
                "   ⌋ ⌊   "
        );
        monkeys[count++] = new MonkeyObject(
                " ʕ(▀ ⍡ ▀)ʔ",
                "  \\_⎐_/ ",
                "  <-2->  ",
                "  〈  〉 "
        );
        monkeys[count++] = new MonkeyObject(
                "ʕ ͡° ͜ʖ ° ͡ʔ",
                "  \\_⍾_/  ",
                "  ==3==  ",
                "  _/ \\_  "
        );
        monkeys[count++] = new MonkeyObject(
                "  (◕‿◕✿) ",
                "  \\_⍾_/ ",
                "  ==4==  ",
                "  _/ \\_  "
        );

    }

    /*
    Simple print of the list of objects, how would you convert this toString method
     */
    public void print() {
        //setup loop to initialize each monkey
        for (MonkeyObject monkey : monkeys) {
            if (monkey != null) {   // check to see if monkey is initialized
                System.out.println(monkey);
            }
        }
    }

    /*
    Method to extract and print same body part for all monkeys in list
     */
    private void printBodyPart(int start, int end, String bp) {

        //build output string
        StringBuilder line_for_output = new StringBuilder();
        for (int i = start; i < end; i++) {
            line_for_output.append(monkeys[i].getBodyPart(bp)).append("\t");
        }
        System.out.println(line_for_output);
    }

    /*
    Method to support countdown song.
     */
    public void printPoem() {
        //prints starting message
        System.out.println("Monkey Jumpers Poem in Java Classy");

        //loop is key logic to allow printing monkeys horizontally according to countdown criteria
        for (int i = count; i >= 1; i--)   //start countdown according to monkeys in list
        {
            System.out.println(i + " little monkeys jumping on the bed...");
            printBodyPart(0, i, MonkeyObject.eyes);
            printBodyPart(0, i, MonkeyObject.chin);
            printBodyPart(0, i, MonkeyObject.body);
            printBodyPart(0, i, MonkeyObject.legs);
        }

        //prints finishing messages
        System.out.println("No more monkeys jumping on the bed");
        System.out.println("0000000000000000000000000000000000");
        System.out.println("             THE END              ");
    }

}

/*
Class contains properties of a single Monkey
 */
class MonkeyObject {
    //Dictionary names of elements in Monkey 'body parts' data table
    //We share these names (public), but no one should every change value (final)
    static public final String eyes = "eyes";
    static public final String chin = "chin";
    static public final String body = "body";
    static public final String legs = "legs";

    //Monkey 'body parts' data table
    //In CompSci this is more typically called a Name-Value pair
    //First string in HashMap is Name (eyes, chin, ...), Second string is Unicode value
    HashMap<String, String> monkey = new HashMap<>();

    //Default monkey constructor has initial set of values, this is put in place to avoid empty set scenarios
    public MonkeyObject() {
        //Add elements to the data table
        monkey.put(eyes, "ʕง ͠° ͟ل͜ ͡°)ʔ ");
        monkey.put(chin, "  \\_⏄_/  ");
        monkey.put(body, "  --0--   ");
        monkey.put(legs, "  ⎛   ⎞   ");
    }

    //A constructor with parameters to make your own monkey values
    public MonkeyObject(String eyes, String chin, String body, String legs){
        // Add elements to the map
        monkey.put(MonkeyObject.eyes, eyes);
        monkey.put(MonkeyObject.chin, chin);
        monkey.put(MonkeyObject.body, body);
        monkey.put(MonkeyObject.legs, legs);
    }

    //Override of toString, this most commonly used by System.out.println to get sensible data instead of an object
    public String toString() {
        return monkey.get(eyes) + "\n" + monkey.get(chin) + "\n" + monkey.get(body) + "\n" + monkey.get(legs)+ "\n";
    }

    //This is same as calling toString, a "getter" is a commonly expected method in a Class
    public String getMonkey() {
        return toString();
    }

    //This allows the extraction of a single portion of the monkey
    public String getBodyPart(String bp) {
        return monkey.get(bp);
    }
}
