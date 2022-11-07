package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.UUID;

@Service
@Validated
public class ParcelService {
    private final ParcelRepository parcelRepository;

    @Autowired
    public ParcelService(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    public NewParcelInfo createParcel(@Valid ParcelEntity p) {
        p.setTrackingId(UUID.randomUUID().toString());
        //parcelRepository.save(p);
        return ParcelMapper.INSTANCE.parcelToNewParcelInfo(p);
    }
}