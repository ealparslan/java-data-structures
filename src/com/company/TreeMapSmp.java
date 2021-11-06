package com.company;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/*
TreeMap keeps entries ordered by keys by default.
You can define another comparator to order items how you like.
 */
public class TreeMapSmp {
    static class Student implements Comparable{
        int id;
        String name;
        Student(int id, String name){
            this.id=id;
            this.name = name;
        }

        @Override
        public int compareTo(Object o) {
            return ((Student)o).name.compareTo(this.name);
        }
    }
    public static void main(String[] args) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(3,100);
        map.put(1,300);
        System.out.println(map);

        TreeMap<Integer,Integer> map2 = new TreeMap<>(Collections.reverseOrder());
        map2.put(3,100);
        map2.put(1,300);
        System.out.println(map2);

        Student s1=new Student(1,"Erdem");
        Student s2=new Student(2,"John");
        TreeMap<Student, Integer> map3 = new TreeMap<>();
        map3.put(s1,1000);
        map3.put(s2,2000);
        System.out.println(map3);
    }
}
