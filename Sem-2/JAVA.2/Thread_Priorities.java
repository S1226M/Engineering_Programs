class MyThread1 extends Thread{
    public MyThread1(String name){
        super(name);
    }
    public void run(){
        while(true){
            System.out.println("Well come to my thread and my thread name is : "+this.getName());
        }
    }
}
public class Thread_Priorities {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1("Hello 1 spfgp[gff,s,fdpds,vddovsgokoek]");
        MyThread1 t2 = new MyThread1("Hello 2");
        MyThread1 t3 = new MyThread1("Hello 3");
        MyThread1 t4 = new MyThread1("Hello 4");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }    
}
