package pers.npcka.service;

import pers.npcka.model.Users;

import java.util.List;

public interface UserService {

    Users goToLogin(String account, String password) throws Exception;

    List<Users> getAllUser() throws Exception;

    int register(String account, String password) throws Exception;
}
