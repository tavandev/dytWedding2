package me.wedding.dytwedding.domain;

import java.time.format.DateTimeFormatter;

public class CustomLocalDateTimeFormat {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
}
