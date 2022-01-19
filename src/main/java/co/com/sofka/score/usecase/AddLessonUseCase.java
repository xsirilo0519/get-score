package co.com.sofka.score.usecase;

import co.com.sofka.score.domain.course.Course;
import co.com.sofka.score.domain.course.command.AddLessonCommand;

import co.com.sofka.score.domain.generic.DomainEvent;
import co.com.sofka.score.domain.generic.EventStoreRepository;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class AddLessonUseCase implements Function<AddLessonCommand, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public AddLessonUseCase(EventStoreRepository repository){
    this.repository=repository;
    }

    @Override
    public List<DomainEvent> apply(AddLessonCommand command) {
        var events=repository.getEventsBy("course",command.getCourseId());
        var course=Course.from(command.getCourseId(),events);
        course.addLesson(command.getLessonId(),command.getName());
        return course.getUncommittedChanges();
    }
}
