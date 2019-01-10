package pers.npcka.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pers.npcka.model.GameServer;

import java.util.List;

@Repository
public interface GameServerMapper {
    int deleteByPrimaryKey(Integer id) throws Exception;

    int insert(GameServer record) throws Exception;

    GameServer selectByPrimaryKey(Integer id) throws Exception;

    List<GameServer> selectAll() throws Exception;

    int updateByPrimaryKey(GameServer record) throws Exception;

    List<GameServer> getServerByDate(@Param("date") String date) throws Exception;
}