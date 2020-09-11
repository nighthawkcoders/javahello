package com.examples.helloseries;

public class Randomy {
    /** main
     * entry point when testing
     */
    public static void main(String[] args)  {
        String[] teams = new String[8];

        teams[0] = "AidenA"; // #1, B's are 1st
        teams[1] = "AidenB";
        teams[2] = "AryanA"; // #2
        teams[3] = "AryanB";
        teams[4] = "JettA"; // #3
        teams[5] = "JettB";
        teams[6] = "SanviA"; // #4
        teams[7] = "SanviB";

        int i = (int) (Math.random() * 4);
        System.out.println(teams[i*2]);
        i = (int) (Math.random() * 2);
        System.out.println(teams[i]);
    }
}
