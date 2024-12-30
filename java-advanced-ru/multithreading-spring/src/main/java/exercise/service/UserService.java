package exercise.service;

import exercise.model.User;
import exercise.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    // BEGIN
    public Mono<User> show(Long index) {
        return userRepository.findById(index);
    }

    public Mono<User> create(User user) {
        return userRepository.save(user);
    }

    public Mono<User> update(User data, Long id) {
        data.setId(id);
        //updateUser(data);
        return userRepository.save(data);
    }

    public Mono<Void> delete(Long index) {
        return userRepository.deleteById(index);
    }
    // END
}


