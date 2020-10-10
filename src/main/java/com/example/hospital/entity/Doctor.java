package com.example.hospital.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long doctorId;

    @Enumerated(EnumType.STRING)
    private DoctorType DoctorType;

    @OneToMany(mappedBy = "doctor")
    private Set<Patient> patients;

    @OneToMany(mappedBy = "executor")
    private List<Assignment> assignments;

    @OneToOne
    @JoinColumn(name = "user")
    private User user;
}
