package com.yy.study.utils;

import cn.hutool.core.collection.CollectionUtil;
import com.yy.study.bean.MarkDown;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wyy
 * @date 2020/3/10 20:14
 */
public class MarkDownUtils {

    /**
     * 根据#获取标题等级
     *
     * @param title
     * @return
     */
    public static Integer getTitleLevel(String title) {
        String flag = "#";
        for (int i = 0; i < title.length() - 1; i++) {
            if (title.startsWith(flag)) {
                flag += "#";
            } else {
                break;
            }
        }
        return flag.length() - 1;
    }

    /**
     * 获取去除#后的标题内容
     *
     * @return
     */
    public static String getTitleContent(String title) {
        for (int i = 0; i < title.length() - 1; i++) {
            if (title.startsWith("#")) {
                title = StringUtils.substring(title, 1).trim();
            }
        }
        return title;
    }


    public static List<MarkDown> getList(String content, Integer range) {
        List<MarkDown> titles = new ArrayList<>();
        if (content.indexOf("\n") > 0) {
            String[] split = content.split("\n");
            List<String> list = Arrays.asList(split);
            for (int i = 0; i <= list.size() - 1; i++) {
                Integer level = getTitleLevel(list.get(i));
                String title = getTitleContent(list.get(i));
                MarkDown markDown = new MarkDown(level, title, i + 1, null);
                titles.add(markDown);
            }
        }
        return titles.stream().filter(a -> a.getLevel() <= range && a.getLevel() != 0)
                .collect(Collectors.toList());
    }

    // 默认第一个为根节点
    public static MarkDown getTree(List<MarkDown> list) {
        if (CollectionUtil.isNotEmpty(list)) {
            MarkDown root = list.get(0);
            // index从小到大排列
            List<MarkDown> childs = new ArrayList<>();
            for (int i = 0; i < list.size() - 1; i++) {
                if (root.getLevel() + 1 == list.get(i).getLevel()) {
                    childs.add(list.get(i));
                }
            }
            root.setChild(childs);
            if (CollectionUtil.isNotEmpty(childs)) {
                getTree(childs);
            }
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        String content = "# 一级标题\n" +
                "## 二级标题1\n" +
                "### 三级标题1\n" +
                "## 二级标题2\n" +
                "### 三级标题2";
        List<MarkDown> list = getList(content, 3);

        for (MarkDown title : list) {
            System.out.println(title);
        }
        /*List<MarkDown> list1 = new ArrayList<>();
        MarkDown tree = getTree(list);
        System.out.println(11);*/

    }
}
