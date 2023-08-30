package com.test.service;

import org.springframework.stereotype.Service;

import lombok.Value;

@Service
public class KakaoService {

	public Object getKakaoLogin() {
		// TODO Auto-generated method stub
		return null;
	}
	/*  @Value("${kakao.client.id}")
	    private String KAKAO_CLIENT_ID ;

	    @Value("${kakao.client.secret}")
	    private String KAKAO_CLIENT_SECRET ="4X6x1WFibZc5zhidMMtrII4nh6OGxTZ0";

	    @Value("${kakao.redirect.url}")
	    private String KAKAO_REDIRECT_URL="http://localhost:8080/auth/kakao/callback";

	    private final static String KAKAO_AUTH_URI = "https://kauth.kakao.com";
	    private final static String KAKAO_API_URI = "https://kapi.kakao.com";

	    public String getKakaoLogin() {
	        return KAKAO_AUTH_URI + "/oauth/authorize"
	                + "?client_id=" + KAKAO_CLIENT_ID
	                + "&redirect_uri=" + KAKAO_REDIRECT_URL
	                + "&response_type=code";
	    }*/
}
