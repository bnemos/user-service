package io.getarrays.userservice.api;

import io.getarrays.userservice.models.entity.Roles;
import io.getarrays.userservice.models.entity.Users;
import io.getarrays.userservice.models.model.RoleToUserForm;
import io.getarrays.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserResource {
    private final UserService userService;

    @GetMapping("/get-users")
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping("/user/save")
    public ResponseEntity<?> saveUser(@RequestBody Users users){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(users));
    }
    @PostMapping("/role/save")
    public ResponseEntity<?> saveRole(@RequestBody Roles roles){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(roles));
    }
    @PostMapping("/role/assign-to-user")
    public ResponseEntity<?> assignRole(@RequestBody RoleToUserForm form){
        userService.addRoleToUser(form.getUserName(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}
