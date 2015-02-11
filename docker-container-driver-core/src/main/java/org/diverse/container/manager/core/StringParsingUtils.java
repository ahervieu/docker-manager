package org.diverse.container.manager.core;


/**
 * Created by aymeric on 10/12/14.
 */
public class StringParsingUtils {

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public static boolean isValidMemory(String s) {
        if(isInteger(s))
        {
            return true ;
        }
        String value = s.substring(0,s.length()-2);
        String unit = s.substring(s.length()-2);
        if(isInteger(value)){
            if(unit.equals("k") || unit.equals("m") || unit.equals("g"))
            {
                return true ;
            }
        }
        return false;
    }


}
