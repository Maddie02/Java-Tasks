package task;

public class PaymentInfo {
    private double cost;
    private String location;
    private String reason;

    public PaymentInfo(double cost, String location, String reason) {
        this.cost = cost;
        this.location = location;
        this.reason = reason;
    }

    public double getCost() {
        return cost;
    }

    public String getLocation() {
        return location;
    }

    public String getReason() {
        return reason;
    }
}
