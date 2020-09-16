package com.projectmanagement.service;

import com.projectmanagement.dao.ProjectManagementDao;
import com.projectmanagement.entity.ResponseData;
import com.projectmanagement.entity.StatisticsInfo;
import com.projectmanagement.entity.ProjectInfo;
import com.projectmanagement.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

    public ResponseData statisticsByMonth(String pp) {
    	HashMap<String, Integer> res = new HashMap<>();
    	List<StatisticsInfo> list = projectManagementDao.statisticsByMonth(pp);
    	list.stream().forEach(
    			(a) -> res.put(a.getTargetRelease(), a.getCount())
    	);
    	
    	if(res.get("M1") == null) {
    		res.put("M1", 0);
    	}
    	if(res.get("R1") == null) {
    		res.put("R1", 0);
    	}
    	if(res.get("M3") == null) {
    		res.put("M3", 0);
    	}
    	if(res.get("M4") == null) {
    		res.put("M4", 0);
    	}
    	if(res.get("R2") == null) {
    		res.put("R2", 0);
    	}
    	if(res.get("M6") == null) {
    		res.put("M6", 0);
    	}
    	if(res.get("M7") == null) {
    		res.put("M7", 0);
    	}
    	if(res.get("R3") == null) {
    		res.put("R3", 0);
    	}
    	if(res.get("M9") == null) {
    		res.put("M9", 0);
    	}
    	if(res.get("M10") == null) {
    		res.put("M10", 0);
    	}
    	if(res.get("R4") == null) {
    		res.put("R4", 0);
    	}
    	if(res.get("M12") == null) {
    		res.put("M12", 0);
    	}
        return ResponseData.success(res);
    }
}