package com.example.hello;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Long aid;
    private String city;
    Integer i = 10;
    public Person() {
    }


    public Person(String name, Long aid, String city) {
        this.name = name;
        this.aid = aid;
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public Long getAid() {
        return aid;
    }

    public String getCity() {
        return city;
    }
    public String method(Person person){
        System.out.println("method11");
        return person.city;
    }
    public String method(Person person, String str){
        System.out.println("method22");
        return person.city + str;
    }
    public List<String> method2(){
        List<String> list = new ArrayList<>();
        list.add("omkar");
        list.add("omkar1");
        list.add("omkar2");
        return null;

    }
    public boolean method3(){
        if(i==10){
            return true;
        }
        if(i==8){
            return true;
        }
        return false;
    }

}
