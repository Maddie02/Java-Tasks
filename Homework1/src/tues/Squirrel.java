package tues;

public class Squirrel {
    private String name;
    private String sort;
    private int age;
    private int foodTakenCounter = 0;
    private Burrow burrow = new Burrow();

    public Squirrel(String name, String sort, int age) {
        this.name = name;
        this.sort = sort;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSort() {
        return sort;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Burrow getBurrow() {
        return burrow;
    }

    public void printSquirrel() {
        System.out.println("<" + getSort() + "> " + getName() + "(" + getAge() + ") - " + getBurrow().getTotalFoodScore());
    }

    public void addFood(Food food) throws Exception {
        if (foodTakenCounter == 4) {
            throw new Exception("Cannot add more food this year!");
        } else {
            getBurrow().getFood().add(food);
            foodTakenCounter ++;
        }
    }

    public void passWinter() {
        foodTakenCounter = 0;
        for (int i = 0; i < getBurrow().getFood().size(); i ++) {
            getBurrow().getFood().get(i).passWinter();
        }
        setAge(getAge() + 1);
    }
}