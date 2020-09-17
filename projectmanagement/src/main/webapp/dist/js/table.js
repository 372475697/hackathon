var linechart = echarts.init(document.getElementById("line-chart"));
  var selectPp = $("#selectedPp").val();
//   var emptyDataList = [{
//     "targetRelease": "M1",
//     "ctry": "AP",
//     "jiraCode": "C154345A-657",
//     "projectName": "project-testM1",
//     "projectDescription": "the  project for test",
//     "fitComFirm": "Pending Fitment",
//     "rag": "Green",
//     "remark": "",
//     "status": "Requirements",
//     "als": "12.5",
//     "fms": "0",
//     "ftfg": "0",
//             "im": "0",
//             "rcp": "10",
//             "rm": "0",
//             "ts": "20",
//             "ms": "0",
//             "ba": "Ban A",
//             "pm": "Ban B",
//             "brdDate": "2020-01-15",
//             "uatPlanDate": "2020-01-15",
//             "uatRelDate": "2020-01-15",
//             "createTime": "2020-01-15",
//             "cutoverDate": "2020-01-15",
//             "cutoverMonth": "2020-01",
//             "oppmOwner": "TEST_OWNER",
//             "frRelDate": "2020-01-15",
//     "projectProgress" : "10%"
//             },{
//                 "targetRelease": "M2",
//                 "ctry": "AP",
//                 "jiraCode": "C154345A-657",
//                 "projectName": "project-testM1-01",
//                 "projectDescription": "the  project for test",
//                 "fitComFirm": "Pending Fitment",
//                 "rag": "Amber",
//                 "remark": "",
//                 "status": "Requirements",
//                 "als": "12.5",
//                 "fms": "0",
//                 "ftfg": "0",
//                 "im": "0",
//                 "rcp": "10",
//                 "rm": "0",
//                 "ts": "20",
//                 "ms": "0",
//                 "ba": "Ban A",
//                 "pm": "Ban B",
//                 "brdDate": "2020-01-15",
//                 "uatPlanDate": "2020-01-15",
//                 "uatRelDate": "2020-01-15",
//                 "createTime": "2020-01-15",
//                 "cutoverDate": "2020-01-15",
//                 "cutoverMonth": "2020-01",
//                 "oppmOwner": "TEST_OWNER",
//                 "frRelDate": "2020-01-15",
//                 "projectProgress" : "60%"
//             },{
//                   "targetRelease": "M3",
//                   "ctry": "AP",
//                   "jiraCode": "C154345A-657",
//                   "projectName": "project-testM1-01",
//                   "projectDescription": "the  project for test",
//                   "fitComFirm": "Pending Fitment",
//                   "rag": "Red",
//                   "remark": "",
//                   "status": "Requirements",
//                   "als": "12.5",
//                   "fms": "0",
//                   "ftfg": "0",
//                   "im": "0",
//                   "rcp": "10",
//                   "rm": "0",
//                   "ts": "20",
//                   "ms": "0",
//                   "ba": "Ban A",
//                   "pm": "Ban B",
//                   "brdDate": "2020-01-15",
//                   "uatPlanDate": "2020-01-15",
//                   "uatRelDate": "2020-01-15",
//                   "createTime": "2020-01-15",
//                   "cutoverDate": "2020-01-15",
//                   "cutoverMonth": "2020-01",
//                   "oppmOwner": "TEST_OWNER",
//                   "frRelDate": "2020-01-15",
//                   "projectProgress" : "80%"
//               }];
  var emptyDataList = [];
  
  var maintableOption = {
          paging: true,
          ordering: true,
          searching: false,
          info: false,
          fillter: false,
          pageLength: 10,
          autoWidth: true,
          "scrollX": true,
          "scrollCollapse": true,
          lengthChange: false,
          processing: true,
          select: {
              style: "single"
          },
          data: emptyDataList,
          "fixedColumns": {
              "leftColumns": 3
          },
          "columnDefs": [{
            "targets": [ 25 ],
            "visible": true
          },{
            "targets": [ 26 ],
            "visible": false
          },{
            "targets": [ 27 ],
            "visible": false
          },{
            "targets": [ 28 ],
            "visible": false
          },{
            "targets": [ 29 ],
            "visible": false
          },{
            "targets": [ 30 ],
            "visible": false
          },{
            "targets": [ 31 ],
            "visible": false
          }],
          columns: [{
              title: "Target Release",
              data: "targetRelease",
              sortable: true,
              width: "120px"
          },{
              title: "Market",
              data: "ctry",
              sortable: true,
              width: "100px"
          },{
              title: "JIRA#",
              data: "jiraCode",
              sortable: true,
              width: "100px",
              render: function(data, type, row, meta) {
                return '<a href="#">'+data+'</a>'
              }
          },{
              title: "Project Name(from JIRA)",
              data: "projectName",
              sortable: true,
              width: "220px"
          },{
              title: "RAG",
              data: "rag",
              sortable: true,
              width: "100px",
              render: function(data, type, row, meta) {
                if (data == "Red") {
                  return '<div class="btn bg-danger toastsDefaultDanger" style="width: 120px; cursor: text;">'+data+'</div>'
                } else if (data == "Amber") {
                  return '<div class="btn bg-warning toastsDefaultWarning" style="width: 120px; cursor: text;">'+data+'</div>'
                } else if (data == "Green") {
                  return '<div class="btn bg-success toastsDefaultSuccess" style="width: 120px; cursor: text;">'+data+'</div>'
                }
              }
          },{
              title: "Fitment Confirmation",
              data: "fitComFirm",
              sortable: true,
              width: "200px"
          },{
              title: "SDLC Status",
              data: "status",
              sortable: true,
              width: "100px"
          },{
            title: "Project Progress",
            data: "projectProgress",
            sortable: true,
            width: "250px",
            render: function(data, type, row, meta) {
              if (parseFloat(data) < 50) {
                return '<div class="progress progress-sm" style="width:215px; float: left; margin: 12px 20px 0 0;border-radius: 3px;"><div class="progress-bar bg-danger" style="width: '+data+'%"></div></div><span float: left; class="badge bg-danger">'+data+'%</span>'
              } else if (parseFloat(data) < 75) {
                return '<div class="progress progress-sm" style="width:215px; float: left; margin: 12px 20px 0 0;border-radius: 3px;"><div class="progress-bar bg-warning" style="width: '+data+'%"></div></div><span float: left; class="badge bg-warning">'+data+'%</span>'
              } else {
                return '<div class="progress progress-sm" style="width:215px; float: left; margin: 12px 20px 0 0;border-radius: 3px;"><div class="progress-bar bg-success" style="width: '+data+'%"></div></div><span float: left; class="badge bg-success">'+data+'%</span>'
              }
            }
          },{
              title: "ALS",
              data: "als",
              sortable: true,
              width: "100px"
          },{
              title: "FMS",
              data: "fms",
              sortable: true,
              width: "100px"
          },{
              title: "FTFG",
              data: "ftfg",
              sortable: true,
              width: "100px"
          },{
              title: "IM",
              data: "im",
              sortable: true,
              width: "100px"
          },{
              title: "RCP",
              data: "rcp",
              sortable: true,
              width: "100px"
          },{
            title: "rm",
            data: "rm",
            sortable: true,
            width: "100px"
          },{
              title: "TS",
              data: "ts",
              sortable: true,
              width: "100px"
          },{
              title: "MS",
              data: "ms",
              sortable: true,
              width: "100px"
          },{
              title: "BA Assigned",
              data: "ba",
              sortable: true,
              width: "100px"
          },{
              title: "PM",
              data: "pm",
              sortable: true,
              width: "100px"
          },{
              title: "Total L0",
              data: "totalCapacity",
              width: "100px"
          },{
              title: "Total L1",
              data: "totalCapacity",
              width: "100px"
          },{
              title: "Total L0 for Capacity",
              data: "totalCapacity",
              width: "220px"
          },{
              title: "BRD Recd Date",
              data: "brdDate",
              sortable: true,
              width: "150px"
          },{
            title: "Remarks",
            data: "remark",
            sortable: true,
            width: "100px"
          },{
            title: "SDLC Deliverables",
            width: "150px",
            render: function(data, type, row, meta) {
              return '<a href="#">More info<i class="fas fa-arrow-circle-right"></i></a>'
            }
          },{
            title: "Bitbucket Codes",
            width: "150px",
            render: function(data, type, row, meta) {
              return '<a href="#">More info<i class="fas fa-arrow-circle-right"></i></a>'
            }
          },{
            title: "projectDescription",
            data: "projectDescription"
          },{
            title: "uatPlanDate",
            data: "uatPlanDate"
          },{
            title: "uatRelDate",
            data: "uatRelDate"
          },{
            title: "createTime",
            data: "createTime"
          },{
            title: "cutoverDate",
            data: "cutoverDate"
          },{
            title: "oppmOwner",
            data: "oppmOwner"
          },{
            title: "frRelDate",
            data: "frRelDate"
          },{
              title: "Action",
              width: "100px",
              render: function(data, type, row, meta) {
                return '<button type="button" class="btn btn-table" id="delete"><i class="far fa-trash-alt"></i></button><button type="button" class="btn btn-table" id="update_btn"><i class="fas fa-edit"></i></button>'
              }
          }]
      };
  var table = $("#serviceTable").DataTable(maintableOption);


  function ref(arr) {
      table.clear();
      table.rows.add(arr);
      table.page('first').draw(false);
  }
  function searchList(targetRelease,oppmOwner) {
        var data = {};
        data.targetRelease = targetRelease;
        data.oppmOwner=$("#selectedPp").val();
      $.ajax({
          url: "/projectTracker/inquiry",
          type: "post",
          data:  JSON.stringify(data),
          dataType: "json",
          contentType: "application/json",
          success: function(result) {
            if (result.code == "0000") {
              if (result.object.length > 0) {
                for(var i = 0; i<result.object.length;i++) {
                  var totalBox = result.object[i];
                  totalBox.totalCapacity = parseFloat(totalBox.als) + parseFloat(totalBox.fms) + parseFloat(totalBox.ftfg) + parseFloat(totalBox.im) + parseFloat(totalBox.rcp) + parseFloat(totalBox.ts) + parseFloat(totalBox.ms);
                }

                console.log(result.object)
                ref(result.object);
              } else {
                 ref([]);
              }
            }
          }
        });
  }

