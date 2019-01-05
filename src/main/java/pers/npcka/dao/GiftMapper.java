package pers.npcka.dao;

import java.util.List;
import pers.npcka.model.Gift;

public interface GiftMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gift record);

    Gift selectByPrimaryKey(Integer id);

    List<Gift> selectAll();

    int updateByPrimaryKey(Gift record);
}