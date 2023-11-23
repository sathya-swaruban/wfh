package com.capstone.wfh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import java.util.List;

@Service
public class WfhService {

    @Autowired
    WfhRepository wfhRepository;

    public WfhService(WfhRepository wfhRepository) {
        this.wfhRepository = wfhRepository;
    }

    public WfhRequest submit(WfhRequest wfhRequest) {
        List<WfhRequest> tempList = wfhRepository.findByFromDate(wfhRequest.getFromDate());
        if (tempList.isEmpty()) {
            return wfhRepository.save(wfhRequest);
        } else {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
    }

    public List<WfhRequest> getAll() {
        return wfhRepository.findAll();
    }

}
