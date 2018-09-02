package com.morethanheroic.uppercase.domain.model;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeObject {
    private final String time;

    public TimeObject() {
        time = LocalDateTime.now(ZoneId.of("Europe/Paris")).toString();
    }

    public String getTime() {
        return time;
    }
}
