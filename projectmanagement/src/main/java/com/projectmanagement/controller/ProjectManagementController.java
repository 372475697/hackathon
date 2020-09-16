package com.projectmanagement.controller;


import com.projectmanagement.entity.ProjectInfo;
import com.projectmanagement.entity.ResponseData;
import com.projectmanagement.service.ProjectManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("projectTracker")
public class ProjectManagementController {

    @Autowired
    private ProjectManagementService projectManagementService;

    @PostMapping("add")
    public ResponseData add(@RequestBody ProjectInfo projectInfo) {
        return ResponseData.success("add success",projectManagementService.add(projectInfo)) ;
    }

    @PostMapping("delete")
    public ResponseData delete(@RequestBody ProjectInfo projectInfo) {
        return ResponseData.success("delete success",projectManagementService.delete(projectInfo));

    }

    @PostMapping("update")
    public ResponseData update(@RequestBody ProjectInfo projectInfo) {
        return ResponseData.success("update success", projectManagementService.update(projectInfo));
    }

    @PostMapping("inquiry")
    public ResponseData inquiry(@RequestBody ProjectInfo projectInfo) {
        return ResponseData.success(projectManagementService.inquiry(projectInfo));
    }

    @PostMapping("statisticsByMonth")
    public ResponseData statisticsByMonth() {
        return ResponseData.success(projectManagementService.statisticsByMonth());
    }
}
