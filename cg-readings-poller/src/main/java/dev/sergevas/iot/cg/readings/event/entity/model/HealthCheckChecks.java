package dev.sergevas.iot.cg.readings.event.entity.model;


import javax.json.bind.annotation.JsonbProperty;
import java.util.Objects;


public class HealthCheckChecks {
  
  @JsonbProperty("name")
  private String name;

  @JsonbProperty("status")
  private String status;

  @JsonbProperty("data")
  private Object data;
  
 /**
   * Get name
   * @return name
  **/
  public String getName() {
    return name;
  }

  /**
    * Set name
  **/
  public void setName(String name) {
    this.name = name;
  }

  public HealthCheckChecks name(String name) {
    this.name = name;
    return this;
  }

 /**
   * Get status
   * @return status
  **/
  public String getStatus() {
    return status;
  }

  /**
    * Set status
  **/
  public void setStatus(String status) {
    this.status = status;
  }

  public HealthCheckChecks status(String status) {
    this.status = status;
    return this;
  }

 /**
   * Get data
   * @return data
  **/
  public Object getData() {
    return data;
  }

  /**
    * Set data
  **/
  public void setData(Object data) {
    this.data = data;
  }

  public HealthCheckChecks data(Object data) {
    this.data = data;
    return this;
  }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthCheckChecks that = (HealthCheckChecks) o;
        return Objects.equals(name, that.name) && Objects.equals(status, that.status) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, status, data);
    }

    @Override
    public String toString() {
        return "HealthCheckSchemaChecks{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
