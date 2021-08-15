package com.gestaltscheduling.GestaltApplication.models.data;

import com.gestaltscheduling.GestaltApplication.models.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {

}
