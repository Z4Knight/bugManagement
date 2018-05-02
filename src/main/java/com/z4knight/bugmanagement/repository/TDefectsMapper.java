package com.z4knight.bugmanagement.repository;

import com.z4knight.bugmanagement.dataobject.TDefects;

import java.util.ArrayList;



public interface TDefectsMapper {
	/**
	 * 缺陷列表（缺陷管理）
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
    * 编辑缺陷(预更新)
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
   int delectTdfec(TDefects tdefec);
   
}