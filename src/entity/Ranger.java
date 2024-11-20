/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.IOException;
import javax.imageio.ImageIO;
import macilaci.GamePanel;

/**
 *
 * @author Mielec Attila (MNZVUM)
 */
public final class Ranger extends Entity{
    public String startDirection;
    
    public Ranger(GamePanel gp, String startDirection, int speed) throws IOException{
        super(gp);
        
        this.startDirection = startDirection;
        
        this.direction = startDirection;
        this.speed = speed;
        
        getImage();
        
    }
    
    public void getImage() throws IOException{
        try{
          
            right = ImageIO.read(getClass().getResourceAsStream("/ranger/right.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/ranger/left.png"));

        }catch(IOException e){
        }
    }
    
    @Override
    public void setAction(){
        switch(startDirection){
            case "up":
                if(collisionOn == true){
                   if(direction == startDirection){
                       direction = "down";
                   }else{
                       direction = startDirection;
                   }
                }
                break;
            case "down":
                if(collisionOn == true){
                   if(direction == startDirection){
                       direction = "up";
                   }else{
                       direction = startDirection;
                   }
                }
                break;
            case "right":
                if(collisionOn == true){
                   if(direction == startDirection){
                       direction = "left";
                   }else{
                       direction = startDirection;
                   }
                }
                break;
            case "left":
                if(collisionOn == true){
                   if(direction == startDirection){
                       direction = "right";
                   }else{
                       direction = startDirection;
                   }
                }
                break;

        }
            
    }
    
    
            
    
    
}
