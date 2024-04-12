class Employ {
    private int id;
    private String name;

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }
}

public class Getter_And_Setter_Access_Modifire {
    public static void main(String[] args) {
        Employ e1 = new Employ();
        e1.setname("Smit");
        System.out.println(e1.getname());
        e1.setid(2);
        System.out.println(e1.getid());
    }
}
