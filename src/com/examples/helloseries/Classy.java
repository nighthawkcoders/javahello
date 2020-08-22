package com.examples.helloseries;

/*
 * Creator: Nighthawk Coding Society
 * Mini Lab Name: Hello Series, featuring Monkey Jumpers
 * Level: Medium
 *
 * Exploration Ideas
 * 1. Add methods or logic to print monkeys vertically
 * 2. Add names or other properties to the monkeys
 * 3. Add to poem, ie animation of monkey breaking head
 * 4. Build a project with your own ascii/unicode art or logo, experiment with animation
 * 5. Learn to deploy your Java class or JAR to run animation from shell (deployed java).  FYI, the shell has properties (character sequences ) to clear and improve animation.
 *
 * Learning Considerations
 * Note: Classy (OOP Programming Style)
 * Project Focus: Animated Monkey Jumpers
 * A. Observe logic for 5 to 1 monkey in countdown and timer
 * B. Learn about constructors
 * C. Learn about an object and list of objects
 * D. Learn about HashMap (Name-Value pairs)
 * E. Learn about StringBuilder
 */

import java.util.HashMap; //java library for managing data

/**
 * Classy - a Java utility Class that supports entry point for execution
 */
public class Classy {
    /** main
     * entry point when testing independently
     */
    public static void main(String[] args)  {
        new MonkeyList().printPoem();   //a new monkey list and output in one step
    }

    /** Classy
     * constructor and entry point when instantiating a Classy object
     *
     */
    public Classy() {
        new MonkeyList().printPoem();
    }
}

/**
 * Class for Monkeys: a list of Monkeys
 * As well as Actions for Monkeys: print Poem
 */
class MonkeyList {
    int count = 0;                     //Primitives: AP CSA Unit 1 - Integer
    Monkey[] monkeys = new Monkey[10]; //Arrays: AP CSA Unit 6 - User Defined Class

