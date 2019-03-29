package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 可扩容的完全二叉树，数组存储方式
 * @Author liuqn
 * @Date 2019/3/28 11:08
 * @Version 1.0
 **/
public class CompleteBinaryTree {

    private int count;
    private int[] array;
    /**
     * tree的最大存储数
     **/
    private int capacity;
    private CompleteBinaryTree(int capacity){
        array = new int[capacity+1];
        this.capacity = capacity;
        count = 1;
    }
    /**
     * @Author liuqn
     * @Description 添加
     * @Date 11:30 2019/3/28
     * @Param [num]
     * @return void
     **/
    public void add(int num){
        //空间不足，扩容
        if(count==capacity+1){
            int[] temp = new int[(capacity<<1)+1];
            System.arraycopy(array,0,temp,0,capacity+1);
            array = temp;
            capacity = capacity<<1;
        }
        //存放到数组中，并索引自增
        array[count++]=num;

        Integer.parseInt("03");


    }
    /**
     * @Author liuqn
     * @Description 已存放个数
     * @Date 11:29 2019/3/28
     * @Param []
     * @return int
     **/
    public int size(){
        return count-1;
    }

    /**
     * @Author liuqun
     * @Description 前序遍历
     * @Date 11:31 2019/3/28
     * @Param []
     * @return void
     **/
    public void beforPrint(){

          beforPrint(1);

    }

    private void beforPrint(int i){
        if(count<=i){
            return;
        }
        System.out.println(array[i]);
        beforPrint(i*2);
        beforPrint(i*2+1);

    }

    /**
     * @Author liuqn
     * @Description 中序遍历
     * @Date 11:31 2019/3/28
     * @Param []
     * @return void
     **/
    public void midPrint(){

    }
    /**
     * @Author liuqn
     * @Description 后序遍历
     * @Date 11:32 2019/3/28
     * @Param []
     * @return void
     **/
    public void afterPrint(){

    }
    /**
     * @Author liuqn
     * @Description 按层遍历
     * @Date 11:32 2019/3/28
     * @Param []
     * @return void
     **/
    public void floorPrint(){

    }
    public static void main(String[] args) {
        /*CompleteBinaryTree tree = new CompleteBinaryTree(2);
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.beforPrint();*/
        System.out.println(Integer.parseInt("03"));
    }
}
