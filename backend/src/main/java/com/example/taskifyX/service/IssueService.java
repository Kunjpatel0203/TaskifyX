package com.example.taskifyX.service;

import java.util.List;
import java.util.Optional;

import com.example.taskifyX.exception.IssueException;
import com.example.taskifyX.exception.ProjectException;
import com.example.taskifyX.exception.UserException;
import com.example.taskifyX.model.Issue;
import com.example.taskifyX.model.User;
import com.example.taskifyX.request.IssueRequest;

public interface IssueService {

    //	 List<Issue> getAllIssues() throws IssueException;

    Optional<Issue> getIssueById(Long issueId) throws IssueException;

    List<Issue> getIssueByProjectId(Long projectId) throws ProjectException;

    Issue createIssue(IssueRequest issue,Long userid) throws UserException, IssueException, ProjectException;

    Optional<Issue> updateIssue(Long issueid,IssueRequest updatedIssue,Long userid ) throws IssueException, UserException, ProjectException;

    String deleteIssue(Long issueId,Long userid) throws UserException, IssueException;

    List<Issue> getIssuesByAssigneeId(Long assigneeId) throws IssueException;

    List<Issue> searchIssues(String title, String status, String priority, Long assigneeId) throws IssueException;

    List<User> getAssigneeForIssue(Long issueId) throws IssueException;

    Issue addUserToIssue(Long issueId, Long userId) throws UserException, IssueException;

    Issue updateStatus(Long issueId, String status) throws IssueException;

}
