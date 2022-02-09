package br.com.macvinny.goanddo.service;

import br.com.macvinny.goanddo.data.UserData;
import br.com.macvinny.goanddo.exception.NotFoundException;
import br.com.macvinny.goanddo.model.User;
import br.com.macvinny.goanddo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(
                        ()-> new NotFoundException("User by id " + id + " was not found.")
                );
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public List<User> findActiveUsers() {
        return userRepository.findByActiveTrue();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(username));

        if(user.isEmpty()) {
            throw new UsernameNotFoundException("User by email " + username + " was not found.");
        }

        return new UserData(user);
    }
}
