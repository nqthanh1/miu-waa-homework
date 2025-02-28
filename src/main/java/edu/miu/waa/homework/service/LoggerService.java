package edu.miu.waa.homework.service;

public interface LoggerService {
    void log(String operation, long exceutionTime);
    void logException(String operation, String exceptionType, String exceptionMessage);
}
