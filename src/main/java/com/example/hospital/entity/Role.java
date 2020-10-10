package com.example.hospital.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "roleId")
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long roleId;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(Long roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}