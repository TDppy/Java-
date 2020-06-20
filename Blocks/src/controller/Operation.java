package controller;

import model.GameData;
import view.ImgButton;
import view.MainWin;

import javax.swing.*;
//Operation 各种操作
public class Operation {
    MainWin mainWin;//mainWin窗口
    GameData gameData;//gameData游戏数据
    public ImgButton left;//左
    public ImgButton righ;//右
    public ImgButton down;//下
    public ImgButton rota;//旋转
    public JButton stst;//开始
    public ImgButton sett;//设置
    public ImgButton logi;//登录
    //Operation构造函数
    //内部类
    Operation(){
        //将每个按钮的图标设置为图片形式
        left = new ImgButton(new ImageIcon("imgs/left.png")) {
            @Override
            public void onClick() {
                gameData.move(true, -1);
                mainWin.getGamePanel().repaint();
            }
        };

        righ = new ImgButton(new ImageIcon("imgs/right.png")){
            private static final long serialVersionUID = 1L;
            @Override
            public void onClick() {
                gameData.move(true, 1);
                mainWin.getGamePanel().repaint();
            }
        };
        down = new ImgButton(new ImageIcon("imgs/down.png")){
            private static final long serialVersionUID = 1L;
            @Override
            public void onClick() {
                if(gameData.move(false, 1)){
                    mainWin.getScoreNext().repaint();
                };
                mainWin.getGamePanel().repaint();
            }
        };
        rota = new ImgButton(new ImageIcon("imgs/rotate.png")){
            private static final long serialVersionUID = 1L;
            @Override
            public void onClick() {
                gameData.rote();
                //要重新绘制窗口
                mainWin.getGamePanel().repaint();
            }
        };
        stst = new JButton("开始");
        sett = new ImgButton(new ImageIcon("imgs/setting.png")){
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                // TODO Auto-generated method stub

            }
        };
        logi = new ImgButton(new ImageIcon("imgs/signin.png")){
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                // TODO Auto-generated method stub

            }
        };
    }
    /**
     * 关联视图
     * @param mainWin
     */
    public void setWin(MainWin mainWin) {
        this.mainWin=mainWin;
    }

    /**
     * 关联model
     * @param gameData
     */
    public void setData(GameData gameData) {
        this.gameData=gameData;
    }
}
