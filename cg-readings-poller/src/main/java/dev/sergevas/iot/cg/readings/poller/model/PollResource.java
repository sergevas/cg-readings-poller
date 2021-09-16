package dev.sergevas.iot.cg.readings.poller.model;

import java.util.Objects;

public class PollResource {

    private String sourceResourceUrl;

    private String destinationTopic;

    public String getSourceResourceUrl() {
        return sourceResourceUrl;
    }

    public PollResource sourceResourceUrl(String sourceResourceUrl) {
        this.sourceResourceUrl = sourceResourceUrl;
        return this;
    }

    public String getDestinationTopic() {
        return destinationTopic;
    }

    public PollResource destinationTopic(String destinationTopic) {
        this.destinationTopic = destinationTopic;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PollResource that = (PollResource) o;
        return Objects.equals(sourceResourceUrl, that.sourceResourceUrl) && Objects.equals(destinationTopic, that.destinationTopic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceResourceUrl, destinationTopic);
    }

    @Override
    public String toString() {
        return "PollResource{" +
                "sourceResourceUrl='" + sourceResourceUrl + '\'' +
                ", destinationTopic='" + destinationTopic + '\'' +
                '}';
    }
}
