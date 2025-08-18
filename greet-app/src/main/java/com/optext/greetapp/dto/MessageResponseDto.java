package com.optext.greetapp.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record MessageResponseDto(String message, LocalDate date, LocalTime time) {

}
