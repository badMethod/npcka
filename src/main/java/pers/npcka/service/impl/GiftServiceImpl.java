package pers.npcka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.npcka.dao.GiftMapper;
import pers.npcka.model.Gift;
import pers.npcka.service.GiftService;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service("giftService")
public class GiftServiceImpl implements GiftService {

    @Autowired
    private GiftMapper giftMapper;

    @Override
    public List<Gift> getNewGift(int nums) throws Exception {
        return giftMapper.getNewGift(nums);
    }

    @Override
    public List<Gift> getIsPopGift(int isPop) throws Exception {
        return giftMapper.getIsPopGift(isPop);
    }

    @Override
    public List<Gift> getAllGift(String keyword, int currentPage, int pageSize) throws Exception {
        return giftMapper.getAllGift(keyword, ((currentPage - 1) * pageSize), pageSize);
    }

    @Override
    public int getCurrentCount(String keyword) throws Exception {
        return giftMapper.getCurrentCount(keyword);
    }
}
