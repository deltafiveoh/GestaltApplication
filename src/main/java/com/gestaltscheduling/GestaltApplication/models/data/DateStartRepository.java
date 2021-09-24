package com.gestaltscheduling.GestaltApplication.models.data;

import com.gestaltscheduling.GestaltApplication.models.DateStart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateStartRepository extends CrudRepository<DateStart, Integer> {

}
