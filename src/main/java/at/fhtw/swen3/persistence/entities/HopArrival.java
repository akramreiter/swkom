package at.fhtw.swen3.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.OffsetDateTime;

@Entity
public class HopArrival {

    private String code;
    private String description;
    private OffsetDateTime dateTime;
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}