package pers.npcka.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pers.npcka.model.Users;

import java.util.List;

@Repository
public interface UsersMapper {
    int deleteByPrimaryKey(Integer id) throws Exception;

    int insert(Users record) throws Exception;

    Users selectByPrimaryKey(Integer id) throws Exception;

    List<Users> selectAll() throws Exception;

    int updateByPrimaryKey(Users record) throws Exception;

    Users goToLogin(@Param("account") String account, @Param("password") String password) throws Exception;
}