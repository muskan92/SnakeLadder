package utils;

import java.util.Random;

public class Utils {

    static Random ran = new Random();
    public static int rollDice(){
        return ran.nextInt(6)+1;

    }
}
