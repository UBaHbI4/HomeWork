package softing.UBaH4ukDev.Lesson11;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson11

 Created by Ivan Sheynmaer

 2021.02.12
 v1.0
 */
public class Orange extends Fruit {
    private static final float defWeight = 1.5f;

    public Orange() {
        super(defWeight);
    }

    @Override
    public String toString() {
        return "Апельсин(" + defWeight + "кг.)";
    }

}
