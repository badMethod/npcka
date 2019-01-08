package pers.npcka.service;

import pers.npcka.model.Gift;

import java.util.List;

public interface GiftService {

    List<Gift> getNewGift(int nums) throws Exception;

    List<Gift> getIsPopGift(int isPop) throws Exception;

    List<Gift> getAllGift(String keyword, int currentPage, int pageSize) throws Exception;

    int getCurrentCount(String keyword) throws Exception;
}
