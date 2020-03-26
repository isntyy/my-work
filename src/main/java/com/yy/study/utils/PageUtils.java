package com.yy.study.utils;

import cn.hutool.core.collection.CollectionUtil;

import java.util.List;

/**
 * 分页工具类
 *
 * @author wyy
 * @since 2020-03-26 21:41
 */
public class PageUtils {

    public static <T> List<T> startPage(List<T> list, Integer pageNum, Integer pageSize) {
        if (CollectionUtil.isEmpty(list)) {
            return null;
        }
        // 总记录数
        Integer count = list.size();
        // 页数
        Integer pageCount = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
        // 开始索引
        Integer fromIndex = (pageNum - 1) * pageSize;
        // 结束索引
        Integer toIndex = 0;

        if (pageNum.equals(pageCount)) {
            // 查询页码等于总页数
            toIndex = count;
        } else if (pageNum > pageCount) {
            // 查询页码大于总页数
            return null;
        } else {
            // 查询页码小于总页数
            toIndex = pageNum * pageSize;
        }
        List<T> pageList = list.subList(fromIndex, toIndex);
        return pageList;
    }

}
