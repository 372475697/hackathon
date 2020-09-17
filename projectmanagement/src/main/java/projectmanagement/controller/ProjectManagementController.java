package projectmanagement.controller;


import projectmanagement.entity.ProjectInfo;
import projectmanagement.entity.ResponseData;
import projectmanagement.service.ProjectManagementService;
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
        try {
            return projectManagementService.add(projectInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.fail("1000","add data fail");
        }
    }

    @PostMapping("delete")
    public ResponseData delete(@RequestBody ProjectInfo projectInfo) {
        try {
            return projectManagementService.delete(projectInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.fail("1000","delete data fail");
        }

    }

    @PostMapping("update")
    public ResponseData update(@RequestBody ProjectInfo projectInfo) {
        try {
            return projectManagementService.update(projectInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.fail("1000","update data fail");
        }
    }

    @PostMapping("inquiry")
    public ResponseData inquiry(@RequestBody ProjectInfo projectInfo) {
        try {
            return projectManagementService.inquiry(projectInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.fail("1000","inquiry data fail");
        }
    }

    @GetMapping("statisticsByMonth")
    public ResponseData statisticsByMonth(@RequestParam String pp) {
        try {
            return projectManagementService.statisticsByMonth(pp);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.fail("1000", "inquiry data fail");
        }
    }
}