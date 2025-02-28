package edu.miu.waa.homework.service.impl;

import edu.miu.waa.homework.entity.Logger;
import edu.miu.waa.homework.entity.Exception;
import edu.miu.waa.homework.repo.ExceptionRepository;
import edu.miu.waa.homework.repo.LoggerRepository;
import edu.miu.waa.homework.service.LoggerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LoggerServiceImpl implements LoggerService {

    private final LoggerRepository loggerRepository;
    private final ExceptionRepository exceptionRepository;
    private static final String PRINCIPLE = "staticUser";

    @Override
    public void log(String operation, long excutionTime) {
        Logger logger = new Logger(LocalDateTime.now(), PRINCIPLE, operation,excutionTime);
        loggerRepository.save(logger);
    }

    @Override
    public void logException(String operation, String exceptionType, String exceptionMessage) {
        Exception exception = new Exception(LocalDateTime.now(), PRINCIPLE, operation, exceptionType, exceptionMessage);
        exceptionRepository.save(exception);
    }
}