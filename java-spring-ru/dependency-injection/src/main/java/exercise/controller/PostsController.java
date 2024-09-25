package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping()
    public List<Post> index() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post show(@PathVariable Long id) {
        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post data) {
        postRepository.save(data);
        return data;
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable Long id, @RequestBody Post data) {
        var post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        post.setTitle(data.getTitle());
        post.setBody(data.getBody());
        return data;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        var post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("not found id:" + id));
        var comments = commentRepository.deleteByPostId(post.getId());
        postRepository.delete(post);
    }
}
// END
