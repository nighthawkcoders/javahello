/*
Creator: Nighthawk Coding Society
Mini Lab Name: Monkey Jumpers
Level: Easy
*/
package com.examples.helloseries;

import java.util.HashMap;

/*
    How to build Monkey Jumper rhyme in code (OOP Programming Style)
    1. Build the entire rhyme Seven to One monkey in countdown, see sample
    2. Look at and learn about constructors
    3. Study monkey object and list of monkeys
    4. Study HashMap
    5. Look at StringBuilder
*/
public class MonkeyJumpersL2Classy {
    public static void main(String[] args) throws InterruptedException {
        oop(); // introduction to method (this example is more like a function, why?)
        //how would you print these monkeys vertically?
        //add names to the monkeys
        //change list to ArrayList and make implementation dynamic, prove it!
        //build a project with your ascii/unicode art logo, experiment with animation
        //run you logo from shell (deployed java)
    }

    public static void oop() throws InterruptedException {
        MonkeyList monkeyList = new MonkeyList();
        monkeyList.printPoem();
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
                 "ʕ༼ ◕_◕ ༽ʔ",
                 "  \\_⎏_/ ",
                "  ++1++ ",
                 "   ⌋ ⌊  ",
                "ʕ༼ ◕_◕ ༽ʔ",
                "  \\___/ ",
                "  +++++ ",
                "  〈  〉 "
        );
        monkeys[count++] = new MonkeyObject(
                "ʕ(▀ ⍡ ▀)ʔ",
                "  \\___/ ",
                "  <-2-> ",
                "  〈  〉 ",
                "ʕ(▀ ⍡ ▀)ʔ",
                "  \\_⎐_/ ",
                "  <--->  ",
                "   ⌋  ⌊  "
        );
        monkeys[count++] = new MonkeyObject(
                " ʕ ͡° ͜ʖ ° ͡ʔ ",
                "   \\___/",
                "   ==3== ",
                "   _/ \\_",
                " ʕ ͡° ͜ʖ ° ͡ʔ ",
                "   \\_⍾_/ ",
                "   ===== ",
                "   〈  〉 "
        );
        monkeys[count++] = new MonkeyObject(
                " ʕ(◕‿◕✿)ʔ ",
                "   \\_⍾_/ ",
                "   ==4==  ",
                "   _/ \\_  ",
                " ʕ(◕‿◕✿)ʔ ",
                "   \\___/  ",
                "   =====  ",
                "    〈  〉  "
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
            line_for_output.append(String.format("%-12s \t", monkeys[i].getBodyPart(bp)));
        }
        System.out.println(line_for_output);
    }

    /*
    Method to support countdown song.
     */
    public void printPoem() throws InterruptedException {
        //prints starting message
        System.out.println("Monkey Jumpers Poem in Java Classy");

        //loop is key logic to allow printing monkeys horizontally according to countdown criteria
        for (int i = count; i >= 1; i--)   //start countdown according to monkeys in list
        {
            int delay = 3500; int delay_step = 700; boolean toggle = true;
            for (int sleep = 0; sleep < delay; sleep += delay_step ) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(i + " little monkeys jumping on the bed...");

                if (toggle) {
                    printBodyPart(0, i, MonkeyObject.eyes);
                    printBodyPart(0, i, MonkeyObject.chin);
                    printBodyPart(0, i, MonkeyObject.body);
                    printBodyPart(0, i, MonkeyObject.legs);
                } else {
                    printBodyPart(0, i, MonkeyObject.eyes2);
                    printBodyPart(0, i, MonkeyObject.chin2);
                    printBodyPart(0, i, MonkeyObject.body2);
                    printBodyPart(0, i, MonkeyObject.legs2);
                }
                Thread.sleep(delay_step);   //delay
                toggle = !toggle;           //flip toggle
            }
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
    static public final String eyes2 = "eyes2";
    static public final String chin2 = "chin2";
    static public final String body2 = "body2";
    static public final String legs2 = "legs2";

    //Monkey 'body parts' data table
    //In CompSci this is more typically called a Name-Value pair
    //First string in HashMap is Name (eyes, chin, ...), Second string is Unicode value
    HashMap<String, String> monkey = new HashMap<>();

    //Default monkey constructor has initial set of values, this is put in place to avoid empty set scenarios
    public MonkeyObject() {
        //Add elements to the data table
        monkey.put(eyes,  "ʕง ͠° ͟ل͜ ͡°)ʔ ");
        monkey.put(chin,  "  \\_⏄_/ ");
        monkey.put(body,  "  --0--  ");
        monkey.put(legs,  "  ⎛  ⎞   ");
        monkey.put(eyes2, "ʕง ͠° ͟ل͜ ͡°)ʔ ");
        monkey.put(chin2, "  \\___/ ");
        monkey.put(body2, "  -----  ");
        monkey.put(legs2, "  ⌋  ⌊  " );
    }

    //A constructor with parameters to make your own monkey values
    public MonkeyObject(String eyes, String chin, String body, String legs,
                        String eyes2, String chin2, String body2, String legs2) {
        // Add elements to the map
        monkey.put(MonkeyObject.eyes, eyes);
        monkey.put(MonkeyObject.chin, chin);
        monkey.put(MonkeyObject.body, body);
        monkey.put(MonkeyObject.legs, legs);
        monkey.put(MonkeyObject.eyes2, eyes2);
        monkey.put(MonkeyObject.chin2, chin2);
        monkey.put(MonkeyObject.body2, body2);
        monkey.put(MonkeyObject.legs2, legs2);
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
