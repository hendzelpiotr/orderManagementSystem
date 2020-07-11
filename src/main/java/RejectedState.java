class RejectedState extends State {
    public RejectedState(Order order) {
        super(order);
    }

    @Override
    public String getName() {
        return "REJECTED";
    }
}
