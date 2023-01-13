public class LinkedList<type>{
    //Node嵌套类(作为双链表中的节点)
    public class Node{
        public type item ;
        public Node next;
        public Node prev;
        public Node first;

        public void Node(type x,Node pre,Node nex){
            item = x;
            next = new Node nex;
            prev = new Node pre;
        }
    }


    //LinkedListDeque的成员属性
    public int size = 0;             //链表的规模大小
    private Node sentinel1;          //哨兵1为链表头节点
    private Node sentinel2;          //哨兵2为链表尾节点


    //LinkedListDeque的构造函数
    public void LinkedList<type>(type var){
        size += 1;
        first = new Node(type var,Node sentinel1,Node sentinel2);
    }

    
    //方法的实现

}
