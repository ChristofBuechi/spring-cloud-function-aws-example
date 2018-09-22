package ch.christofbuechi.lambda.domain.model;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class JvmTimeObject {
    private final String currentTime;

    private TimeSource timeSource;


    public JvmTimeObject() {
        currentTime = LocalDateTime.now(ZoneId.of("Europe/Paris")).toString();
        timeSource = TimeSource.JVM;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public TimeSource getTimeSource() {
        return timeSource;
    }
}
