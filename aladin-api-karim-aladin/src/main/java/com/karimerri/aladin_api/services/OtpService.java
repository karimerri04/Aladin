package com.karimerri.aladin_api.services;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Service
public class OtpService {
	// cache based on username and OPT MAX 8
	private static final Integer EXPIRE_MINS = 5;
	private LoadingCache<String, Integer> otpCache;

	public OtpService() {
		super();
		otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
				.build(new CacheLoader<String, Integer>() {
					@Override
					public Integer load(String key) {
						return 0;
					}
				});
	}

	// This method is used to clear the OTP catched already
	public void clearOTP(String key) {
		otpCache.invalidate(key);
	}

	// This method is used to push the opt number against Key. Rewrite the OTP if it
	// exists
	// Using user id as key
	public int generateOTP(String key) {
		final Random random = new Random();
		final int otp = 100000 + random.nextInt(900000);
		otpCache.put(key, otp);
		return otp;
	}

	// This method is used to return the OPT number against Key->Key values is
	// username
	public int getOtp(String key) {
		try {
			return otpCache.get(key);
		} catch (final Exception e) {
			return 0;
		}
	}
}
