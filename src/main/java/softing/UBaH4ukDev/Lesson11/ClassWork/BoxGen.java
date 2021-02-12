package softing.UBaH4ukDev.Lesson11.ClassWork;

import java.io.Serializable;
import java.util.Collections;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson11.ClassWork

 Created by Ivan Sheynmaer

 2021.02.12
 v1.0
 */
public class BoxGen<T extends Number & Serializable & Comparable> {
    //    static T t;
//    static T staticField = 20;
    // T(ype), N(umber), K(ey), V(alue), E(lement)
    T obj;



    public BoxGen(T obj) {

        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }


}

