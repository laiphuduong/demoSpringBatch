package com.example.demospringbatch.target.repository;


import com.example.demospringbatch.target.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentTargetRepository extends JpaRepository<Student, Long> {
}
