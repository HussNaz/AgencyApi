package com.example.AgencyApi.service;

import com.example.AgencyApi.model.Agency;
import com.example.AgencyApi.util.AgencyJsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.AgencyApi.util.AgencyJsonUtils.writeAgencies;

@Service
public class AgencyService {

    @Value("${agency.updates-allowed}")
    private boolean updatesAllowed;

    public List<Agency> getAllAgencies() {
        return AgencyJsonUtils.readAgencies();
    }


    public String addOrUpdateAgency(Agency newAgency) {

        if(!updatesAllowed){
            return "Update functionality is disabled.";
        }
        List<Agency> agencies = AgencyJsonUtils.readAgencies();
        Optional<Agency> existingAgency = agencies.stream()
                .filter(agency ->
                        agency.getId().equals(newAgency.getId()))
                .findFirst();

        if (existingAgency.isPresent()) {
            agencies.remove(existingAgency.get());
            agencies.add(newAgency);
            writeAgencies(agencies);
            return "Agency updated successfully.";
        } else {
            agencies.add(newAgency);
            writeAgencies(agencies);
            return "Agency added successfully.";
        }
    }

}
