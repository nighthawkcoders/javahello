/*
Creator: Nighthawk Coding Society
Mini Lab Name: Hello Series, featuring Monkey Jumpers
Level: Easy
*/
package com.examples.helloseries;

// imports allow you to use code from others
import java.util.HashMap; //java library for managing data
import java.util.Scanner; //java library for user input

public class Main {
    /*
    Java always has main someplace, these are often called drivers or entry points for code execution
    -- main is carry over from 'C' language
    -- python people think class above and main here are annoying (perhaps they are right)
     */
    static public void main(String[] args) throws InterruptedException {    // Squigs, Squigalies, Curly brackets denote code blocks
        menu();
    }

    public static void menu() throws InterruptedException {
        int selection;

        //Using a Class: AP CSA Requirement 2
        //Scanner is well know class for text based input
        Scanner input = new Scanner(System.in);

        System.out.println("-------------------------\n");
        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Hello");
        System.out.println("2 - Faces");
        System.out.println("3 - Loopy");
        System.out.println("4 - Classy");
        System.out.println("0 - Quit");
        //Using Scanner Class to get integer as input
        selection = input.nextInt();

        switch (selection) {
            case 0:
                return;
            case 1:
                System.out.println("Hello, World of Monkeys!");
                break;
            case 2:
                Faces.main(null);
                break;
            case 3:
                Loopy.main(null);
                break;
            case 4:
                Classy.main(null);
                break;

            default:
                // The user input an unexpected choice.
                System.out.println("Unexpected choice, try again.");
        }
        menu(); //Recursion: AP CSA requirement 10
    }

}

/* Faces - Monkey Faces using System.out.println()
This is just a little increment from Hello World, only differences is we are representing an "object" that requires multiple lines.
1. This contains one line of the Monkey Jumpers poem
2. It contains ASCII and more, Unicode is superset to ASCII
*/
class Faces {

    public static void main(String[] args) {
        monkeys();  // introduction to method (this example is more like a function, why?)
        //make up to 10 characters of your own
        //how would you store monkeys in variables?
        //explore variables and see where you can get building a poem
    }

    public static void monkeys()
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

/* Loopy - Monkey Faces using 2D Array and Loops
How to build Monkey Jumper rhyme in code (this example is using Imperative Programming Style)
1. Build the entire rhyme up to Ten monkeys counting down to One monkey in countdown
2. Look at and learn about variable assignments
3. Study loops and zero based counting
4. Study two-dimensional array and referencing elements
*/
class Loopy {

    public static void main(String[] args) {
        iterative();
        //how would you print these monkeys horizontally?
        //add a name to the monkeys and print either on top or below
        //start to think about a monkey as an object versus two-dimensional array
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
                        "  (◕‿◕✿) ",          //[4][0]
                        "  \\_⍾_/ ",          //[4][1]
                        "  ==4==  ",          //[4][2]
                        "  _/ \\_ "           //[4][3]
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


}

/* Classy - Animated Monkey faces using List of Objects and Inheritances
    How to build Monkey Jumper rhyme in code (OOP Programming Style)
    1. Build the entire rhyme Seven to One monkey in countdown, see sample
    2. Look at and learn about constructors
    3. Study monkey object and list of monkeys
    4. Study HashMap
    5. Look at StringBuilder
*/
class Classy {
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
    Monkey[] monkeys = new Monkey[10]; //an array of Monkeys

    /*
    Constructor initializes a list monkey object
     */
    public MonkeyList() {

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
                case name0: lookup = alt_dictionary[0]; break;
                case name1: lookup = alt_dictionary[1]; break;
                case name2: lookup = alt_dictionary[2]; break;
                case name3: lookup = alt_dictionary[3]; break;
                default: throw new IllegalStateException("Unexpected value: " + dictName);
            }
        }
        return anime.get(lookup);
    }
}

/*
Class contains properties of a single Monkey
-- Note: A class that extends is performing 'Unit 10' required inheritance
-- Note: A Monkey is-a Anime
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

    /*
    Constructor establishes initial set of values, this avoids empty monkey scenarios
     */
    public Monkey() {
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
    public Monkey(boolean animation) {
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
