package edu.miu.waa.homework.security.util;

import edu.miu.waa.homework.security.entity.Role;
import edu.miu.waa.homework.security.entity.User;
import edu.miu.waa.homework.repo.UserRepository;
import edu.miu.waa.homework.security.repo.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Configuration
public class DatabaseInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        if (userRepository.findByUsername("admin") == null) {
            Role adminRole = roleRepository.findByRole("ROLE_ADMIN")
                    .orElseGet(() -> roleRepository.save(new Role("ADMIN")));

            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("Admin@123"));
            admin.setRoles(Collections.singletonList(adminRole));

            userRepository.save(admin);
        }
        if (userRepository.findByUsername("user") == null) {
            Role clientRole = roleRepository.findByRole("CLIENT")
                    .orElseGet(() -> roleRepository.save(new Role("CLIENT")));
            User user = new User();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("User@123"));
            user.setRoles(Collections.singletonList(clientRole));

            userRepository.save(user);
        }
    }
}