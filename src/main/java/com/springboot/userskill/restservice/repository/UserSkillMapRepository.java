package com.springboot.userskill.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.userskill.restservice.model.UserSkillMap;


@Repository
public interface UserSkillMapRepository extends JpaRepository<UserSkillMap, String> {

}
