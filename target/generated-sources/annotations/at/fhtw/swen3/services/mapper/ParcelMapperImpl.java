package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.entities.State;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-07T18:09:12+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ParcelMapperImpl implements ParcelMapper {

    @Override
    public NewParcelInfo parcelToNewParcelInfo(ParcelEntity parcel) {
        if ( parcel == null ) {
            return null;
        }

        NewParcelInfo newParcelInfo = new NewParcelInfo();

        newParcelInfo.setTrackingId( parcel.getTrackingId() );

        return newParcelInfo;
    }

    @Override
    public TrackingInformation parcelToTrackingInformation(ParcelEntity parcel) {
        if ( parcel == null ) {
            return null;
        }

        TrackingInformation trackingInformation = new TrackingInformation();

        trackingInformation.setState( stateToStateEnum( parcel.getState() ) );
        trackingInformation.setVisitedHops( hopArrivalEntityListToHopArrivalList( parcel.getVisitedHops() ) );
        trackingInformation.setFutureHops( hopArrivalEntityListToHopArrivalList( parcel.getFutureHops() ) );

        return trackingInformation;
    }

    @Override
    public Parcel parcelToParcelDto(ParcelEntity parcel) {
        if ( parcel == null ) {
            return null;
        }

        Parcel parcel1 = new Parcel();

        parcel1.setWeight( parcel.getWeight() );
        parcel1.setRecipient( recipientEntityToRecipient( parcel.getRecipient() ) );
        parcel1.setSender( recipientEntityToRecipient( parcel.getSender() ) );

        return parcel1;
    }

    @Override
    public ParcelEntity parcelDtoToParcel(Parcel parcel) {
        if ( parcel == null ) {
            return null;
        }

        ParcelEntity parcelEntity = new ParcelEntity();

        parcelEntity.setWeight( parcel.getWeight() );
        parcelEntity.setRecipient( recipientToRecipientEntity( parcel.getRecipient() ) );
        parcelEntity.setSender( recipientToRecipientEntity( parcel.getSender() ) );

        return parcelEntity;
    }

    protected TrackingInformation.StateEnum stateToStateEnum(State state) {
        if ( state == null ) {
            return null;
        }

        TrackingInformation.StateEnum stateEnum;

        switch ( state ) {
            case PICKUP: stateEnum = TrackingInformation.StateEnum.PICKUP;
            break;
            case INTRANSPORT: stateEnum = TrackingInformation.StateEnum.INTRANSPORT;
            break;
            case INTRUCKDELIVERY: stateEnum = TrackingInformation.StateEnum.INTRUCKDELIVERY;
            break;
            case TRANSFERRED: stateEnum = TrackingInformation.StateEnum.TRANSFERRED;
            break;
            case DELIVERED: stateEnum = TrackingInformation.StateEnum.DELIVERED;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + state );
        }

        return stateEnum;
    }

    protected HopArrival hopArrivalEntityToHopArrival(HopArrivalEntity hopArrivalEntity) {
        if ( hopArrivalEntity == null ) {
            return null;
        }

        HopArrival hopArrival = new HopArrival();

        return hopArrival;
    }

    protected List<HopArrival> hopArrivalEntityListToHopArrivalList(List<HopArrivalEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<HopArrival> list1 = new ArrayList<HopArrival>( list.size() );
        for ( HopArrivalEntity hopArrivalEntity : list ) {
            list1.add( hopArrivalEntityToHopArrival( hopArrivalEntity ) );
        }

        return list1;
    }

    protected Recipient recipientEntityToRecipient(RecipientEntity recipientEntity) {
        if ( recipientEntity == null ) {
            return null;
        }

        Recipient recipient = new Recipient();

        recipient.setName( recipientEntity.getName() );
        recipient.setStreet( recipientEntity.getStreet() );
        recipient.setPostalCode( recipientEntity.getPostalCode() );
        recipient.setCity( recipientEntity.getCity() );
        recipient.setCountry( recipientEntity.getCountry() );

        return recipient;
    }

    protected RecipientEntity recipientToRecipientEntity(Recipient recipient) {
        if ( recipient == null ) {
            return null;
        }

        RecipientEntity recipientEntity = new RecipientEntity();

        recipientEntity.setName( recipient.getName() );
        recipientEntity.setStreet( recipient.getStreet() );
        recipientEntity.setPostalCode( recipient.getPostalCode() );
        recipientEntity.setCity( recipient.getCity() );
        recipientEntity.setCountry( recipient.getCountry() );

        return recipientEntity;
    }
}
