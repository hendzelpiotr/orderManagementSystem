abstract class State {

    private final static String IGNORE_MESSAGE = "That option is not available in the current state.";

    public State(Order order) {
        this.order = order;
    }

    protected Order order;

    public void assignUser(Employee employeeToBeAssigned) {
        System.out.println(IGNORE_MESSAGE);
    }

    public void reject() {
        System.out.println(IGNORE_MESSAGE);
    }

    public void finish() {
        System.out.println(IGNORE_MESSAGE);
    }

    public abstract String getName();
}
