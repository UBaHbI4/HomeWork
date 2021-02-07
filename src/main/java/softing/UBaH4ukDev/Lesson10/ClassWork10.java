package softing.UBaH4ukDev.Lesson10;

import java.util.*;
import java.util.function.BiConsumer;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson10

 Created by Ivan Sheynmaer

 2021.02.07
 v1.0
 */
public class ClassWork10 {
    //E(lement), T(ype), N(umber), K(ey), V(alue)
    //    Integer i = 10;
    //    Character = char;
    //    Byte = byte;
    //    Short = short;
    //    Boolean = boolean;
    //    Long = long;
    //    Double = double;
    //    Float = float;
    public static void main(String[] args) {
        Box b1 = new Box(1, 1, 1);
        Box b2 = new Box(2, 2, 2);
        Box b3 = new Box(3, 3, 3);
        Box b4 = new Box(1, 1, 4);

        TreeMap<String, Integer> hashMap = new TreeMap<>();
        hashMap.put("Vasya", 20);
        hashMap.put("Petya", 30);
        hashMap.putIfAbsent("Petya", 40);         //Если отсутствует ключ Petya, тогда вставит Petya, 40
        //hashMap.put("Petya", 40);               //Заменит 30 на 40

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Iterator<Map.Entry<String, Integer>> mapIter = hashMap.entrySet().iterator();
        while (mapIter.hasNext()) {
            //mapIter.remove();
        }
//        System.out.println(hashMap);
//        for (String s : hashMap.keySet()) {
//            System.out.println(hashMap.get(s));
//        }

        hashMap.forEach((k, v) -> System.out.println("key: " + k + " value: " + v));
    }

    private static void setEx(Box b1, Box b2, Box b3, Box b4) {
        TreeSet<Box> boxes = new TreeSet<>();
        boxes.add(b1);
        boxes.add(b2);
        boxes.add(b3);
        boxes.add(b4);
        System.out.println(boxes);


        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("January");
        set.add("February");
        set.add("March");
//        set.add("March");
        System.out.println(set);
    }

    private static void listEx() {
        String[] arr = {
                "January",
                "February",
                "March"
        };
        System.out.println(arr);

        LinkedList<String> list = new LinkedList<>();
        list.add("January");
        list.add("Февраль");
        list.add("March");
        list.sort((s1, s2) -> s1.length() - s2.length());
        System.out.println(list);

        for (String s : list) {
            System.out.println(s);
        }

        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

//        System.out.println(arr);
    }

    static class Box implements Comparable<Box> {
        int width;
        int height;
        int flag;

        public Box() {
        }

        public Box(int width, int height, int flag) {
            this.width = width;
            this.height = height;
            this.flag = flag;
        }

        public Box(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Box " + width + " " + height + " " + flag;

        }

        @Override
        public int compareTo(Box o) {
            return width + height - o.width - o.height;
        }

        @Override
        public int hashCode() {
//            return 1;
            return Objects.hash(width, height);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Box box = (Box) o;
            return width == box.width &&
                    height == box.height;
        }
    }
}

