package com.track_swift.trackswift.service;

import com.track_swift.trackswift.dto.ParcelRequestDto;
import com.track_swift.trackswift.dto.ParcelResponseDto;
import com.track_swift.trackswift.entity.Parcel;
import com.track_swift.trackswift.repository.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ParcelServiceImpl implements ParcelService{
    private ParcelRepository parcelRepository;

    @Autowired
    public ParcelServiceImpl(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    @Override
    public List<ParcelResponseDto> getParcels() {
        return parcelRepository.findAll().stream().map(this::createParcelResponse).toList();
    }

    @Override
    public ParcelResponseDto getParcel(Long id) {
        Parcel parcel = parcelRepository.findById(id).orElseThrow(()->new RuntimeException("Parcel Not Found"));
        return createParcelResponse(parcel);
    }

    @Override
    public ParcelResponseDto addParcel(ParcelRequestDto parcelRequestDto) {
        Parcel parcel = createParcel(parcelRequestDto);
        Parcel savedParcel = parcelRepository.save(parcel);
        return createParcelResponse(savedParcel);
    }

    @Override
    public void deleteParcel(Long id) {
        parcelRepository.deleteById(id);
    }

    @Override
    public Parcel createParcel(ParcelRequestDto parcelRequestDto) {
        Parcel parcel=new Parcel();

        parcel.setSenderName(parcelRequestDto.getSenderName());
        parcel.setSenderPhone(parcelRequestDto.getSenderPhone());
        parcel.setSenderAddress(parcelRequestDto.getSenderAddress());
        parcel.setReceiverName(parcelRequestDto.getReceiverName());
        parcel.setReceiverPhone(parcelRequestDto.getReceiverPhone());
        parcel.setReceiverAddress(parcelRequestDto.getReceiverAddress());
        parcel.setParcelWeight(parcelRequestDto.getParcelWeight());
        parcel.setParcelType(parcelRequestDto.getParcelType());
        parcel.setTrackingNumber();
        parcel.setCreatedAt(LocalDate.now());
        LocalDate today = LocalDate.now();
        LocalDate expectedDate = today.plusDays(10);
        parcel.setExpectedDeliveryDate(expectedDate);
        parcel.setUpdatedAt(LocalDate.now());

        return parcel;
    }

    @Override
    public ParcelResponseDto createParcelResponse(Parcel parcel) {
        ParcelResponseDto parcelResponseDto = new ParcelResponseDto(parcel.getId(),parcel.getTrackingNumber(),parcel.getSenderName(),parcel.getSenderPhone(),parcel.getSenderAddress(),parcel.getReceiverName(),parcel.getReceiverPhone(),parcel.getReceiverAddress(),parcel.getParcelWeight(),parcel.getReceiverName(),parcel.getStatus(),parcel.getExpectedDeliveryDate(), parcel.getCreatedAt(), parcel.getUpdatedAt());
        return parcelResponseDto;
    }

    @Override
    public ParcelResponseDto updateParcel(Long id, ParcelRequestDto parcelRequestDto) {
        Parcel existingParcel = parcelRepository.findById(id).orElseThrow(()->new RuntimeException("Parcel Not Found"));
        existingParcel.setSenderName(parcelRequestDto.getSenderName());
        existingParcel.setSenderPhone(parcelRequestDto.getSenderPhone());
        existingParcel.setSenderAddress(parcelRequestDto.getSenderAddress());

        existingParcel.setReceiverName(parcelRequestDto.getReceiverName());
        existingParcel.setReceiverPhone(parcelRequestDto.getReceiverPhone());
        existingParcel.setReceiverAddress(parcelRequestDto.getReceiverAddress());

        existingParcel.setParcelWeight(parcelRequestDto.getParcelWeight());
        existingParcel.setParcelType(parcelRequestDto.getParcelType());

        existingParcel.setUpdatedAt(LocalDate.now());

        Parcel savedParcel = parcelRepository.save(existingParcel);
        return createParcelResponse(savedParcel);
    }
}
