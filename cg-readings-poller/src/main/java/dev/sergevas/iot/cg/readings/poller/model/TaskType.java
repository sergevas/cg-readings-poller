package dev.sergevas.iot.cg.readings.poller.model;

import dev.sergevas.iot.cg.readings.poller.boundary.RequirementsNotSatisfiedException;

import java.util.Arrays;

public enum TaskType {

    LIGHT("LIGHT", "lightJob", "lightTrigger", 10),
    THP("THP", "thpJob", "thpTrigger", 10),
    CAMERA_MODE("CAMERA_MODE", "cameraModeJob", "cameraModeTrigger", 30),
    CAMERA_IMAGE("CAMERA_IMAGE", "cameraImageJob", "cameraImageTrigger", 300),
    HEALTH("HEALTH", "healthJob", "healthTrigger", 30);

    public static final String CG_READINGS_POLLER = "CG_READINGS_POLLER";
    public static final String TASK_CODE = "taskCode";

    private String code;
    private String jobName;
    private String triggerName;
    private int intervalInSeconds;

    TaskType(String code, String jobName, String triggerName, int intervalInSeconds) {
        this.code = code;
        this.jobName = jobName;
        this.triggerName = triggerName;
        this.intervalInSeconds = intervalInSeconds;
    }

    public String getCode() {
        return code;
    }

    public String getJobName() {
        return jobName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public int getIntervalInSeconds() {
        return intervalInSeconds;
    }

    public static TaskType getByCode(String code) {
        return Arrays.stream(TaskType.values())
                .filter(t -> t.code.equals(code))
                .findAny()
                .orElseThrow(() -> new RequirementsNotSatisfiedException(String.format("Illegal task code [%s]", code)));
    }

    @Override
    public String toString() {
        return "TaskType{" +
                "code='" + code + '\'' +
                ", jobName='" + jobName + '\'' +
                ", triggerName='" + triggerName + '\'' +
                ", intervalInSeconds=" + intervalInSeconds +
                '}';
    }
}
