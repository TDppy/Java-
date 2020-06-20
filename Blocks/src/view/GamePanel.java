package view;

import model.GameData;
import javax.swing.*;
import java.awt.*;

//GamePanel继承JPanel
public class GamePanel extends JPanel {
    //游戏数据
    GameData gameData;
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1860979716621182120L;

    GamePanel(GameData gameData){
        this.gameData=gameData;
        //false表示透明
        setOpaque(false);
        setBounds(15,30,200,360);//游戏区域大小
    }
    //绘制方块
    @Override
    public void paintComponent(Graphics g){
        for(Point point:gameData.blocks.points){
            g.setColor(gameData.colors[gameData.current]);
            //绘制方格
            g.fillRect((point.x+gameData.x)*20,(point.y+gameData.y)*20,20,20);
            g.drawImage(new ImageIcon("./img/mask3.png").getImage(), (point.x+gameData.x)*20, (point.y+gameData.y)*20, 20, 20, null);
        }
        for(int i=19;i>=2;i--){
            for(int j=0;j<10;j++){
                if(gameData.existBlocks[j][i]!=0){
                    g.setColor(gameData.colors[gameData.existBlocks[j][i]-1]);
                    g.fillRect(j*20,(i-2)*20,20,20);
                    g.drawImage(new ImageIcon("./img/mask3.png").getImage(), (j)*20, (i-2)*20, 20, 20, null);
                }
            }
        }
    }
}
