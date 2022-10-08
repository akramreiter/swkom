package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.NewParcelInfo;
import at.fhtw.swen3.services.dto.NewParcelInfoDto;
import org.mapstruct.Mapper;

@Mapper
public interface NewParcelInfoMapper {
    NewParcelInfoDto entityToDto(NewParcelInfo newParcelInfo);
    NewParcelInfo dtoToEntity(NewParcelInfoDto newParcelInfoDto);
}
