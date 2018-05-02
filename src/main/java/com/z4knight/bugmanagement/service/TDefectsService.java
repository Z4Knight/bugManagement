package com.z4knight.bugmanagement.service;

import java.util.ArrayList;

import com.z4knight.bugmanagement.dataobject.TDefects;

public interface TDefectsService {
	/**
	 * 缺陷列表
	 * @return
	 */
   ArrayList<TDefects> findList();
   /**
    * 新增缺陷
    * @param tdefec
    * @return
    */
   int   insertInto(TDefects tdefec);
   /**
    * 编辑缺陷(编辑前首先进行查询)
    * @param tdefec
    * @return
    */
   TDefects  updateSelect(TDefects tdefec);
   /**
    * 编辑缺陷(修改)
    * @param tdefec
    * @return
    */
   int updateTdefec(TDefects tdefec);
   /**
    * 删除缺陷
    * @param tdefec
    * @return
    */
   int delectTdefec(TDefects tdefec);
}
