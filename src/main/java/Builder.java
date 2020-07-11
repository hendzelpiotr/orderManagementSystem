import java.time.Instant;

public interface Builder {
    Builder withOrderId(int orderId);
    Builder withStartedAt(Instant startedAt);
    Builder withFinishedAt(Instant finishedAt);
    Builder withQuantity(int quantity);
    Builder withProductId(int product);
    Builder withCreatedBy(int userId);
    Builder withEmployee(Employee employee);
}
