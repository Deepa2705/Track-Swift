package com.track_swift.trackswift.repository;

import com.track_swift.trackswift.entity.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Long> {
}
