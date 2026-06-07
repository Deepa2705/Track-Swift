package com.track_swift.trackswift.entity;

import com.track_swift.trackswift.enums.ParcelStatus;
import jakarta.persistence.*;

@Entity
public class TrackingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ParcelStatus status;
    private String location;

    @Enumerated(EnumType.STRING)
    private String remarks;
}
