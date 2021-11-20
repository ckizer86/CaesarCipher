import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipher {
    public int indexOfMax(int[] values){
        int maxSoFar = 0;
        int maxindex = 0;
        for(int i = 0; i < values.length; i++){
            if(values[i] > maxSoFar){
                maxSoFar = values[i];
                maxindex = i;
            }
        }
        return maxindex;
    }
    
    public int[] countLetters(String encrypted){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int i = 0; i < encrypted.length(); i++){
            char ch = Character.toLowerCase(encrypted.charAt(i));
            int dex = alph.indexOf(ch);
            if(dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }
    
    public String breakCaesarCipher(String input){
        int[] freqs = countLetters(input);
        int maxDex = indexOfMax(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4){
            dkey = 26 - (4-maxDex);
        }
        CaesarCipher cc = new CaesarCipher(dkey);
        return cc.decrypt(input);
    }
    
    public void simpleTests(){
        //FileResource fr = new FileResource();
        String message = "This is a test string with two keys.";
        CaesarCipher cc = new CaesarCipher(17);
        String encrypted = cc.encrypt(message);
        System.out.println(encrypted);
        String test = breakCaesarCipher(encrypted);
        System.out.println(test);
    }
}
