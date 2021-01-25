package softing.UBaH4ukDev.Lesson6;

public class Bowl {

    private int food;   //Количество еды в миске

    //Метод наполнения миски едой в количестве amount
    public void putFood(int amount) {
        this.food += amount;
        System.out.println("В миску " + ((food == 0) ? "положили ":"добавили ")  + amount + " еды. Сейчас в ней " + food + " еды");
    }

    //Метод уменьшения еды в миске на количество amount
    public boolean decreaseFood(int amount) {
        if (this.food == 0) {
            System.out.print(" В миске отсутствует еда. Пополните миску!!! ");
            return false;
        } else if (this.food - amount < 0){
            System.out.print(" В миске нет столько еды. Максимум, что можно покушать, это " + food + " еды. ");
            return false;
        }
        this.food -= amount;
        System.out.print(" С миски съедено " + amount + " еды. Осталось " + food + " еды. ");
        return true;
    }


    public String getFood() {
        return  "В миске " + food + " еды";
    }

}
