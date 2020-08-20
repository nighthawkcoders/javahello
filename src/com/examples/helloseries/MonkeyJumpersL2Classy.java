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
        //how would you add methods to print monkeys vertically?
        //add names or other properties to the monkeys
        //change list to ArrayList and make implementation dynamic, prove it!
        //add animation of monkey breaking head
        //build a project with your own ascii/unicode art logo, experiment with animation
        //run you logo from shell (deployed java), sell has properties to clear and improve animation
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
    MonkeyObject[] monkeys = new MonkeyObject[10]; //an array of Monkeys

    /*
    Constructor initializes a list monkey object
     */
    public MonkeyList() {

        //setup and array of monkeys
        //1st
        monkeys[count++] = new MonkeyObject(true );  //Default Monkey and update list count
        //2nd
        monkeys[count] = new MonkeyObject();    //All other Monkeys use setters to update monkey parts
        monkeys[count].setMonkey(
             "ʕ༼ ◕_◕ ༽ʔ",
             "  \\_⎏_/ ",
            "  ++1++ ",
             "   ⌋ ⌊  "
        );
        monkeys[count].setMonkeyAnime(
            "ʕ༼ ◕_◕ ༽ʔ",
            "  \\___/ ",
            "  +++++ ",
            "  〈  〉 "
        );
        count++;

        //3rd
        monkeys[count] = new MonkeyObject();
        monkeys[count].setMonkey(
            "ʕ(▀ ⍡ ▀)ʔ",
            "  \\___/ ",
            "  <-2-> ",
            "  〈  〉 "
        );
        monkeys[count].setMonkeyAnime(
            "ʕ(▀ ⍡ ▀)ʔ",
            "  \\_⎐_/ ",
            "  <--->  ",
            "   ⌋  ⌊  "
        );
        count++;

        //4th
        monkeys[count] = new MonkeyObject();
        monkeys[count].setMonkey(
            " ʕ ͡° ͜ʖ ° ͡ʔ ",
            "   \\___/",
            "   ==3== ",
            "   _/ \\_"
        );
        monkeys[count].setMonkeyAnime(
            " ʕ ͡° ͜ʖ ° ͡ʔ ",
            "   \\_⍾_/ ",
            "   ===== ",
            "   〈  〉 "
        );
        count++;

        //5th
        monkeys[count] = new MonkeyObject();
        monkeys[count].setMonkey(
            " ʕ(◕‿◕✿)ʔ ",
            "   \\_⍾_/ ",
            "   ==4==  ",
            "   _/ \\_  "
        );
        monkeys[count].setMonkeyAnime(
            " ʕ(◕‿◕✿)ʔ ",
            "   \\___/  ",
            "   =====  ",
            "    〈  〉  "
        );
        count++;
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
    Method to flip control value of monkey output
     */
    private void toggleAnime(int start, int end, boolean toggle) {
        //toggle animation setting
        for (int i = start; i < end; i++) {
            monkeys[i].setAnime(toggle);
        }
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
            //loop and control are to support animation
            int delay = 3500; int delay_step = 700; boolean toggle = false;
            for (int sleep = 0; sleep < delay; sleep += delay_step ) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(i + " little monkeys jumping on the bed...");

                printBodyPart(0, i, MonkeyObject.eyes);
                printBodyPart(0, i, MonkeyObject.chin);
                printBodyPart(0, i, MonkeyObject.body);
                printBodyPart(0, i, MonkeyObject.legs);

                Thread.sleep(delay_step);           //delay
                toggle = !toggle;                   //toggle value flips each pass
                toggleAnime(0, i, toggle);    //use toggle value to change monkey anime
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
    //Animation body parts, slight variations
    static public final String eyes2 = "eyes2";
    static public final String chin2 = "chin2";
    static public final String body2 = "body2";
    static public final String legs2 = "legs2";

    //Monkey 'body parts' data table
    //In CompSci this is more typically called a Name-Value pair
    //First string in HashMap is Name (eyes, chin, ...), Second string is Unicode value
    HashMap<String, String> monkey = new HashMap<>();

    //Animation control variables
    boolean anime = false;      //animation is on
    boolean standard = true;    //standard is used to flip, standard -> animation -> standard

    /*
    Constructor establishes initial set of values, this avoids empty monkey scenarios
     */
    public MonkeyObject() {
        this.MonkeyInit();
    }

    /*
    Constructor establishes standard and alternate values for monkey body parts
    */
    public MonkeyObject(boolean anime) {
        this.MonkeyInit();
        this.anime = true;
        monkey.put(eyes2, "ʕง ͠° ͟ل͜ ͡°)ʔ ");
        monkey.put(chin2, "  \\___/ ");
        monkey.put(body2, "  -----  ");
        monkey.put(legs2, "  ⌋   ⌊ " );
    }

    /*
    Shared initializer, these puts are shared by both constructors
     */
    private void MonkeyInit() {
        //Add elements to the data table
        monkey.put(eyes,  "ʕง ͠° ͟ل͜ ͡°)ʔ ");
        monkey.put(chin,  "  \\_⏄_/ ");
        monkey.put(body,  "  --0--  ");
        monkey.put(legs,  "  ⎛   ⎞  ");
    }

    /*
    "setter" is used to initialize standard values of the monkey
     */
    public void setMonkey(String eyes, String chin, String body, String legs) {
        monkey.put(MonkeyObject.eyes, eyes);
        monkey.put(MonkeyObject.chin, chin);
        monkey.put(MonkeyObject.body, body);
        monkey.put(MonkeyObject.legs, legs);
    }

    /*
    2nd "setter" is used to initialize alternate values of monkey
     */
    public void setMonkeyAnime(String eyes, String chin, String body, String legs) {
        this.anime = true;  //if you use this "setter" animation is implied
        monkey.put(MonkeyObject.eyes2, eyes);
        monkey.put(MonkeyObject.chin2, chin);
        monkey.put(MonkeyObject.body2, body);
        monkey.put(MonkeyObject.legs2, legs);
    }

    /*
    "setter" that allow user to control standard or animated output from "getters"
     */
    public void setAnime(boolean on) {
        this.standard = !on;
    }

    /*
    Override "or polymorphism" of system "toString" which is generated for every object
    -- default "toString" returns a number representing the object
    -- most often "toStrng" is used in conjunction with "System.out.println" to return sensible data
     */
    public String toString() {
        String out_string;

        //control support toggling output string
        if (this.standard)  //standard out
            out_string = monkey.get(eyes) + "\n" + monkey.get(chin) + "\n" + monkey.get(body) + "\n" + monkey.get(legs)+ "\n";
        else                //alternate out
            out_string = monkey.get(eyes2) + "\n" + monkey.get(chin2) + "\n" + monkey.get(body2) + "\n" + monkey.get(legs2)+ "\n";

        //if user sets anime, then this toggles between standard and alternate output
        if (this.anime) this.standard = !this.standard;

        return out_string;
    }

    /*
    "getter" is a commonly expected method used to return data from an Object
     */
    public String getMonkey() {
        return toString();
    }

    /*
    This "getter" allows the extraction of a single monkey body part
     */
    public String getBodyPart(String bp) {
        String tag = bp;

        //animation control
        if (!this.standard) {
            switch (bp) {
                case eyes -> tag = eyes2;
                case chin -> tag = chin2;
                case body -> tag = body2;
                case legs -> tag = legs2;
                default -> throw new IllegalStateException("Unexpected value: " + bp);
            }
        }
        return monkey.get(tag);
    }
}
