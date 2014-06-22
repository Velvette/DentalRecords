/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author admin
 */
public class ValidateInput {
    
    public String formatStringSpaces(String formatString) {
        formatString = formatString.trim().replaceAll("\\s+", " ");
        return formatString;
    }
    
    public boolean checkIfEmpty(String checkString) {
        if(checkString.length() == 0)
            return false;
        return true;
    }
    
    public boolean checkForSpecial(String checkString) {
        try {
            if(checkString.charAt(0) == '.' || checkString.charAt(0) == '-') {
                return true;
            }
        }
        catch(Exception e) { 
            
        }
        Pattern p = Pattern.compile("[^a-z0-9. -]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(checkString);
        boolean b = m.find();
        
        if(b)
            return false;
        return true;
    }
    
    public boolean checkForPeriod(String checkString) {
        return true;
    }
}
