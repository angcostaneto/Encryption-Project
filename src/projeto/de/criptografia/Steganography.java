/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.de.criptografia;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author angelo
 */
public class Steganography {
    
    public void encrypt(String msg, BufferedImage picture) {
        int height, width, i, j, rgb;
        
        // Transform a string into byte.
        byte[] msg_byte = msg.getBytes();
        
        // Get heigth from image.
        height = picture.getHeight();
        
        // Get width from image.
        width = picture.getWidth();
        
        for (i = 0; i < height; i++) {
            for (j = 0; j< width; j++) {
                rgb = picture.getRGB(j, i);
                
                // Catch the color by rgb.
                Color color = new Color(rgb);
                
                // Get the colors red, green and blue than transform they in binary.
                int blue = color.getBlue();
                int red = color.getRed();
                int green = color.getGreen();
            } 
        }
        
    }   
}
