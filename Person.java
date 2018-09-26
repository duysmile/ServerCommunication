/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermanager;

/**
 *
 * @author duy21
 */
public class Person {
    int age;
    String name;
    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
}
