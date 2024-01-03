package com.example.demospringbatch.batch.writer;

import com.example.demospringbatch.target.entity.Student;
import com.example.demospringbatch.target.repository.StudentTargetRepository;

import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentWriter {
    @Autowired
    StudentTargetRepository studentTargetRepository;
    public RepositoryItemWriter<Student> writeData() {
        var result = new RepositoryItemWriterBuilder<Student>();
        result.repository(studentTargetRepository);
        result.methodName("save");
        return result.build();
    }
}
