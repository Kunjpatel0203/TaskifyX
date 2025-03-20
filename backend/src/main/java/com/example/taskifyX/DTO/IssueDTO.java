package com.example.taskifyX.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.taskifyX.model.Project;
import com.example.taskifyX.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//IssueDTO class
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueDTO {

 private Long id;
 private String title;
 private String description;
 private String status;
 private Long projectID;
 private String priority;
 private LocalDate dueDate;
 private List<String> tags = new ArrayList<>();
 private Project project;

 // Exclude assignee during serialization

 private User assignee;

 public IssueDTO(Long id, String title, String description, String status, Long projectID, String priority, LocalDate dueDate, List<String> tags, Project project, User assignee) {
  this.id = id;
  this.title = title;
  this.description = description;
  this.status = status;
  this.projectID = projectID;
  this.priority = priority;
  this.dueDate = dueDate;
  this.tags = tags;
  this.project = project;
  this.assignee = assignee;
 }

 public IssueDTO(){}

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getTitle() {
  return title;
 }

 public void setTitle(String title) {
  this.title = title;
 }

 public String getDescription() {
  return description;
 }

 public void setDescription(String description) {
  this.description = description;
 }

 public String getStatus() {
  return status;
 }

 public void setStatus(String status) {
  this.status = status;
 }

 public Long getProjectID() {
  return projectID;
 }

 public void setProjectID(Long projectID) {
  this.projectID = projectID;
 }

 public String getPriority() {
  return priority;
 }

 public void setPriority(String priority) {
  this.priority = priority;
 }

 public LocalDate getDueDate() {
  return dueDate;
 }

 public void setDueDate(LocalDate dueDate) {
  this.dueDate = dueDate;
 }

 public List<String> getTags() {
  return tags;
 }

 public void setTags(List<String> tags) {
  this.tags = tags;
 }

 public Project getProject() {
  return project;
 }

 public void setProject(Project project) {
  this.project = project;
 }

 public User getAssignee() {
  return assignee;
 }

 public void setAssignee(User assignee) {
  this.assignee = assignee;
 }
}
