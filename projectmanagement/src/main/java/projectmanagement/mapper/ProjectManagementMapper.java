package projectmanagement.mapper;

import projectmanagement.entity.StatisticsInfo;
import projectmanagement.entity.ProjectInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectManagementMapper {

    @Insert("INSERT INTO project_tracker VALUES(#{targetRelease},#{ctry},#{jiraCode},#{projectName},#{projectDescription},#{fitComFirm},#{rag},#{remark},#{status},#{als},#{fms},#{ftfg},#{im},#{rcp},#{rm},#{ts},#{ms},#{ba},#{pm},#{brdDate},#{uatPlanDate},#{uatRelDate},#{createTime},#{cutoverMonth},#{cutoverDate},#{oppmOwner},#{frRelDate})")
    int add(ProjectInfo projectInfo);

    @Delete("DELETE FROM project_tracker WHERE TARGET_RELEASE=#{targetRelease} AND CTRY=#{ctry} AND PROJECT_NAME=#{projectName}")
    int delete(ProjectInfo projectInfo);

    @Update("UPDATE project_tracker SET TARGET_RELEASE=#{targetRelease},CTRY=#{ctry},JIRA_CODE=#{jiraCode},PROJECT_NAME=#{projectName},PROJECT_DESCRIPTION=#{projectDescription},FIT_COMFIRM=#{fitComFirm},RAG=#{rag},REMARK=#{remark},STATUS=#{status},ALS=#{als},FMS=#{fms},FTFG=#{ftfg},IM=#{im},RCP=#{rcp},RM=#{rm},TS=#{ts},MS=#{ms},BA=#{ba},PM=#{pm},BRD_DATE=#{brdDate},UAT_PLAN_DATE=#{uatPlanDate},UAT_RELDATE=#{uatRelDate},CREATE_TIME=#{createTime},CUTOVER_DATE=#{cutoverDate},CUTOVER_YM=#{cutoverMonth},OPPM_OWNER=#{oppmOwner},FR_RELDATE=#{frRelDate} WHERE TARGET_RELEASE=#{targetRelease} AND CTRY=#{ctry} AND PROJECT_NAME=#{projectName}")
    int update(ProjectInfo projectInfo);

    @Select("<script>select * from project_tracker where 1=1 <if test='cutoverMonth !=null and cutoverMonth !=\"\"'>and CUTOVER_YM=#{cutoverMonth} </if></script>")
    @Results({
            @Result(property ="targetRelease", column = "TARGET_RELEASE"),
            @Result(property ="ctry", column = "CTRY"),
            @Result(property ="jiraCode", column = "JIRA_CODE"),
            @Result(property ="projectName", column = "PROJECT_NAME"),
            @Result(property ="projectDescription", column = "PROJECT_DESCRIPTION"),
            @Result(property ="fitComFirm", column = "FIT_COMFIRM"),
            @Result(property ="rag", column = "RAG"),
            @Result(property ="remark", column = "REMARK"),
            @Result(property ="status", column = "STATUS"),
            @Result(property ="als", column = "ALS"),
            @Result(property ="fms", column = "FMS"),
            @Result(property ="ftfg", column = "FTFG"),
            @Result(property ="im", column = "IM"),
            @Result(property ="rcp", column = "RCP"),
            @Result(property ="rm", column = "RM"),
            @Result(property ="ts", column = "TS"),
            @Result(property ="ms", column = "MS"),
            @Result(property ="ba", column = "BA"),
            @Result(property ="pm", column = "PM"),
            @Result(property ="brdDate", column = "BRD_DATE"),
            @Result(property ="uatPlanDate", column = "UAT_PLAN_DATE"),
            @Result(property ="uatRelDate", column = "UAT_RELDATE"),
            @Result(property ="createTime", column = "CREATE_TIME"),
            @Result(property ="cutoverMonth", column = "CUTOVER_YM"),
            @Result(property ="cutoverDate", column = "CUTOVER_DATE"),
            @Result(property ="oppmOwner", column = "OPPM_OWNER"),
            @Result(property ="frRelDate", column = "FR_RELDATE")
    })
    List<ProjectInfo> inquiry(ProjectInfo projectInfo);

    @Select("<script>select count(*) count, TARGET_RELEASE targetRelease from project_tracker "
    		+ "<if test='pp !=null'>where ${pp} > 0 </if>"
    		+ "group by TARGET_RELEASE order by TARGET_RELEASE </script>")
    @Results({
            @Result(property ="count", column = "count"),
            @Result(property ="targetRelease", column = "targetRelease")
    })
    List<StatisticsInfo> statisticsByMonth(@Param("pp") String pp);
}
