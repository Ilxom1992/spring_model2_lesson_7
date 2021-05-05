package com.example.appnewsite.component;

import com.example.appnewsite.entity.Position;
import com.example.appnewsite.entity.User;
import com.example.appnewsite.entity.enums.Huquq;
import com.example.appnewsite.repository.PositionRepository;
import com.example.appnewsite.repository.UserRepository;
import com.example.appnewsite.utils.AppConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.example.appnewsite.entity.enums.Huquq.*;

@Component
public class DataLoader implements CommandLineRunner {
    final UserRepository userRepository;
    final PositionRepository positionRepository;
    final PasswordEncoder passwordEncoder;

    public DataLoader(UserRepository userRepository, PositionRepository positionRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.positionRepository = positionRepository;
        this.passwordEncoder = passwordEncoder;
    }
@Value("${spring.datasource.initialization-mode}")
private String initialMode;
    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")){
            Huquq[] huquqs=Huquq.values();
            Position admin = positionRepository.save(new Position(
                    AppConstants.ADMIN,
                    Arrays.asList(huquqs),
                    "Sistema egasi"
            ));
            Position user = positionRepository.save(new Position(
                    AppConstants.USER,
                    Arrays.asList(ADD_COMMIT, EDIT_COMMIT, DELETE_MY_COMMIT),
                    "Oddiy foydalanuvchi"
            ));
            userRepository.save(new User(
                    "Admin",
                    "admin",
                    passwordEncoder.encode("admin123"),
                    admin,
                    true
            ));
            userRepository.save(new User(
                    "User",
                    "user",
                    passwordEncoder.encode("user123"),
                    user,
                    true
            ));
        }
    }
}
