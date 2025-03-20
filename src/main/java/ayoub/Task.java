package ayoub;

import java.time.LocalDate;

public class Task {
    private String title ;
    private Status status ;
    private LocalDate dueDate;
    private Priority priority ;


    public Task(String title, Status status, LocalDate dueDate, Priority priority) {
        this.title = title;
        this.status = status;
        this.dueDate = dueDate;
        this.priority = priority;
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDqte(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "📌 " + title + " [" + status + "] Due: " + dueDate + " Priority: " + priority;
    }
}
