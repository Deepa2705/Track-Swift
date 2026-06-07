package com.track_swift.trackswift.entity;

import com.track_swift.trackswift.enums.ParcelStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class DeliveryAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date assignedDate;
    private String assignedBy;

    @Enumerated(EnumType.STRING)
    private ParcelStatus status;

    private String notes;
}
