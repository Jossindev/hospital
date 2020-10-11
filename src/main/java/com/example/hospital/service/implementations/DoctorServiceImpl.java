package com.example.hospital.service.implementations;

import com.example.hospital.entity.Doctor;
import com.example.hospital.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DoctorServiceImpl {
    private final DoctorRepository doctorRepository;

    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }
}
