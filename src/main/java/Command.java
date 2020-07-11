public abstract class Command {

    protected OrderStorage storage;

    public Command(OrderStorage storage) {
        this.storage = storage;
    }

    abstract void execute();

}