var deleteDate = {};
  function deleteBox() {
    $(".delete_po").toggle();
      var row = $("table#serviceTable tr").index($(this).closest("tr"));
      var targetRelease = $("table#serviceTable").find("tr").eq(row).find("td").eq(0).text();
      var ctry = $("table#serviceTable").find("tr").eq(row).find("td").eq(1).text();
      var projectName = $("table#serviceTable").find("tr").eq(row).find("td").eq(3).text();
      console.log("1");
      console.log(row);
      console.log(targetRelease);
      console.log(ctry);
      console.log(projectName);
      console.log("2");
      deleteDate = {};
      deleteDate.targetRelease = targetRelease;
      deleteDate.ctry = ctry;
      deleteDate.projectName = projectName;
      console.log("delete");
      console.log(deleteDate);
      console.log("delete");
  }
  function deleteBoxClose() {
      $(".delete_po").toggle();
  }
  function deleteList() {
        $.ajax({
          url: "/projectTracker/delete",
          type: "post",
          data:  JSON.stringify(deleteDate),
          dataType: "json",
          contentType: "application/json",
          success: function(result) {
            if (result.code == "0000") {
              searchList(deleteDate.targetRelease,selectPp);
            }
          }
        });
  }


  function newBox() {
    $(".new_po").toggle();
    clearInput();
  }
  function newList() {
    var data = {};
    data.targetRelease = $("#target_release_select").val();
    data.ctry = $("#market").val();
    data.jiraCode = $("#jira").val();
    data.projectName = $("#project_name").val();
    data.projectDescription = $("#project_description").val("");;
    data.rag = "0";
    data.fitComFirm = $("#fitment_confirmation").val();
    data.status = $("#sdlc_select").val();
    data.als = $("#als").val();
    data.fms = $("#fms").val();
    data.ftfg = $("#ftfg").val();
    data.im = $("#im").val();
    data.rcp = $("#rcp").val();
    data.rm = $("#rm").val();
    data.ts = $("#ts").val();
    data.ms = $("#ms").val();
    data.ba = $("#ba_assigned").val();
    data.pm = $("#pm").val();
    data.brdDate = $("#brd_date").val();
    data.remark = $("#remarks").val();
    data.uatPlanDate = $("#uat_date").val();
    data.uatRelDate = $("#uat_rel_date").val();
    data.createTime = $("#create_date").val()+" 00:00:01";
    data.cutoverDate = $("#cutover_date").val();
    data.oppmOwner = $("#oppm_owner").val();
    data.frRelDate = $("#fr_date").val();
    $.ajax({
      url: "/projectTracker/add",
      type: "post",
      data:  JSON.stringify(data),
      dataType: "json",
      contentType: "application/json",
      success: function(result) {
        if (result.code == "0000") {
          searchList("",selectPp);
          newBox();
          clearInput();
        }
      }
    });
  }
  function clearInput() {
    $("#target_release_select").val("M1");
    $("#market").val("");
    $("#jira").val("");
    $("#project_name").val("");
    $("#project_description").val("");
    $("#rag_select").val("R");
    $("#fitment_confirmation").val("");
    $("#sdlc_select").val("Requirements");
    $("#als").val("");
    $("#fms").val("");
    $("#ftfg").val("");
    $("#im").val("");
    $("#rcp").val("");
    $("#rm").val("");
    $("#ts").val("");
    $("#ms").val("");
    $("#ba_assigned").val("");
    $("#pm").val("");
    $("#brd_date").val("");
    $("#remarks").val("");
    $("#uat_date").val("");
    $("#uat_rel_date").val("");
    $("#create_date").val("");
    $("#cutover_date").val("");
    $("#oppm_owner").val("");
    $("#fr_date").val("");
  }

  function updateBox() {
    $(".update_po").toggle();
    updateClear();
  }
  function updateList() {
        var data = {};
        data.targetRelease = $("#target_select2").text();
        data.ctry = $("#market2").text();
        data.jiraCode = $("#jira2").val();
        data.projectName = $("#project_name2").val();
        data.projectDescription = $("#project_description2").val();
        data.rag = "0";
        data.fitComFirm = $("#fitment_confirmation2").val();
        data.status = $("#sdlc_select2").val();
        data.als = $("#als2").val();
        data.fms = $("#fms2").val();
        data.ftfg = $("#ftfg2").val();
        data.im = $("#im2").val();
        data.rcp = $("#rcp2").val();
        data.rm = $("#rm2").val();
        data.ts = $("#ts2").val();
        data.ms = $("#ms2").val();
        data.ba = $("#ba_assigned2").val();
        data.pm = $("#pm2").val();
        data.brdDate = $("#brd_date2").val();
        data.remark = $("#remarks2").val();
        data.uatPlanDate = $("#uat_date2").val();
        data.uatRelDate = $("#uat_rel_date2").val();
        data.createTime = $("#create_date2").val()+" 00:00:01";
        data.cutoverDate = $("#cutover_date2").val();
        data.oppmOwner = $("#oppm_owner2").val();
        data.frRelDate = $("#fr_date2").val();
        console.log("update")
        console.log(data)
        console.log("update")
        $.ajax({
          url: "/projectTracker/update",
          type: "post",
          data:  JSON.stringify(data),
          dataType: "json",
          contentType: "application/json",
          success: function(result) {
            if (result.code == "0000") {
              searchList("",selectPp);
              updateBox();
            }
          }
        });
  }
  function updateShow() {
    updateBox();
    var updateDate = [];
    var row = $("table#serviceTable tr").index($(this).closest("tr"));
    var targetRelease = $("table#serviceTable").find("tr").eq(row).find("td").eq(0).text();
    var ctry = $("table#serviceTable").find("tr").eq(row).find("td").eq(1).text();
    var projectName = $("table#serviceTable").find("tr").eq(row).find("td").eq(3).text();
    var data = {};
    data.targetRelease = targetRelease;
    data.ctry = ctry;
    data.projectName = projectName;
      console.log("1");
    console.log(data);
  $.ajax({
      url: "/projectTracker/inquiry",
      type: "post",
      data:  JSON.stringify(data),
      dataType: "json",
      contentType: "application/json",
      success: function(result) {
        if (result.code == "0000") {
          if (result.object.length > 0) {
            console.log(result.object)
            updateDate = result.object[0];
              console.log("2");
              console.log(updateDate);
              console.log(updateDate.targetRelease);
              console.log("3");
              $("#target_select2").text(updateDate.targetRelease);
              $("#market2").text(updateDate.ctry);
              $("#jira2").val(updateDate.jiraCode);
              $("#project_name2").val(updateDate.projectName);
              $("#project_description2").val(updateDate.projectDescription);
              $("#fitment_confirmation2").val(updateDate.fitComFirm);
              $("#sdlc_select2").val(updateDate.status);
              $("#als2").val(updateDate.als);
              $("#fms2").val(updateDate.fms);
              $("#ftfg2").val(updateDate.ftfg);
              $("#im2").val(updateDate.im);
              $("#rcp2").val(updateDate.rcp);
              $("#rm2").val(updateDate.rm);
              $("#ts2").val(updateDate.ts);
              $("#ms2").val(updateDate.ms);
              $("#ba_assigned2").val(updateDate.ba);
              $("#pm2").val(updateDate.pm);
              $("#brd_date2").val(updateDate.brdDate);
              $("#remarks2").val(updateDate.remark);
              $("#uat_date2").val(updateDate.uatPlanDate);
              $("#uat_rel_date2").val(updateDate.uatRelDate);
              $("#create_date2").val(updateDate.createTime);
              $("#cutover_date2").val(updateDate.cutoverDate);
              $("#oppm_owner2").val(updateDate.oppmOwner);
              $("#fr_date2").val(updateDate.frRelDate);
          }
        }
      }
    });

  }
  function updateClear() {
    $("#target_select2").text("");
    $("#market2").text("");
    $("#jira2").val("");
    $("#project_name2").val("");
    $("#rag_select2").val("");
    $("#fitment_confirmation2").val("");
    $("#sdlc_select2").val("");
    $("#als2").val("");
    $("#fms2").val("");
    $("#ftfg2").val("");
    $("#im2").val("");
    $("#rcp2").val("");
    $("#rm2").val("");
    $("#ts2").val("");
    $("#ms2").val("");
    $("#ba_assigned2").val("");
    $("#pm2").val("");
    $("#brd_date2").val("");
    $("#remarks2").val("");
    $("#uat_date2").val("");
    $("#create_date2").val("");
    $("#cutover_date2").val("");
    $("#oppm_owner2").val("");
    $("#fr_date2").val("");
  }

  $(function () {
    // for(var i = 0; i<emptyDataList.length;i++) {
    //   var totalBox = emptyDataList[i];
    //   totalBox.totalCapacity = parseFloat(totalBox.als) + parseFloat(totalBox.fms) + parseFloat(totalBox.ftfg) + parseFloat(totalBox.im) + parseFloat(totalBox.rcp) + parseFloat(totalBox.ts) + parseFloat(totalBox.ms);
    // }
    // console.log(emptyDataList)
    // var table = $("#serviceTable").DataTable(maintableOption);
    searchList("","ALL");
    $("#refreshButton").click(function() {
      searchList("",selectPp);
    });
    $("#selectedPp").change(function() {
      searchList("",selectPp);
    })
    linechart.on("click",function(params) {
      searchList(params.name,selectPp);
    })
    $("#serviceTable tbody").on("click", "#delete",deleteBox);
    $("#serviceTable tbody").on("click", "#update_btn",updateShow);
    $("#delete_y").click(function() {
      deleteList();
        deleteBoxClose();
    })
    $("#delete_n").click(function() {
        deleteBoxClose();
    })
    $("#new_btn").click(function() {
      newBox();
    })
    $("#new_n").click(function() {
      newBox();
    })

    $("#update_n").click(function() {
      updateBox();
    })
    
    $('#brd_date').inputmask('yyyy-mm-dd', { 'placeholder': 'yyyy-mm-dd' })
    $('#uat_date').inputmask('yyyy-mm-dd', { 'placeholder': 'yyyy-mm-dd' })
    $('#uat_rel_date').inputmask('yyyy-mm-dd', { 'placeholder': 'yyyy-mm-dd' })
    $('#create_date').inputmask('yyyy-mm-dd', { 'placeholder': 'yyyy-mm-dd' })
    $('#cutover_date').inputmask('yyyy-mm-dd', { 'placeholder': 'yyyy-mm-dd' })
    $('#fr_date').inputmask('yyyy-mm-dd', { 'placeholder': 'yyyy-mm-dd' })
    $('#brd_date2').inputmask('yyyy-mm-dd', { 'placeholder': 'yyyy-mm-dd' })
    $('#uat_date2').inputmask('yyyy-mm-dd', { 'placeholder': 'yyyy-mm-dd' })
    $('#uat_rel_date2').inputmask('yyyy-mm-dd', { 'placeholder': 'yyyy-mm-dd' })
    $('#create_date2').inputmask('yyyy-mm-dd', { 'placeholder': 'yyyy-mm-dd' })
    $('#cutover_date2').inputmask('yyyy-mm-dd', { 'placeholder': 'yyyy-mm-dd' })
    $('#fr_date2').inputmask('yyyy-mm-dd', { 'placeholder': 'yyyy-mm-dd' })
    $("#new_y").click(function() {
      newList();
    });
    $("#update_y").click(function() {
      updateList();
    });
  });