package rotateit.uidto;

public class UiPullRequest {
    private final UiTeam assignedTeam;
    private final String title;
    private final String url;
    private final long startTime;


    public UiPullRequest(String title, String url, UiTeam assignedTeam) {
        this.title = title;
        this.url = url;
        this.assignedTeam = assignedTeam;
        startTime = System.currentTimeMillis();
    }

    public UiTeam getAssignedTeam() {
        return assignedTeam;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public long getStartTime() {
        return startTime;
    }
}
