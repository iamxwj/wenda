package com.wd.common;

/**
 * Created by Zhipeng on 2016/4/13.
 */
public class AdviceState {
    public static final Byte draft = 1;//草稿
    public static final Byte send = 2;//已发送 or 待回复
    public static final Byte replyed = 3;//已回复
    public static final Byte receiveSaved = 4;// 接收者保存

    public static final int difficulty_easy = 1; // 简单
    public static final int difficulty_middle = 2; // 一般
    public static final int difficulty_hard = 3; //较难
}
