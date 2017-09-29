/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.de.criptografia;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author angelo
 */
public class Steganography {
    
    public void encrypt(String msg, BufferedImage picture) throws IOException {
        int height, width, i, j, length;
        
        // Transform a string into byte.
        byte[] msg_byte = msg.getBytes();
        
        // Get heigth from image.
        height = picture.getHeight();
        
        // Get width from image.
        width = picture.getWidth();
        
        // Get the msg length
        length = msg.length();
        
        // Count
        int count = 0;
        
        for (i = 0; i < height; i++) {
            for (j = 0; j< width; j++) {
                int rgb = picture.getRGB(j, i);
                
                // Catch the color by rgb.
                Color color = new Color(rgb);
                
                // Get the colors red, green and blue than transform they in binary.
                int blue = color.getBlue();
                int red = color.getRed();
                int green = color.getGreen();
                
                // Transform the values in binary
                String blueBin = Integer.toBinaryString(blue);
                String redBin = Integer.toBinaryString(red);
                String greenBin = Integer.toBinaryString(green);
                
                if (count < length) {
                    // Create a vector based in the size of blueBin
                    char[] chr = blueBin.toCharArray();
                    chr[blueBin.length() - 1] = (char) msg_byte[count];
                    count++;
                    String blueString = new String(chr);
                    blue = Integer.parseInt(blueString, 2);
                }
                
                if (count < length) {
                    // Create a vector based in the size of blueBin
                    char[] chr = redBin.toCharArray();
                    chr[redBin.length() - 1] = (char) msg_byte[count];
                    count++;
                    String redString = new String(chr);
                    red = Integer.parseInt(redString, 2);
                }
                
                if (count < length) {
                    // Create a vector based in the size of blueBin
                    char[] chr = greenBin.toCharArray();
                    chr[greenBin.length() - 1] = (char) msg_byte[count];
                    count++;
                    String greenString = new String(chr);
                    green = Integer.parseInt(greenString, 2);
                }
                Color novoPixel = new Color(red, green, blue);
                
                picture.setRGB(j, i, novoPixel.getRGB());
                
                // ERRO
                ImageIO.write(picture, "jpg", new File("/home/angelo/NetBeansProjects/Projeto de criptografia/src/images/novaImagem.jpg"));
                
            }
        }
        
    }   
}
