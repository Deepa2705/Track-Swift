package com.track_swift.trackswift.service;

import com.track_swift.trackswift.dto.ParcelRequestDto;
import com.track_swift.trackswift.dto.ParcelResponseDto;
import com.track_swift.trackswift.entity.Parcel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ParcelService {
    public List<ParcelResponseDto> getParcels();
    public ParcelResponseDto getParcel(Long id);
    public ParcelResponseDto addParcel(ParcelRequestDto parcelRequestDto);
    public void deleteParcel(Long id);
    public Parcel createParcel(ParcelRequestDto parcelRequestDto);
    public ParcelResponseDto createParcelResponse(Parcel parcel);
}
