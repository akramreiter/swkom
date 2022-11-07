package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.entities.State;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class ParcelMapperTest {

    @Test
    public void parcelToNewParcelInfo() {
        ParcelEntity p = new ParcelEntity(null, null, null, "testid",
                null, null, null);

        NewParcelInfo newParcelInfo = ParcelMapper.INSTANCE.parcelToNewParcelInfo(p);
        assertThat(newParcelInfo).isNotNull();
        assertThat(newParcelInfo.getTrackingId()).isEqualTo("testid");
    }

    @Test
    public void parcelToTrackingInformation() {
        ParcelEntity p = new ParcelEntity(null, null, null, "testid",
                State.DELIVERED, Collections.emptyList(), Collections.emptyList());

        TrackingInformation newParcelInfo = ParcelMapper.INSTANCE.parcelToTrackingInformation(p);
        assertThat(newParcelInfo).isNotNull();
        assertThat(newParcelInfo.getState().getValue()).isEqualTo(TrackingInformation.StateEnum.DELIVERED.getValue());
    }

    @Test
    public void parcelToParcelDto() {
        ParcelEntity p = new ParcelEntity(12.0f, new RecipientEntity(), new RecipientEntity(), "testid",
                State.DELIVERED, Collections.emptyList(), Collections.emptyList());

        at.fhtw.swen3.services.dto.Parcel newParcelInfo = ParcelMapper.INSTANCE.parcelToParcelDto(p);
        assertThat(newParcelInfo).isNotNull();
        assertThat(newParcelInfo.getWeight()).isEqualTo(newParcelInfo.getWeight());
    }



}