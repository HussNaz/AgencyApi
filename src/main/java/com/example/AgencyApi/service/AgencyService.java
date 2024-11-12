package com.example.AgencyApi.service;


import com.example.AgencyApi.model.Agency;
import com.example.AgencyApi.util.AgencyJsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Service
public class AgencyService {
    @Value("${agency.updates-allowed}")
    private boolean updatesAllowed;

    public List<String> getAllAgencies() {
        return Collections.singletonList(AgencyJsonUtils.readAgencies().toString());
    }

    public List<Agency> getAgencies() {
        return AgencyJsonUtils.readAgencies();
    }

    public String getAgencyById(String id) {
        List<Agency> agencies = AgencyJsonUtils.readAgencies();
        Optional<Agency> agency = agencies.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
        if (agency.isEmpty()) {
            return "No agency found with the given ID.";
        }
        return agency.get().toString();
    }

    public String addAgency(Agency newAgency) {
        List<Agency> agencies = AgencyJsonUtils.readAgencies();
        boolean exists = agencies.stream().anyMatch(agency ->
                agency.getName().equalsIgnoreCase(newAgency.getName()) ||
                        agency.getCode().equalsIgnoreCase(newAgency.getCode())
        );
        if (exists) {
            return "Cannot add agency: An agency with the same name or code already exists.";
        }
        agencies.add(newAgency);
        AgencyJsonUtils.writeAgencies(agencies);
        return "Agency added successfully.";
    }

    public String updateAgency(Agency updatedAgency) {
        if (!updatesAllowed) {
            return "Update functionality is disabled.";
        }
        List<Agency> agencies = AgencyJsonUtils.readAgencies();
        Optional<Agency> existingAgency = agencies.stream()
                .filter(agency ->
                        agency.getId().equals(updatedAgency.getId()))
                .findFirst();
        if (existingAgency.isEmpty()) {
            return "No agency found with the given ID.";
        }
        agencies.remove(existingAgency.get());
        agencies.add(updatedAgency);
        AgencyJsonUtils.writeAgencies(agencies);
        return "Agency updated successfully.";
    }
}