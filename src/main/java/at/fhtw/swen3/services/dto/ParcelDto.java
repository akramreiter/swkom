package at.fhtw.swen3.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParcelDto {
    private Float weight;
    private Recipient recipient;
    private Recipient sender;
}
