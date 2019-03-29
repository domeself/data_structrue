package linked;



import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @Description  单向链表
 * @Author liuqn
 * @Date 2019/3/8 9:50
 * @Version
 **/
public class OneWayLinkedList<T> implements Iterable {

    @Override
    public Iterator<T> iterator() {
        return new Ite(header);
    }

    @Override
    public void forEach(Consumer action) {
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()){
            action.accept(iterator.next());
        }

    }

    /**
     * @Author lqn
     * @Description 节点
     * @Date 11:08 2019/3/8
     * @Param
     * @return
     **/
    public   class Node<T>{
        public T  data;
        public Node next;
        public Node(T t){
            this.data = t;
        }

    }

    private class Ite<T> implements Iterator{
        private Node<T> cur;

        public Ite(Node node){
            cur = node;
        }
        @Override
        public boolean hasNext() {
            return cur!=null;
        }

        @Override
        public T next() {
            T t = cur.data;
            cur = cur.next;
            return t;
        }
    }
    //头节点
    private Node<T> header;
    //尾节点
    private Node<T> last;
    //长度
    private int length;

    /**
     * @Author liuqn
     * @Description 添加
     * @Date 11:10 2019/3/8
     * @Param
     * @return
     **/
    public void add(T t){
        Node node = new Node(t);
        if(header==null){
            header = node;
        }else{
            last.next = node;
        }
        last = node;
        length++;
    }
    /**
     * @Author liuqn
     * @Description 长度
     * @Date 11:14 2019/3/8
     * @Param []
     * @return int
     **/
    public int size(){
        return this.length;
    }
    /**
     * @Author liuqn
     * @Description  获取头节点
     * @Date 11:20 2019/3/8
     * @Param []
     * @return T
     **/
    public T getHeader(){
        if(header==null){
            return null;
        }
        return header.data;
    }
    /**
     * @Author liuqn
     * @Description 尾节点
     * @Date 11:21 2019/3/8
     * @Param []
     * @return T
     **/
    public T getLast(){
        if (last==null){
            return null;
        }
        return last.data;
    }

    public Node getLastNode(){
        if (last==null){
            return null;
        }
        return last;
    }

    public void remove(T t){
        if(last==null||t==null){
            return;
        }
        if(t.equals(header.data)){
            header =null;
        }
        Node cur = header;
        Node next = header.next;
        while (next!=null){
            if(t.equals(next.data)){
                cur.next=cur.next.next;
                length--;
                break;
            }else{
                next = cur.next.next;
                cur = cur.next;
            }
        }
    }

    public void reverse(){
        Node cur = header;
        Node befor = null;
        Node next = null;
        while (cur!=null){
                next = cur.next;
                cur.next=befor;
                befor = cur;
                cur = next;
        }
        header = befor;
    }

    private void swap(Node befor, Node slow) {
        if(befor==null){
            slow.next=null;
            return;
        };
        slow.next=befor;
    }

    public void addOrder(T t){
        Node node = new Node(t);
        length++;
        if(header==null){
            header=node;
            last=node;
            return;
        }
            if((Integer)t<(Integer) header.data){
                node.next=header;
                header=node;
                return;
            }
            if((Integer)t>(Integer) last.data){
                last.next=node;
                last=node;
                return;
            }
            Node temp = header;
            Node pre = header;
            while((Integer)t>(Integer) temp.data){
                pre = temp;
                temp=temp.next;
            }
            node.next=temp;
            pre.next=node;
        }

        public T  getMid(){
            if (header==last){
                return header.data;
            }
            Node<T> slow = header;
            Node<T> quick = header;
            while(quick.next!=null){
                slow=slow.next;
                quick=quick.next.next;
                if(quick==null){
                    return null;
                }
            }
            return slow.data;
        }

    public Node  getMidNode(){
        if (header==last){
            return header;
        }
        Node<T> slow = header;
        Node<T> quick = header;
        while(quick.next!=null&&quick.next.next!=null){
            slow=slow.next;
            quick=quick.next.next;
        }
        return slow;
    }

        public void deleteBack(int i) {
            /*if (header==last){
                return header.data;
            }*/
            int totol = 0;
            Node<T> slow = header;
            Node<T> quick = header;
            int half = 1;
            while(quick.next!=null&&quick.next.next!=null){
                slow=slow.next;
                quick=quick.next.next;
                half++;
            }
            if(half%2==0){
                totol = 2*half;
            }else{
                totol = 2*half-1;
            }

            if(totol+i<0){
               throw  new  RuntimeException("indexOutOfBounds");
            }
            if(i+totol==0){
                header = header.next;
            }
            else if(i+half<0){
                Node temp = header;
                for (int j = 0; j < totol+i-1 ; j++) {
                   temp = temp.next;
                }
                temp.next=temp.next.next;
            }else{
                for (int j = 0; j <totol-half+i ; j++) {
                     slow=slow.next;
                }
                slow.next=slow.next.next;
            }


        }

        public void union(OneWayLinkedList<T> list){
            list.forEach(t->{
                addOrder((T)t);
            });
        }


        public boolean  isRing(){
        Node slow = header;
        Node quick = header;

        while (quick.next.next!=null&&quick.next!=null){
            slow=slow.next;
            quick=quick.next.next;
            if(slow.data==quick.data){
                return true;
            }
        }


        return false;

        }
}
