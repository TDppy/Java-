package model;

import java.awt.*;
import java.util.Random;

//专门存放游戏数据 blocks
public class GameData {
    public Blocks blocks;
    //blocks数组中存放七个block，每个block是一种俄罗斯方块，每个俄罗斯方块由四个单元组成。
    public static Blocks[] Blocks=new Blocks[]{
        new Blocks(new int[]{-1,0,1,1}, new int[]{0,0,0,1}),
        new Blocks(new int[]{-1,0,1,2}, new int[]{0,0,0,0}),
        new Blocks(new int[]{-1,-1,0,1}, new int[]{0,1,0,0}),
        new Blocks(new int[]{-1,0,0,1}, new int[]{0,0,1,1}),
        new Blocks(new int[]{0,0,1,1}, new int[]{0,1,0,1}),
        new Blocks(new int[]{-1,0,0,1}, new int[]{1,0,1,0}),
        new Blocks(new int[]{-1,0,0,1}, new int[]{0,0,1,0}),
    };
    int opracy=100;
    public Color[] colors = new Color[]{
            new Color(255, 0, 0, opracy),
            new Color(0, 255, 0, opracy),
            new Color(0, 0, 255, opracy),
            new Color(255, 255, 0, opracy),
            new Color(255, 0, 255, opracy),
            new Color(0, 255, 255, opracy),
            new Color(150, 150, 150, opracy),
    };
    /**
     * 偏移量
     */
    public int x;
    public int y;

    /**
     * 存放格子的数组
     */
    public int[][] existBlocks;

    /**
     * 存放删除格数的数组
     */
    int[] deletnum;

    /**
     * 随机因子
     */
    Random random;

    /**
     * 下一个
     */
    public int next;

    /**
     * 当前方块id
     */
    public int current;
    public int score;
    public GameData(){
        existBlocks=new int[10][20];
        random=new Random();
        next=random.nextInt(7);//生成0~6之间
        initBlock();
    }

    /**move
     * @param isH 方向
     * @param step 步长
     * @return
     */
    //返回isdelete 消行判定
    public boolean move(boolean isH, int step){
        //true时水平移动 false时垂直移动
        boolean isdelete=false;
        if(isH){
            //左移
            for(Point point:blocks.points){
                //超界判定
                if(point.x+x+step<0||point.x+x+step>9
                   ||existBlocks[point.x+x+step][point.y+y+2]!=0){
                    return false;
                }
            }
            x+=step;
        }else{
            for(Point point:blocks.points){
                //看不懂
                if(point.y+y+step>17||existBlocks[point.x+x][point.y+y+2+step]!=0){
                    saveBlocks();
                    isdelete=deletTest();
                    if(isdelete){
                        deletLine();
                    }
                    if(isdead()){
                        //TODO 死亡方法
                    }
                    initBlock();
                    return true;
                }
            }
            y+=step;
        }
        return isdelete;
    }

    private void initBlock() {
        x=4;
        y=0;
        deletnum=new int[20];
        blocks = new Blocks(Blocks[next]);
        current=next;
        next=random.nextInt(7);
    }

    /**
     * 旋转方法
     */
    public void rote(){
        for(Point point:blocks.points){
            int _x=-point.y+x;
            int _y=point.x+y;
            if(_x<0||_x>9){
                return ;
            }
            if(_y>17){
                return;
            }
        }
        for (Point point:blocks.points) {
            int temp=point.x;
            point.x=-point.y;
            point.y=temp;
        }
    }
    /**
     * 保存方块组
     */
    void saveBlocks(){
        for(Point point:blocks.points){
            existBlocks[point.x+x][point.y+y+2]=current+1;
        }
    }
    /**
     * 检测消行
     */
    boolean deletTest(){
        boolean isdelet=false;//默认不能消行
        boolean isEmpty;
        for(int i=19;i>=2;i--){
            isEmpty=false;
            for(int j=0;j<10;j++){
                if(existBlocks[j][i]==0){
                    isEmpty=true;
                    break;
                }
            }
            if(!isEmpty){
                isdelet=true;
                deletnum[i-1]=deletnum[i]+1;
            }else{
                deletnum[i-1]=deletnum[i];
            }
        }
        return isdelet;
    }

    /**
     * 消除行
     */
    void deletLine(){
        for(int i=19;i>=2;i--){
            for(int j=0;j<10;j++) {
                existBlocks[j][i+deletnum[i]]=existBlocks[j][i];
            }
        }
        score=score+deletnum[2]*10;
    }
    boolean isdead() {
        for(int j=0; j<10; j++){
            if(existBlocks[j][2]!=0)
                return true;
        }
        return false;
    }
    public String getScore(){return ""+score;}
}
