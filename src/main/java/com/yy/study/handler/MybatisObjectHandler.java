package com.yy.study.handler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author wyy
 * @since 2020-04-19 22:44
 */
@Component
public class MybatisObjectHandler extends MetaObjectHandler {

    private static String COLUMN_NAME_CREATED_BY = "created_by";
    private static String COLUMN_NAME_CREATED_USER = "created_user";
    private static String COLUMN_NAME_CREATED_AT = "created_at";
    private static String COLUMN_NAME_UPDATED_BY = "updated_by";
    private static String COLUMN_NAME_UPDATED_USER = "updated_user";
    private static String COLUMN_NAME_UPDATED_At = "updated_at";

    @Override
    public void insertFill(MetaObject metaObject) {
        Date date = new Date();
        // todo 需要token信息获取
        // 当前登录用户id
        String userId = "";
        // 当前登录用户名称
        String userName = "";
        if (getFieldValByName(COLUMN_NAME_CREATED_BY, metaObject) == null) {
            setFieldValByName(COLUMN_NAME_CREATED_BY, userId, metaObject);
        }
        if (getFieldValByName(COLUMN_NAME_CREATED_USER, metaObject) == null) {
            setFieldValByName(COLUMN_NAME_CREATED_USER, userName, metaObject);
        }
        if (getFieldValByName(COLUMN_NAME_CREATED_AT, metaObject) == null) {
            setFieldValByName(COLUMN_NAME_CREATED_AT, date, metaObject);
        }
        if (getFieldValByName(COLUMN_NAME_UPDATED_BY, metaObject) == null) {
            setFieldValByName(COLUMN_NAME_UPDATED_BY, userId, metaObject);
        }
        if (getFieldValByName(COLUMN_NAME_UPDATED_USER, metaObject) == null) {
            setFieldValByName(COLUMN_NAME_UPDATED_USER, userId, metaObject);
        }
        if (getFieldValByName(COLUMN_NAME_UPDATED_At, metaObject) == null) {
            setFieldValByName(COLUMN_NAME_UPDATED_At, date, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // todo 需要token信息获取
        // 当前登录用户id
        String userId = "";
        // 当前登录用户名称
        String userName = "";
        setFieldValByName(COLUMN_NAME_UPDATED_BY, userId, metaObject);
        setFieldValByName(COLUMN_NAME_UPDATED_USER, userName, metaObject);
        setFieldValByName(COLUMN_NAME_UPDATED_At, new Date(), metaObject);
    }
}
