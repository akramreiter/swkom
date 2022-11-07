package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.Parcel;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParcelMapper {

    ParcelMapper INSTANCE = Mappers.getMapper(ParcelMapper.class);

    @Mapping(source = "trackingId", target = "trackingId")
    NewParcelInfo parcelToNewParcelInfo(Parcel parcel);

    @Mapping(source = "state", target = "state")
    @Mapping(source = "visitedHops", target = "visitedHops")
    @Mapping(source = "futureHops", target = "futureHops")
    TrackingInformation parcelToTrackingInformation(Parcel parcel);

    @Mapping(source = "weight", target = "weight")
    @Mapping(source = "recipient", target = "recipient")
    @Mapping(source = "sender", target = "sender")
    at.fhtw.swen3.services.dto.Parcel parcelToParcelDto(Parcel parcel);

    @Mapping(source = "weight", target = "weight")
    @Mapping(source = "recipient", target = "recipient")
    @Mapping(source = "sender", target = "sender")
    Parcel parcelDtoToParcel(at.fhtw.swen3.services.dto.Parcel parcel);
}
