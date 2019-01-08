package pers.npcka.service;

import pers.npcka.model.Guide;

import java.util.List;

public interface GuideService {
    List<Guide> getNewsListByPage(int currentPage, int pageSize) throws Exception;

    List<Guide> getGuideListByPage(int currentPage, int pageSize) throws Exception;

    Guide getGuideDetail(int id) throws Exception;

    int getGuideCount() throws Exception;

    int getNewsCount() throws Exception;
}
