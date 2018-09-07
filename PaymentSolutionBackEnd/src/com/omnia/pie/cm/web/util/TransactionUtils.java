package com.omnia.pie.cm.web.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import javax.crypto.KeyGenerator;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.omnia.pie.cm.data.model.SmsOtp;
import com.omnia.pie.cm.data.model.UserInfo;
import com.omnia.pie.cm.web.rest.param.ErrorResponse;
import com.omnia.pie.cm.web.rest.param.SendSmsOtp;
import com.omnia.pie.cm.web.rest.param.SendSmsOtpRequest;
import com.omnia.pie.cm.web.rest.param.SendSmsOtpResponse;
import com.omnia.pie.cm.web.rest.param.ValidateSmsOtp;
import com.omnia.pie.cm.web.rest.param.ValidateSmsOtpResponse;
import com.remit.now.otp.TimeBasedOneTimePasswordGenerator;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
public class TransactionUtils {
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	public static final String generateSmsOtp() throws NoSuchAlgorithmException, InvalidKeyException {
		try {
			TimeBasedOneTimePasswordGenerator totp = new TimeBasedOneTimePasswordGenerator();

			final Key secretKey;
			{
				final KeyGenerator keyGenerator = KeyGenerator.getInstance(totp.getAlgorithm());
				keyGenerator.init(512);
				secretKey = keyGenerator.generateKey();
			}

			final Date now = new Date();
			int value = totp.generateOneTimePassword(secretKey, now);
			return pad(String.valueOf(value), 6, "0");
		} catch (Exception e) {
			return null;
		}
	}
	public static final SmsOtp setSendSmsOtpParams(String uuid, String otp, SendSmsOtpRequest request,UserInfo userId) {
		SmsOtp smsOtp = new SmsOtp();
		smsOtp.setUuid(uuid);
		smsOtp.setOtp(otp);
		smsOtp.setMismatchCount(0);
		smsOtp.setValidated(0);
		if(request.getTransactionData() != null && request.getTransactionData().getSessionId() != null)
		smsOtp.setSessionId(request.getTransactionData().getSessionId());
		smsOtp.setUserId(userId);
		smsOtp.setResponseCode(ResponseCodes._000_APPROVED);
		return smsOtp;
	}
	
	public static SendSmsOtpResponse setSmsOtpResponse(String uuid,String sms_otp) {
		SendSmsOtp responseObj = new SendSmsOtp();
		SendSmsOtpResponse response = new SendSmsOtpResponse();

		if (uuid != null && sms_otp != null) {
			responseObj.setUuid(uuid);
			responseObj.setOtp(sms_otp);
			response.setSendsmsotp(responseObj);
			response.setResponseCode(ResponseCodes._000_APPROVED);
			return response;

		} else {
			response.setSendsmsotp(null);
			response.setErrorRsp(getProcessingError());
			response.setResponseCode(ResponseCodes._999_ERROR);
			return response;
		}
	}

	

	private static String generateSessionId() {
		return UUID.randomUUID().toString();
	}

