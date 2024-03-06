interface Transport{
    void deliver();
}
abstract class Animal{

}
class Tiger extends Animal{

}
class Cemal extends Animal implements Transport{
    public void deliver(){
        System.out.println("camel was callsd");
    }
}
class Deer extends Animal{

}
class Donkey extends Animal implements Transport{
    public void deliver(){
        System.out.println("donkey was callsd");
    }
}
public class TransportDemo{
    public static void main(String[] args) {
        Animal[] a={new Tiger(),new Cemal(),new Deer(),new Donkey()};
        for(Animal b:a){
            if(b instanceof Transport){
                Transport t1=(Transport)b;
                t1.deliver();
            }
        }
    }
}