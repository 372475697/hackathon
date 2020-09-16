package com.projectmanagement.service;

import com.projectmanagement.dao.ProjectManagementDao;
import com.projectmanagement.entity.ResponseData;
import com.projectmanagement.entity.StatisticsInfo;
import com.projectmanagement.entity.ProjectInfo;
import com.projectmanagement.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectManagementService {

    @Autowired
    private ProjectManagementDao projectManagementDao;

    public ResponseData add(ProjectInfo projectInfo) {
        projectInfo.setCutoverMonth(DateUtils.convert(projectInfo.getCutoverDate(),"yyyy-MM-dd","yyyy-MM"));
        return ResponseData.success("add success",projectManagementDao.add(projectInfo)) ;
    }

    public ResponseData delete(ProjectInfo projectInfo) {
        return ResponseData.success("delete success",projectManagementDao.delete(projectInfo));

    }

    public ResponseData update(ProjectInfo projectInfo) {
        projectInfo.setCutoverMonth(DateUtils.convert(projectInfo.getCutoverDate(),"yyyy-MM-dd","yyyy-MM"));
        return ResponseData.success("update success", projectManagementDao.update(projectInfo));
    }

    public ResponseData inquiry(ProjectInfo projectInfo) {
        return ResponseData.success(projectManagementDao.inquiry(projectInfo));
    }

    public ResponseData statisticsByMonth() {
        return ResponseData.success(projectManagementDao.statisticsByMonth());
    }
}