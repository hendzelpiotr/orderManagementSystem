public abstract class Command {

    protected OrderStorage storage;

    public Command(OrderStorage storage) {
        this.storage = storage;
    }

    public abstract void execute();

}
