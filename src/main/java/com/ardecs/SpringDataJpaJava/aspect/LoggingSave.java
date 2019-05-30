package com.ardecs.SpringDataJpaJava.aspect;


import com.ardecs.SpringDataJpaJava.Entity.Report;
import com.ardecs.SpringDataJpaJava.Repository.ReportRepository;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Aspect
@Component
public class LoggingSave {
    @Autowired
    private ReportRepository reportRepository;
    private Object entity;

    @AfterReturning(
            "execution(* com.ardecs.SpringDataJpaJava.Repository..*.save(Object))" +
                    "&&!execution(* com.ardecs.SpringDataJpaJava.Repository.ReportRepository.save(Object))" +
                    "&&args(entity)"
    )
    public void logEntity(Object entity) {
        String nameClass = entity.getClass().getName();
        Report report = new Report(nameClass, "save", LocalDateTime.now());
        reportRepository.save(report);
    }


}
