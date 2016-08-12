package com.wd.data.investor;

/**
 * Created by Zhipeng on 2016/5/30.
 */
public class AdvertismentInfo {
    private Long id;
    private String name;
    private Byte type;
    private String img;

    public AdvertismentInfo() {
    }

    public AdvertismentInfo(Long id, String name, Byte type, String img) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
