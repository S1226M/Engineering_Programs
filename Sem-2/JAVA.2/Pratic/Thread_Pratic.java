class MyThread1a extends Thread{
    public void run(){
        while(true){
            System.out.println("Good Morning");
            try{
                Thread.sleep(200);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
class MyThread2b extends Thread{
    public void run(){
        while(true){
            System.out.println("Well Come");
            try{
                Thread.sleep(200);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
public class Thread_Pratic {
    public static void main(String[] args) {
        MyThread1a t1 = new MyThread1a();
        MyThread2b t2 = new MyThread2b();
        t1.start();
        t2.start();    
    }
    
}
