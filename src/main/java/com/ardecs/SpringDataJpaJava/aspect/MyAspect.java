package com.ardecs.SpringDataJpaJava.aspect;


import com.ardecs.SpringDataJpaJava.Entity.Report;
import com.ardecs.SpringDataJpaJava.Repository.ReportRepository;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.time.LocalDateTime;

@EnableAspectJAutoProxy
@Aspect
public class MyAspect {
    @Autowired
    private ReportRepository reportRepository;
    private Object entity;
    @Pointcut("execution(* org.springframework.data.repository.CrudRepository.save(Object))&&args(entity)&& within(com.ardecs.SpringDataJpaJava.Repository.*)")
    public void saveToReport(Object entity) {
    }

    @AfterReturning("saveToReport(entity)")
    public void logEntity(Object entity) {
        Object unknowEntity=entity;
        Class classEntity=unknowEntity.getClass();
        String nameClass=classEntity.getName();
        Report report=new Report(nameClass,"save",LocalDateTime.now());
        reportRepository.save(report);
    }
}
