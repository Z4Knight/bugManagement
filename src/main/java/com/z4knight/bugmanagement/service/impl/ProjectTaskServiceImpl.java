package com.z4knight.bugmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.z4knight.bugmanagement.dataobject.ProjectOrder;
import com.z4knight.bugmanagement.dataobject.ProjectTask;
import com.z4knight.bugmanagement.enums.ErrorMsg;
import com.z4knight.bugmanagement.enums.ItemCode;
import com.z4knight.bugmanagement.enums.TaskState;
import com.z4knight.bugmanagement.exception.ServiceException;
import com.z4knight.bugmanagement.form.ProjectTaskForm;
import com.z4knight.bugmanagement.repository.ProjectTaskMapper;
import com.z4knight.bugmanagement.service.ProjectOrderService;
import com.z4knight.bugmanagement.service.ProjectTaskService;
import com.z4knight.bugmanagement.util.CodeGeneratorUtil;
import com.z4knight.bugmanagement.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/1/17 16:28
 * 
 * 任务-服务实现类
 */
@Service
public class ProjectTaskServiceImpl implements ProjectTaskService {

    @Autowired
    private ProjectTaskMapper mapper;

    @Autowired
    private ProjectOrderService orderService;

    @Override
    public List<ProjectTask> selectAll(Integer page, Integer size) {
        // 起始页
        int startPage = page.intValue();
        // 每页显示多少条
        int pageRow = size.intValue();
        if (startPage == 0 && pageRow == 0) {
            List<ProjectTask> taskList = mapper.selectAll();
            if (taskList != null && taskList.size() > 1000L) {
                throw new ServiceException(ErrorMsg.DATA_OVERFLOW.getMsg());
            }
        }
        PageHelper.startPage(startPage, pageRow);
        List<ProjectTask> taskList = mapper.selectAll();
        PageInfo<ProjectTask> taskPageInfo = new PageInfo<>(taskList);
        taskList = taskPageInfo.getList();
        if (null == taskList || taskList.size() == 0) {
            throw new ServiceException(ErrorMsg.DATA_NOT_EXIST.getMsg());
        }
        return taskList;
    }

    @Override
    public ProjectTask save(ProjectTaskForm projectTaskForm) {
        ProjectTask task = selectByTaskName(projectTaskForm.getTaskName());
        if (null != task) {
            throw new ServiceException(ErrorMsg.TASK_NAME_EXIST.getMsg());
        }
        task = new ProjectTask();
        // 设置来自于前端传送的接口信息
        BeanUtils.copyProperties(projectTaskForm, task);
        // 新任务状态默认设置为：新建
        task.setState(TaskState.NEW_TASK.getMsg());
        // 工作量来自于所属工单
        ProjectOrder order = orderService.selectByOrderName(projectTaskForm.getOwnOrder());
        if (null == order) {
            throw new ServiceException(ErrorMsg.OWN_ORDER_NOT_EXIST.getMsg());
        }
        task.setWorkLoad(order.getDevWorkLoad());
        // 新任务是否里程碑默认为：否
        task.setMileStone("否");
        // 新任务是否可裁剪默认为：否
        task.setTailor("否");
        // 设置自动生成编码
        task.setTaskId(CodeGeneratorUtil.generateCode(ItemCode.TASK));
        // 设置登记与修改日期为系统当前日期
        task.setCreateTime(DateUtil.getCurrentDate());
        task.setEditTime(DateUtil.getCurrentDate());
        mapper.save(task);
        return task;
    }

    @Override
    public ProjectTask update(ProjectTaskForm projectTaskForm) {
        ProjectTask result = selectByTaskName(projectTaskForm.getTaskName());
        if (null != result && !result.getTaskId().equals(projectTaskForm.getTaskId())) {
            throw new ServiceException(ErrorMsg.TASK_NAME_EXIST.getMsg());
        }
        result = new ProjectTask();
        ProjectTask task = selectByTaskId(projectTaskForm.getTaskId());
        // 设置来自于前端传送的接口信息
        BeanUtils.copyProperties(projectTaskForm, result);
        // 设置其他原本存于数据库中的数据
        result.setState(task.getState());
        result.setMileStone(task.getMileStone());
        result.setReviewer(task.getReviewer());
        result.setWorkLoad(task.getWorkLoad());
        result.setTailor(task.getTailor());
        result.setOwnOrder(task.getOwnOrder());
        result.setCreateTime(task.getCreateTime());
        result.setEditTime(DateUtil.getCurrentDate());
        result.setRegister(task.getRegister());
        mapper.update(result);
        return result;
    }

    @Override
    public ProjectTask selectByTaskId(String taskId) {
        if (StringUtils.isEmpty(taskId)) {
            throw new ServiceException(ErrorMsg.TASK_CODE_REQUIRED.getMsg());
        }
        ProjectTask task = mapper.selectByTaskId(taskId);
        if (null == task) {
            throw new ServiceException(ErrorMsg.DATA_NOT_EXIST.getMsg());
        }
        return task;
    }

    @Override
    public ProjectTask selectByTaskName(String taskName) {
        if (StringUtils.isEmpty(taskName)) {
            throw new ServiceException(ErrorMsg.TASK_NAME_REQUIRED.getMsg());
        }
        ProjectTask task = mapper.selectByTaskName(taskName);
        return task;
    }

    @Override
    public void delete(String taskId) {
        if (StringUtils.isEmpty(taskId)) {
            throw new ServiceException(ErrorMsg.TASK_CODE_REQUIRED.getMsg());
        }
        ProjectTask task = selectByTaskId(taskId);
        if (null == task) {
            throw new ServiceException(ErrorMsg.DATA_NOT_EXIST.getMsg());
        }
        mapper.delete(taskId);
    }
}
