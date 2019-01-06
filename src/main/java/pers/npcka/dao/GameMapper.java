package pers.npcka.dao;

import org.springframework.stereotype.Repository;
import pers.npcka.model.Game;

import java.util.List;

@Repository
public interface GameMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Game record);

    Game selectByPrimaryKey(Integer id);

    List<Game> selectAll();

    int updateByPrimaryKey(Game record);

    List<Game> getAllGameGift();
}