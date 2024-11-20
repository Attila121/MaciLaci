/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Mielec Attila (MNZVUM)
 */
public class Object_heart extends SuperObject {
    
    
    public Object_heart() {
        name = "Basket";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/heart.png"));
        }catch(IOException e){
            
        }
    }
    
}
