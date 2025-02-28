package edu.miu.waa.homework.aspect;
import edu.miu.waa.homework.service.LoggerService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAspect {

    private final LoggerService loggerService;

    @Before("execution(* edu.miu.waa.homework.service.*.*(..)) && !execution(* edu.miu.waa.homework.service.LoggerService.*(..))")
    public void logOperation(JoinPoint joinPoint) {
        String operation = joinPoint.getSignature().toShortString();
        loggerService.log(operation,0);
    }

    @AfterThrowing(pointcut = "execution(* edu.miu.waa.homework.controller.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        String operation = joinPoint.getSignature().toShortString();
        String exceptionType = ex.getClass().getName();
        String exceptionMessage = ex.getMessage();
        loggerService.logException(operation, exceptionType, exceptionMessage);
    }
}