package com.track_swift.trackswift.entity;

import com.track_swift.trackswift.enums.ParcelStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Parcel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long trackingNumber;
    private String senderName;
    private String senderPhone;
    private String senderAddress;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private Double parcelWeight;
    private String parcelType;

    @Enumerated(EnumType.STRING)
    private ParcelStatus status;

    private Date expectedDeliveryDate;

}
