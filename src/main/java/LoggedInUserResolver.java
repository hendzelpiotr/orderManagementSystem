import java.util.Random;

class LoggedInUserResolver {

    private static LoggedInUserResolver instance;

    private final int mockedUserId = new Random().nextInt() & Integer.MAX_VALUE;

    private LoggedInUserResolver() {
    }

    public static synchronized LoggedInUserResolver getInstance() {
        if (instance == null) {
            instance = new LoggedInUserResolver();
        }
        return instance;
    }

    public int getCurrentLoggedInUserId() {
        return mockedUserId;
    }

}
