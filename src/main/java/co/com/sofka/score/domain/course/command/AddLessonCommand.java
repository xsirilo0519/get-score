package co.com.sofka.score.domain.course.command;

import co.com.sofka.score.domain.generic.Command;

public class AddLessonCommand extends Command {
    private String courseId;
    private String name;
    private String lessonId;

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

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
