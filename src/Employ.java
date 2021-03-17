import java.util.Random;

public class Employ {
    private static int nextId;
    private int id;
    private String name="";
    private double salary;
    static {
        Random generator = new Random();
        nextId= generator.nextInt(10000);
        System.out.println("static Block");
    }
    {
        id = nextId;
        nextId++;
        System.out.println("Block1");
    }
    public Employ(String n,double s){
        name=n;
        salary=s;
        System.out.println("String-double");
    }
    public Employ(double s){
        this("Emplyee#"+nextId,s);
        System.out.println("double");
    }
    public Employ(){
        System.out.println("默认");
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    public int getId(){
        return id;
    }
    {
        System.out.println("Block2");
    }

    public static void main(String[] args) {
        System.out.println("开始");
        Employ[] staff = new Employ[3];
        staff[0]=new Employ("Harry",4000);
        staff[1]=new Employ(6000);
        staff[2]=new Employ();
    }
}

class Manager extends Employ{
    @Override
    public double getSalary() {
        return super.getSalary();
    }
    public Manager(){

    }
}
