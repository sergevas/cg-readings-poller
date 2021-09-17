package dev.sergevas.iot.cg.readings.poller.controller;

import dev.sergevas.iot.cg.readings.poller.model.TaskType;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;
import org.quartz.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.Arrays;

@ApplicationScoped
public class PollerSchedulerService {

    @Inject
    Logger logger;

    @Inject
    Scheduler scheduler;

    public void onStart(@Observes StartupEvent event) {
        logger.info(PollerSchedulerService.class.getName() + ".onStart() " + event);
        Arrays.stream(TaskType.values())
                .forEach(t -> {
                    logger.info("Have got TaskType instance: " + t);
                    JobDetail job = JobBuilder.newJob(BaseJob.class)
                            .withIdentity(t.getJobName(), TaskType.CG_READINGS_POLLER)
                            .usingJobData(TaskType.TASK_TYPE_CODE, t.getCode())
                            .build();
                    Trigger trigger = TriggerBuilder.newTrigger()
                            .withIdentity(t.getTriggerName(), TaskType.CG_READINGS_POLLER)
                            .startNow()
                            .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                                    .withIntervalInSeconds(t.getIntervalInSeconds())
                                    .withMisfireHandlingInstructionNextWithRemainingCount()
                                    .repeatForever())
                            .build();
                    try {
                        scheduler.scheduleJob(job, trigger);
                    } catch (SchedulerException se) {
                        logger.error(String.format("Unable to schedule the job [%s]", t), se);
                    }
                });
    }
}
