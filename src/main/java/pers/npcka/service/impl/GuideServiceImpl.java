package pers.npcka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.npcka.constant.GuideType;
import pers.npcka.dao.GuideMapper;
import pers.npcka.model.Guide;
import pers.npcka.service.GuideService;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service("guideService")
public class GuideServiceImpl implements GuideService {

    @Autowired
    private GuideMapper guideMapper;

    @Override
    public List<Guide> getNewsListByPage(int currentPage, int pageSize, String keyword) throws Exception {
        return guideMapper.getGuideListByPage((currentPage - 1) * pageSize, pageSize, GuideType.NEWS, keyword);
    }

    @Override
    public List<Guide> getGuideListByPage(int currentPage, int pageSize, String keyword) throws Exception {
        return guideMapper.getGuideListByPage((currentPage - 1) * pageSize, pageSize, GuideType.GUIDE, keyword);
    }

    @Override
    public Guide getGuideDetail(int id) throws Exception {
        return guideMapper.selectByPrimaryKey(id);
    }

    @Override
    public int getGuideCount(String keyword) throws Exception {
        return guideMapper.getGuideCount(GuideType.GUIDE, keyword);
    }

    @Override
    public int getNewsCount(String keyword) throws Exception {
        return guideMapper.getGuideCount(GuideType.NEWS,keyword);
    }

}
