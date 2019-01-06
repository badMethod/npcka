package pers.npcka.model;

import java.util.Date;

public class Gift {
    private Integer id;

    private Integer gameId;

    private String name;

    private Integer total;

    private Integer remainder;

    private String content;

    private String method;

    private Date createTime;

    private Integer isPop;

    private Game game;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getRemainder() {
        return remainder;
    }

    public void setRemainder(Integer remainder) {
        this.remainder = remainder;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsPop() {
        return isPop;
    }

    public void setIsPop(Integer isPop) {
        this.isPop = isPop;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "id=" + id +
                ", gameId=" + gameId +
                ", name='" + name + '\'' +
                ", total=" + total +
                ", remainder=" + remainder +
                ", content='" + content + '\'' +
                ", method='" + method + '\'' +
                ", createTime=" + createTime +
                ", isPop=" + isPop +
                ", game=" + game +
                '}';
    }
}