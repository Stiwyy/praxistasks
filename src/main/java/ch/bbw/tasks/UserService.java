package ch.bbw.tasks;

import ch.bbw.tasks.model.Task;
import ch.bbw.tasks.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        for (Task task : user.getTasks()) {
            task.setUser(user);
        }
        return userRepository.save(user);
    }
}
