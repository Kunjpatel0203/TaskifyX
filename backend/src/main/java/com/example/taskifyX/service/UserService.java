package com.example.taskifyX.service;

import com.example.taskifyX.model.User;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Service;


public interface UserService {

    //public User findUserProfileByJwt(String jwt) throws ExecutionControl.UserException, ProjectException;

    public User findUserByEmail(String email) throws ExecutionControl.UserException;

    public User findUserById(Long userId) throws ExecutionControl.UserException;

    public User updateUsersProjectSize(User user,int number);

	//public List<User> findAllUsers();

	//public List<User> getPenddingRestaurantOwner();

    void updatePassword(User user, String newPassword);

    void sendPasswordResetEmail(User user);

    //void sendPasswordResetEmail(User user);
}
