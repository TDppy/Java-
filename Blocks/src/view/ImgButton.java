package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//JButton JFrame JPanel
//抽象类ImgButton继承自Jbutton
public abstract class ImgButton extends JButton {
    /**
     * 序列化
     */
    private static final long serialVersionUID = -1137580422525064041L;

    //构造函数 参数：一张图片
    public ImgButton(ImageIcon imgic) {
        // 背景透明
        setContentAreaFilled(false);
        // 更改图片
        setIcon(imgic);
        // 去除边框
        setBorder(null);
        //加添按键检测
        addActionListener(new ActionListener() {
            //监听到事件时执行
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });
    }
    //抽象方法onClick
    public abstract void onClick();
}