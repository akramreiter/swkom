package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParcelMapper {

    ParcelMapper INSTANCE = Mappers.getMapper(ParcelMapper.class);

    @Mapping(source = "trackingId", target = "trackingId")
    NewParcelInfo parcelToNewParcelInfo(ParcelEntity parcel);

    @Mapping(source = "state", target = "state")
    @Mapping(source = "visitedHops", target = "visitedHops")
    @Mapping(source = "futureHops", target = "futureHops")
    TrackingInformation parcelToTrackingInformation(ParcelEntity parcel);

    @Mapping(source = "weight", target = "weight")
    @Mapping(source = "recipient", target = "recipient")
    @Mapping(source = "sender", target = "sender")
    at.fhtw.swen3.services.dto.Parcel parcelToParcelDto(ParcelEntity parcel);

    @Mapping(source = "weight", target = "weight")
    @Mapping(source = "recipient", target = "recipient")
    @Mapping(source = "sender", target = "sender")
    ParcelEntity parcelDtoToParcel(at.fhtw.swen3.services.dto.Parcel parcel);
}
