package com.capstone.wfh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WfhService {

    @Autowired
    WfhRepository wfhRepository;

    public WfhService(WfhRepository wfhRepository) {
        this.wfhRepository = wfhRepository;
    }

    public WfhRequest submit(WfhRequest wfhRequest) {
        return wfhRepository.save(wfhRequest);
    }

    public List<WfhRequest> getAll() {
        return wfhRepository.findAll();
    }

}
