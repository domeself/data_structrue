package queue;

/**
 * @Description
 * @Author liuqn
 * @Date 2019/3/26 17:25
 * @Version
 **/
public class Test {
    public static void main(String[] args) {
        CirCularQueue  cirCularQueue = new CirCularQueue(4);
        cirCularQueue.enqueue("1");
        cirCularQueue.enqueue("2");
        new Thread(()-> {
            try {
                Thread.sleep(3000);
                System.out.println("weekup");
                System.out.println(cirCularQueue.dequeue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        cirCularQueue.enqueue("3");
        cirCularQueue.enqueue("4");
        /*System.out.println(cirCularQueue.enqueue("5"));
        System.out.println(cirCularQueue.dequeue());
        System.out.println(cirCularQueue.dequeue());*/


        System.out.println(cirCularQueue.dequeue());
        System.out.println(cirCularQueue.dequeue());
        System.out.println(cirCularQueue.dequeue());
    }
}
