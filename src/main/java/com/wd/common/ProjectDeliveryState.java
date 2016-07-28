package com.wd.common;

/**
 * Created by Zhipeng on 2016/4/14.
 */
public class ProjectDeliveryState {
    /**
     * ==========================投递状态=================================
     */
    public static final Byte beforeDelivery = 1;//待投递
    public static final Byte beforeView = 2;//未查看
    public static final Byte alreadyView = 3;//已查看
    public static final Byte replyed = 4;//已回复
    public static final Byte discuss = 5;//想约谈
    public static final Byte comment = 6;//评价
    public static final Byte afterComment = 7;//已评价
    /**
     * ==============================查看反馈===================================
     */
    public static final Byte love = 1;//热爱
    public static final Byte like = 2;//喜欢
    public static final Byte hope = 3;//待观察
    public static final Byte dislike = 4;//不看好
}
