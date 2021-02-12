package softing.UBaH4ukDev.Lesson11.ClassWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson11.ClassWork

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.02.12
 v1.0
 */
public class ClassWork11 {
    public static void main(String[] args) {
        List l = new ArrayList();

        List<String> str = new ArrayList<>();


        ListBox b4 = new ListBox(Arrays.asList(10, 20, 30, 40));
        ListBox<Integer> box = new ListBox<>(Arrays.asList(10, 20, 30, 40));
        Float f = 0f;
        for (int i = 0; i < 100; i++) f+=0.1f;
        System.out.println(f);
        ListBox<Float> box1 = new ListBox<>(Arrays.asList(f + 10f, 15.5f + 14.5f, 40f, 10f));
    //        b4 = box1;
        System.out.println(box.compare(box1));

        List<Float> fl = box1.list;
        List<Object> strings = Arrays.asList("One", "Two");
    //        getFirstElement(fl);
        getFirstElement(strings);
    //        box.addCollection(box1.list);

    //        Collections.addAll(box.list, box1.list)
        System.out.println(box1.getClass().getName());
        System.out.println(box.getClass().getName());
}

    private static void boxExample() {
        BoxGen<Integer> b1 = new BoxGen<>(10);
        BoxGen<Integer> b2 = new BoxGen(15);
//        System.out.println((Integer) b1.getObj() + (Integer) b2.getObj());
//        b1.setObj("Hello");
        Integer sum = b1.getObj() + b2.getObj();
        System.out.println(sum);
//        if (b1.getObj() instanceof Integer && b2.getObj() instanceof Integer)
//        System.out.println((Integer) b1.getObj() + (Integer) b2.getObj());
    }

    private static void getFirstElement(List<? super Number> list) {
        System.out.println(list.get(0));
    }
}
