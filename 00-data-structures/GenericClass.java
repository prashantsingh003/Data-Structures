class data <T>{
    T i;
    public void add(T i1)
    {
        i=i1;
    }

    T get(){
        return(i);
    }
}
public class GenericClass {
    public static void main(String args[]) {
        data<Integer> d=new data<Integer>();
        data<String> ds=new data<String>();
        d.add(8);
        ds.add("kfjuhksxunyv");
        System.out.println("data "+d.get());
        System.out.println("data "+ds.get());
    }
}