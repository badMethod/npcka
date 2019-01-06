package pers.npcka.dao;

import org.springframework.stereotype.Repository;
import pers.npcka.model.Gift;

import java.util.List;

@Repository
public interface GiftMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gift record);

    Gift selectByPrimaryKey(Integer id);

    List<Gift> selectAll();

    int updateByPrimaryKey(Gift record);

    Gift getGiftDetailById(int id);
}