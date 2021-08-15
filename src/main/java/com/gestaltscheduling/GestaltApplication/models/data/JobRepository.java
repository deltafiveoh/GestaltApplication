package com.gestaltscheduling.GestaltApplication.models.data;

import com.gestaltscheduling.GestaltApplication.models.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface JobRepository extends CrudRepository<Job, Integer> {

}
