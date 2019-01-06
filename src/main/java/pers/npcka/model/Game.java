package pers.npcka.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Game {
    private Integer id;

    private String name;

    private String icon;

    private Integer tag;

    private String image;

    private String version;

    private String size;

    private Integer platform;

    private String operator;

    private BigDecimal price;

    private Date updateTime;

    private String desc;

    private List<Gift> gifts;

    private List<GameServer> gameServers;

    public List<GameServer> getGameServers() {
        return gameServers;
    }

    public void setGameServers(List<GameServer> gameServers) {
        this.gameServers = gameServers;
    }

    public List<Gift> getGifts() {
        return gifts;
    }

    public void setGifts(List<Gift> gifts) {
        this.gifts = gifts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", tag=" + tag +
                ", image='" + image + '\'' +
                ", version='" + version + '\'' +
                ", size='" + size + '\'' +
                ", platform=" + platform +
                ", operator='" + operator + '\'' +
                ", price=" + price +
                ", updateTime=" + updateTime +
                ", desc='" + desc + '\'' +
                ", gifts=" + gifts +
                ", gameServers=" + gameServers +
                '}';
    }
}