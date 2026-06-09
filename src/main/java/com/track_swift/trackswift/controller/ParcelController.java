package com.track_swift.trackswift.controller;

import com.track_swift.trackswift.dto.ParcelRequestDto;
import com.track_swift.trackswift.dto.ParcelResponseDto;
import com.track_swift.trackswift.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ParcelController {
    private ParcelService parcelService;

    @Autowired
    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    @GetMapping("/parcels")
    public List<ParcelResponseDto> getParcels(){
        return parcelService.getParcels();
    }

    @GetMapping("/parcels/retrieve/{id}")
    public ParcelResponseDto getParcel(@PathVariable Long id){
        return parcelService.getParcel(id);
    }

    @PostMapping("/parcels")
    public ParcelResponseDto addParcel(@RequestBody ParcelRequestDto parcelRequestDto){
        return parcelService.addParcel(parcelRequestDto);
    }

    @PutMapping("/parcels/update/{id}")
    public ParcelResponseDto updateParcel(@PathVariable Long id, @RequestBody ParcelRequestDto parcelRequestDto){
        return parcelService.updateParcel(id, parcelRequestDto);
    }

    @DeleteMapping("/parcels/delete/{id}")
    public void deleteParcel(@PathVariable Long id){
        parcelService.deleteParcel(id);
    }
}
