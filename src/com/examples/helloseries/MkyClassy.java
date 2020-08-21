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
public class MkyClassy {
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
class MkyList {
    int count = 0;
    Monkey[] monkeys = new Monkey[10]; //an array of Monkeys

    /*
    Constructor initializes a list monkey object
     */
    public MkyList() {

        //setup and array of monkeys
        //1st
        monkeys[count++] = new Monkey(true );  //Default Monkey and update list count
        //2nd
        monkeys[count] = new Monkey();    //All other Monkeys use setters to update monkey parts
        monkeys[count].setAnimeStandard(
             "ʕ༼ ◕_◕ ༽ʔ",
             "  \\_⎏_/ ",
            "  ++1++ ",
             "   ⌋ ⌊  "
        );
        monkeys[count].setAnimeAlternate(
            "ʕ༼ ◕_◕ ༽ʔ",
            "  \\___/ ",
            "  +++++ ",
            "  〈  〉 "
        );
        count++;

        //3rd
        monkeys[count] = new Monkey();
        monkeys[count].setAnimeStandard(
            "ʕ(▀ ⍡ ▀)ʔ",
            "  \\___/ ",
            "  <-2-> ",
            "  〈  〉 "
        );
        monkeys[count].setAnimeAlternate(
            "ʕ(▀ ⍡ ▀)ʔ",
            "  \\_⎐_/ ",
            "  <--->  ",
            "   ⌋  ⌊  "
        );
        count++;

        //4th
        monkeys[count] = new Monkey();
        monkeys[count].setAnimeStandard(
            " ʕ ͡° ͜ʖ ° ͡ʔ ",
            "   \\___/",
            "   ==3== ",
            "   _/ \\_"
        );
        monkeys[count].setAnimeAlternate(
            " ʕ ͡° ͜ʖ ° ͡ʔ ",
            "   \\_⍾_/ ",
            "   ===== ",
            "   〈  〉 "
        );
        count++;

        //5th
        monkeys[count] = new Monkey();
        monkeys[count].setAnimeStandard(
            " ʕ(◕‿◕✿)ʔ ",
            "   \\_⍾_/ ",
            "   ==4==  ",
            "   _/ \\_  "
        );
        monkeys[count].setAnimeAlternate(
            " ʕ(◕‿◕✿)ʔ ",
            "   \\___/  ",
            "   =====  ",
            "   〈  〉  "
        );
        count++;
    }

