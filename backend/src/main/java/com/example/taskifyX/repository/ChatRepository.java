package com.example.taskifyX.repository;

import com.example.taskifyX.model.Chat;
import com.example.taskifyX.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {


    Chat findByProject(Project projectById);
//	List<Chat> findByProjectNameContainingIgnoreCase(String projectName);
}