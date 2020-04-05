package com.example.hello;

import com.sun.javafx.scene.control.skin.LabeledImpl;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.DateUtil;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {
    static Integer z = 1;
    static Integer y = null;

    public static Integer m1(Integer x) throws Exception {
        if (x == 0) {
            throw new NullPointerException();
        }
        return null;
    }


    private Function<Person, Long> getRollNum = person -> {
        return person.getAid();
    };
    private Function<Person, Boolean> getRoll = person -> {
        System.out.println("akdsl");
        if (person.getName() != null && person.getAid() != null & person.getCity() != null) {
            return true;
        }
        return false;
    };


    public static void main(String[] args) throws Exception {

        SpringApplication.run(DemoApplication.class, args);
        DemoApplication demo = new DemoApplication();
		/*Person person = new Person("om",100l,"DMM");
		//Long lon = demo.getRollNum.apply(person);
		System.out.println(demo.getFirstName.apply(person));
		//System.out.println(lon);*/
        Function<Person, String> fun = (person -> person.getName());
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("om", 100l, "DMM"));
        personList.add(new Person("om1", 101l, "DMM1"));
        personList.add(new Person("om2", 102l, "DMM2"));
        personList.add(new Person("om3", 103l, "DMM3"));
        List<String> list0 = convertPerToStrList(personList, fun);
		Function<String,String> function = (String s)->s.concat("xyz");
		Function<Person,Person> function1 = (Person person)->new Person(person.getCity(),person.getAid(),person.getName());
		//List<String> list =convertPerToStrList(personList,fun.andThen(function));
		List<String> list =convertPerToStrList(personList,fun.andThen(function));
		List<String> list1 =convertPerToStrList(personList,fun.compose(function1));

       list0.forEach(System.out::println);
       list.forEach(System.out::println);
       list1.forEach(System.out::println);
    }


    private static Function<Person, String> getFirstName = Person::getName;

    private static List<String> convertPerToStrList(List<Person> personList, Function<Person, String> fun) {
        List<String> list = new ArrayList<>();
        for (Person per : personList) {
            list.add(fun.apply(per));
        }
        return list;
    }
	private static Function<Person,String> getStr  = Person::getName;
}
