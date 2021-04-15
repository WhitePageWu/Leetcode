import com.sun.org.apache.xpath.internal.operations.Mod;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
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

    public static void main(String[] args) throws Exception{
//        System.out.println("开始");
//        Employ[] staff = new Employ[3];
//        staff[0]=new Employ("Harry",4000);
//        staff[1]=new Employ(6000);
//        staff[2]=new Employ();
        Employ e = new Employ();
        System.out.println(e.getClass().getName());
        Class cl = Class.forName("Employ");
        String modeifiers = Modifier.toString(cl.getModifiers());
        if (modeifiers.length()>0)
            System.out.println(modeifiers);
        Constructor[] constructors = cl.getConstructors();
        for (Constructor c:constructors){
            String name = c.getName();
            Class[] parameters = c.getParameterTypes();
            for (Class x :parameters){
                System.out.print(x+" ");

            }        }
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
