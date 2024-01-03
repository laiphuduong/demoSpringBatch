package com.example.demospringbatch.source.repository;


import com.example.demospringbatch.source.entity.Student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSourceRepository extends JpaRepository<Student,Long>, PagingAndSortingRepository<Student, Long> {
    @Query("select s from Student s where s.id = :id")
    Page<Student> getAllData(Long id, Pageable pageable);
}
