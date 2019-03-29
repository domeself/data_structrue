package queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author liuqn
 * @Date 2019/3/26 17:25
 * @Version
 **/
public class Test {
    public static void main(String[] args) {
    /*  Test test  = new Test();
      List<String> list = new ArrayList<>();
      list.add("05:31");
      list.add("22:08");
      list.add("00:35");
        System.out.println(test.findMinDifference(list));*/
        System.out.println(checkRecord("LPLLA"));

    }
    public static  boolean checkRecord(String s) {
        char[] chars = s.toCharArray();
        int Acount = 0;
        int Lcount = 0;
        for (int i = 0; i <chars.length ; i++) {
            if(chars[i]=='L'){
                Lcount++;
                if(Lcount==3){
                    return false;
                }
                continue;
            }else{
                Lcount=0;
            }
            if(chars[i]=='A'){
                Acount++;
                if(Acount==2){
                    return false;
                }
            }

        }
        return true;

    }
    public int findMinDifference(List<String> timePoints) {

        Collections.sort(timePoints);
        int min = Integer.MAX_VALUE;

        for(int i = 0;i < timePoints.size()-1;i++){
            int minu =  reduce(timePoints.get(i),timePoints.get(i+1));
            if(minu<min){
                min = minu;
            }
        }
        return min;

    }

    private int reduce(String befor,String after){
        if(befor.equals("00:00")){
            befor = "24:00";
        }
        if(after.equals("00:00")){
            after = "24:00";
        }
        String[] befors = befor.split(":");
        String[] afters = after.split(":");

        return  Integer.parseInt(afters[0])*60+Integer.parseInt(afters[1])-(Integer.parseInt(befors[0])*60+Integer.parseInt(befors[1]));

    }
}
