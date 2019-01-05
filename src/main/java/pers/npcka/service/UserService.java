package pers.npcka.service;

import pers.npcka.model.Users;

import java.util.List;

public interface UserService {

    List<Users> getAllUser() throws Exception;
}
