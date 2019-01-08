package pers.npcka.enums;

public enum GiftPlatformEnum {
    IOS(1, "ios"), ANDROID(2, "Android"), DOUBLE_PLATFORM(3, "双平台");
    private int key;
    private String value;

    GiftPlatformEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static GiftPlatformEnum getInfo(int key) {
        for (GiftPlatformEnum game : values()) {
            if (game.key == key)
                return game;
        }
        throw new IllegalArgumentException("参数不存在");
    }
}
