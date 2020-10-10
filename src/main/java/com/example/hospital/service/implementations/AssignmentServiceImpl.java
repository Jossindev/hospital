package com.example.hospital.service.implementations;

import com.example.hospital.entity.Assignment;
import com.example.hospital.repository.AssignmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AssignmentServiceImpl {
    private final AssignmentRepository assignmentRepository;


    public Optional<Assignment> findById(Long id) {
        return assignmentRepository.findById(id);
    }

    public Iterable<Assignment> findAll() {
        return assignmentRepository.findAll();
    }
}
