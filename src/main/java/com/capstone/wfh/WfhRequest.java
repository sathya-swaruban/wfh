package com.capstone.wfh;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class WfhRequest {

    @Id
    private String id;

    private String fromDate;

    private String toDate;

    private String fromTime;

    private String toTime;
}
