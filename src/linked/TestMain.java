package linked;

/**
 * @Description
 * @Author liuqn
 * @Date 2019/3/8 10:21
 * @Version
 **/
public class TestMain {
    public static void main(String[] args) {



      OneWayLinkedList list  =new OneWayLinkedList<String>();
       list.add(1);
        list.add(2);
        list.add(5);
        list.add(7);
        list.add(8);
        list.add(13);




       /* OneWayLinkedList list2  =new OneWayLinkedList<String>();
        list2.addOrder(3);
        list2.addOrder(4);
        list2.addOrder(9);
        list2.addOrder(11);
        list2.addOrder(14);


*/

      list.reverse();
        list.forEach(
            System.out::println
        );


        //  list.deleteBack(-1);


        //  list.reverse();

       // list.remove("c");

      /*  OneWayLinkedList list2  =new OneWayLinkedList<String>();
        list2.addOrder(10);
        list2.addOrder(6);
        list2.addOrder(8);
        list2.addOrder(4);
        list2.addOrder(2);

        list.union(list2);

        list.forEach(System.out::println);*/




    }


}
