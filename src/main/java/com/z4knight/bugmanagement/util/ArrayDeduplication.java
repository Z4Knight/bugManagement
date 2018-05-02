package com.z4knight.bugmanagement.util;

import java.util.LinkedList;
import java.util.List;

public class ArrayDeduplication {
    /** 
     * 数组去重 
     * 
     * @param arr1 
     * @param arr2 
     * @return 
     */  
	public  String[] arrContrast(String[] arr1, String[] arr2) {  
  
        List<String> list = new LinkedList<String>();  
  
        // 处理第一个数组,list里面的值为1,3,5,7  
        for (String str : arr1) {  
            if (!list.contains(str)) {  
                list.add(str);  
            }  
        }  
  
        // 如果第二个数组存在和第一个数组相同的值，就删除  
        for (String str : arr2) {  
            if (list.contains(str)) {  
                list.remove(str);  
            }  
        }  
  
        // 创建空数组  
        String[] result = {};  
  
        // List to Array  
        return list.toArray(result);  
    }  
}
