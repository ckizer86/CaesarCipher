import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    
    public CaesarCipherTwo(int key1, int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        mainKey1 = key1;
        mainKey2 = key2;
    }
    
    public String encrypt(String input){
        StringBuilder sb = new StringBuilder(input);
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            int chIndex = alphabet.indexOf(ch);
            if(i % 2 == 0){
                if(chIndex == -1){
                    String alphaLower = alphabet.toLowerCase();
                    chIndex = alphaLower.indexOf(ch);
                    if(chIndex == -1){
                        sb.setCharAt(i, ch);
                    }
                    else{
                        ch = shiftedAlphabet1.charAt(chIndex);
                        sb.setCharAt(i,Character.toLowerCase(ch));
                    }
                }
                else{
                    ch = shiftedAlphabet1.charAt(chIndex);
                    sb.setCharAt(i,ch);
                }
            }
            else{
                if(chIndex == -1){
                    String alphaLower = alphabet.toLowerCase();
                    chIndex = alphaLower.indexOf(ch);
                    if(chIndex == -1){
                        sb.setCharAt(i, ch);
                    }
                    else{
                        ch = shiftedAlphabet2.charAt(chIndex);
                        sb.setCharAt(i,Character.toLowerCase(ch));
                    }
                }
                else{
                    ch = shiftedAlphabet2.charAt(chIndex);
                    sb.setCharAt(i,ch);
                }
            }
        }
        return sb.toString();
    }
    
    public String decrypt(String input){
        TestCaesarCipherTwo testcc = new TestCaesarCipherTwo();
        
        String test = encrypt(input);
        return test;
    }
}
