package com.z4knight.bugmanagement.service;

import com.z4knight.bugmanagement.dataobject.TestSystem;
import com.z4knight.bugmanagement.form.TestSystemForm;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/10 16:22
 *
 * 被测系统-服务的接口
 */

public interface TestSystemService {
    List<TestSystem> selectAll(Integer page, Integer size);

    TestSystem save(TestSystemForm testSystemForm);

    TestSystem update(TestSystemForm testSystemForm);

    TestSystem selectBySystemId(String systemId);

    TestSystem selectBySystemName(String systemName);

    void delete(String groupId);

}
