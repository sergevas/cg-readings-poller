package dev.sergevas.iot.cg.readings.poller.controller;

import dev.sergevas.iot.cg.readings.poller.boundary.TaskCode;
import dev.sergevas.iot.cg.readings.poller.model.TaskType;
import org.jboss.logging.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class BaseJob implements Job {

    @Inject
    Logger  logger;

    @Inject
    Event<TaskCode> event;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("Execute a Quartz Job with a context: " + jobExecutionContext);
        event.fire(new TaskCode().code(jobExecutionContext
                .getJobDetail()
                .getJobDataMap()
                .getString(TaskType.TASK_TYPE_CODE)));
    }
}
