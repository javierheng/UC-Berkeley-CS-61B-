public class ArrayDeque<type>{
    //属性
    type[] array;
    type[] tmp;
    int realsize = 2;
    int sentinel2 = 1;

	//构造
    public ArrayDeque(type x){
        size += 1;
        array=new type[]{null,x,null};
        sentinel2 += 1;
    }

    public ArrayDeque(){
        array=new type[]{null,null};
    }

    public ArrayDeque(ArrayDeque a){
        this.realsize = a.realsize;
        array = new type[realsize];
        System.arraycopy(a, 0, array, 0, a.realsize);
    }
    
    //Deque方法的实现
    public void addFirst(type x){
        tmp = new type[realsize];
        System.arraycopy(arrar, 0, tmp, 0, realsize);
        realsize += 1;
        array = new type[realsize];
        array[0] = null;
        array[1] = x;
        System.arraycopy(tmp, 1, array, 2, realsize - 2);
        sentinel2 = realsize - 1;
    }
    
    public void addLast(type x){
        tmp = new type[realsize];
        System.arraycopy(arrar, 0, tmp, 0, realsize);
        realsize += 1;
        array = new type[realsize];
        System.arraycopy(tmp, 0, array, 0, realsize - 2);
        array[realsize - 2] = x;
        array[realsize - 1] = null;
        sentinel2 = realsize - 1;
    }
    
    public boolean isEmpty(){
        if(realsize == 2) return true;
        else return false;
    }
    
    public int size(){
        return realsize - 2;
    }
    
    public void printDeque(){
        int num = 1;
        while(num != sentinel2-1){
            System.println(array[num]);
            num = num + 1;
        }
    }
    
    public void removeFirst(){
        tmp = new type[realsize];
        System.arraycopy(array, 0, tmp, 0, realsize);
        realsize -= 1;
        array = new type[realsize];
        array[0] = null;
        System.arraycopy(tmp, 2, array, 1, realsize - 1);
    }
    
    public void removeLast(){
        tmp = new type[realsize];
        System.arraycopy(array, 0, tmp, 0, realsize);
        realsize -= 1;
        array = new type[realsize];
        System.arraycopy(tmp, 0, array, 0, realsize-1);
        array[realsize] = null;
    }
    
    public type get(int num){
        return array[num];
    }
}

