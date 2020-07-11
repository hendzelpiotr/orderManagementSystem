import java.time.Instant;

class InProgressState extends State {

    public InProgressState(Order order) {
        super(order);
    }

    @Override
    public void reject() {
        order.changeState(new RejectedState(order));
    }

    @Override
    public void finish() {
        order.changeState(new FinishedState(order));
        order.setFinishedAt(Instant.now());
    }

    @Override
    public String getName() {
        return "IN PROGRESS";
    }
}
