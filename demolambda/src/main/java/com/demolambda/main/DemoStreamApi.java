package com.demolambda.main;



import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.demolambda.entity.Student;

public class DemoStreamApi {  
    static List<Integer> ls = Arrays.asList(1, 32, 4, 54, 54, 2, 756, 34, 23, 12, 12,12, 544, 65, 76);
      static List<Student> lst = Arrays.asList(
            new Student("NGuyen noc lam ", true, 9.9),
            new Student("NGuyen noc huyen ", false, 9.5),
            new Student("NGuyen noc duy ", true, 9.4),
            new Student("NGuyen noc hieu ", false, 10.0),
            new Student("NGuyen noc guyrtmn ", true, 7.5));
    public static void main(String[] args) {
       
          
            demoth6();
    
    }
         
    private static void demoth6() {
    

        Map<Boolean, List<Student>> kk = lst.stream()
                .collect(Collectors.groupingBy(Student::getGender));

        // Print the result
        kk.forEach((gender, students) -> {
            System.out.println(gender + ": " + students);
        });

    }

    private static void demoth5() {
        //Lấy ra tất cả các phần tử không trùng lặp trong danh sách
        List<Integer> Single = ls.stream().distinct().collect(Collectors.toList());
        Single.forEach(x -> System.out.print(x + " "));
    }

    private static void demoth4() {
        //Sắp xếp danh sách theo thứ tự ngược lại
        List<Integer> sortedls = ls.stream().sorted((arg0, arg1) -> arg1.compareTo(arg0)).toList();
        sortedls.forEach( s -> System.out.print(s + " "));
    }

    private static void demoth3() {
  //: Tính tổng của bình phương của các số chẵn
        List<Integer> arr = ls.stream().filter(arg0 -> arg0 % 2 == 0  ).map(arg0 -> arg0 * arg0 ).collect(Collectors.toList());
         arr.forEach( s -> System.out.print(s + " "));
    }

    private static void demoth2() {
        // Lọc ra các số lớn hơn một giá trị cho trước
        int number = 5 ;
        List lst = ls.stream().filter(arg0 -> arg0 > 5).toList();
        lst.forEach(arg0 -> System.out.print(arg0 + " ") );
    }

    private static void demoth1() {  
        //Tính tổng của các số trong danh sách
          int sum = ls.stream().mapToInt(ss -> ss).sum();
          System.out.println(sum);
    }

    static void demo() {
     
        double a = ls.stream().filter(x -> x % 2 == 0).peek(System.out::println).map(x -> Math.sqrt(x))
                .mapToDouble(arg0 -> arg0).average().getAsDouble();
        System.out.println(a);

        List<Integer> aa = ls.stream().filter(ar -> ar > 5).sorted().collect(Collectors.toList());
        aa.forEach(sa -> System.out.print(sa + " "));
    }
}
