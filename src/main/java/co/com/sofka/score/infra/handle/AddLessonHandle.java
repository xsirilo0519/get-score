package co.com.sofka.score.infra.handle;

import co.com.sofka.score.domain.course.command.AddLessonCommand;
import co.com.sofka.score.domain.course.command.ConfigureCourseCommand;
import co.com.sofka.score.infra.generic.UseCaseHandle;
import co.com.sofka.score.usecase.AddLessonUseCase;
import co.com.sofka.score.usecase.ConfigureCourseUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AddLessonHandle extends UseCaseHandle {
    private final AddLessonUseCase useCase;


    public AddLessonHandle(AddLessonUseCase useCase) {
        this.useCase = useCase;
    }

    @ConsumeEvent(value = "sofkau.course.addLesson")
    void consumeBlockingG(AddLessonCommand command) {
        var events = useCase.apply(command);
        process(command.getCourseId(), events);
    }
}
