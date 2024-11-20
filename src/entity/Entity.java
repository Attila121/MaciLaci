/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import macilaci.GamePanel;

/**
 *
 * @author Mielec Attila (MNZVUM)
 */
public class Entity {
    GamePanel gp;
    
    public int worldX, worldY;
    public int speed;
    public String startDirection;
    
    public BufferedImage right, left;
    public String direction;
    public String lastDirection;
    public Rectangle solidArea = new Rectangle(1, 1, 47 ,47);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public boolean invincible = false;
    public int invincibleCounter = 0;
    double deathCounter = 0;
    
    // Karakter állapota
    public int maxLife;
    public int life;
    
    public Entity(GamePanel gp){
        this.gp = gp;
    }

   public void draw(Graphics g2){
        
        BufferedImage image = null;
        
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY; 
            
        if( worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
            worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
            worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
            worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
                switch(direction){
                case "left" -> image = left;
                case "right" -> image = right;
                case "up" -> image = right;
                case "down" -> image = right;
                }
                g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
        
        
    }
    public void setAction(){}
    
    public void update(){
        setAction();
        
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        boolean contactPlayer = gp.cChecker.checkPlayer(this);
        
        if(contactPlayer == true){
            if(gp.player.invincible == false){
                gp.player.life--;
                if(gp.player.life == 0){
                    gp.ui.death = true;
                }
                gp.player.invincible = true;
                
            }
        }
        
         if(collisionOn == false){
                switch(direction){
                case "up" -> worldY -= speed;
                case "down" -> worldY += speed;
                case "left" -> worldX -= speed;
                case "right" -> worldX += speed;
                }
            }
    }
}
