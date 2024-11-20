/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package macilaci;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import object.Object_basket;
import object.Object_heart;
import object.SuperObject;

/**
 *
 * @author Mielec Attila (MNZVUM)
 */
public class UI {
    GamePanel gp;
    Font arial_40, arial_60B;
    BufferedImage basketImage;
    BufferedImage heartImage;
    
    public DataBase db;
    
    public boolean death = false;
    public boolean win = false;
    
    
    public double playTime;
    
    public int commandNum = -1;
    public boolean resultCommand = false;
    
    public DecimalFormat dFormat = new DecimalFormat("#0.00");
    
    
    public UI(GamePanel gp) throws IOException, SQLException{
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_60B = new Font("Arial", Font.BOLD, 60);

        Object_basket basket = new Object_basket();
        basketImage = basket.image;
        
        SuperObject heart = new Object_heart();
        heartImage = heart.image;
        
        db = new DataBase();
    }
    
    public void draw(Graphics2D g2) throws SQLException{
        if(gp.gameState == gp.resultState){
            drawResults(g2);
        }
        else if(gp.gameState == gp.titleState){
            drawTitleScrren(g2);
        }
        else if(win == true || death == true){
            
            g2.setFont(arial_60B);
            
            String text;
            int textLength;
            int x;
            int y;
            if(win){
                text = "Megnyerted a játékot!";
                g2.setColor(Color.yellow);  
                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
                x = gp.screenWidth/2 - textLength/2;
                y = gp.screenHeight/2 - (int)(gp.tileSize * 2.5);
                g2.drawString(text, x, y);
                
                text = "Az időd: " + dFormat.format(playTime) + "s !";
                g2.setFont(arial_40);
                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
                x = gp.screenWidth/2 - textLength/2;
                y = gp.screenHeight/2 + (int)(gp.tileSize * 1.5);
                g2.drawString(text, x, y);
                
                text = "Nyomj 'ENTER' a menübe lépéshez";
                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
                x = gp.screenWidth/2 - textLength/2;
                y += gp.tileSize * 2;
                g2.drawString(text, x, y);
                
                
                //Megadni a nevet
                

            }else{

                gp.gameState = gp.deathState;
                text = "Meghaltál!";
                g2.setFont(arial_60B);
                g2.setColor(Color.red);
                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
                x = gp.screenWidth/2 - textLength/2;
                y = gp.screenHeight/2 - (int)(gp.tileSize * 2.5);
                g2.drawString(text, x, y);
                
                text = "Az időd: " + dFormat.format(playTime) + "s !";
                g2.setFont(arial_40); 
                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
                x = gp.screenWidth/2 - textLength/2;
                y = gp.screenHeight/2 + (int)(gp.tileSize * 1.5);
                g2.drawString(text, x, y);
                
                text = "Pontjaid : " + gp.player.howManyAllBasket + "!";
                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
                x = gp.screenWidth/2 - textLength/2;
                y += gp.tileSize;
                g2.drawString(text, x, y);
                
                
                g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 24));
                text = "Nyomj 'R' az  újraéledéshez";
                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
                x = gp.screenWidth/2 - textLength/2;
                y += gp.tileSize * 2 ;
                g2.drawString(text, x, y);
                text = "Nyomj 'ENTER' a menübe lépéshez";
                textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
                x = gp.screenWidth/2 - textLength/2;
                y += gp.tileSize;
                g2.drawString(text, x, y);
            }
        }else{
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawImage(basketImage, gp.tileSize/2, gp.tileSize/2 * 21, gp.tileSize, gp.tileSize, null);
            g2.drawString("x " + gp.player.howManyBasket, 80, 550);

            int x = gp.tileSize/2;
            int y = gp.tileSize/2;

            for(int i = 0; i < gp.player.life; i++){
                
                g2.drawImage(heartImage, x, y,48,48, null);
                x += gp.tileSize;
            }

            playTime += (double) 1/60;
            g2.drawString("Idő: " + dFormat.format(playTime), gp.tileSize * 11, 65);
        }
    }
    
    public void drawTitleScrren(Graphics2D g2){
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
        String text = "MACI LACI";
        int textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - textLength/2;
        int y = gp.tileSize *3 ;
        
        g2.setColor(Color.GRAY);
        g2.drawString(text, x+5, y+5);
        
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
        
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
        text = "ÚJ JÁTÉK";
        textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = gp.screenWidth/2 - textLength/2;
        y += gp.tileSize * 4 ;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-gp.tileSize, y);
        }
        
        text = "RANGLISTA";
        textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = gp.screenWidth/2 - textLength/2;
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-gp.tileSize, y);
        }
        
        text = "KILÉPÉS";
        textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = gp.screenWidth/2 - textLength/2;
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString(">", x-gp.tileSize, y);
        }
    }
    
    public void drawResults(Graphics2D g2) throws SQLException{
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));
        g2.setColor(Color.white);
        String text;
        int x;
        int y = gp.tileSize;
        int textLength;
        for(int i = 0; i < db.getResults().size(); i++){
            text = i+1 + ". Név: " + db.getResults().get(i).getName() + 
                   "  Pont: "+ db.getResults().get(i).getPoint() +
                   "  Idő: " + db.getResults().get(i).getTime();
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y += gp.tileSize ;
            g2.drawString(text, x, y);
        }
        text = "VISSZA";
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 25F));
        x = 40;
        y = 35;
        g2.drawString(text, x, y);
        if(resultCommand == true){
            g2.drawString(">", x-20, y);
        }
    }
}
