package co.com.sofka.score.infra.handle;

import co.com.sofka.score.domain.course.command.ConfigureCourseCommand;
import co.com.sofka.score.infra.generic.UseCaseHandle;
import co.com.sofka.score.usecase.ConfigureCourseUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConfigureCourseHandle extends UseCaseHandle {
    private final ConfigureCourseUseCase useCase;


    public ConfigureCourseHandle(ConfigureCourseUseCase useCase) {
        this.useCase = useCase;
    }

    @ConsumeEvent(value = "sofkau.course.create")
    void consumeBlocking(ConfigureCourseCommand command) {
        var events = useCase.apply(command);
        process(command.getCourseId(), events);
    }
}
