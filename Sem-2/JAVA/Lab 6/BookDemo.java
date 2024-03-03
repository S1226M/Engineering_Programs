public class BookDemo {
    public static void main(String[] args) {
        System.out.println("aouther name"+args[0]);
        String name=args[0];
        Book b1;
        System.out.println("aouther name"+args[1]);
        String publication=args[1];
        System.out.println("aouther name"+args[2]);
        String title=args[2];
        if(publication=="bookpublicatiion"){
            b1=new BookPublication(name,title);
        }
        else {
            b1=new PaperPublication(name,title);
        }
        b1.displayDetail();
    }
}
class Book{
    private String authorName;
    Book(String name){
        authorName=name;
    }

    void printName(){
        System.out.println("the author name is "+authorName);
    }

    void displayDetail(){
        System.out.println("No book found!");
    }
}
class BookPublication extends Book{
    private String title;
    BookPublication(String name,String title) {
        super(name);
        this.title=title;

    }
    void displayDetail(){
        printName();
        System.out.println("the book's title is"+title);
    }
}
class PaperPublication extends Book{
    private String title;
    PaperPublication(String name,String title) {
        super(name);
        this.title=title;
    }
    void displayDetail(){
        printName();
        System.out.println("the paper's title is"+title);
    }
}
