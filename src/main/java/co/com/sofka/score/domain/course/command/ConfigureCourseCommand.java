package co.com.sofka.score.domain.course.command;

import co.com.sofka.score.domain.generic.Command;

public class ConfigureCourseCommand extends Command {
    private String courseId;
    private String name;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
