package com.leiax00.universe.owner.bean.constant;

public class CommonConst {
    public static String getRedisKey4UserByToken(String token) {
        return "universe:owner:token:" + token;
    }
}
