package com.marondal.spring.ex.jpa.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
