package projectmanagement.dao;

import projectmanagement.entity.ProjectInfo;
import projectmanagement.entity.StatisticsInfo;
import projectmanagement.mapper.ProjectManagementMapper;
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

    public List<StatisticsInfo> statisticsByMonth(String pp) {
    	if(pp.equals("ALL")) {
    		pp = null;
    	}
        return projectManagementMapper.statisticsByMonth(pp);
    }

}
