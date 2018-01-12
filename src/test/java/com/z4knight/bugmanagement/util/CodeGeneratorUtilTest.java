package com.z4knight.bugmanagement.util;

import com.z4knight.bugmanagement.enums.ItemCode;
import org.junit.Assert;
import org.junit.Test;


/**
 * @Author Z4knight
 * @Date 2018/1/9 11:33
 */

public class CodeGeneratorUtilTest {

    @Test
    public void generateCode() {
        CodeGeneratorUtil.setGroupNum(4);
        String result = CodeGeneratorUtil.generateCode(ItemCode.SYSTEM);
        Assert.assertEquals("S000001",result);
    }
}