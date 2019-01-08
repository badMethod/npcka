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
    public List<Guide> getNewsListByPage(int currentPage, int pageSize) throws Exception {
        return guideMapper.getGuideListByPage((currentPage - 1) * pageSize, pageSize, GuideType.News);
    }

    @Override
    public List<Guide> getGuideListByPage(int currentPage, int pageSize) throws Exception {
        return guideMapper.getGuideListByPage((currentPage - 1) * pageSize, pageSize, GuideType.GUIDE);
    }

    @Override
    public Guide getGuideDetail(int id) throws Exception {
        return guideMapper.selectByPrimaryKey(id);
    }

    @Override
    public int getGuideCount() throws Exception {
        return guideMapper.getGuideCount(GuideType.GUIDE);
    }

    @Override
    public int getNewsCount() throws Exception {
        return guideMapper.getGuideCount(GuideType.News);
    }

}
