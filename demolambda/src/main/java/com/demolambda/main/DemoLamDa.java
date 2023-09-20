package com.demolambda.main;

import java.util.Arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demolambda.entity.Student;

public class DemoLamDa {
    static Map<Integer,Student> mapp =  new HashMap<Integer,Student>();
    
    static List<Student> lst = Arrays.asList(
            new Student("NGuyen noc lam ", true, 9.9),
            new Student("NGuyen noc huyen ", false, 9.5),
            new Student("NGuyen noc duy ", true, 9.4),
            new Student("NGuyen noc hieu ", false, 10.0),
            new Student("NGuyen noc guyrtmn ", true, 7.5));

    public static void main(String[] args) {
       for (int i = 0; i < lst.size(); i++) {
          mapp.put(i+1, lst.get(i));   
       }
       mapp.forEach((Key, val) -> System.out.println(val.getName()) );
       
    }

    private static void demo4() {
         InnerDemoLamDaaa d   =  x -> {System.out.println(x + x); return x;};
         d.sum(4);
    }

    private static void demo3() {
        Collections.sort(lst, (arg0, arg1) -> -arg0.getGpa().compareTo(arg1.getGpa()));
        demo2();
    }

    private static void demo2() {
        lst.forEach(arg0 -> System.out.println(arg0.getName() + " " + arg0.getGpa()));
    }

    public static void demo1() {
        List<Integer> ls = Arrays.asList(1, 3, 45, 3, 2, 23, 23, 3, 23, 2, 32);
        ls.forEach(arg0 -> System.out.print(arg0));
    }

}

@FunctionalInterface
 interface InnerDemoLamDaaa {
    int sum(int x);

    default int summmm() {
        System.out.println(3 + 2);
        return 5;
    };

    public static void sub() {
    };
}


