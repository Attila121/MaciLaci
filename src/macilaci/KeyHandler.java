/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package macilaci;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mielec Attila (MNZVUM)
 */
public class KeyHandler implements KeyListener{
    
    GamePanel gp;
    
    public boolean upPressed, downPressed, rightPressed, leftPressed; 
    
    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        if(gp.gameState == gp.titleState){
            if(code == KeyEvent.VK_W){
                gp.ui.commandNum --;
                if(gp.ui.commandNum < 0){
                    gp.ui.commandNum = 2;
                }
            }
            if(code == KeyEvent.VK_S){
                gp.ui.commandNum ++;
                if(gp.ui.commandNum > 2){
                    gp.ui.commandNum = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum == 0){
                    gp.gameState = gp.playState;
                    gp.currentMap = 1;
                    gp.gameState = gp.playState;
                    gp.player.worldX = gp.tileSize * 23;
                    gp.player.worldY = gp.tileSize * 21;
                    gp.player.life = gp.player.maxLife;
                    gp.ui.death = false;
                    gp.ui.win = false;
                    gp.player.howManyBasket = 0;
                    gp.player.howManyAllBasket = 0;
                    gp.ui.playTime = 0;
                    gp.player.invincible = false;
                    gp.aSetter.setObject();
                    try {
                        gp.aSetter.setRanger();
                    } catch (IOException ex) {
                        Logger.getLogger(KeyHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(gp.ui.commandNum == 1){
                    gp.gameState = gp.resultState;
                }
                if(gp.ui.commandNum == 2){
                    System.exit(0);
                }
                
            }
        }
        
        if(gp.gameState == gp.winState || gp.gameState == gp.deathState){
            if(code == KeyEvent.VK_ENTER){
                gp.gameState = gp.titleState;
            }
        }
        if(gp.gameState == gp.resultState){
            if(code == KeyEvent.VK_W){
                gp.ui.resultCommand = true;
            }
            if(code == KeyEvent.VK_S){
                gp.ui.resultCommand = true;
            }
            if(code == KeyEvent.VK_ENTER && gp.ui.resultCommand == true){
                gp.gameState = gp.titleState;
                gp.ui.resultCommand = false;
            }
        }
        
        if(code == KeyEvent.VK_W){
            upPressed = true;
        }
        if(code == KeyEvent.VK_S){
            downPressed = true;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
        if(code == KeyEvent.VK_R){
            if(gp.gameState == gp.deathState){
                gp.currentMap = 1;
                gp.gameState = gp.playState;
                gp.player.worldX = gp.tileSize * 23;
                gp.player.worldY = gp.tileSize * 21;
                gp.player.life = gp.player.maxLife;
                gp.ui.death = false;
                gp.ui.playTime = 0;
                gp.player.invincible = false;
                gp.player.howManyAllBasket = 0;
                gp.player.howManyBasket = 0;
                gp.aSetter.setObject();
                try {
                    gp.aSetter.setRanger();
                } catch (IOException ex) {
                    Logger.getLogger(KeyHandler.class.getName()).log(Level.SEVERE, null, ex);
                }

                
            }
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
    }
    
}
