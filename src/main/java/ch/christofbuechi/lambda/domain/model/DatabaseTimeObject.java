package ch.christofbuechi.lambda.domain.model;

public class DatabaseTimeObject {
    private String currentTime;
    private TimeSource timeSource;

    public DatabaseTimeObject(String currentTime, TimeSource timeSource) {
        this.currentTime = currentTime;
        this.timeSource = timeSource;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public TimeSource getTimeSource() {
        return timeSource;
    }

    public void setTimeSource(TimeSource timeSource) {
        this.timeSource = timeSource;
    }

}
