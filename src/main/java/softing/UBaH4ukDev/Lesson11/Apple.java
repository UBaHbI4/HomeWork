package softing.UBaH4ukDev.Lesson11;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson11

 Created by Ivan Sheynmaer

 2021.02.12
 v1.0
 */
public class Apple extends Fruit {
    private static final float defWeight = 1.0f;

    public Apple() {
        super(defWeight);
    }

    @Override
    public String toString() {
        return "Яблоко(" + defWeight + "кг.)";
    }

}
