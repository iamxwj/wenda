package com.wd.utils;

/**
 * 金额计算工具
 * Created by Zhipeng on 2016/5/10.
 */
public class AmountCalculatorUtil {
    public static final Long projectDeliveryInvestLevelDiff = 200L;
    public static final Long projectDeliveryProjectLevelDiff = 200L;
    public static final Byte projectDeliveryTopLevel = 6;
    public static final Long adviceInvestLevelDiff = 100L;
    public static final Long adviceWordDiff = 50L;
    public static Long getProjectDeliveryAmount(Byte myLevel, Byte investLevel){
        return 100*(investLevelAmount(investLevel,projectDeliveryInvestLevelDiff) + projectLevelAmount(myLevel));
    }

    private static Long projectLevelAmount(Byte myLevel) {
        return (5 - myLevel ) * projectDeliveryProjectLevelDiff;
    }

    private static Long investLevelAmount(Byte investLevel, Long projectDeliveryDiff) {
        if(investLevel> projectDeliveryTopLevel)
            investLevel = projectDeliveryTopLevel;
        return investLevel * projectDeliveryDiff;

    }

    public static Long getAdviceAmount(Byte investLevel, int wordLevel){
        return 100*(wordLeveAmount(wordLevel));
    }

    private static Long wordLeveAmount(int wordLevel) {
        return wordLevel * adviceWordDiff;
    }
}
