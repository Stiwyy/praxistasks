package ch.bbw.tasks;

import ch.bbw.tasks.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User mit ID " + id + " nicht gefunden"));
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    @PostMapping("/signIn")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<User> signIn(@RequestBody User authenticationUser) {
        Optional<User> userOptional = userRepository.findByUsername(authenticationUser.getUsername());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(authenticationUser.getPassword())) {
                String token = UUID.randomUUID().toString();
                user.setToken(token);
                userRepository.save(user);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .header("Authorization", "Bearer " + token)
                        .body(user);
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
