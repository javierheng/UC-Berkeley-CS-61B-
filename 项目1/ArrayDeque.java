//import javax.rmi.*;

public class ArrayDeque<T>{
    //属性
    T[] array;
    //T[] tmp;
    int size = 0;
    int length ;
    //int front = 0;
    int last;

    //任务拆解:数组扩容、空出位置1
    public void expand(){
        T[] tmp = (T[]) new Object[length];
        System.arraycopy(array, 0, tmp, 0, length);
        array =(T[]) new Object[length * 2];
        length = length * 2;
        System.arraycopy(tmp,0,array,0,length/2);
    }
    
    public T[] getfirstspace(T[] a){
        T[] tmp =(T[]) Object(length);
        System.arraycopy(a, 0, tmp, 1, size);
        return tmp;
    }
    
	//构造
    public ArrayDeque(T x){
        array=(T[]) Object(100);
        array[0] = x;
        this.last = 0;
        size = 1;
        length = 100;
    }

    public ArrayDeque(){
        array=(T[]) Object(100);
        size = 0;
        length = 100;
        last = -1;
    }

    public ArrayDeque(ArrayDeque a){
        this.size = a.size;
        this.length = a.length;
        this.last = a.last;
        array=(T[]) Object(length);
        System.arraycopy(a, 0, array, 0, size);
        
    }
    
    //Deque方法的实现
    public void addFirst(T x){
        if(size == length) expand();
        array = getfirstspace(array);
        array[0] = x;
        size = size + 1;
        last = last + 1;
    }
    
    public void addLast(T x){
        if(size == length) expand();
        array[last + 1]=x;
        last += 1;
        size += 1;
    }
    
    public boolean isEmpty(){
        if(this.size == 0) return true;
        else return false;
    }
    
    public int size(){
        return this.size;
    }
    
    public void printDeque(){
        int num = 0;
        while(num != size){
            System.println(array[num]);
            num = num + 1;
        }
    }
    
    public void removeFirst(){
        T[] tmp =(T[]) new Object[length];
        System.arraycopy(array, 1, tmp, 0, size-1);
        array = tmp;
        size -= 1;
        last -= 1;
    }
    
    public void removeLast(){
        array[last] = null;
        last -= 1;
        size -= 1;
    }
    
    public T get(int num){
        if((num<0)||(num>last)) return null;
        else return array[num];
    }
}

