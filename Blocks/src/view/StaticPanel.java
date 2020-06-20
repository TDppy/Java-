package view;

import controller.Operation;

import javax.swing.*;
import java.awt.*;

public class StaticPanel extends JPanel {
    JButton left;
    JButton righ;
    JButton down;
    JButton rota;//rotate
    JButton stst;//start
    JButton sett;//setting
    JButton logi;//login
    private static final long serialVersionUID = 991741388603869262L;
    //构造函数
    StaticPanel(Operation operation){
        left = operation.left;
        righ = operation.righ;
        down = operation.down;
        rota = operation.rota;
        stst = operation.stst;
        sett = operation.sett;
        logi = operation.logi;
        setBounds(0,0,360,600);
        setLayout(null);
        setOpaque(false);//消除背景颜色
        stst.setContentAreaFilled(false);
        stst.setFocusPainted(false);
        stst.setFont(new Font("华文行楷", Font.PLAIN, 25));
        stst.setForeground(Color.white);
        left.setBounds(233,255, 45, 45);//设置按钮位置
        righ.setBounds(278,255, 45, 45);
        down.setBounds(233,300, 45, 45);
        rota.setBounds(278,300, 45, 45);
        stst.setBounds(233,350, 90, 50);
        sett.setBounds(240,510, 48, 48);
        logi.setBounds(290,510, 48, 48);
        add(left);
        add(righ);
        add(down);
        add(rota);
        add(stst);
        add(sett);
        add(logi);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(150,150,150,70));
        //主屏
        g.fillRect(15,30,200,360);
        //排名区
        g.fillRect(15,405,200,130);
        //右侧排版
        g.fillRect(223,20,110,400);
        g.setColor(new Color(2,2,2,30));
        //得分区
        g.fillRect(233,30,90,70);
        //提示区
        g.fillRect(233,105,90,140);
        //操作区
        g.fillRect(233,255,90,90);
        //边框
        g.setColor(Color.white);
        ((Graphics2D)g).setStroke(new BasicStroke(3L));
        g.drawRect(13,28,204,364);
        g.drawRect(13,403,204,134);
        ((Graphics2D)g).setStroke(new BasicStroke(1L));
        //设置为黑体来写字
        g.setFont(new Font("黑体",Font.PLAIN,23));
        g.setColor(Color.DARK_GRAY);
        g.drawString("得分",240,53);
        g.drawString("下一个",236,140);
        g.drawString("荣誉榜",25,435);
    }
}

