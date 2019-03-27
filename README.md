 # 数据结构
 ## 复杂度分析
 ### 空间复杂度
 ### 时间复杂度

 ## 数据结构
 ### 数组(Array)
 >优点：   
  * 可利用cpu的预读缓存功能，提高读取效率  
  * 随机访问  
    ```
    a[i]=firstAddress + offset * i;
    ```  
    tips:`为何数组下标是从0开始?`  
    > C语言风格继承  
    > 如果是从1开始，寻址时多一个减法运算  
    ```
     a[i]=firstAddress + offset * (i-1);
    ```
 >缺点:
 * 长度固定不可变
 * 如果内存中碎片多，在创建数组时，虽然可用内存能够支持创建一个数组，但是由于可用内存不联系可能会发生异常。
 * 插入和删除效率低，插入和删除的元素后面的所有元素都要相应的移动一位。  
    * 优化：执行删除操作时将数据标记为删除状态而不实际删除，当数组没有空间添加数据时，一次性真正删除。  
    tips：`类似GC垃圾对象回收对象时的思想`  
 >性能：
 * 随机访问O(1)
 * 删除、插入O(n)
 >二维数组
 * 数据结构上是用1维数组模拟产生
 * 寻址：
 ```
 //a数组长度m*n
 a[i][j]=firstAddress + offset * (i*n+j);
 ```
 >使用场景
 * 多随机访问，少删除、插入
 ### 链表(linked)
 >结构
  * 节点(node)  
    * 包含若干指针和数据变量  
  * 头节点(head)  
    * 第一个节点
  * 尾节点(tail)
    * 最后一个节点
 >优点
 * 长度可变
 * 插入删除快
 >缺点
 * 随机访问要从头遍历
 * 每个node需要消耗额外内存存储next node的指针
 * 删除操作频繁的释放内存，容易产生内存碎片，导致GC回收。 
 >性能
 * 访问O(n)
 * 插入、删除O(1)
 >种类
 * 单向链表  
    ```
    tail.next=null;
     ```
 * 双向链表
     ```
    head.pre = null;
    head.next=second;
    second.pre=head;
    ```
 * 循环链表
    ```
    tail.next=head;
    ```
 * 双向循环列表
    ```
    head.pre=tail;
    tail.next=head;
     ```
  >使用场景
  * 多插入、删除，少随机访问
  * 练习
    * 链表反转
         ```
          public void reverse(){
                  Node cur = header;
                  Node befor = null;
                  Node next = null;
                  while (cur!=null){
                          next = cur.next;
                          swap(befor,cur);
                          befor = cur;
                          cur = next;
                  }
                  header = befor;
              }
         ```
    * 环检测
        ```
            快慢指针，slow每次行动一个Node，quick指针每次移动2个Node  
            如果quick指针走到尾之前，2个指针能遇到（相等），则说明有环
        ```
    * 找到链表的中间节点
        ```
            快慢指针，slow一次移动一个Node，quick一次移动2个Node  
            当quick移动到尾部时，slow节点就是中间节点（需要考虑奇偶性）
        ```
 ### 栈(stack)
 >特点：  
  * FILO
  * 操作受限；只有出栈、入栈操作
 >实现方式：
  * 链表
  * 数组
 >应用：
 * 函数调用
 * 表达式求值
 * 括号匹配
 * 浏览器前进、后退
 ### 队列(queue)
 >优点：
 >缺点：
  ### 散列表(hash)
 >优点：
 >缺点：
 >LRU
 ### 堆(heap)
 >优点：
 >缺点：
 ### 树(tree)
 >优点：
 >缺点：
 ### 图(graph)
 >优点：
 >缺点：
 
 ## 排序
 ### 冒泡(bubble sort)
 ### 选择(selection sort)
 ### 插入(insertion sort)
 ### 归并(merge sort)
 ### 快速(quick sort)
 ### 桶(bucket sort)
 ### 计数
 ### 基数
 ### 堆(heap sort)
 ### 常见排序复杂度分析
 | Name | 原地 | 稳定 | 最好 | 最坏 | 平均 |  
 | - | :-: | :-: | :-: | :-: | -: | 
 | 冒泡 | 是 | 是 | O(n) | O(n2) | O(n2) |
 | 选择 | 是 | 是 | O(n) | O(n2) | O(n2) |
 | 插入 | 是 | 否 | O(n2) | O(n2) | O(n2) |
 | 归并 | 否 | 否 | O(nlogn) |O(nlogn) | O(nlogn) |
 | 快速 | 是 | 否 | O(nlogn) | O(n2) | O(nlogn) |



 ## 策略
