package com.projectmanagement.service;

import com.projectmanagement.dao.ProjectManagementDao;
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

    public int add(ProjectInfo projectInfo) {
        projectInfo.setCutoverMonth(DateUtils.convert(projectInfo.getCutoverDate(),"yyyy-MM-dd","yyyy-MM"));
        return projectManagementDao.add(projectInfo);
    }

    public int delete(ProjectInfo projectInfo) {
        return projectManagementDao.delete(projectInfo);

    }

    public int update(ProjectInfo projectInfo) {
        projectInfo.setCutoverMonth(DateUtils.convert(projectInfo.getCutoverDate(),"yyyy-MM-dd","yyyy-MM"));
        return projectManagementDao.update(projectInfo);
    }

    public List<ProjectInfo> inquiry(ProjectInfo projectInfo) {
        return projectManagementDao.inquiry(projectInfo);
    }

    public List<StatisticsInfo> statisticsByMonth() {
        return projectManagementDao.statisticsByMonth();
    }


}
