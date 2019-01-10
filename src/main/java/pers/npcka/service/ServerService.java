package pers.npcka.service;

import pers.npcka.model.GameServer;

import java.util.List;

public interface ServerService {
    List<GameServer> getServerByDate(String date) throws Exception;
}
