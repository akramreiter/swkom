package at.fhtw.swen3.persistence.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Parcel {

    @Id
    @Pattern(regexp = "^[A-Z0-9]{9}$")
    private String trackingId;
    @Min(0) //@Positive
    private Float weight;
    @OneToOne
    @NotNull
    private Recipient recipient;
    @OneToOne
    @NotNull
    private Recipient sender;
    private State state;
    @OneToMany
    @NotNull
    private List<HopArrival> visitedHops;
    @OneToMany
    @NotNull
    private List<HopArrival> futureHops;

    public Parcel(Float weight, Recipient recipient, Recipient sender, String trackingId, State state, List<HopArrival> visitedHops, List<HopArrival> futureHops) {
        this.weight = weight;
        this.recipient = recipient;
        this.sender = sender;
        this.trackingId = trackingId;
        this.state = state;
        this.visitedHops = visitedHops;
        this.futureHops = futureHops;
    }

    public Parcel() {
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public Recipient getSender() {
        return sender;
    }

    public void setSender(Recipient sender) {
        this.sender = sender;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<HopArrival> getVisitedHops() {
        return visitedHops;
    }

    public void setVisitedHops(List<HopArrival> visitedHops) {
        this.visitedHops = visitedHops;
    }

    public List<HopArrival> getFutureHops() {
        return futureHops;
    }

    public void setFutureHops(List<HopArrival> futureHops) {
        this.futureHops = futureHops;
    }
}
