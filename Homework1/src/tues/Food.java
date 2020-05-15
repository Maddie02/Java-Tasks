package tues;

public abstract class Food {
    private double quantity;
    private double quality;
    private int age;

    public Food(double quantity, double quality) {
        this.quantity = quantity;
        this.quality = quality;
        this.age = 0;
    }

    public double getQuality() {
        return quality;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getFoodScore() {
        return getQuality() * getQuantity();
    }

    public abstract void passWinter();
}
