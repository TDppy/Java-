package model;

import java.awt.*;
//一共有七种方块，定义在GameData中
public class Blocks {
    //points是一个point数组
    public Point[] points;
    //重载了Blocks的构造方法
    Blocks(int[] xs, int[] ys){
        points=new Point[4];
        for(int i=0;i<4;i++){
            points[i]=new Point(xs[i],ys[i]);
        }
    }
    //传入一个blocks，对每个point进行赋值
    public Blocks(Blocks blocks){
        points=new Point[4];
        for(int i=0;i<4;i++){
            points[i]=new Point(blocks.points[i].x,blocks.points[i].y);
        }
    }
}
