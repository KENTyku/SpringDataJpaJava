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
public class LoggingDelete {
    @Autowired
    private ReportRepository reportRepository;
    private Object entity;

    @Pointcut(
            "(" +
                    "execution(* com.ardecs.SpringDataJpaJava.Repository.ClientRepository.delete(Object))||" +
                    "execution(* com.ardecs.SpringDataJpaJava.Repository.OrderRepository.delete(Object))||" +
                    "execution(* com.ardecs.SpringDataJpaJava.Repository.CategoryRepository.delete(Object))||" +
                    "execution(* com.ardecs.SpringDataJpaJava.Repository.CountryRepository.delete(Object))||" +
                    "execution(* com.ardecs.SpringDataJpaJava.Repository.OrderPositionRepository.delete(Object))||" +
                    "execution(* com.ardecs.SpringDataJpaJava.Repository.ProductRepository.delete(Object))" +
                    ")" +
                    "&&args(entity)"
    )
    public void saveToReport(Object entity) {
    }

    @AfterReturning("saveToReport(entity)")
    public void logEntity(Object entity) {
        Object unknowEntity = entity;
        Class classEntity = unknowEntity.getClass();
        String nameClass = classEntity.getName();
        Report report = new Report(nameClass, "delete", LocalDateTime.now());
        reportRepository.save(report);
    }

}
