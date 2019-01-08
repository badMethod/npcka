package pers.npcka.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pers.npcka.model.Guide;

import java.util.List;

@Repository
public interface GuideMapper {
    int deleteByPrimaryKey(Integer id) throws Exception;

    int insert(Guide record) throws Exception;

    Guide selectByPrimaryKey(Integer id) throws Exception;

    List<Guide> selectAll() throws Exception;

    int updateByPrimaryKey(Guide record) throws Exception;

    List<Guide> getGuideListByPage(@Param("page") int page, @Param("pageSize") int pageSize, @Param("type") int type) throws Exception;

    int getGuideCount(int type) throws Exception;
}