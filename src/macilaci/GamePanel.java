/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package macilaci;

import entity.Entity;
import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import object.SuperObject;
import tile.TileManager;

/**
 *
 * @author Mielec Attila (MNZVUM)
 */
public class GamePanel extends JPanel implements Runnable{
    // Kép beállítások
    final int originalTileSize = 16; // 16x16 pixel karakter
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16; 
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels
    
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player;
    public SuperObject obj[][];
    public Entity ranger[][];
    public UI ui;
    
    // Világ beállításai
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * tileSize;
    public final int worldHeight = tileSize * maxWorldRow;
    public final int maxMap = 11;
    public int currentMap = 1;
    
    
    public int gameState ;
    public final int playState = 1;
    public final int deathState = 2;
    public final int winState = 3;
    public final int titleState = 4;
    public final int resultState = 5;

    
    //FPS
    int FPS = 60; 
    
    // Játékos alap helyének beállítása
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;


    public GamePanel() throws IOException, SQLException {
        this.ui = new UI(this);
        this.obj = new SuperObject[maxMap][10];
        this.ranger = new Entity[maxMap][10];
        this.player = new Player(this, keyH);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.gameState = titleState;
        
    }
    
    public void setupGame() throws IOException{
        aSetter.setObject();
        aSetter.setRanger();
        gameState = titleState;
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
        
    }
    
    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime =  System.nanoTime();
        long currentTime;
        long timer = 0;
        int  drawCount = 0;
        
        while(gameThread != null){
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            timer +=  (currentTime - lastTime);
            lastTime = currentTime;
            
            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
            
            if(timer >= 1000000000){
                drawCount = 0;
                timer = 0;
            }
            
        }
    }
    
    public void update(){
        if(gameState == playState){
            player.update();

            for(int i = 0; i < ranger[1].length; i++){
                if(ranger[currentMap][i] != null){
                    ranger[currentMap][i].update();
                }
            }
        }
        if(gameState == deathState){
            
        }
        if(gameState == winState){ 
        }
        if(gameState == titleState){
        }
        if(gameState == resultState){
        } 
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        if(gameState == titleState || gameState == resultState){
            try {   
                ui.draw(g2);
            } catch (SQLException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            
        
            tileM.draw(g2);

            for(int i = 0; i < obj[1].length; i++){
                if(obj[currentMap][i] != null){
                    obj[currentMap][i].draw(g2, this);
                }
            }

            for(int i  = 0; i < ranger[1].length; i++){
                if(ranger[currentMap][i] != null){
                    ranger[currentMap][i].draw(g2);
                }
            }
            player.draw(g2);

            try {
                ui.draw(g2);
            } catch (SQLException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        g2.dispose();
    }
    
    
    
    
}
