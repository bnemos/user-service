package io.getarrays.userservice;

import io.getarrays.userservice.models.entity.Roles;
import io.getarrays.userservice.models.entity.Users;
import io.getarrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
            userService.saveRole(new Roles(null, "ROLE_ADMIN"));
            userService.saveRole(new Roles(null, "ROLE_USER"));
            userService.saveRole(new Roles(null, "ROLE_SUPER_ADMIN"));
            userService.saveRole(new Roles(null, "ROLE_MANAGER"));

            userService.saveUser(new Users(null, "John", "jonny", "1234", new ArrayList<>()));
            userService.saveUser(new Users(null, "Mike", "mikee", "1234", new ArrayList<>()));
            userService.saveUser(new Users(null, "Leo", "leos", "1234", new ArrayList<>()));
            userService.saveUser(new Users(null, "Thor", "odinson", "1234", new ArrayList<>()));

            userService.addRoleToUser("jonny", "ROLE_ADMIN");
            userService.addRoleToUser("mikee", "ROLE_USER");
            userService.addRoleToUser("leos", "ROLE_MANAGER");
            userService.addRoleToUser("odinson", "ROLE_SUPER_ADMIN");
        };
    }

}
