package com.z4knight.bugmanagement.repository;

import com.z4knight.bugmanagement.dataobject.TestSystem;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/10 15:23
 *
 * 被测系统-mapper接口
 */
public interface TestSystemMapper {

    List<TestSystem> selectAll();

    void update(TestSystem system);

    TestSystem selectBySystemId(String systemId);

    void save(TestSystem system);

    int delete(List<String> systemIds);

    TestSystem selectBySystemName(String systemName);
}
