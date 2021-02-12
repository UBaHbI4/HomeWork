package softing.UBaH4ukDev.Lesson11.ClassWork;

import java.util.List;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson11.ClassWork

 Created by Ivan Sheynmaer

 2021.02.12
 v1.0
 */
public class ListBox<T extends Number> {
    List<T> list;

    public double avg() {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum / list.size();
    }

    public boolean compare(ListBox<?> other) {
        return Math.abs(avg() - other.avg()) < 0.0001;
    }

//    public void addCollection(List<? extends Integer> list1) {
//        list.addAll(list1);
//    }

    public ListBox(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}