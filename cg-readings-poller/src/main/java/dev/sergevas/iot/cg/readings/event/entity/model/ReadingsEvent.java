
package dev.sergevas.iot.cg.readings.event.entity.model;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;


/**
 * LightEvent
 * <p>
 * Represents an IoT device domain event, containing ambient light readings data,
 * for communication support between components of the system
 * 
 */
public class ReadingsEvent extends BaseEvent implements Serializable {

    private final static long serialVersionUID = 190772222892827935L;

    /**
     * 
     * (Required)
     * 
     */
    @JsonbProperty("data")
    @Valid
    @NotNull
    private DataItem data;

    /**
     * 
     * (Required)
     * 
     */
    public DataItem getData() {
        return data;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setData(DataItem data) {
        this.data = data;
    }

    public ReadingsEvent withData(DataItem data) {
        this.data = data;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ReadingsEvent that = (ReadingsEvent) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), data);
    }

    @Override
    public String toString() {
        return "ReadingsEvent{" +
                "data=" + data +
                '}';
    }
}
