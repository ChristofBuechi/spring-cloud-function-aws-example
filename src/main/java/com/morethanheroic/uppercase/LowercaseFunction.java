package com.morethanheroic.uppercase;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.morethanheroic.uppercase.domain.LowercaseResponse;
import com.morethanheroic.uppercase.domain.UppercaseRequest;
import com.morethanheroic.uppercase.service.LowercaseService;

@Component("lowercaseFunction")
public class LowercaseFunction implements Function<UppercaseRequest, LowercaseResponse> {

	private final LowercaseService lowercaseService;

	public LowercaseFunction(final LowercaseService lowercaseService) {
		this.lowercaseService = lowercaseService;
	}

	@Override
	public LowercaseResponse apply(final UppercaseRequest uppercaseRequest) {
		final LowercaseResponse result = new LowercaseResponse();
		result.setResultString(this.lowercaseService.lowercase(uppercaseRequest.getInput()));
		return result;
	}
}
