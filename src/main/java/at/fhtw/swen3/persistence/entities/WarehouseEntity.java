package at.fhtw.swen3.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WarehouseEntity {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
