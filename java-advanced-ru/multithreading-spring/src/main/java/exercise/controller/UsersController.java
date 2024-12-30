package exercise.controller;

import exercise.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import exercise.service.UserService;


@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "")
    public Flux<User> getUsers() {
        return userService.findAll();
    }

    // BEGIN
    @GetMapping(path = "/{id}")
    public Mono<User> show(@PathVariable Long id) {
        return userService.show(id);
    }

    @PostMapping(path = "")
    public Mono<User> create(@RequestBody User data) {
        return userService.create(data);
    }

    @PatchMapping(path = "/{id}")
    public Mono<User> update(@RequestBody User data, @PathVariable Long id) {
        return userService.update(data, id);
    }

    @DeleteMapping(path = "/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return userService.delete(id);
    }
    // END
}
