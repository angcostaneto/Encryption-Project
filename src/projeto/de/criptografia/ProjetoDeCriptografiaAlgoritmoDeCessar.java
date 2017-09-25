/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.de.criptografia;

import java.awt.image.BufferedImage;

/**
 *
 * @author angelo
 */
public class ProjetoDeCriptografiaAlgoritmoDeCessar {
    
    public static String encodeCesar(String msg, int key){        
        int index;
        String newMessage = "";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        // Regex all numeric and special character in  string and converts to upper case
        for(char letter: msg.toUpperCase().replaceAll("[^a-zA-Z]","").toCharArray()){
            index = new String(alphabet).indexOf(letter);
            newMessage += Character.toString(alphabet.charAt((index + key)%26));   
        }
        
        return newMessage;
    }
    
    public static String decodeCesar(String msg, int key){
        int index, value;
        String newMessage = "";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        // Regex all numeric and special character in  string and converts to upper case
        for(char letter: msg.toUpperCase().replaceAll("[^a-zA-Z]","").toCharArray()){
            index = new String(alphabet).indexOf(letter);
            if((index - key) < 0){
               value = 26 + (index - key);
               newMessage += Character.toString(alphabet.charAt(value%26));
            }
            else {
              newMessage += Character.toString(alphabet.charAt((index - key)%26));  
            }
        }
        
        return newMessage;
    }
    
    public void steganography(String msg, BufferedImage picture) {
        int height, width, i, j, rgb;
        
        // Transform a string into byte.
        byte[] msg_byte = msg.getBytes();
        
        // Get heigth from image.
        height = picture.getHeight();
        
        // Get picture from image.
        width = picture.getWidth();
        
        for (i = 0; i < height; i++) {
            for (j = 0; j< width; j++) {
                rgb = picture.getRGB(i, j);
                
            } 
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
