package com.leiax00.universe.owner.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.leiax00.universe.owner.api.bean.po.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Select("SELECT " +
            "t1.*, t2.id as r_id, t2.name as r_name, t2.authority, t2.description as r_description" +
            " FROM u_user t1, u_role t2 " +
            "WHERE t1.role_id = t2.id AND username = #{userName}")
    @Results(id = "auth_user_map", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "phone_num", property = "phoneNumber"),
            @Result(column = "r_id", property = "role.id"),
            @Result(column = "r_name", property = "role.name"),
            @Result(column = "authority", property = "role.authority"),
            @Result(column = "r_description", property = "role.description"),
    })
    UserInfo findByUsername(String userName);

    @Select("SELECT " +
            "t1.*, t2.id as r_id, t2.name as r_name, t2.authority, t2.description as r_description" +
            " FROM u_user t1, u_role t2 " +
            "WHERE t1.role_id = t2.id")
    @ResultMap("auth_user_map")
    List<UserInfo> queryAll();
}
