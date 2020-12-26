package work.model;

public class Sedan {
    private int id;
    private String mark;
    private String model;
    private int weight;
    private int maxSpeed;

    public Sedan(){}

    public Sedan(String mark, String model, int weight, int maxSpeed){
        this.mark = mark;
        this.model = model;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
