package dev.sergevas.iot.cg.readings.poller.controller;

import dev.sergevas.iot.cg.readings.poller.model.TaskType;
import io.quarkus.runtime.StartupEvent;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.Arrays;

@ApplicationScoped
public class PollerTaskService {

    @Inject
    Scheduler scheduler;

    public void onStart(@Observes StartupEvent event) throws SchedulerException {
        Arrays
                .stream(TaskType.values())
                .forEach(t -> {

                });

    }


}
