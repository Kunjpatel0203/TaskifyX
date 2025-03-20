package com.example.taskifyX.service;

import com.example.taskifyX.exception.IssueException;
import com.example.taskifyX.exception.UserException;
import com.example.taskifyX.model.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Long issueId,Long userId,String comment) throws UserException, IssueException;

    void  deleteComment(Long commentId, Long userId) throws UserException, IssueException;

    List<Comment> findCommentByIssueId(Long issueId);

}