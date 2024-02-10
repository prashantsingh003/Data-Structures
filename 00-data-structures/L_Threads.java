import java.lang.*;
//USING THREAD CLASS
class A extends Thread{
    public void run()
    {
        for(int i=0;i<10;i++)
            System.out.println("A "+i);
    }
}
class B extends Thread{
    public void run()
    {
        for(int i=0;i<9;i++)
            System.out.println("B "+i);
    }
}
public class L_Threads{
    public static void main(String args[]) {
        A t1=new A();
        B t2=new B();
        t1.start();
        t2.start();
        System.out.println(t1.getPriority());
    }
}


// Using RUNNABLE INTERFACE
/*class A implements Runnable{
    public void run(){
        for(int i=0;i<10;i++)
            System.out.println("A "+i);
    }
}
class B implements Runnable{
    public void run(){
        for(int i=0;i<10;i++)
            System.out.println("B "+i);
    }
}
public class L_Threads{
    public static void main(String args[]) {
        Thread t1=new Thread(new A( ));
        Thread t2=new Thread(new B( ));
        t1.start();
        t2.start();
    }
}*/