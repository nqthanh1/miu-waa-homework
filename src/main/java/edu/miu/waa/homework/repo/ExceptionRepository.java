package edu.miu.waa.homework.repo;

import edu.miu.waa.homework.entity.Exception;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExceptionRepository extends JpaRepository<Exception, Long> {
}