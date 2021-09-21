
package dev.sergevas.iot.cg.readings.event.model;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class DataItem implements Serializable {

    private final static long serialVersionUID = -7616824780827883909L;

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
        DataItem dataObj = (DataItem) o;
        return Objects.equals(unit, dataObj.unit) && Objects.equals(value, dataObj.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit, value);
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "unit='" + unit + '\'' +
                ", value=" + value +
                '}';
    }
}
