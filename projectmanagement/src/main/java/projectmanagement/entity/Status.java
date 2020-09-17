package projectmanagement.entity;

public enum Status {
    requirements("requirements",10),
    sizing("sizing",20),
    FR("FR",30),
    dev("dev",60),
    UAT("uat",80),
    implemented("implemented",100),
    support("support",100);

    private String status;
    private int progress;

    Status(String status, int progress) {
        this.status = status;
        this.progress = progress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public static String getProgress(String status){
        for (Status s: Status.values()) {
            if (s.status.equalsIgnoreCase(status)){
                return s.getProgress()+"";
            }
        }
        return "0";
    }
}
