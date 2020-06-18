package com.github.instagram4j.Instagram4J.requests;

import java.net.URLEncoder;

import com.github.instagram4j.Instagram4J.IGConstants;
import com.github.instagram4j.Instagram4J.responses.IGResponse;

import lombok.SneakyThrows;
import okhttp3.Request;

public abstract class IGGetRequest<T extends IGResponse> extends IGRequest<T> {
	public String getQueryStrings() {
		return "";
	}

	@SneakyThrows
	protected String mapQueryString(String... strings) {
		StringBuilder builder = new StringBuilder("?");

		for (int i = 0; i < strings.length; i += 2) {
			if (i + 1 < strings.length) {
				builder.append(URLEncoder.encode(strings[i], "utf-8"))
					   .append("=")
					   .append(URLEncoder.encode(strings[i + 1], "utf-8"))
					   .append("&");
			}
		}

		return builder.substring(0, builder.length() - 1);
	}

	@Override
	public Request formRequest() {
		Request.Builder req = new Request.Builder().url(IGConstants.API_URL + this.getUrl() + this.getQueryStrings());
		this.applyHeaders(req);
		;

		return req.build();
	}
}