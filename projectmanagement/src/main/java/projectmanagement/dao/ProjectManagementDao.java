package projectmanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import projectmanagement.entity.ProjectInfo;
import projectmanagement.entity.StatisticsInfo;
import projectmanagement.entity.Status;
import projectmanagement.mapper.ProjectManagementMapper;

import java.util.List;

@Repository
public class ProjectManagementDao {

    @Autowired
    private ProjectManagementMapper projectManagementMapper;

    public int add(ProjectInfo projectInfo) {
        projectInfo.setProjectProgress(Status.getProgress(projectInfo.getStatus()));
        projectInfo.setUatRelDate(projectInfo.getUatPlanDate());
        return projectManagementMapper.add(projectInfo);
    }

    public int delete(ProjectInfo projectInfo) {
        return projectManagementMapper.delete(projectInfo);

    }

    public int update(ProjectInfo projectInfo) {
        projectInfo.setProjectProgress(Status.getProgress(projectInfo.getStatus()));
        return projectManagementMapper.update(projectInfo);
    }

    public List<ProjectInfo> inquiry(ProjectInfo projectInfo) {
        if("ALL".equals(projectInfo.getOppmOwner())||"---ALL---".equalsIgnoreCase(projectInfo.getOppmOwner())) {
           projectInfo.setOppmOwner(null);
        }
        return projectManagementMapper.inquiry(projectInfo);
    }

    public List<StatisticsInfo> statisticsByMonth(String pp) {
    	if("ALL".equals(pp)){
    		pp = null;
    	}
        return projectManagementMapper.statisticsByMonth(pp);
    }

}
