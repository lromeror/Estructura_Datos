package ggm.codigo_conjuntos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Codigo_Conjuntos {
    
    public static void main(String[] args) {
        
        
//        Set<Integer> s1 = new HashSet();
//        System.out.println(s1.add(4));
//        System.out.println(s1.add(8));
//        System.out.println(s1.add(9));
//        System.out.println(s1.add(8)); 
//        System.out.println(s1.add(-1)); 
//        System.out.println(s1.add(6)); 
//        System.out.println(s1.add(-90)); 
//        System.out.println(s1.add(91)); 
//        
//        Iterator<Integer> iterator = s1.iterator();
//        while (iterator.hasNext()) {
//            Integer next = iterator.next();
//            System.out.println(next);
//        }
        
//        System.out.println("************+");
//        Set<String> s2 = new LinkedHashSet();
//        System.out.println(s2.add("Hola"));
//        System.out.println(s2.add("Chao"));
//        System.out.println(s2.add("Hola"));
//        
        System.out.println("*************+");
        Set<Student> s3 = new TreeSet<>((s1, s2) -> {
            return s1.getName().compareTo(s2.getName());
        });
        System.out.println(s3.add(new Student("Maria", 15)));
        System.out.println(s3.add(new Student("Pepe", 14)));
        System.out.println(s3.add(new Student("Lucia", 13)));
        System.out.println(s3.add(new Student("Oscar", 44)));
        System.out.println(s3.add(new Student("Mario", 64)));
        System.out.println(s3.add(new Student("Paula", 15)));
        System.out.println(s3.add(new Student("Pepe", 15)));
        System.out.println(s3.add(new Student("Pepe", 35)));
        
        System.out.println("El conjunto tiene " + s3.size() + " elementos");
        
        Iterator<Student> it3 = s3.iterator();
        while (it3.hasNext()) {
            Student next = it3.next();
            System.out.println(next);
        }
        
    }

    private static Set<String> LinkedHashSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static Set<Student> TreeSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
