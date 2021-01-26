package softing.UBaH4ukDev.Lesson7;

/****
 Project HomeWork
 Package softing.UBaH4ukDev.Lesson7

 Created by Ivan Sheynmaer

 2021.01.26
 v1.0
 */
public class Classwork {
    private int localVariable;

    public static void main(String[] args) {


        //private
        //default
        //protected
        //public

        //Интерфейсы:
        // - общая информация
        // - методы и переменные
        // - имплементация и наследование
        // - дефолтные методы, статика
        // - функциональные интерфейсы
        // - приватные методы (9)


        //Перечисления:
        // - константы (public static)
        // - инициализация без new, наследование
        // - методы values и valueOf, ordinal
        // - конструкторы и методы

        //Внутренние(), вложенные(s) и локальные классы, вложенные интерфейсы

//        enumExample();

        //interfaceExample();
        Fish fish = new Fish();
        Fish.Heart fh = fish.new Heart();

        Swimming s = length -> System.out.println("Anonimous swimming");

        Swimming sw = new Swimming() {
            @Override
            public void swim(int length) {
                System.out.println("Anonimus 2");
            }
        };
        s.doSomething(10, 20);
        System.out.println(s.getClass());
        System.out.println(sw.getClass());

//        localExample();

    }

    private void localExample() {
        class Local {
            int a;
            float b;

            public Local(int a, float b) {
                this.a = a;
                this.b = b;
                localVariable = 10;

            }

            public int getA() {
                return a;
            }

            public void setA(int a) {
                this.a = a;
            }

            public float getB() {
                return b;
            }

            public void setB(float b) {
                this.b = b;
            }
        }

        Local local = new Local(1, 0.5f);
        System.out.println(local.getB());
    }

    private static void interfaceExample() {
        Swimming[] swimmings = {
                new Duck(),
                new Ship(),
                new Apple()
        };

        for (Swimming s : swimmings) {
            s.swim(100);
            s.doSomething(5, 25);
        }
        Swimming.doStatic();
    }

    private static void enumExample() {
        WeekDay day = WeekDay.THURSDAY;
        System.out.println(day.ordinal());
        System.out.println(day.getDayNumber());
        System.out.println(day);
        System.out.println(day.getDayNumber());
        System.out.println(day.getRussianName());
        System.out.println(WeekDay.valueOf("SATURDAY"));

        for (WeekDay wd : WeekDay.values()) {
            System.out.println(wd.getRussianName());
        }

        Operator op = Operator.SUM;
        System.out.println(op.operation(15, 21));
        op = Operator.MULTIPLY;
        System.out.println(op.operation(2, 20));

        System.out.println(day.ordinal());
        day = WeekDay.MONDAY;
        System.out.println(day.ordinal());
        day = WeekDay.THURSDAY;
        System.out.println(day);

        if (day == WeekDay.THURSDAY) {
            System.out.println("It's THURSDAY!!!");
        } else System.out.println("It's other day");

        switch (day) {
            case MONDAY:
                System.out.println("Monday");
                break;
            case SATURDAY:
                System.out.println("Sat");
                break;
            default:
                System.out.println("Nothing");
        }
    }
}