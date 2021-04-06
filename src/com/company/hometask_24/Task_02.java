package com.company.hometask_24;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task_02 {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("Tom", 23, "man"));
        people.add(new Person("Hanna", 60, "woman"));
        people.add(new Person("Mike", 17, "man"));
        people.add(new Person("Adelle", 33, "woman"));
        people.add(new Person("Joe", 20, "man"));
        people.add(new Person("Kate", 7, "woman"));
        people.add(new Person("Nik", 70, "man"));

        // Вибираємо чоловіків-військовозобов'язаних (від 18 до 27 років)
        people.stream().filter(person -> person.getSex().equals("man") && person.getAge() >= 18 && person.getAge()<+27)
                .forEach(System.out::println);

        // Шукаємо середній вік серед чоловіків
        System.out.println("Average men's age : "+people.stream().filter(person -> person.getSex().equals("man"))
                .mapToInt(Person::getAge).average().getAsDouble());

        // Шукаємо кількість потенційно працездатних людей (від 18 років: жінки до 55, чоловіки до 60)
        List<Person> workable = people.stream().filter(person -> person.getSex().equals("man")
                && person.getAge() >= 18 && person.getAge() < 60).collect(Collectors.toList());
        people.stream().filter(person -> person.getSex().equals("woman") && person.getAge() >= 18
                && person.getAge() < 55).forEach(workable::add);
        System.out.println("Number of potentially workable people : "+workable.size());

        // Сортуємо колекцію людей за ім'ям в зворотному алфавітному порядку
        System.out.println("People in reverse alphabetical order: ");
        people.stream().sorted((p1, p2) -> p2.getName().compareTo(p1.getName())).forEach(System.out::println);

        // Сортуємо колекцію людей за ім'ям в алфавітному порядку та за віком
        System.out.println("People in alphabetical order: ");
        people.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
        System.out.println("People sorted by age: ");
        people.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);

        // Шукаємо найстаршу та наймолодшу людину
        System.out.println("The oldest person : "+people.stream().sorted((p1, p2) -> p2.getAge()
                .compareTo(p1.getAge())).findFirst().get());
        System.out.println("The youngest person : "+people.stream().sorted(Comparator.comparing(Person::getAge))
                .findFirst().get());

        // Виводимо кількості чоловіків та жінок
        System.out.println("Number of men : "+people.stream().filter(person -> person.getSex().equals("man")).count());
        System.out.println("Number of women : "+people.stream().filter(person -> person.getSex()
                .equals("woman")).count());

        // Виводимо жінок, імена яких починаються на A
        System.out.println("Women which names start with A : ");
        people.stream().filter(person -> person.getSex().equals("woman") && person.getName()
                .startsWith("A")).forEach(System.out::println);
        }
}
