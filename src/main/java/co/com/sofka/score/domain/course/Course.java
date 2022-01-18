package co.com.sofka.score.domain.course;

import co.com.sofka.score.domain.course.event.CourseCreated;
import co.com.sofka.score.domain.course.event.LessonAdded;
import co.com.sofka.score.domain.generic.AggregateRoot;
import co.com.sofka.score.domain.generic.DomainEvent;
import co.com.sofka.score.domain.generic.EventChange;

import java.util.*;

public class Course extends AggregateRoot implements EventChange {

    protected Map<String,Lesson> lessons;
    protected String name;
    public Course(String id,String name) {
        super(id);
        subscribe(new CourseEventChange(this));
        appendChange(new CourseCreated(id,name)).apply();
    }

    public Course(String courseId) {
        super(courseId);
        subscribe(new CourseEventChange(this));
    }

    public static Course from(String courseId, List<DomainEvent> events) {
        var course=new Course(courseId);
        events.forEach(course::applyEvent);
        return course;
    }


    public void addLesson(String id,String name){
        this.lessons.put(id,new Lesson(id,name));
        appendChange(new LessonAdded(id,name)).apply();
    }

    public void addStudentToLesson(String lessonId, String name,String email){
        this.lessons.get(lessonId).addStudent(name,email);
    }

    public void addScoreToStudentToLesson(String lessonId,String email,Score score){
        this.lessons.get(lessonId).students().get(email).eval(score);
    }

    private Lesson findLessionsById(String id){
        return this.lessons.get(id);
    }

    public String name() {
        return name;
    }
}
