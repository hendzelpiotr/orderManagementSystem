class NewState extends State {

    public NewState(Order order) {
        super(order);
    }

    @Override
    public void assignUser(Employee employeeToBeAssigned) {
        order.changeState(new InProgressState(order));
        order.assignEmployee(employeeToBeAssigned);
    }

    @Override
    public void reject() {
        order.changeState(new RejectedState(order));
    }

    @Override
    public String getName() {
        return "NEW";
    }
}
