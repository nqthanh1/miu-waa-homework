package edu.miu.waa.homework.aspect;

import edu.miu.waa.homework.service.LoggerService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {
    private final LoggerService loggerService;

    @Around("@annotation(edu.miu.waa.homework.aspect.annotation.ExecutionTime)")
    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        String operation = joinPoint.getSignature().toShortString();
        loggerService.log(operation, executionTime);
        return proceed;
    }
}
