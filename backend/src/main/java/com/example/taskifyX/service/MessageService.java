package com.example.taskifyX.service;

import com.example.taskifyX.exception.ChatException;
import com.example.taskifyX.exception.ProjectException;
import com.example.taskifyX.exception.UserException;
import com.example.taskifyX.model.Message;

import java.util.List;

public interface MessageService {
    Message sendMessage(Long senderId, Long chatId, String content) throws UserException, ChatException, ProjectException;

    List<Message> getMessagesByProjectId(Long projectId) throws ProjectException, ChatException;
}
