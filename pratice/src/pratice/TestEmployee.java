package pratice;

class Employee{
    String name;
    int year;
    int month;
    int day;
    String department;
    int salary;
    public Employee(String name, int year, int month, int day, String department, int salary){
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.department = department;
        this.salary = salary;
    }
    public void set(String name, int year, int month, int day, String department, int salary){
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.department = department;
        this.salary = salary;
    }
    public void get(){
        System.out.println("姓名：" + name);
        System.out.println("入职时间：" + year + "年" + month + "月" + day + "日");
        System.out.println("所在部门：" + department);
        System.out.println("工资：" + salary);
        System.out.println();
    }
}

public class TestEmployee {
    static Employee[] employees = new Employee[3];
    public static void main(String[] args){
        employees[0] = new Employee("小明",2020,9,1,"计算机学院",9000);
        employees[1] = new Employee("小红",2021,9,1,"外国语学院",9500);
        employees[2] = new Employee("小华",2020,9,1,"物理学院",9250);
        employees[0].get();
        employees[1].get();
        employees[2].get();
        employees[0].set("小明",2020,9,1,"计算机学院",10000);
        employees[1].set("小红",2021,9,1,"外国语学院",10000);
        employees[2].set("小华",2020,9,1,"物理学院",10000);
        employees[0].get();
        employees[1].get();
        employees[2].get();
    }
}
