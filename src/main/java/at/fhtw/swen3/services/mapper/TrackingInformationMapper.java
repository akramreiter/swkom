package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.TrackingInformation;
import at.fhtw.swen3.services.dto.TrackingInformationDto;
import org.mapstruct.Mapper;

@Mapper
public interface TrackingInformationMapper {
    TrackingInformationDto entityToDto(TrackingInformation trackingInformation);
    TrackingInformation dtoToEntity(TrackingInformationDto trackingInformationDto);
}
