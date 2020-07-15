class AssignOrderCommand extends Command {

    private final int orderId;
    private final String employeeFirstName;
    private final String employeeLastName;

    public AssignOrderCommand(OrderStorage storage,
                              int orderId,
                              String employeeFirstName,
                              String employeeLastName) {
        super(storage);
        this.orderId = orderId;
        this.employeeFirstName = employeeFirstName.trim();
        this.employeeLastName = employeeLastName.trim();
    }

    @Override
    public void execute() {
        final Order order = storage.getOrder(orderId);

        if (order == null) {
            System.out.println("Order not found.");
            return;
        }

        final Employee employee = EmployeeFactory.getEmployee(employeeFirstName, employeeLastName);
        order.getState().assignUser(employee);
    }
}
