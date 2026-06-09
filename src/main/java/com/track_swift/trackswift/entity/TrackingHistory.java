package com.track_swift.trackswift.entity;

import com.track_swift.trackswift.enums.ParcelStatus;
import jakarta.persistence.*;

@Entity
public class TrackingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ParcelStatus status;

    private String location;
    private String remarks;
}
