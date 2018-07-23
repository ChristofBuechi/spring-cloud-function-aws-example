package com.morethanheroic.uppercase.handler.aws;

import com.morethanheroic.uppercase.domain.TimeRequest;
import com.morethanheroic.uppercase.domain.TimeResponse;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class TimeHandler extends SpringBootRequestHandler<TimeRequest, TimeResponse> {

}
