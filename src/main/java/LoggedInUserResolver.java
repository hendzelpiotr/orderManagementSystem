import java.util.Random;
import java.util.UUID;

class LoggedInUserResolver {

    private static LoggedInUserResolver instance;

    private final int mockedUserId = new Random().nextInt() & Integer.MAX_VALUE;

    private LoggedInUserResolver() {
    }

    public static synchronized LoggedInUserResolver getInstance() {
        if (instance == null) {
            return new LoggedInUserResolver();
        }
        return instance;
    }

    public int getCurrentLoggedInUserId() {
        return mockedUserId;
    }

}
