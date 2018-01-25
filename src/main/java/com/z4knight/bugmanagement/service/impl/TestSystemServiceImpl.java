package com.z4knight.bugmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.z4knight.bugmanagement.dataobject.TestSystem;
import com.z4knight.bugmanagement.enums.ErrorMsg;
import com.z4knight.bugmanagement.enums.ItemCode;
import com.z4knight.bugmanagement.enums.LoggerMsg;
import com.z4knight.bugmanagement.enums.OpenCode;
import com.z4knight.bugmanagement.exception.ServiceException;
import com.z4knight.bugmanagement.form.TestSystemForm;
import com.z4knight.bugmanagement.repository.TestSystemMapper;
import com.z4knight.bugmanagement.service.TestSystemService;
import com.z4knight.bugmanagement.util.CodeGeneratorUtil;
import com.z4knight.bugmanagement.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/10 16:40
 *
 * 被测系统-服务实现类
 */
@Slf4j
@Service
public class TestSystemServiceImpl implements TestSystemService {

    @Autowired
    private TestSystemMapper mapper;

    @Override
    public List<TestSystem> selectAll(Integer page, Integer size) {
        // 起始页
        int startPage = page.intValue();
        // 每页显示多少条
        int pageRow = size.intValue();
        if (startPage == 0 && pageRow == 0) {
            List<TestSystem> systemList = mapper.selectAll();
            if (systemList != null && systemList.size() > 1000L) {
                log.error(LoggerMsg.SYSTEM_MANAGER_QUERY_LIST.getMsg() + ", ErrorMsg={}",ErrorMsg.DATA_OVERFLOW.getMsg());
                throw new ServiceException(ErrorMsg.DATA_OVERFLOW.getMsg());
            }
        }
        PageHelper.startPage(startPage, pageRow);
        List<TestSystem> systemList = mapper.selectAll();
        PageInfo<TestSystem> systemPageInfo = new PageInfo<>(systemList);
        systemList = systemPageInfo.getList();
        if (null == systemList || systemList.size() == 0) {
            log.error(LoggerMsg.SYSTEM_MANAGER_QUERY_LIST.getMsg() + ", ErrorMsg={}",ErrorMsg.DATA_NOT_EXIST.getMsg());
            throw new ServiceException(ErrorMsg.DATA_NOT_EXIST.getMsg());
        }
        log.info(LoggerMsg.SYSTEM_MANAGER_QUERY_LIST.getMsg() + ", List={}", systemList);
        return systemList;
    }

    @Override
    public TestSystem save(TestSystemForm testSystemForm) {
        TestSystem system = null;
        system = selectBySystemName(testSystemForm.getSystemName());
        if (null != system) {
            log.error(LoggerMsg.SYSTEM_MANAGER_QUERY_LIST.getMsg() + ", ErrorMsg={}",ErrorMsg.SYSTEM_NAME_EXIST.getMsg());
            throw new ServiceException(ErrorMsg.SYSTEM_NAME_EXIST.getMsg());
        }
        system = new TestSystem();
        // 设置来自于前端传送的接口信息
        BeanUtils.copyProperties(testSystemForm, system);
        // 默认开启
        system.setOpen(OpenCode.OPEN.code());
        // 设置自动生成编码
        system.setSystemId(CodeGeneratorUtil.generateCode(ItemCode.SYSTEM));
        // 设置登记与修改日期为系统当前日期
        system.setCreateTime(DateUtil.getCurrentDate());
        system.setEditTime(DateUtil.getCurrentDate());
        mapper.save(system);
        log.info(LoggerMsg.SYSTEM_MANAGER_ADD.getMsg() + ", system={}", system);
        return system;
    }

    @Override
    public TestSystem update(TestSystemForm testSystemForm) {
        TestSystem result = null;
        result = selectBySystemName(testSystemForm.getSystemName());
        if (null != result && !result.getSystemId().equals(testSystemForm.getSystemId())) {
            log.error(LoggerMsg.SYSTEM_MANAGER_QUERY_LIST.getMsg() + ", ErrorMsg={}",ErrorMsg.SYSTEM_NAME_EXIST.getMsg());
            throw new ServiceException(ErrorMsg.SYSTEM_NAME_EXIST.getMsg());
        }
        result = new TestSystem();
        TestSystem system = selectBySystemId(testSystemForm.getSystemId());
        // 设置来自于前端传送的接口信息
        BeanUtils.copyProperties(testSystemForm, result);
        // 设置其他原本存于数据库中的数据
        result.setOpen(system.getOpen());
        result.setCreateTime(system.getCreateTime());
        result.setEditTime(DateUtil.getCurrentDate());
        result.setRegister(system.getRegister());
        mapper.update(result);
        log.info(LoggerMsg.SYSTEM_MANAGER_UPDATE.getMsg() + ", system={}", system);
        return result;
    }

    @Override
    public TestSystem selectBySystemId(String systemId) {
        if (StringUtils.isEmpty(systemId)) {
            log.error(LoggerMsg.SYSTEM_MANAGER_QUERY_POINT.getMsg() + ", ErrorMsg={}",ErrorMsg.SYSTEM_CODE_REQUIRED.getMsg());
            throw new ServiceException(ErrorMsg.SYSTEM_CODE_REQUIRED.getMsg());
        }
        TestSystem system = mapper.selectBySystemId(systemId);
        if (null == system) {
            log.error(LoggerMsg.SYSTEM_MANAGER_QUERY_POINT.getMsg() + ", ErrorMsg={}",ErrorMsg.DATA_NOT_EXIST.getMsg());
            throw new ServiceException(ErrorMsg.DATA_NOT_EXIST.getMsg());
        }
        log.info(LoggerMsg.SYSTEM_MANAGER_QUERY_POINT.getMsg() + ", system={}", system);
        return system;
    }

    @Override
    public TestSystem selectBySystemName(String systemName) {
        if (StringUtils.isEmpty(systemName)) {
            log.error(LoggerMsg.SYSTEM_MANAGER_QUERY_POINT.getMsg() + ", ErrorMsg={}",ErrorMsg.SYSTEM_NAME_REQUIRED.getMsg());
            throw new ServiceException(ErrorMsg.SYSTEM_NAME_REQUIRED.getMsg());
        }
        TestSystem system = mapper.selectBySystemName(systemName);
        log.info(LoggerMsg.SYSTEM_MANAGER_QUERY_POINT.getMsg() + ", system={}", system);
        return system;
    }

    @Override
    public int delete(List<String> systemIds) {
        if (systemIds != null || systemIds.size() > 0) {
            int result = mapper.delete(systemIds);
            log.info(LoggerMsg.SYSTEM_MANAGER_DELETE.getMsg() + ", delete numbers={}", result);
            return result;
        } else {
            log.error(LoggerMsg.SYSTEM_MANAGER_DELETE.getMsg() + ", ErrorMsg={}",ErrorMsg.NO_MESSAGE_DELETED.getMsg());
            throw new ServiceException(ErrorMsg.NO_MESSAGE_DELETED.getMsg());
        }
    }
}
