package com.capstone.wfh.service;

import com.capstone.wfh.exception.DifferentDatesException;
import com.capstone.wfh.exception.RequestExistsException;
import com.capstone.wfh.exception.WeekendException;
import com.capstone.wfh.model.WfhRequest;
import com.capstone.wfh.repository.WfhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.List;

@Service
public class WfhService {

    @Autowired
    WfhRepository wfhRepository;

    public WfhService(WfhRepository wfhRepository) {
        this.wfhRepository = wfhRepository;
    }

    private void validateDate(String fromDateString, String toDateString) {
        if (!fromDateString.equals(toDateString)) {
            throw new DifferentDatesException("Provided from-date and to-date are different!");
        } else if (LocalDate.parse(fromDateString).get(ChronoField.DAY_OF_WEEK) >= 6) {
            throw new WeekendException("Provided date must not be a weekend!");
        } else if (!wfhRepository.findByFromDate(fromDateString).isEmpty()) {
            throw new RequestExistsException("WFH Request already exists for this date!");
        }
    }

    public WfhRequest submit(WfhRequest wfhRequest) {
        validateDate(wfhRequest.getFromDate(), wfhRequest.getToDate());
        return wfhRepository.save(wfhRequest);
    }

    public List<WfhRequest> getAll() {
        return wfhRepository.findAll();
    }

}
