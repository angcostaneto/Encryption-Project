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
    
    public void steganography(String msg, BufferedImage picture) {
        int height, width, i, j;
        
        // Transform a string into byte.
        byte[] msg_byte = msg.getBytes();
        
        // Get heigth from image.
        height = picture.getHeight();
        
        // Get picture from image.
        width = picture.getWidth();
        
        for (i = 0; i < height; i++) {
            for (j = 0; j< width; j++) {
                picture.getRGB(i, j);
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
