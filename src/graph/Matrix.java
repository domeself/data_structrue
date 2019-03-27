package graph;

import java.util.*;

/**
 * 邻接矩阵
 *
 *
 */
public class Matrix {
    /**
     * 顶点数组
     */
    private String[] topPoint;
    /**
     * 存放边数据的二维数组
     */
    private int[][] sideMatrix;


    public void addGraph(String[] topPoint) {
        this.topPoint = topPoint;
        sideMatrix = new int[topPoint.length][topPoint.length];
    }

    public void addElment(String from, String to, int value) {
        sideMatrix[Arrays.binarySearch(topPoint, from)][Arrays.binarySearch(topPoint, to)] = value;
    }

    public Map.Entry<String, Integer> getMin(String from,String to) {
        Map<String, Integer> searchPath = searchPath(from, to);
        if (searchPath.isEmpty()){
            return null;
        }
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(searchPath.entrySet());

        Collections.sort(entries,(entry1,entry2)->{return entry1.getValue()-entry2.getValue();});
        return entries.get(0);
    }
    private Map<String,Integer> searchPath(String from, String to){

        int begin = Arrays.binarySearch(topPoint, from);
        Map<String,Integer> map = new TreeMap<>();
        for (int i = 0; i <sideMatrix[begin].length ; i++) {
            int value = sideMatrix[begin][i];
            if(value !=0){
                String path = from+"->"+topPoint[i];
                if(topPoint[i].equals(to)){
                    map.put(path, value);

                }else {
                    Map<String, Integer> searchPath = searchPath(topPoint[i], to);
                    searchPath.forEach((key,val)->{map
                    .put(from+"->"+key,val+value);});
                }
            }
        }
        return map;

    }

    /**
     * a   b   c   d
     * a   0
     * b       0
     * c           0
     * d               0
     *
     * @return
     */

    public void print() {
        for (int i = -1; i < topPoint.length; i++) {
            if (i != -1) {
                System.out.print(" " + topPoint[i]);
            }else{
                System.out.print(" ");
            }
        }
        System.out.println();
        for (int i = 0; i < topPoint.length; i++) {
            for (int j = -1; j < topPoint.length; j++) {
                //正常sideMatrix[i][j]
                if (j == -1) {
                    System.out.print(topPoint[i]);
                } else {
                    System.out.print(" " + sideMatrix[i][j]);
                }

            }
            System.out.println();
        }
    }
}