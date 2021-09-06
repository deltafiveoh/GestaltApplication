package com.gestaltscheduling.GestaltApplication.models.data;

import com.gestaltscheduling.GestaltApplication.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateRepository extends CrudRepository<Employee, Integer> {

}