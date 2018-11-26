/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package com.ardecs.SpringDataJpaJava.Repository;

import com.ardecs.SpringDataJpaJava.Entity.Report;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Yuri Tveritin, e-mail: kentyku@bk.ru
 */

public interface ReportRepository extends CrudRepository<Report, Long> {


}
