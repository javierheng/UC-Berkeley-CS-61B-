public class ArrayDeque<type>{
    //属性
    type[] array;


	//构造
    public ArrayDeque(type x){
        array=new type[]{null,x,null};
    }

    public ArrayDeque(){
        array=new type[]{null,null};
    }

    public ArrayDeque(ArrayDeque a){

    }

}

