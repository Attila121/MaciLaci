/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import macilaci.GamePanel;
import macilaci.KeyHandler;

/**
 *
 * @author Mielec Attila (MNZVUM)
 */
public final class Player extends Entity{
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    
    public int howManyBasket = 0;

    public int allBasket = 4;
    public int howManyAllBasket;
        
    
    public Player(GamePanel gp, KeyHandler keyH) throws IOException{
        
        super(gp);
        
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        
        solidArea = new Rectangle(0, 20 , gp.tileSize - 10, gp.tileSize - 20);
        solidArea.x = 0;
        solidArea.y = 20;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = gp.tileSize - 10;
        solidArea.height = gp.tileSize - 20;
        this.howManyAllBasket = 0;
        
        setDefaultValues();
        getPlayerImage();
    }
    
    public void setDefaultValues(){
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 5;
        direction = "right";
        lastDirection = "right";
        maxLife = 3;
        life = maxLife;
    }
    
    
    public void getPlayerImage() throws IOException{
        try{
            right = ImageIO.read(getClass().getResourceAsStream("/player/right.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/player/left.png"));
        }catch(IOException e){
        }
    }
    
    @Override
    public void update(){
        if(keyH.upPressed == true || keyH.downPressed == true ||
            keyH.leftPressed == true ||    keyH.rightPressed == true){
            if(keyH.upPressed == true){
                direction = "up";
            }else if(keyH.downPressed == true){
                direction = "down";
            }else if(keyH.leftPressed == true){
                direction = "left";
                lastDirection = "left";
            }else if(keyH.rightPressed == true){
                direction = "right";
                lastDirection = "right";
            }
        
            // Vizsgáljuk az ütközést
            collisionOn = false;
            gp.cChecker.checkTile(this);
            
            // Ha obijektummal ütközünk
            int objIndex = gp.cChecker.checkObject(this, true);
            try {
                pickUpObject(objIndex);
            } catch (SQLException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            int rangerIndex = gp.cChecker.checkEntity(this, gp.ranger);
            try {
                contactRanger(rangerIndex);
            } catch (SQLException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
            

            // Ha ütközés nem jön létre, a karakter tud mozogni
            if(collisionOn == false){
                switch(direction){
                case "up" -> worldY -= speed;
                case "down" -> worldY += speed;
                case "left" -> worldX -= speed;
                case "right" -> worldX += speed;
                }
            }
        }
        
        if(invincible == true){
            invincibleCounter++;
            if(invincibleCounter > 60){
                invincible = false;
                invincibleCounter = 0;
            }
        }
        
    }
    
    public void pickUpObject(int i) throws SQLException{
        if(i != 999){
            if("Basket".equals(gp.obj[gp.currentMap][i].name)){
                gp.obj[gp.currentMap][i] = null;
                howManyBasket++;
                howManyAllBasket++;
                if(howManyBasket == allBasket){
                    if(gp.currentMap != 10){
                        this.howManyBasket = 0;
                        life = maxLife;
                        gp.currentMap++;
                    }else{
                        gp.ui.win = true;
                        gp.gameState = gp.winState;
                        gp.ui.db.insertScore("Player", gp.ui.playTime, howManyAllBasket);
                    }
               }
            }
        }
    }
    public void contactRanger(int i) throws SQLException{
        if(i != 999){
            if(invincible == false){
                life -= 1;
                if(life == 0){
                    gp.ui.death = true;
                    gp.gameState = gp.deathState;
                    gp.ui.db.insertScore("Player", gp.ui.playTime, howManyAllBasket);
                }
                invincible = true;
            }
        }
    }
    
    
    public void draw(Graphics2D g2){
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        
        BufferedImage image = right;
        
        switch(direction){
            case "left":
                image = left;
                break;
            case "right":
                image = right;
                break;
            case "up":
                if("right".equals(lastDirection)){
                    image = right;
                }else{
                    image = left;
                } 
                break;
            case "down":
                if("right".equals(lastDirection)){
                    image = right;
                }else{
                    image = left;
                } 
                break;
        }
        
        if(invincible == true){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }
}
