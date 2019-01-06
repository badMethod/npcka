package pers.npcka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.npcka.dao.UsersMapper;
import pers.npcka.model.Users;
import pers.npcka.service.UserService;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<Users> getAllUser() throws Exception {
        return usersMapper.selectAll();
    }
}
