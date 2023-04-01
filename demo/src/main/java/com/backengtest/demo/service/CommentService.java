package com.backengtest.demo.service;

import com.backengtest.demo.dto.ProjectDto;
import com.backengtest.demo.repository.ProjectRepo;
import com.backengtest.demo.dto.CommentsDto;
import com.backengtest.demo.exception.ProjectNotFoundException;
import com.backengtest.demo.exception.SpringFreelanciniException;
import com.backengtest.demo.mapper.CommentMapper;
import com.backengtest.demo.model.Comment;
import com.backengtest.demo.model.NotificationEmail;
import com.backengtest.demo.model.Project;
import com.backengtest.demo.model.User;
import com.backengtest.demo.repository.CommentRepository;
import com.backengtest.demo.repository.ProjectRepo;
import com.backengtest.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class CommentService {
    private final UserRepository userRepository;
    private final AuthService authService;
    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;

    public void save(CommentsDto commentsDto) {
        //mel mafroudh tekhdem bel getCurrentUser()
        User user = userRepository.findById(commentsDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Comment comment = commentMapper.map(commentsDto, user);
        commentRepository.save(comment);
    }

    public List<CommentsDto> getAllCommentsForUser(String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException(userName));
        return commentRepository.findAllByUser(user)
                .stream()
                .map(commentMapper::mapToDto)
                .toList();
    }

    @Transactional
    public List<CommentsDto> getAllComments() {
        return   commentRepository.findAll()
                .stream()
                .map(commentMapper::mapToDto)
                .collect(toList());
    }
    public boolean containsSwearWords(String comment) {
        if (comment.contains("shit")) {
            throw new SpringFreelanciniException("Comments contains unacceptable language");
        }
        return false;
    }
}
