package co.com.sofka.score.usecase;

import co.com.sofka.score.domain.course.Course;
import co.com.sofka.score.domain.course.command.ConfigureCourseCommand;
import co.com.sofka.score.domain.generic.DomainEvent;

import java.util.List;
import java.util.function.Function;

public class ConfigureCourseUseCase implements Function<ConfigureCourseCommand, List<DomainEvent>> {
    @Override
    public List<DomainEvent> apply(ConfigureCourseCommand command) {
        var course=new Course(command.getCourseId(),command.getName());
        return course.getUncommittedChanges();
    }
}
