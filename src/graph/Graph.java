package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @module data_structure
 * @ClassName Graph
 * @Description  邻接表
 * @Author superNove
 * @Date 2019/3/24 15:10
 * @Version 1.0
 */

public class Graph {
    /**
     * 端点个数
     */
    private  int vertex;
    /**
     * 端点数组
     */
    private  List<Integer>[] array;
    public Graph(int vertex){
        this.vertex = vertex;
        array = new List[vertex];
        //初始化
        for (int i = 0; i <vertex ; i++) {
            array[i]=new LinkedList();
        }
    }
    public void add(int s,int t){
        array[s].add(t);
        array[t].add(s);
    }

    public void bfs(int s, int t) {
      if(s==t) return;
      boolean[]  acess = new boolean[vertex];

        Queue<Integer> queue= new LinkedList<>();
        queue.add(s);
        int[] prev = new int[vertex];
        for (int i = 0; i < prev.length; i++) {
            prev[i]=-1;
        }
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            if(poll==t){
                print(prev,s,t);
                return;
            }
            acess[poll]=true;
            for (int i = 0; i < array[poll].size(); i++) {
                if(acess[array[poll].get(i)]){
                    continue;
                }
                queue.add(array[poll].get(i));
                prev[array[poll].get(i)]=poll;
            }


        }

    }

    private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
        if(t!=s){
            print(prev,s,prev[t]);
        }
        System.out.println(t);

    }


    boolean found = false; // 全局变量或者类成员变量

    /**
     * 深度优先
     * @param s
     * @param t
     */
    public void dfs(int s, int t) {
        boolean[] visited = new boolean[vertex];
        int[] prev = new int[vertex];
        for (int i = 0; i < prev.length; i++) {
            prev[i]=-1;
        }
        found = false;

        recurDfs(s,t,visited,prev);
        print(prev,s,t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
     if(found){
         return;
     }
     if(w==t){
         found = true;
         return;
     }
     visited[w]=true;


        for (int i = 0; i <   array[w].size(); i++) {
            Integer integer = array[w].get(i);
            if(visited[integer]){
                continue;
            }
            prev[integer]=w;
            recurDfs(integer,t,visited,prev);
        }



    }


}