    /*
    Simple print of the list of objects, how would you convert this toString method
     */
    public void print() {
        //setup loop to initialize each monkey
        for (Monkey monkey : monkeys) {
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
            line_for_output.append(String.format("%-12s \t", monkeys[i].getAnimePart(bp)));
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
            //loop and control are to support animation
            int delay = 3500; int delay_step = 700; boolean toggle = false;
            for (int sleep = 0; sleep < delay; sleep += delay_step ) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(i + " little monkeys jumping on the bed...");

                printBodyPart(0, i, Monkey.eyes);
                printBodyPart(0, i, Monkey.chin);
                printBodyPart(0, i, Monkey.body);
                printBodyPart(0, i, Monkey.legs);

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

    /*
    Method to flip control value of monkey output
    -- Note: Recursive method is a 'Unit 10' CSA requirement
     */
    private void toggleAnime(int start, int end, boolean toggle) {
        if (start >= end)
            return;
        monkeys[start].setAnime(toggle);
        toggleAnime(++start, end, toggle);  //recursive call, ++before is critical
    }

}

/*
Abstract Class contains properties of a single Anime
-- Note: A base class (in this case Abstracts) is part of 'Unit 10' inheritance requirements
-- Note: Abstract class does not stand alone
 */
abstract class MkyAnime {
    //Anime data table
    //In CompSci HashMap is more well known as a Name-Value pair
    //First string in HashMap is Name, Second string is Unicode value
    //-- in MkyAnime we will typically use this to store part of the figure (eyes, legs, ,..)
    protected HashMap<String, String> anime;

    //Dictionary names of elements in Monkey 'body parts' data table
    //We share these names (public), but no one should every change value (final)
    static private final String name0 = "n0", name1 = "n1", name2 = "n2", name3 = "n3", name4 = "n4";
    static protected final String[] std_dictionary = { name0, name1, name2, name3, name4 };
    static protected final String[] alt_dictionary = { "a-n0", "a-n", "a-n2", "a-n3", "a-n4" };
    //Animation control variables
    boolean animation = false;  //animation is on
    boolean standard = true;    //standard is used to flip, standard -> animation -> standard

    public void MkyAnime () {
        anime = new HashMap<>();
    }
    /*
     "setter" that allow user to control standard or animated output from "getters"
      */
    public void setAnime(boolean on) {
        this.standard = !on;
    }

    /*
    standard "setter" is used to initialize standard values of the monkey
     */
    public void setAnimeStandard(String value0, String value1, String value2, String value3) {
        anime.put(name0, value0);
        anime.put(name1, value1);
        anime.put(name2, value2);
        anime.put(name3, value3);
    }

    /*
    alternate "setter" is used to initialize standard values of the monkey
     */
    public void setAnimeAlternate(String value0, String value1, String value2, String value3) {
        this.animation = true;  //if you use this "setter" animation is implied
        anime.put(alt_dictionary[0], value0);
        anime.put(alt_dictionary[1], value1);
        anime.put(alt_dictionary[2], value2);
        anime.put(alt_dictionary[3], value3);
    }

    /*
    This "getter" allows the extraction of a single monkey body part
     */
    public String getAnimePart(String dictName) {
        String lookup = dictName;

        //animation control
        if (!this.standard) {
            switch (dictName) {
                case name0 -> lookup = alt_dictionary[0];
                case name1 -> lookup = alt_dictionary[1];
                case name2 -> lookup = alt_dictionary[2];
                case name3 -> lookup = alt_dictionary[3];
                default -> throw new IllegalStateException("Unexpected value: " + dictName);
            }
        }
        return anime.get(lookup);
    }
}

/*
Class contains properties of a single Monkey
-- Note: A class that extends is performing 'Unit 10' required inheritance
-- Note: A Monkey is-a MkyAnime
 */
class Mky extends MkyAnime {
    //These final values can be used publicly to easy setting off values
    static public final String eyes = Anime.std_dictionary[0];
    static public final String chin = Anime.std_dictionary[1];
    static public final String body = Anime.std_dictionary[2];
    static public final String legs = Anime.std_dictionary[3];
    //These final values limite in scope to this method
    static private final String eyes2 = Anime.alt_dictionary[0];
    static private final String chin2 = Anime.alt_dictionary[1];
    static private final String body2 = Anime.alt_dictionary[2];
    static private final String legs2 = Anime.alt_dictionary[3];

    /*
    Constructor establishes initial set of values, this avoids empty monkey scenarios
     */
    public Mky() {
        this.MonkeyInit();
    }

    /*
    Shared initializer, these puts are shared by both constructors
     */
    private void MonkeyInit() {
        //Add elements to the data table
        anime.put(eyes,  "ʕง ͠° ͟ل͜ ͡°)ʔ ");
        anime.put(chin,  "  \\_⏄_/ ");
        anime.put(body,  "  --0--  ");
        anime.put(legs,  "  ⎛   ⎞  ");
    }

    /*
    Constructor establishes standard and alternate values for monkey body parts
    */
    public Mky(boolean animation) {
        this.MonkeyInit();
        this.animation = animation;
        anime.put(eyes2, "ʕง ͠° ͟ل͜ ͡°)ʔ ");
        anime.put(chin2, "  \\___/ ");
        anime.put(body2, "  -----  ");
        anime.put(legs2, "  ⌋   ⌊ " );
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
            out_string = anime.get(eyes) + "\n" + anime.get(chin) + "\n" + anime.get(body) + "\n" + anime.get(legs)+ "\n";
        else                //alternate out
            out_string = anime.get(eyes2) + "\n" + anime.get(chin2) + "\n" + anime.get(body2) + "\n" + anime.get(legs2)+ "\n";

        //if user sets anime, then this toggles between standard and alternate output
        if (this.animation) this.standard = !this.standard;

        return out_string;
    }

}