    /**
     * Constructor initializes a list monkey object
     */
    public MonkeyList() {
        //1st monkey
        monkeys[count++] = new Monkey(true );  //Default Monkey and update list count
        //2nd monkey
        monkeys[count] = new Monkey();    //All other Monkeys use setters to update monkey parts
        monkeys[count].setAnimeStandard(   //Standard monkey parts
                "ʕ༼ ◕_◕ ༽ʔ",
                "  \\_⎏_/ ",
                "  ++1++ ",
                "   ⌋ ⌊  "
        );
        monkeys[count].setAnimeAlternate(   //Alternate monkey parts (for animation)
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

    /**
     * Print the list of objects
     */
    public void print() {
        //setup loop to initialize each monkey
        for (Monkey monkey : monkeys) { //Iteration: AP CSA Unit 4 - For-each loop
            if (monkey != null) {   //check to see if monkey is initialized
                System.out.println(monkey);
            }
        }
    }

    /**
     * Extract and print the same body part for all monkeys in list
     */
    private void printBodyPart(int start, int end, String bp) {
        //build output string
        StringBuilder line_for_output = new StringBuilder();
        for (int i = start; i < end; i++) { //Iteration: AP CSA Unit 4 - For loop
            line_for_output.append(String.format("%-12s \t", monkeys[i].getAnimePart(bp)));
        }
        System.out.println(line_for_output);
    }

    /**
     * Print the countdown poem
     */
    public void printPoem() {
        //prints starting message
        System.out.println("Monkey Jumpers Poem in Java Classy");

        //loop is key logic to allow printing monkeys horizontally according to countdown criteria
        for (int i = count; i >= 1; i--)   //start countdown according to monkeys in list
        {
            //loop and control are to support animation
            int delay = 3500; int delay_step = 700; boolean toggle = false;
            for (int sleep = 0; sleep < delay; sleep += delay_step ) {
                System.out.print("\033[H\033[2J"); //this sends special sequence to clear console/terminal window
                System.out.flush();                //this makes sure previous line happens right away
                System.out.println(i + " little monkeys jumping on the bed...");    //formatted message in poem

                //printPoem has helper method within the class to line up body parts horizontally
                printBodyPart(0, i, Monkey.eyes);   //each call passes parameters which match poem prgression
                printBodyPart(0, i, Monkey.chin);
                printBodyPart(0, i, Monkey.body);
                printBodyPart(0, i, Monkey.legs);

                try {   //certain methods (ie Time.sleep) have error handline
                    Thread.sleep(delay_step);           //animation delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); //set interrupt flag
                    e.printStackTrace();                //trace error
                }

                toggle = !toggle; //Primitive: Boolean value flips each pass with negation (!)
                toggleAnime(0, i, toggle);    //use toggle value to change monkey anime
            }
        }
        //prints finishing messages when poem is done, loop have exited before reaching here
        System.out.println("No more monkeys jumping on the bed");
        System.out.println("0000000000000000000000000000000000");
        System.out.println("             THE END              ");
    }

    /**
     * Method to flip control value of monkey output
     * --  Recursion: AP CSA Unit 10
     */
    private void toggleAnime(int start, int end, boolean toggle) {
        if (start >= end)   //terminal condition exits recursion, similar to middle portion of for loop
            return;
        monkeys[start].setAnime(toggle); //this tells monkey to alternate between standard and alternate anime
        toggleAnime(++start, end, toggle);  //recursive call, ++ must be before variable name
    }

}

/**
 * Abstract Class contains properties of a single Anime (generic, not specific to Monkeys)
 *  --  Inheritance: AP CSA Unit 9
 * A base class (in this case an 'abstract base class) is part of inheritance requirement
 * An 'abstract class' needs an inheritor to make it useful
 */
abstract class Anime {
    //Anime data table
    //In CompSci HashMap is more well known as a Name-Value pair
    //First string in HashMap is Name, Second string is Unicode value
    //-- in Anime we will typically use this to store part of the figure (eyes, legs, ,..)
    protected HashMap<String, String> anime;

    //Dictionary names of elements in Monkey 'body parts' data table
    //We share these names (public), but no one should every change value (final)
    static private final String name0 = "n0", name1 = "n1", name2 = "n2", name3 = "n3", name4 = "n4";
    static protected final String[] std_dictionary = { name0, name1, name2, name3, name4 };
    static protected final String[] alt_dictionary = { "a-n0", "a-n", "a-n2", "a-n3", "a-n4" };
    //Animation control variables
    boolean animation = false;  //animation is on
    boolean standard = true;    //standard is used to flip, standard -> animation -> standard

    //Object constructor
    public Anime () {
        anime = new HashMap<>();
    }

    /*
     "setter" that allow user to control standard or animated output from "getters"
      */
    public void setAnime(boolean on) {
        this.standard = !on;
    }

    /**
     * standard "setter" is used to initialize standard values of the monkey
     */
    public void setAnimeStandard(String value0, String value1, String value2, String value3) {
        anime.put(name0, value0);
        anime.put(name1, value1);
        anime.put(name2, value2);
        anime.put(name3, value3);
    }

    /**
     * alternate "setter" is used to initialize standard values of the monkey
     */
    public void setAnimeAlternate(String value0, String value1, String value2, String value3) {
        this.animation = true;  //if you use this "setter" animation is implied
        anime.put(alt_dictionary[0], value0);
        anime.put(alt_dictionary[1], value1);
        anime.put(alt_dictionary[2], value2);
        anime.put(alt_dictionary[3], value3);
    }

    /**
     * "getter" allows the extraction of a single monkey body part
     */
    public String getAnimePart(String dictName) {
        String lookup = dictName;

        //animation control
        try {
            if (!this.standard) {
                lookup = switch (dictName) {
                    case name0 -> alt_dictionary[0];
                    case name1 -> alt_dictionary[1];
                    case name2 -> alt_dictionary[2];
                    case name3 -> alt_dictionary[3];
                    default -> throw new IllegalStateException("Unexpected value: " + dictName);
                };
            }
        } catch (IllegalStateException e) {
            Thread.currentThread().interrupt();  // set interrupt flag
            e.printStackTrace();
        }
        return anime.get(lookup);
    }
}

/**
 * Class contains properties of a single Monkey
 *  --  Inheritance: AP CSA Unit 9
 *  A class that extends is Java way of performing inheritance
 *  Though inheritance a Monkey is-a Anime, but an Anime is-not-a Monkey
 */
class Monkey extends Anime {
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

    /**
     * Constructor establishes initial set of values
     */
    public Monkey() {
        this.MonkeyInit();
    }

    /**
     * Shared initializer, these puts are shared by both constructors
     */
    private void MonkeyInit() {
        //Add elements to the data table
        anime.put(eyes,  "ʕง ͠° ͟ل͜ ͡°)ʔ ");
        anime.put(chin,  "  \\_⏄_/ ");
        anime.put(body,  "  --0--  ");
        anime.put(legs,  "  ⎛   ⎞  ");
    }

    /**
     * This constructor establishes standard and alternate default for monkey body parts
    */
    public Monkey(boolean animation) {
        this.MonkeyInit();
        this.animation = animation;
        anime.put(eyes2, "ʕง ͠° ͟ل͜ ͡°)ʔ ");
        anime.put(chin2, "  \\___/ ");
        anime.put(body2, "  -----  ");
        anime.put(legs2, "  ⌋   ⌊ " );
    }

    /**
     * Override "or polymorphism" of system "toString" which is generated for every object
     * -- default "toString" returns a number representing the object
     * -- most often "toStrng" is used in conjunction with "System.out.println" to return sensible data
     * -- this is on every AP test I have seen
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