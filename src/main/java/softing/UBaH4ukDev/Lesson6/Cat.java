package softing.UBaH4ukDev.Lesson6;

public class Cat {
    private String name;                //Имя кота
    private int appetite;               //Аппетит кота
    private int health;                 //Жизни кота
    private int damage;                 //Урон кота при одном ударе
    private boolean isSatiety;          //Сытость

    public Cat(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.isSatiety = false;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isSatiety = false;
    }

    //Метод получения урона кота от другого (another) кота
    public void takeHit(Cat another) {
        this.health -= another.getDamage();
        if (this.health > 0) System.out.println(name + " получил от кота с именем " + another.getName() + ". У кота с именем " + name + " осталось " + health);
        if (this.health <= 0) {
            System.out.println(name + " проиграл в битве котов.");
            //throw new MyCustomException("HealthOutOfBoundsException");
        }
    }

    //Метод нанесения урона от кота другому коту (another)
    public void kick(Cat another) {
        System.out.println("Кот с именем " + this.name + " ударил кота с именем " + another.name);
        another.takeHit(this);
    }

    //Метод, который заставляет кушать кота с миски (bowl)
    public void eat(Bowl bowl) {
        System.out.print(this.name + " пришел покушать.");
        if (bowl.decreaseFood(appetite)){
            System.out.print(this.name + " съел " + appetite + " еды с миски\r\n");
            setSatiety(true); //Если кот поел, значит он сыт
        } else {
            System.out.print(this.name + " не поел.\r\n");
            setSatiety(false); //Если кот не поел, значит он голодный
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean getSatiety() {
        return isSatiety;
    }

    public void setSatiety(boolean isSatiety) {
        this.isSatiety = isSatiety;
    }

    public String getStatus(){
        return (name + ": " + (isSatiety ? "Сыт":"Голоден") + ". Аппетит: " + appetite);
    }
}
