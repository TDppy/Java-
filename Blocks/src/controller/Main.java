package controller;
/**
 * 程序介绍：这是基于Java的俄罗斯方块程序
 * 程序实现的功能：
 * 1.可以通过点击左、右、下、旋转操作俄罗斯方块
 * 2.当成功消行时，得分栏+10分
 * 3.可预先看到下一个方块
 * 架构：
 * 采用MVC（模型-视图-控制器）模式，将和界面有关的类放入view，和数据有关的放入model，contrller则放置主方法和操作类。
 * 难点：
 * 1.旋转：通过选定俄罗斯方块的中心点,在坐标系中分析可知，令其他点x=-y y=x即可实现旋转。
 * 2.及时刷新画面：例如如何让俄罗斯方块每秒下落，在循环中程序每次下落1格，然后调用sleep休眠一秒即可。
 */
import model.GameData;
import view.MainWin;

public class Main {
    public static void main(String[] args) {
        //实例化操作
        Operation operation=new Operation();
        //加载数据
        GameData gameData = new GameData();
        //将数据和窗口进行关联
        MainWin mainWin = new MainWin(operation,gameData);
        //将窗口和操作区关联
        operation.setWin(mainWin);
        //将数据和操作区关联
        operation.setData(gameData);
        //实例化线程
        MyThread myThread = new MyThread(gameData, mainWin);
        //start方法启动线程
        myThread.start();
        //主窗口可视化
        mainWin.setVisible(true);
    }
}
//MyThread继承Thread，重写run方法
class MyThread extends Thread{
    private GameData gameData;
    private MainWin mainWin;
    MyThread(GameData gameData, MainWin mainWin){
        this.gameData=gameData;
        this.mainWin=mainWin;
    }
    @Override
    public void run(){
        while(true){
            if(gameData.move(false,1)){
                mainWin.getScoreNext().repaint();
            };
            mainWin.getGamePanel().repaint();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}