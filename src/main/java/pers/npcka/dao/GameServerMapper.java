package pers.npcka.dao;

import java.util.List;
import pers.npcka.model.GameServer;

public interface GameServerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GameServer record);

    GameServer selectByPrimaryKey(Integer id);

    List<GameServer> selectAll();

    int updateByPrimaryKey(GameServer record);
}