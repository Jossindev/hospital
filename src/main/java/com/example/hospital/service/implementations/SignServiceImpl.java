package com.example.hospital.service.implementations;

import com.example.hospital.entity.Role;
import com.example.hospital.entity.User;
import com.example.hospital.repository.RoleRepository;
import com.example.hospital.repository.UserRepository;
import com.example.hospital.service.SignService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class SignServiceImpl implements SignService {
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    //    public void signUp(UserDto userDto) {
//        User user = userDto.toUser();
//        user.setRoles(Collections.singleton(new Role()));
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//    }

    @Override
    public void signUp(String name, String surname, LocalDate birthday, String email, String password, String role) {
        User user = new User();
        Role currentRole = roleRepository.findRoleByName(role);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(currentRole);

        user.setName(name);
        user.setSurname(surname);
        user.setBirthday(birthday);
        user.setEmail(email);
        user.setRoles(roleSet);
        user.setPassword(passwordEncoder.encode(password));

        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
