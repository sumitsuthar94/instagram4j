package com.github.instagram4j.Instagram4J.requests;

import com.github.instagram4j.Instagram4J.models.IGPayload;
import com.github.instagram4j.Instagram4J.responses.IGLoginResponse;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IGChallengeSendCodeRequest extends IGPostRequest<IGLoginResponse> {
	@NonNull
	private String path;
	@NonNull
	private String code;
	
	@Override
	public IGPayload getPayload() {
		return new IGPayload() {
			@Getter
			private final String security_code = code;
		};
	}

	@Override
	public String getUrl() {
		return path;
	}

	@Override
	public Class<IGLoginResponse> getResponseType() {
		return IGLoginResponse.class;
	}
	
}