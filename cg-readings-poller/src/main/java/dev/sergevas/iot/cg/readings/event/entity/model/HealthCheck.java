package dev.sergevas.iot.cg.readings.event.entity.model;

import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class HealthCheck extends BaseEvent implements Serializable {

  @JsonbProperty("status")
  private String status;

  @JsonbProperty("checks")
  private List<HealthCheckChecks> checks = new ArrayList<>();
  
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

  public HealthCheck status(String status) {
    this.status = status;
    return this;
  }

 /**
   * Get checks
   * @return checks
  **/
  public List<HealthCheckChecks> getChecks() {
    return checks;
  }

  /**
    * Set checks
  **/
  public void setChecks(List<HealthCheckChecks> checks) {
    this.checks = checks;
  }

  public HealthCheck checks(List<HealthCheckChecks> checks) {
    this.checks = checks;
    return this;
  }

  public HealthCheck addChecksItem(HealthCheckChecks checksItem) {
    this.checks.add(checksItem);
    return this;
  }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthCheck that = (HealthCheck) o;
        return Objects.equals(status, that.status) && Objects.equals(checks, that.checks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, checks);
    }

    @Override
    public String toString() {
        return "HealthCheck{" +
                "status='" + status + '\'' +
                ", checks=" + checks +
                '}';
    }
}
