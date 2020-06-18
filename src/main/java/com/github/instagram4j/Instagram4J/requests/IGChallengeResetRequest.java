package com.github.instagram4j.Instagram4J.requests;

import com.github.instagram4j.Instagram4J.models.IGPayload;
import com.github.instagram4j.Instagram4J.responses.IGChallengeStateResponse;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IGChallengeResetRequest extends IGPostRequest<IGChallengeStateResponse> {
	@NonNull
	private String path;
	
	@Override
	public IGPayload getPayload() {
		return new IGPayload();
	}

	@Override
	public String getUrl() {
		return path.replace("/challenge/", "/challenge/reset/");
	}

	@Override
	public Class<IGChallengeStateResponse> getResponseType() {
		return IGChallengeStateResponse.class;
	}
	
}