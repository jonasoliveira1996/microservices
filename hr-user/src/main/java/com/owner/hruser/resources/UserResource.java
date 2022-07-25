package com.owner.hruser.resources;

import com.owner.hruser.entities.User;
import com.owner.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userRepository.findById(id).get();

        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/search")
    public ResponseEntity<User> findById(@RequestParam String email) {
        User user = userRepository.findByEmail(email);

        return ResponseEntity.ok().body(user);
    }
}
