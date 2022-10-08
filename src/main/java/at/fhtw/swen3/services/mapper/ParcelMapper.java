package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.Parcel;
import at.fhtw.swen3.services.dto.ParcelDto;
import org.mapstruct.Mapper;

@Mapper
public interface ParcelMapper {
    ParcelDto entityToDto(Parcel parcel);
    Parcel dtoToEntity(ParcelDto parcelDto);
}
