import java.util.*;

public class LinkedListDeque<type>{
    //Node嵌套类(作为双链表中的节点)
    public class Node{
        public type item ;
        public Node next;
        public Node prev;

        public Node(type x,Node pre,Node nex){
            item = x;
            next = nex;
            prev = pre;
        }
    }


    //LinkedListDeque的成员属性
    public int size = 0;             //链表的规模大小
    private Node sentinel1;          //哨兵1为链表头节点
    private Node sentinel2;          //哨兵2为链表尾节点
    public Node first;


    //LinkedListDeque的构造函数
    public LinkedListDeque(type x){
        size += 1;
        first = new Node(x, sentinel1, sentinel2);
        sentinel1 = new Node(null,null,first);
        sentinel2 = new Node(null,first,null);
    }
    
    public LinkedListDeque(){
        sentinel1 = new Node(null,null,first);
        sentinel2 = new Node(null,first,null);
    }


    //方法的实现
    public void addFirst(type var){
        if(size == 0) {first = new Node(var,sentinel1,sentinel2);}
        else first = new Node(var,sentinel1,first);
        sentinel1.next = first;
        first.next.prev = first;
        size += 1;
    }

    public void addLast(type var){
        size += 1;
        Node tmp = sentinel2;
        tmp = tmp.prev;
        tmp.next = new Node(var,tmp,sentinel2);
        sentinel2.prev = tmp.next;
    }

    public boolean isEmpty(){
        if(size == 0) return true;
        else return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node tmp = first;

        while(tmp.next != sentinel2){
            System.out.println(tmp.item);
            tmp = tmp.next;
        }
    }

    public void removeFirst(){
        size -= 1;
        sentinel1.next = first.next;
        first.next.prev = sentinel1;
        first = first.next;
    }

    public  void removeLast(){
        size -= 1;
        Node Last = sentinel2;

        Last = Last.prev;

        Last.prev.next = sentinel2;
        sentinel2.prev = Last.prev;
    }

    public type get(int a){
        if((a > size)||(a < 0)) return null;
        Node tmp = first;
        for(int x=0;x<a;x++){
            tmp = tmp.next;
        }
        return tmp.item;
    }

}

