import java.util.Random;

class LoggedInUserResolver {

    private static final int mockedUserId = new Random().nextInt() & Integer.MAX_VALUE;

    public static int getCurrentLoggedInUserId() {
        return mockedUserId;
    }

}
