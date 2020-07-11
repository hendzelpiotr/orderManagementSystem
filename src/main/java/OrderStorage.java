import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class OrderStorage {

    private static OrderStorage instance;

    private final HashMap<Integer, Order> orders = new HashMap<>();

    private OrderStorage() {
    }

    public static synchronized OrderStorage getInstance() {
        if (instance == null) {
            instance = new OrderStorage();
        }
        return instance;
    }

    public Order getOrder(int orderId) {
        return orders.get(orderId);
    }

    public List<Order> getAll() {
        return orders.values()
                .stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public Order saveOrUpdate(Order order) {
        orders.put(order.getOrderId(), order);
        System.out.println("Saving order " + order.getOrderId());
        return order;
    }
}
