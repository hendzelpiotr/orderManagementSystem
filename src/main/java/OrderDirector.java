import java.time.Clock;
import java.time.Instant;
import java.util.Random;

class OrderDirector {

    public void constructNewOrder(Builder builder) {
        final int randomPositiveInt = new Random().nextInt() & Integer.MAX_VALUE;
        builder.withOrderId(randomPositiveInt)
                .withStartedAt(Instant.now(Clock.systemUTC()))
                .withCreatedBy(LoggedInUserResolver.getCurrentLoggedInUserId());
    }

}
