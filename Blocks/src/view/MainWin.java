package view;

import controller.Operation;
import model.GameData;

import javax.swing.*;
import java.awt.*;

//MainWin继承JFrame，是窗口
public class MainWin extends JFrame {
    Operation operation;
    //游戏数据
    GameData gameData;
    //游戏窗口
    GamePanel gamePanel;
    Container mainpane;
    StaticPanel staticPanel;
    ScoreNext scoreNext;
    private static final long serialVersionUID=7232361914612049231l;
    public MainWin(Operation operation, GameData gameData){
        this.gameData=gameData;
        this.operation=operation;
        mainpane=getLayeredPane();
        setBounds(100,50,360,600);//设置起始位置 宽 高
        setResizable(false);//不允许拉伸
        setLayout(null);//自由布局
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //采用自定义函数setback来设置背景
        setBack();
        //new一个StaticPanel，StaticPanel中再newButton
        staticPanel = new StaticPanel(operation);
        //绘制区域
        mainpane.add(staticPanel);
        //添加游戏画布到主窗口
        setGamePanel();
        // 添加分数和下一个
        setScoreNext();
        // 调整层次
        setOverflow();
    }

    /**
     * 设置背景
     */
    void setBack(){
        ImageIcon imgic=new ImageIcon("imgs/bg.jpg");
        JLabel jl=new JLabel(imgic);
        jl.setBounds(0,0,360,600);
        getContentPane().add(jl);
    }
    /**
     * 添加游戏方块
     */
    void setGamePanel(){
        gamePanel=new GamePanel(gameData);
        mainpane.add(gamePanel);
    }

    /**
     * 获取游戏区
     * @return
     */
    public GamePanel getGamePanel() {
        return gamePanel;
    }

    /**
     * 添加下一个
     */
    public void setScoreNext(){
        scoreNext = new ScoreNext(gameData);
        mainpane.add(scoreNext);
    }
    /**
     * 设置图层位置
     */
    public void setOverflow(){
        mainpane.setComponentZOrder(gamePanel, 0);
        mainpane.setComponentZOrder(staticPanel, 1);
        mainpane.setComponentZOrder(scoreNext, 0);
    }
    public ScoreNext getScoreNext(){
        return scoreNext;
    }
}
