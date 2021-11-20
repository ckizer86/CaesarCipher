import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipherTwo {
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
    
    public String halfOfString(String message, int start){
        StringBuilder split = new StringBuilder();
        for(int i =start; i < message.length(); i+=2){
            
                split.append(message.charAt(i));
        }
        return split.toString();
    }
    
    public void simpleTest(){
        int a = 17;
        int b = 3;
        CaesarCipherTwo cc = new CaesarCipherTwo(a, b);
        String test = cc.encrypt("This is a test string with two keys.");
        System.out.println(test);
        a = 26 - a;
        b = 26 - b;
        cc = new CaesarCipherTwo(a, b);
        String decrypt = cc.decrypt(test);
        System.out.println(decrypt);
    }
}
