package dev.sergevas.iot.cg.readings.poller.controller;

import dev.sergevas.iot.cg.readings.poller.model.TaskType;
import io.vertx.core.eventbus.EventBus;
import org.jboss.logging.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.inject.Inject;

@DisallowConcurrentExecution
public class BaseJob implements Job {

    @Inject
    Logger logger;

    @Inject
    EventBus eventBus;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("Execute a Quartz Job with a context: " + jobExecutionContext);
        eventBus.send(TaskType.TASK_CODE, jobExecutionContext
                .getJobDetail()
                .getJobDataMap()
                .getString(TaskType.TASK_CODE));
    }
}
