package pratice;

class Person{
    String name;
    int age;
    String sex;
    String spouse;
    public Person(String name, int age, String sex, String spouse){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.spouse = spouse;
    }
    void marry(Person p){
        System.out.println(name + "和" + p.name + "正在登记...");
        if(age < 18 && p.age < 18){
            System.out.println(name + "和" + p.name + "均未达到适婚年龄,不能结婚。");
            return;
        }else if(age < 18){
            System.out.println(name + "未达到适婚年龄,不能结婚。");
            return;
        }else if(p.age < 18){
            System.out.println(p.name + "未达到适婚年龄,不能结婚。");
            return;
        }else{
            if(sex == p.sex){
                System.out.println("两人为同性,不能结婚。");
                return;
            }else{
                if(spouse != "无"){
                    System.out.println(name + "已有配偶,不能结婚。");
                    return;
                }else if(p.spouse != "无"){
                    System.out.println(p.name + "已有配偶,不能结婚。");
                    return;
                }else{
                    this.spouse = p.name;
                    p.spouse = this.name;
                    System.out.println(name + "和" + p.name + "已成功结为配偶！");
                }
            }
        }
    }
}

public class TestPerson {
    public static void main(String[] args){
        Person person1 = new Person("小明",20,"男","无");
        Person person2 = new Person("小红",18,"女","无");
        Person person3 = new Person("小华",19,"男","无");
        Person person4 = new Person("小强",17,"男","无");
        Person person5 = new Person("小平",18,"男","小丽");
        person1.marry(person3);
        person2.marry(person4);
        person2.marry(person5);
        person1.marry(person2);
        System.out.println(person1.name + "的配偶是：" + person1.spouse);
        System.out.println(person2.name + "的配偶是：" + person2.spouse);
        System.out.println(person3.name + "的配偶是：" + person3.spouse);
        System.out.println(person4.name + "的配偶是：" + person4.spouse);
        System.out.println(person5.name + "的配偶是：" + person5.spouse);
    }
}
