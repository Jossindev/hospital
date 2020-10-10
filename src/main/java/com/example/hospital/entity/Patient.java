package com.example.hospital.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patientId;

    private boolean onTreatment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor")
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name = "user")
    private User user;
}
