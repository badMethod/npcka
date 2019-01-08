package pers.npcka.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pers.npcka.model.Gift;

import java.util.List;

@Repository
public interface GiftMapper {
    int deleteByPrimaryKey(Integer id) throws Exception;

    int insert(Gift record);

    Gift selectByPrimaryKey(Integer id) throws Exception;

    List<Gift> selectAll() throws Exception;

    int updateByPrimaryKey(Gift record) throws Exception;

    Gift getGiftDetailById(int id) throws Exception;

    List<Gift> getNewGift(@Param("nums") int nums) throws Exception;

    List<Gift> getIsPopGift(int isPop) throws Exception;

    List<Gift> getAllGift(@Param("keyword") String keyword, @Param("page") int page, @Param("pageSize") int pageSize) throws Exception;

    int getCurrentCount(@Param("keyword") String keyword) throws Exception;
}