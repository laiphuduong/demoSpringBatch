package com.example.demospringbatch.batch.processor;

import com.example.demospringbatch.source.entity.Student;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class StudentProcessor implements ItemProcessor<Student, com.example.demospringbatch.target.entity.Student> {
    @Override
    public com.example.demospringbatch.target.entity.Student process(Student item) throws Exception {
        var result = com.example.demospringbatch.target.entity.Student.builder().id(item.getId()).name(item.getName()).build();
        return result;
    }
}
