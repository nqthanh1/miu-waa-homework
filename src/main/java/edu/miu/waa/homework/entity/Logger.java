package edu.miu.waa.homework.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Logger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private LocalDateTime dateTime;

    private String principle;

    private String operation;

    private long executionTime = 0; // in milliseconds

    public Logger() {
    }

    public Logger(LocalDateTime dateTime, String principle, String operation, long executionTime) {
        this.dateTime = dateTime;
        this.principle = principle;
        this.operation = operation;
        this.executionTime = executionTime;
    }
}