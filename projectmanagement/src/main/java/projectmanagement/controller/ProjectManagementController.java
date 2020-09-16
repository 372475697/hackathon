package com.projectmanagement.controller;


import com.projectmanagement.entity.ProjectInfo;
import com.projectmanagement.entity.ResponseData;
import com.projectmanagement.service.ProjectManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("projectTracker")
@CrossOrigin
public class ProjectManagementController {

    @Autowired
    private ProjectManagementService projectManagementService;

    @PostMapping("add")
    public ResponseData add(@RequestBody ProjectInfo projectInfo) {
        return projectManagementService.add(projectInfo);
    }

    @PostMapping("delete")
    public ResponseData delete(@RequestBody ProjectInfo projectInfo) {
        return projectManagementService.delete(projectInfo);

    }

    @PostMapping("update")
    public ResponseData update(@RequestBody ProjectInfo projectInfo) {
        return projectManagementService.update(projectInfo);
    }

    @PostMapping("inquiry")
    public ResponseData inquiry(@RequestBody ProjectInfo projectInfo) {
        return projectManagementService.inquiry(projectInfo);
    }

    @GetMapping("statisticsByMonth")
    public ResponseData statisticsByMonth(@RequestParam String pp) {
        return projectManagementService.statisticsByMonth(pp);
    }
}