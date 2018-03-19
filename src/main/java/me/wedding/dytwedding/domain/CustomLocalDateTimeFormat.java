package me.wedding.dytwedding.domain;

import java.time.format.DateTimeFormatter;

public class CustomLocalDateTimeFormat {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
}
