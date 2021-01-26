package softing.UBaH4ukDev.Lesson7;

public class MyArrayDataException  extends RuntimeException{
    public MyArrayDataException(String message) {
        super("Возникло исключение MyArrayDataException. В " + message + " неверные данные.");
    }
}

