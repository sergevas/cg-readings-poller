package dev.sergevas.iot.cg.readings.poller.scheduler.model;

import java.util.Objects;

public class TaskCode {

    private String code;

    public String getCode() {
        return code;
    }

    public TaskCode code(String code) {
        this.code = code;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskCode taskCode = (TaskCode) o;
        return Objects.equals(code, taskCode.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "TaskCode{" +
                "code='" + code + '\'' +
                '}';
    }
}
