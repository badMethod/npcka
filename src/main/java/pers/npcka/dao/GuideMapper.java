package pers.npcka.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pers.npcka.model.Guide;

import java.util.List;

@Repository
public interface GuideMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Guide record);

    Guide selectByPrimaryKey(Integer id);

    List<Guide> selectAll();

    int updateByPrimaryKey(Guide record);

    List<Guide> getGuideListByPage(@Param("page") int page, @Param("pageSize") int pageSize, @Param("type") int type);
}