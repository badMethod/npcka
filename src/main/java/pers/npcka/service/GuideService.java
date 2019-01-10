package pers.npcka.service;

import pers.npcka.model.Guide;

import java.util.List;

public interface GuideService {
    List<Guide> getNewsListByPage(int currentPage, int pageSize, String keyword) throws Exception;

    List<Guide> getGuideListByPage(int currentPage, int pageSize, String keyword) throws Exception;

    Guide getGuideDetail(int id) throws Exception;

    int getGuideCount(String keyword) throws Exception;

    int getNewsCount(String keyword) throws Exception;
}