	public static final String generateUUID() {
		try {
			UUID uuid = UUID.randomUUID();
			String randomUUIDString = uuid.toString();
			return randomUUIDString;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String pad(String value, int length, String with) {
		StringBuilder result = new StringBuilder(length);
		// Pre-fill a String value
		result.append(fill(Math.max(0, length - value.length()), with));
		result.append(value);

		return result.toString();
	}

	public static String fill(int length, String with) {
		StringBuilder sb = new StringBuilder(length);
		while (sb.length() < length) {
			sb.append(with);
		}
		return sb.toString();
	}
	public static ErrorResponse getProcessingError() {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(ResponseCodes._999_ERROR);
		errorResponse.setErrorMessageText(ResponseCodesDescription._999_ERROR_PROCESSING_REQUEST);
		return errorResponse;
	}
	
	public static ErrorResponse getSystemMalfunctionError() {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(ResponseCodes._997_SYSTEM_MALFUNCTION);
		errorResponse.setErrorMessageText(ResponseCodesDescription._997_SYSTEM_MALFUNCTION);
		return errorResponse;
	}
	public static ErrorResponse getMissingMandatoryFieldsError() {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(ResponseCodes._996_MISSING_MANDATORY_FIELDS);
		errorResponse.setErrorMessageText(ResponseCodesDescription._996_MISSING_MANDATORY_FIELDS);
		return errorResponse;
	}
	
	public static SmsOtp setOtpMatched(SmsOtp sms) {
		sms.setValidated(1);
		return sms;
	}
	

	public static ValidateSmsOtpResponse getAlreadyValidateSmsOtpResponse(SmsOtp otp) {
		ValidateSmsOtpResponse smsOtpResponse = new ValidateSmsOtpResponse();
		smsOtpResponse.setValidateSmsOtp(null);
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(ResponseCodes._992_SMS_OTP_ALREADY_VALIDATED);
		error.setErrorMessageText(ResponseCodesDescription._993_SMS_OTP_ALREADY_VALIDATED);
		smsOtpResponse.setErrorRsp(error);
		smsOtpResponse.setResponseCode(ResponseCodes._992_SMS_OTP_ALREADY_VALIDATED);
		return smsOtpResponse;
	}
	public static ValidateSmsOtpResponse getValidateSmsOtpResponse(SmsOtp otp, boolean match) {
		ValidateSmsOtpResponse smsOtpResponse = new ValidateSmsOtpResponse();

		if (otp != null) {
			if (match) {
				ValidateSmsOtp validSmsOtp = new ValidateSmsOtp();
				validSmsOtp.setOtpMatched(SMSOtpMatch._OTP_MATCH);
				validSmsOtp.setOtpMismatchCount(String.valueOf(otp.getMismatchCount()));
				smsOtpResponse.setErrorRsp(null);
				smsOtpResponse.setValidateSmsOtp(validSmsOtp);
				smsOtpResponse.setResponseCode(ResponseCodes._000_APPROVED);
				return smsOtpResponse;
			} else {
				ValidateSmsOtp validSmsOtp = new ValidateSmsOtp();
				validSmsOtp.setOtpMatched(SMSOtpMatch._OTP_NOT_MATCHED);
				validSmsOtp.setOtpMismatchCount(String.valueOf(otp.getMismatchCount()));
				smsOtpResponse.setErrorRsp(null);
				smsOtpResponse.setValidateSmsOtp(validSmsOtp);
				smsOtpResponse.setResponseCode(ResponseCodes._993_UNMATCHED_SMS_OTP);
				return smsOtpResponse;
			}
		} else {
			smsOtpResponse.setValidateSmsOtp(null);
			smsOtpResponse.setErrorRsp(getProcessingError());
			smsOtpResponse.setResponseCode(ResponseCodes._999_ERROR);
			return smsOtpResponse;
		}
	}
	public static final class ResponseCodes {
		public static final String _913_DUPLICATE_RECORD = "913";
		public static final String _000_APPROVED = "000";
		public static final String _907_TRANSACTION_TIMEOUT = "907";
		/*
		 * public static final String _302_UNABLE_TO_LOCATE_RECORD = "302";
		 * public static final String _145_BLOCKED_CARD = "145"; public static
		 * final String _143_EXPIRED_CARD = "143";
		 */
		public static final String _999_ERROR = "999";
		public static final String _889_ERROR = "889";
		public static final String _890_UNABLE_TO_LOCATE_RECORD = "890";
		public static final String _891_DUPLICATE_RECORD = "891";
		public static final String _892_EXCEEDS_TRANSACTION_LIMIT = "892";
		public static final String _893_TRANSACTION_TIMEOUT = "893";
		public static final String _894_INSUFFICIENT_FUNDS = "894";
		public static final String _895_EXCEEDED_WITHDRAWAL_LIMIT = "895";
		public static final String _896_CARD_CAPTURE = "896";
		public static final String _897_INVALID_PIN = "897";
		public static final String _898_BLOCKED_CARD = "898";
		public static final String _899_CARD_EXPIRED = "899";
		public static final String _990_PIN_TRIES_EXCEEDED = "990";
		public static final String _991_TRANSACTION_TIMEOUT = "991";
		public static final String _992_SMS_OTP_ALREADY_VALIDATED = "992";
		public static final String _993_UNMATCHED_SMS_OTP = "993";
		public static final String _994_INVALID_EID = "994";
		public static final String _995_UNDEFINED_CONDITION_ID = "995";
		public static final String _996_MISSING_MANDATORY_FIELDS = "996";
		public static final String _998_TERMINAL_DOES_NOT_EXIST = "998";
		public static final String _997_SYSTEM_MALFUNCTION = "997";
		public static final String _887_IO_ERROR = "887";
		// public static final String _22_SUSPECTED_MALFUNCTION = "22";
	}
	public static final class SMSOtpMatch {
		public static final String _OTP_MATCH = "1";
		public static final String _OTP_NOT_MATCHED = "0";
	}
	public static final class ResponseCodesDescription {
		public static final String _000_APPROVED = "APPROVED";

		public static final String _887_IO_ERROR = "CONNECTION TO PIE COMPONENT FAILED";
		public static final String _877_CARD_NOT_DELIVERED = "CARD NOT DELIVERED";
		public static final String _878_CARD_NOT_ACTIVE = "CARD NOT ACTIVE";
		public static final String _879_INVALID_CARD = "INVALID CARD";
		public static final String _890_UNABLE_TO_LOCATE_RECORD = "UNABLE TO LOCATE RECORD";
		public static final String _891_DUPLICATE_RECORD = "DUPLICATE RECORD";

		public static final String _907_TRANSACTION_TIMEOUT = "TRANSACTION TIMEOUT";
		public static final String _302_UNABLE_TO_LOCATE_RECORD = "UNABLE TO LOCATE RECORD";
		public static final String _145_BLOCKED_CARD = "BLOCKED CARD";
		public static final String _143_EXPIRED_CARD = "EXPIRED CARD";
		public static final String _995_UNDEFINED_CONDITION_ID = "UNIDENTIFIED CONDITION ID";
		public static final String _996_MISSING_MANDATORY_FIELDS = "MANDATORY FIELD(S) MISSING IN PAYLOAD";

		public static final String _993_SMS_OTP_ALREADY_VALIDATED = "SMS OTP ALREADY VALIDATED";
		public static final String _997_SYSTEM_MALFUNCTION = "SYSTEM MALFUNCTION";
		public static final String _998_TERMINAL_DOES_NOT_EXIST = "TERMINAL DOES NOT EXIST";
		public static final String _999_ERROR = "ERROR";
		public static final String _889_ERROR = "SERVICE PERMISSION ERROR";
		public static final String _999_ERROR_PROCESSING_REQUEST = "ERROR WHILE PROCESSING REQUEST";
		public static final String _BIB_ERROR = "BIB ERROR OR ERROR WHILE PROCESSING MQ RESPONSE";

		public static final String _22_SUSPECTED_MALFUNCTION = "SUSPECTED MALFUNCTION";
	}
}
