package com.example.demospringbatch.batch.reader;

import java.util.Collections;

import com.example.demospringbatch.source.entity.Student;
import com.example.demospringbatch.source.repository.StudentSourceRepository;

import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class StudentReader {
    @Autowired
    StudentSourceRepository studentSourceRepository;
//    public RepositoryItemReader<Student> readAll() {
//        var result = new RepositoryItemReader<Student>();
//        result.setName("studentReader");
//        result.setRepository(studentSourceRepository);
//        result.setMethodName("findAll");
//        result.setPageSize(10);
//        result.setSort(Collections.singletonMap("id", Sort.Direction.ASC));
//        return result;
//    }

    public RepositoryItemReader<Student> readAll() {
        var result = new RepositoryItemReader<Student>();
        result.setName("studentReader");
        result.setRepository(studentSourceRepository);
        result.setMethodName("getAllData");
        result.setArguments(Collections.singletonList(3L));
        result.setPageSize(10);
        result.setSort(Collections.singletonMap("id", Sort.Direction.ASC));
        return result;
    }
}
