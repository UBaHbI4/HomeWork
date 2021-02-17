package softing.UBaH4ukDev.Lesson13.ClassWork;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson13.ClassWord

 Created by Ivan Sheynmaer

 2021.02.17
 v1.0
 */

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ClassWork {

    public static void main(String[] args) {
        Vector<String> vector; //ArrayList
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        Hashtable<String, String> ht;
        ConcurrentHashMap<String, String> chm;
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> sm = Collections.synchronizedMap(map);
        AtomicInteger ai = new AtomicInteger(10);

    }

}
