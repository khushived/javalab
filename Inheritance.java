public class Inheritance {
    public static void main(String[] args) {
        Officer officer=new Officer("Priya",29,"45678","Los Angeles",400000,"IT");
        Manager manager=new Manager("BOB", 34, "898989", "United States", 900000, "CS");
        System.out.println(officer.toString());
        System.out.println(manager.toString());
    }
}
class Employee{
    String name;
    int age;
    String phoneno;
    String address;
    double salary;
   Employee(String name,int age,String phoneno,String address,double salary){
    this.name=name;
    this.age=age;
    this.phoneno=phoneno;
    this.address=address;
    this.salary=salary;
   }
    void printSalary(){
    System.out.println("salary-"+salary);
   }
   
}
class Officer extends Employee{
    String specialization;
    Officer(String name,int age,String phoneno,String address,double salary,String specialization){
        super(name,age,phoneno,address,salary);
        this.specialization=specialization;
    }
    public String toString(){
        return "Name"+name+"Age"+age+"Phoneno"+phoneno+"Address"+address+"Salary-"+salary+"Specialization"+specialization;
    }
}
class Manager extends Employee{
    String department;
    Manager(String name,int age,String phoneno,String address,double salary,String department){
        super(name, age, phoneno, address, salary);
        this.department=department;
    }
    public String toString(){
        return "Name"+name+"Age"+age+"Phoneno"+phoneno+"Address"+address+"Salary-"+salary+"Department"+department;
    }
}

