package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.services.impl.ParcelService;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.net.URI;
import java.util.Collections;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-18T08:59:17.579754Z[Etc/UTC]")
@Controller
public class ParcelApiController implements ParcelApi {

    public static final String PARCEL_LOCATION_TEMPLATE = "/parcel/%s";
    private final NativeWebRequest request;
    private final ParcelService parcelService;

    @Autowired
    public ParcelApiController(NativeWebRequest request,
                               ParcelService parcelService) {
        this.request = request;
        this.parcelService = parcelService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }


    @Override
    public ResponseEntity<NewParcelInfo> submitParcel(Parcel parcel) {
        var newParcel = ParcelMapper.INSTANCE.parcelDtoToParcel(parcel);
        // This is needed as validation requirements state that visited and future hops must not be null
        if(newParcel.getFutureHops() == null) {
            newParcel.setFutureHops(Collections.emptyList());
        }
        if(newParcel.getVisitedHops() == null) {
            newParcel.setVisitedHops(Collections.emptyList());
        }
        var parcelCreatedInfo = this.parcelService.createParcel(newParcel);
        return ResponseEntity
                .created(URI.create(String.format(PARCEL_LOCATION_TEMPLATE, parcelCreatedInfo.getTrackingId())))
                .body(parcelCreatedInfo);

    }

    @Override
    public ResponseEntity<Void> reportParcelDelivery(String trackingId) {
        return ParcelApi.super.reportParcelDelivery(trackingId);
    }

    @Override
    public ResponseEntity<Void> reportParcelHop(String trackingId, String code) {
        return ParcelApi.super.reportParcelHop(trackingId, code);
    }



    @Override
    public ResponseEntity<TrackingInformation> trackParcel(String trackingId) {
        return ParcelApi.super.trackParcel(trackingId);
    }

    @Override
    public ResponseEntity<NewParcelInfo> transitionParcel(String trackingId, Parcel parcel) {
        return ParcelApi.super.transitionParcel(trackingId, parcel);
    }
}
