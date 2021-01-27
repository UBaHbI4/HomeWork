package softing.UBaH4ukDev.Lesson7;

//Класс препятствий
public class Obstruction {
    private int limit;          //Лимит длины дорожки либо высоты стены
    private String model;       //Тип модели дорожки или стены

    public Obstruction(String model, int limit) {
        this.model = model;
        this.limit = limit;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getLimit() {
        return limit;
    }
}
