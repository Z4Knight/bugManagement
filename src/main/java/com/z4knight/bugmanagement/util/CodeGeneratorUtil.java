package com.z4knight.bugmanagement.util;

import com.z4knight.bugmanagement.enums.ItemCode;


/**
 * @Author Z4knight
 * @Date 2018/1/8 15:29
 *
 * 各类编码生成器工具类
 */
public class CodeGeneratorUtil {


    private static int groupNum = 0;

    private static int systemNum = 0;

    private static int projectNum = 0;

    private static int taskNum = 0;

    /**
     *
     * @param itemCode
     * @return String 对应的项目编码
     * 生成规则为： 一个或多个标识符，后跟六位自增数字
     * 比如： G000001
     */
    public static String generateCode(ItemCode itemCode) {
        StringBuilder sb = new StringBuilder();
        String code = itemCode.code();
        int num = increaseNum(itemCode);
        String zero = addZero(num);
        sb.append(code);
        sb.append(zero);
        sb.append(num);
        return sb.toString();
    }

    private static String addZero(int num) {
        StringBuilder sb = new StringBuilder();
        if (num < 10) {
            sb.append("00000");
        } else if (num < 100) {
            sb.append("0000");
        } else if (num < 1000) {
            sb.append("000");
        } else if (num < 10000) {
            sb.append("00");
        } else if (num < 100000) {
            sb.append("0");
        } else {
            sb.append("");
        }
        return sb.toString();
    }

    private static int increaseNum(ItemCode code) {
        int result = 0;
        if (ItemCode.GROUP.equals(code)) {
            result = ++groupNum;
        } else if (ItemCode.SYSTEM.equals(code)) {
            result = ++systemNum;
        } else if (ItemCode.ORDER.equals(code)) {
            result = ++projectNum;
        } else if (ItemCode.TASK.equals(code)) {
            result = ++taskNum;
        }
        return result;
    }


    public static void setGroupNum(int groupNum) {
        CodeGeneratorUtil.groupNum = groupNum;
    }

    public static void setSystemNum(int systemNum) {
        CodeGeneratorUtil.systemNum = systemNum;
    }

    public static void setProjectNum(int projectNum) {
        CodeGeneratorUtil.projectNum = projectNum;
    }

    public static void setTaskNum(int taskNum) {
        CodeGeneratorUtil.taskNum = taskNum;
    }
}
