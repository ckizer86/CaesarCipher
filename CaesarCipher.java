
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public CaesarCipher(int key){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        mainKey = key;
    }
    
    public String encrypt(String input){
        int num = 22;
        CaesarCipher cc = new CaesarCipher(num);
        StringBuilder sb = new StringBuilder(input);
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            int chIndex = alphabet.indexOf(ch);
            if(chIndex == -1){
                String alphaLower = alphabet.toLowerCase();
                chIndex = alphaLower.indexOf(ch);
                if(chIndex == -1){
                    sb.setCharAt(i, ch);
                }
                else{
                    ch = shiftedAlphabet.charAt(chIndex);
                    sb.setCharAt(i,Character.toLowerCase(ch));
                }
            }
            else{
                ch = shiftedAlphabet.charAt(chIndex);
                sb.setCharAt(i,ch);
            }
            
        }
        return sb.toString();
    }
    
    public String decrypt(String input){
        CaesarCipher cc = new CaesarCipher(26-mainKey);
        String decrypted = cc.encrypt(input);
        return decrypted;
    }
    
    public void testing(){
        String message = "Will this test work?";
        String testencrypt = encrypt(message);
        System.out.println("This is the message encrypted " + testencrypt);
        String testdecrypt = decrypt(testencrypt);
        System.out.println("This is the message decrypted " + testdecrypt);
    }

}
