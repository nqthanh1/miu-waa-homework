package edu.miu.waa.homework.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Exception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private LocalDateTime dateTime;

    private String principle;

    private String operation;

    private String exceptionType;

    private String exceptionMessage;

    public Exception() {
    }

    public Exception(LocalDateTime dateTime, String principle, String operation, String exceptionType, String exceptionMessage) {
        this.dateTime = dateTime;
        this.principle = principle;
        this.operation = operation;
        this.exceptionType = exceptionType;
        this.exceptionMessage = exceptionMessage;
    }
}
