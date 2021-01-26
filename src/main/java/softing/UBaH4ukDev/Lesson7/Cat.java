package softing.UBaH4ukDev.Lesson7;

public class Cat  implements Actionable  {
    private String name;
    private int limitJump;
    private int limitRun;

    public Cat(String name, int limitJump, int limitRun) {
        this.name = name;
        this.limitJump =  limitJump;
        this.limitRun = limitRun;
    }

    @Override
    public boolean run(RunningTrack runningTrack) {
        if(limitRun < runningTrack.getLimit()) {
            System.out.println("Кот " + name + " не смог пробежать на беговой дорожке [" + runningTrack.getModel() + "] расстояние " + runningTrack.getLimit() + " м. (Его лимит: "+limitRun+" м.)");
            System.out.println("Кот " + name + " эстафету окончил не полностью.");
            return false;
        } else {
            System.out.println("Кот " + name + " успешно пробежал на беговой дорожке [" + runningTrack.getModel() + "] расстояние " + runningTrack.getLimit() + " м. (Его лимит: "+limitRun+" м.)");
            return true;
        }
    }

    @Override
    public boolean jump(Wall wall) {
        if(limitJump < wall.getLimit()) {
            System.out.println("Кот " + name + " не перепрыгнул через стену [" + wall.getModel() + "] высотой " + wall.getLimit() + " м. (Его лимит: "+limitJump+" м.)");
            System.out.println("Кот " + name + " эстафету окончил не полностью.");
            return false;
        } else {
            System.out.println("Кот " + name + " успешно перепрыгнул через стену [" + wall.getModel() + "] высотой " + wall.getLimit() + " м. (Его лимит: "+limitJump+" м.)");
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLimitJump() {
        return limitJump;
    }

    public void setLimitJump(int limitJump) {
        this.limitJump = limitJump;
    }

    public int getLimitRun() {
        return limitRun;
    }

    public void setLimitRun(int limitRun) {
        this.limitRun = limitRun;
    }
}
