package com.example.jpa.controller;

import com.example.jpa.repository.CodeRepositoryRepository;
import com.example.jpa.repository.DataRepository;
import com.example.jpa.repository.LanguageRepository;
import com.example.jpa.repository.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private MetricRepository metricRepository;

    @Autowired
    private CodeRepositoryRepository codeRepositoryRepository;

    @Autowired
    private LanguageRepository languageRepository;

//    @GetMapping("/posts/{postId}/comments")
//    public Page<Comment> getAllCommentsByPostId(@PathVariable (value = "postId") Long postId,
//                                                Pageable pageable) {
//        return commentRepository.findByPostId(postId, pageable);
//    }
//
//    @PostMapping("/posts/{postId}/comments")
//    public Comment createComment(@PathVariable (value = "postId") Long postId,
//                                 @Valid @RequestBody Comment comment) {
//        return postRepository.findById(postId).map(post -> {
//            comment.setPost(post);
//            return commentRepository.save(comment);
//        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
//    }
//
//    @PutMapping("/posts/{postId}/comments/{commentId}")
//    public Comment updateComment(@PathVariable (value = "postId") Long postId,
//                                 @PathVariable (value = "commentId") Long commentId,
//                                 @Valid @RequestBody Comment commentRequest) {
//        if(!postRepository.existsById(postId)) {
//            throw new ResourceNotFoundException("PostId " + postId + " not found");
//        }
//
//        return commentRepository.findById(commentId).map(comment -> {
//            comment.setText(commentRequest.getText());
//            return commentRepository.save(comment);
//        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + "not found"));
//    }

//    @DeleteMapping("/posts/{postId}/comments/{commentId}")
//    public ResponseEntity<?> deleteComment(@PathVariable (value = "postId") Long postId,
//                              @PathVariable (value = "commentId") Long commentId) {
//        return commentRepository.findByIdAndPostId(commentId, postId).map(comment -> {
//            commentRepository.delete(comment);
//            return ResponseEntity.ok().build();
//        }).orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + commentId + " and postId " + postId));
//    }
}
