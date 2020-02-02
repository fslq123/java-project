package com.fslqup.day07.Reference;
/*类的构造方法引用
* */
public class ConstructorReference {
    public  static void printName(String name,PersonBuilder personBuilder){
        Person person=personBuilder.buildPerson(name);
        System.out.println(person.getName());
    }

    public static void main(String[] args) {
        printName("古力娜扎",(name)->new Person(name));//Lamdba表达式
        printName("马儿扎哈",Person::new);//类的构造方法引用
    }
}
