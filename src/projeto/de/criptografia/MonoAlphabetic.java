/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.de.criptografia;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author angelo
 */
public class MonoAlphabetic {
    public static String encodeMonoAlphabetic(String msg, String key){        
        int index;
        String newMessage = "";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        // Regex all numeric and special character in string and converts to upper case
        for(char letter: msg.toUpperCase().replaceAll("[^a-zA-Z]","").toCharArray()){
            index = new String(alphabet).indexOf(letter);
            newMessage += Character.toString(key.charAt((index)%26));   
        }
        
        return newMessage;
    }
    
    public String generateKey() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        String key = "";
        
        List<String> letters = Arrays.asList(alphabet.split(""));  
        
        Collections.shuffle(letters);
        
        for(String letter: letters) {
            key += letter;
        }
        
        return key;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        MonoAlphabetic c = new MonoAlphabetic();
        Steganography s = new Steganography();
        
        String newKey = c.generateKey();
        
        BufferedImage img = ImageIO.read(new File("/home/angelo/NetBeansProjects/Projeto de criptografia/src/images/linux.jpg"));
        
        String message = c.encodeMonoAlphabetic("batatinha quando nasce", newKey);
        
        s.encrypt(message, img);
    }
}
