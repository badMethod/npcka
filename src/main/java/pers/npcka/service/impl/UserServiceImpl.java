package pers.npcka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.npcka.dao.UsersMapper;
import pers.npcka.model.Users;
import pers.npcka.service.UserService;

import java.util.Date;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public Users goToLogin(String account, String password) throws Exception {
        return usersMapper.goToLogin(account, password);
    }

    @Override
    public List<Users> getAllUser() throws Exception {
        return usersMapper.selectAll();
    }

    @Override
    public int register(String account, String password) throws Exception {
        Users user = new Users();
        if (account.length() == 11 && !account.contains("@")) {
            user.setPhone(account);
        } else {
            user.setEmail(account);
        }
        user.setCreateTime(new Date());
        user.setPassword(password);
        user.setUsername(account);
        int result = usersMapper.insert(user);
        return result;
    }
}
