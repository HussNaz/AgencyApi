package com.example.AgencyApi.controller;

import com.example.AgencyApi.model.Agency;
import com.example.AgencyApi.service.AgencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/agency")
@RequiredArgsConstructor
public class AgencyApiController {


    private final AgencyService agencyService;

    @GetMapping("/all")
    public List<Agency> getAllAgencies() {
        return agencyService.getAllAgencies();
    }

    @PostMapping("/add")
    public String addAgency(@Valid @RequestBody Agency agency) {
        return agencyService.addAgency(agency);
    }
    @PutMapping("/update")
    public String updateAgency(@Valid @RequestBody Agency agency) {
        return agencyService.updateAgency(agency);
    }
}
