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
public class Object_basket extends SuperObject{

    public Object_basket() {
        name = "Basket";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/basket.png"));
        }catch(IOException e){
            
        }
    }
    
}
