class FinishedState extends State {
    public FinishedState(Order order) {
        super(order);
    }

    @Override
    public String getName() {
        return "FINISHED";
    }
}
