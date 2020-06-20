package view;

import model.GameData;
import javax.swing.*;
import java.awt.*;

public class ScoreNext extends JPanel {
    GameData gameData;
    /**
     * 序列化
     */
    int[] offset=new int[]{0,-10,0,0,-10,0,0};
    private static final long serialVersionUID=1860979716621182121L;
    ScoreNext(GameData gameData) {
        this.gameData = gameData;
        setOpaque(false);
        setBounds(233, 30, 90, 215);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setFont(new Font("黑体", Font.PLAIN, 23));
        g.drawString(gameData.getScore(), 10, 50);
        for (Point point : gameData.Blocks[gameData.next].points) {
            g.setColor(gameData.colors[gameData.next]);
            g.fillRect((point.x) * 20 + 35 + offset[gameData.next], (point.y) * 20 + 150, 20, 20);
            g.drawImage(new ImageIcon("./img/mask3.png").getImage(), (point.x) * 20 + 35 + offset[gameData.next],
                    (point.y) * 20 + 150, 20, 20, null);
        }
    }
}
