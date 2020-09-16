package com.projectmanagement.dao;

import com.projectmanagement.entity.ProjectInfo;
import com.projectmanagement.entity.StatisticsInfo;
import com.projectmanagement.mapper.ProjectManagementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectManagementDao {

    @Autowired
    private ProjectManagementMapper projectManagementMapper;

    public int add(ProjectInfo projectInfo) {
        return projectManagementMapper.add(projectInfo);
    }

    public int delete(ProjectInfo projectInfo) {
        return projectManagementMapper.delete(projectInfo);

    }

    public int update(ProjectInfo projectInfo) {
        return projectManagementMapper.update(projectInfo);
    }

    public List<ProjectInfo> inquiry(ProjectInfo projectInfo) {
        return projectManagementMapper.inquiry(projectInfo);
    }

    public List<StatisticsInfo> statisticsByMonth() {
        return projectManagementMapper.statisticsByMonth();
    }

}
