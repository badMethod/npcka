package pers.npcka.dao;

import pers.npcka.model.Game;

import java.util.List;

public interface GameMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Game record);

    Game selectByPrimaryKey(Integer id);

    List<Game> selectAll();

    int updateByPrimaryKey(Game record);
}