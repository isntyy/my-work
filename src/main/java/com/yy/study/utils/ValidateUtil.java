package com.yy.study.utils;

import java.util.List;

public class ValidateUtil {
    /**
     * 验证数组中是否包含空值
     */
    public static <T> boolean hasEmptyValue(T[] array) {
        if (array == null || array.length == 0) {
            return true;
        } else {
            for (T element : array) {
                if (element == null || element.toString().length() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 验证数组中是否包含空值
     */
    public static <T> boolean hasEmptyValue(List<T> array) {
        if (array == null || array.size() == 0) {
            return true;
        } else {
            for (T element : array) {
                if (element == null || element.toString().length() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 验证数组中是否包含某个对象
     */
    public static <T> boolean hasValue(T[] array, T obj) {
        for (T a : array) {
            if (a == obj) {
                return true;
            } else if (obj.getClass() == String.class && obj.equals(a)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 验证数组中是否不包含某个对象
     */
    public static <T> boolean hasNoValue(T[] array, T obj) {
        return !hasValue(array, obj);
    }
}
