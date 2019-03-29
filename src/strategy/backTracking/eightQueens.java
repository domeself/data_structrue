package strategy.backTracking;




/**
 * @Description
 * @Author liuqn
 * @Date 2019/3/29 11:24
 * @Version
 **/
public class eightQueens {
    int[] result = new int[8];// 全局或成员变量, 下标表示行, 值表示 queen 存储在哪一列
    public void cal8queens(int row) { // 调用方式：cal8queens(0);
        if (row == 8) { // 8 个棋子都放置好了，打印结果
            printQueens(result);
            return; // 8 行棋子都放好了，已经没法再往下递归了，所以就 return
        }
        for (int column = 0; column < 8; ++column) { // 每一行都有 8 中放法
            if (isOk(row, column)) { // 有些放法不满足要求
                result[row] = column; // 第 row 行的棋子放到了 column 列
                cal8queens(row+1); // 考察下一行
            }
        }
    }

    private boolean isOk(int row, int column) {// 判断 row 行 column 列放置是否合适
     int left = column-1;
     int right = column +1;
        for (int i = row-1; i >=0 ; i--) {
            if(result[i]==column){
                return false;
            }
            if(left>=0&&result[i]==left){
                return false;
            }
            if(right<=7&&result[i]==right){
                return false;
            }
            left--;right++;
        }
        return  true;
    }

    private void printQueens(int[] result) { // 打印出一个二维矩阵
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        eightQueens eightQueens = new eightQueens();
        eightQueens.cal8queens(0);
    }
}
