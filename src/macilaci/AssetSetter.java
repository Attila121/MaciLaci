/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package macilaci;

import entity.Ranger;
import java.io.IOException;
import object.Object_basket;

/**
 *
 * @author Mielec Attila (MNZVUM)
 */
public class AssetSetter {
    GamePanel gp;
    
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    
    public void setObject(){
        int mapNum = 1;
        
        gp.obj[mapNum][0] = new Object_basket();
        gp.obj[mapNum][0].worldX = 23 * gp.tileSize;
        gp.obj[mapNum][0].worldY = 7 * gp.tileSize;
        
        gp.obj[mapNum][1] = new Object_basket();
        gp.obj[mapNum][1].worldX = 23 * gp.tileSize;
        gp.obj[mapNum][1].worldY = 40 * gp.tileSize;
        
        gp.obj[mapNum][2] = new Object_basket();
        gp.obj[mapNum][2].worldX = 36 * gp.tileSize;
        gp.obj[mapNum][2].worldY = 37 * gp.tileSize;
        
        gp.obj[mapNum][3] = new Object_basket();
        gp.obj[mapNum][3].worldX = 10 * gp.tileSize;
        gp.obj[mapNum][3].worldY = 8 * gp.tileSize;
        
        mapNum = 2;
        
        gp.obj[mapNum][0] = new Object_basket();
        gp.obj[mapNum][0].worldX = 19 * gp.tileSize;
        gp.obj[mapNum][0].worldY = 21 * gp.tileSize;
        
        gp.obj[mapNum][1] = new Object_basket();
        gp.obj[mapNum][1].worldX = 36 * gp.tileSize;
        gp.obj[mapNum][1].worldY = 18 * gp.tileSize;
        
        gp.obj[mapNum][2] = new Object_basket();
        gp.obj[mapNum][2].worldX = 20 * gp.tileSize;
        gp.obj[mapNum][2].worldY = 37 * gp.tileSize;
        
        gp.obj[mapNum][3] = new Object_basket();
        gp.obj[mapNum][3].worldX = 10 * gp.tileSize;
        gp.obj[mapNum][3].worldY = 7 * gp.tileSize;
        
        
        
    }
    
    public void setRanger() throws IOException{
        int mapNum = 1;
        
        gp.ranger[mapNum][0] = new Ranger(gp, "up", 5);
        gp.ranger[mapNum][0]. worldX = gp.tileSize * 21;
        gp.ranger[mapNum][0]. worldY = gp.tileSize * 21;
        
        gp.ranger[mapNum][1] = new Ranger(gp, "up", 7);
        gp.ranger[mapNum][1]. worldX = gp.tileSize * 8;
        gp.ranger[mapNum][1]. worldY = gp.tileSize * 20;

        gp.ranger[mapNum][2] = new Ranger(gp, "down", 7);
        gp.ranger[mapNum][2]. worldX = gp.tileSize * 9;
        gp.ranger[mapNum][2]. worldY = gp.tileSize * 20;
        
        gp.ranger[mapNum][3] = new Ranger(gp, "right", 7);
        gp.ranger[mapNum][3]. worldX = gp.tileSize * 30;
        gp.ranger[mapNum][3]. worldY = gp.tileSize * 40;
        
        gp.ranger[mapNum][4] = new Ranger(gp, "right", 7);
        gp.ranger[mapNum][4]. worldX = gp.tileSize * 30;
        gp.ranger[mapNum][4]. worldY = gp.tileSize * 41;
        
        gp.ranger[mapNum][5] = new Ranger(gp, "left", 7);
        gp.ranger[mapNum][5]. worldX = gp.tileSize * 20;
        gp.ranger[mapNum][5]. worldY = gp.tileSize * 35;
        
        gp.ranger[mapNum][6] = new Ranger(gp, "right", 7);
        gp.ranger[mapNum][6]. worldX = gp.tileSize * 20;
        gp.ranger[mapNum][6]. worldY = gp.tileSize * 36;
        
        gp.ranger[mapNum][7] = new Ranger(gp, "left", 7);
        gp.ranger[mapNum][7]. worldX = gp.tileSize * 20;
        gp.ranger[mapNum][7]. worldY = gp.tileSize * 37;
        
        gp.ranger[mapNum][8] = new Ranger(gp, "down", 5);
        gp.ranger[mapNum][8]. worldX = gp.tileSize * 20;
        gp.ranger[mapNum][8]. worldY = gp.tileSize * 21;
        
        gp.ranger[mapNum][9] = new Ranger(gp, "up", 5);
        gp.ranger[mapNum][9]. worldX = gp.tileSize * 19;
        gp.ranger[mapNum][9]. worldY = gp.tileSize * 21;
        
        mapNum = 2;
        
        gp.ranger[mapNum][0] = new Ranger(gp, "up", 5);
        gp.ranger[mapNum][0]. worldX = gp.tileSize * 20;
        gp.ranger[mapNum][0]. worldY = gp.tileSize * 21;
        
        gp.ranger[mapNum][1] = new Ranger(gp, "up", 7);
        gp.ranger[mapNum][1]. worldX = gp.tileSize * 8;
        gp.ranger[mapNum][1]. worldY = gp.tileSize * 20;

        gp.ranger[mapNum][2] = new Ranger(gp, "down", 7);
        gp.ranger[mapNum][2]. worldX = gp.tileSize * 9;
        gp.ranger[mapNum][2]. worldY = gp.tileSize * 20;
        
        gp.ranger[mapNum][3] = new Ranger(gp, "up", 7);
        gp.ranger[mapNum][3]. worldX = gp.tileSize * 36;
        gp.ranger[mapNum][3]. worldY = gp.tileSize * 27;
        
        gp.ranger[mapNum][4] = new Ranger(gp, "down", 7);
        gp.ranger[mapNum][4]. worldX = gp.tileSize * 37;
        gp.ranger[mapNum][4]. worldY = gp.tileSize * 27;
        
        gp.ranger[mapNum][5] = new Ranger(gp, "down", 7);
        gp.ranger[mapNum][5]. worldX = gp.tileSize * 35;
        gp.ranger[mapNum][5]. worldY = gp.tileSize * 27;
        
        gp.ranger[mapNum][6] = new Ranger(gp, "right", 7);
        gp.ranger[mapNum][6]. worldX = gp.tileSize * 20;
        gp.ranger[mapNum][6]. worldY = gp.tileSize * 36;
        
        gp.ranger[mapNum][7] = new Ranger(gp, "left", 7);
        gp.ranger[mapNum][7]. worldX = gp.tileSize * 20;
        gp.ranger[mapNum][7]. worldY = gp.tileSize * 37;
        
        gp.ranger[mapNum][8] = new Ranger(gp, "down", 5);
        gp.ranger[mapNum][8]. worldX = gp.tileSize * 19;
        gp.ranger[mapNum][8]. worldY = gp.tileSize * 21;
        
        gp.ranger[mapNum][9] = new Ranger(gp, "up", 5);
        gp.ranger[mapNum][9]. worldX = gp.tileSize * 18;
        gp.ranger[mapNum][9]. worldY = gp.tileSize * 21;
    }
    
}
