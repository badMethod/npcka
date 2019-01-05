package pers.npcka.dao;

import java.util.List;
import pers.npcka.model.Guide;

public interface GuideMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Guide record);

    Guide selectByPrimaryKey(Integer id);

    List<Guide> selectAll();

    int updateByPrimaryKey(Guide record);
}