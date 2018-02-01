package com.z4knight.bugmanagement.controller;

import com.z4knight.bugmanagement.dataobject.HistoricProcess;
import com.z4knight.bugmanagement.enums.ErrorMsg;
import com.z4knight.bugmanagement.exception.ServiceException;
import com.z4knight.bugmanagement.form.ProcessForm;
import com.z4knight.bugmanagement.resultVO.Result;
import com.z4knight.bugmanagement.resultVO.ResultGenerator;
import com.z4knight.bugmanagement.service.HistoricProcessService;
import com.z4knight.bugmanagement.vo.HistoricProcessVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Z4knight
 * @Date 2018/2/1 13:50
 *
 * 流转记录控制类
 */

@RestController
@RequestMapping("/HistoricProcessManagement")
public class HistoricProcessController {

    @Autowired
    private HistoricProcessService historicProcessService;

    @PostMapping("/selectByObjectId")
    public Result selectByObjectId(@RequestBody ProcessForm processForm) {
        try {
            List<HistoricProcessVO> historicProcesses = historicProcessService.selectByObjectId(processForm.getObjectId());
            return ResultGenerator.genSuccessResult(historicProcesses);
        } catch (Exception e) {
            // 请求失败，则按接口定义，返回失败信息
            return ResultGenerator.genFailResult(e.getMessage());
        }
    }


}
