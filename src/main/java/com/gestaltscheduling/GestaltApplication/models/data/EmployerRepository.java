package com.gestaltscheduling.GestaltApplication.models.data;

import com.gestaltscheduling.GestaltApplication.models.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends CrudRepository<Employer, Integer> {

}
