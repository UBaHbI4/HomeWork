package softing.UBaH4ukDev.Lesson7;

public class MyArraySizeException  extends RuntimeException{
    public MyArraySizeException(String message) {
        super("Возникло исключение MyArraySizeException. " + message + ", а должно быть 4.");
    }
}
