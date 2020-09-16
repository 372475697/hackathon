package com.projectmanagement.mapper;

public class Test {
    public static void main(String [] args){
        String string2="`TARGET_RELEASE\n" +
                "  `CTRY\n" +
                "  `JIRA_CODE\n" +
                "  `PROJECT_NAME\n" +
                "  `PROJECT_DESCRIPTION\n" +
                "  `FIT_COMFIRM\n" +
                "  `RAG\n" +
                "            `REMARK\n" +
                "  `STATUS\n" +
                "            `ALS\n" +
                "            `FMS\n" +
                "            `FTFG\n" +
                "            `IM\n" +
                "            `RCP\n" +
                "            `RM\n" +
                "            `TS\n" +
                "            `MS\n" +
                "            `BA\n" +
                "  `PM\n" +
                "  `BRD_DATE\n" +
                "            `UAT_PLAN_DATE\n" +
                "            `UAT_RELDATE\n" +
                "            `CREATE_TIME\n" +
                "            `CUTOVER_DATE";
        String[] array2=string2.split("`");

        String string="private String  targetRelease;\n" +
                "    private String  ctry;\n" +
                "    private String  jiraCode;\n" +
                "    private String  projectName;\n" +
                "    private String  projectDescription;\n" +
                "    private String  fitComFirm;\n" +
                "    private String  rag;\n" +
                "    private String  remark;\n" +
                "    private String  status;\n" +
                "    private String  als;\n" +
                "    private String  fms;\n" +
                "    private String  ftfg;\n" +
                "    private String  im;\n" +
                "    private String  rcp;\n" +
                "    private String  rm;\n" +
                "    private String  ts;\n" +
                "    private String  ms;\n" +
                "    private String  ba;\n" +
                "    private String  pm;\n" +
                "    private String  brdDate;\n" +
                "    private String  uatPlanDate;\n" +
                "    private String  uatRelDate;\n" +
                "    private String  createTime;\n" +
                "    private String  cutoverDate;\n" +
                "    private String  cutoverMonth;";

        String[] array=string.split("private String");
        for (int i = 0; i <array2.length ; i++) {
            //System.out.print(array2[i].trim()+"=#{"+array[i].replace(";","").trim()+"},");
            System.out.println("@Result(property =\""+array[i].replace(";","").trim()+"\", column = \""+array2[i].trim()+"\"),");
        }
    }
}
