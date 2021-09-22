
package dev.sergevas.iot.cg.readings.event.model;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class DataItem implements Serializable {

    private final static long serialVersionUID = -7616824780827883909L;

    /**
     * A type of a sensor or device
     * (Required)
     *
     */
    @JsonbProperty("type")
    @NotNull
    private String type;

    /**
     * A unit of measurement name
     * (Required)
     * 
     */
    @JsonbProperty("unit")
    @NotNull
    private String unit;
    /**
     * The readings value
     * (Required)
     * 
     */
    @JsonbProperty("value")
    @NotNull
    private Object value;

    /**
     * A type of a sensor or device
     * (Required)
     *
     */
    public String getType() {
        return type;
    }

    /**
     * A type of a sensor or device
     * (Required)
     *
     */
    public void setType(String type) {
        this.type = type;
    }

    public DataItem withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * A unit of measurement name
     * (Required)
     * 
     */
    public String getUnit() {
        return unit;
    }

    /**
     * A unit of measurement name
     * (Required)
     * 
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public DataItem withUnit(String unit) {
        this.unit = unit;
        return this;
    }

    /**
     * The readings value
     * (Required)
     * 
     */
    public Object getValue() {
        return value;
    }

    /**
     * The readings value
     * (Required)
     * 
     */
    public void setValue(Object value) {
        this.value = value;
    }

    public DataItem withValue(Object value) {
        this.value = value;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataItem dataItem = (DataItem) o;
        return Objects.equals(type, dataItem.type) && Objects.equals(unit, dataItem.unit) && Objects.equals(value, dataItem.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, unit, value);
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "type='" + type + '\'' +
                ", unit='" + unit + '\'' +
                ", value=" + value +
                '}';
    }
}
