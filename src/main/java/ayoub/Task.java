package ayoub;

import java.time.LocalDate;

public class Task {
    private String title ;
    private Status status ;
    private LocalDate dueDqte ;
    private Priority priority ;


    public Task (String title, Status status, LocalDate dueDqte , Priority priority ){
        this.title = title ;
        this.status = status ;
        this.dueDqte = dueDqte ;
        this.priority = priority ;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDueDqte() {
        return dueDqte;
    }

    public void setDueDqte(LocalDate dueDqte) {
        this.dueDqte = dueDqte;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title = ' " + title + '\'' +
                ", status = " + status +
                ", DeadLine = " + dueDqte +
                ",preioriry = " + priority +
                '}';
    }
}
