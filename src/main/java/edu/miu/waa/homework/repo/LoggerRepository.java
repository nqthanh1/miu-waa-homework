package edu.miu.waa.homework.repo;

import edu.miu.waa.homework.entity.Logger;
import org.springframework.data.repository.CrudRepository;

public interface LoggerRepository extends CrudRepository<Logger,Long> {
}
