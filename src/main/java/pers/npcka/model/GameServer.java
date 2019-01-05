package pers.npcka.model;

import java.util.Date;

public class GameServer {
    private Integer id;

    private Integer gameId;

    private String serverName;

    private Date openServerTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName == null ? null : serverName.trim();
    }

    public Date getOpenServerTime() {
        return openServerTime;
    }

    public void setOpenServerTime(Date openServerTime) {
        this.openServerTime = openServerTime;
    }
}