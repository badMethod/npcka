package pers.npcka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.npcka.dao.GameServerMapper;
import pers.npcka.model.GameServer;
import pers.npcka.service.ServerService;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service("serverService")
public class ServerServiceImpl implements ServerService {

    @Autowired
    private GameServerMapper serverMapper;

    @Override
    public List<GameServer> getServerByDate(String date) throws Exception {
        return serverMapper.getServerByDate(date);
    }
}
