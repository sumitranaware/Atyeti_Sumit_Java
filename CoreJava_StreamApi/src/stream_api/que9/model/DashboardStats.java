package stream_api.que9.model;

public class DashboardStats {
    private Long count;
    private double averagePrice;

    public DashboardStats(Long count, double averagePrice) {
        this.count = count;
        this.averagePrice = averagePrice;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    @Override
    public String toString() {
        return "DashboardStats{" +
                "count=" + count +
                ", averagePrice=" + averagePrice +
                '}';
    }
}
