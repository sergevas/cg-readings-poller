package dev.sergevas.iot.cg.readings.poller.model;

import dev.sergevas.iot.cg.readings.poller.boundary.RequirementsNotSatisfiedException;

import java.util.Arrays;

public enum TaskType {
    LIGHT("LIGHT", "lightJob", "lightTrigger"),
    THP("THP", "thpJobe", "thpTrigger"),
    CAMERA_MODE("CAMERA_MODE", "cameraModeJob", "cameraModeTrigger"),
    HEALTH("HEALTH", "healthJob", "healthTrigger");

    private String code;
    private String jobName;
    private String triggerName;

    private TaskType(String code, String jobName, String triggerName) {
        this.code = code;
        this.jobName = jobName;
        this.triggerName = triggerName;
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

    public static TaskType getByCode(String code) {
        return Arrays.stream(TaskType.values())
                .filter(tt -> tt.code.equals(code))
                .findAny()
                .orElseThrow(() -> new RequirementsNotSatisfiedException("Illegal task code: " + code));
    }
}
