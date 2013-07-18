package HawkClient;

import java.net.URL;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.google.common.io.BaseEncoding;

public class HawkClient {

	private final static String Algorithm = "HmacSHA256";

	public static String createAuthorizationHeader(URL url, String method, String timestamp, String nonce, HawkCredentials credentials, String payload, String ext) throws Exception {

		if (url == null || method == null || timestamp == null || nonce == null || credentials == null)
			throw new Exception("url, method, timestamp, nonce and credentials are required!");
		
		payload = (payload == null) ? "" : payload;
	    ext = (ext == null) ? "" : ext;
		
	    String normalized = generateNormalizedString(url, method, timestamp, nonce, credentials, payload, ext);	    
		String mac = generateMAC(normalized, credentials);
		
		return "Hawk id=\"" + credentials.get_identifier() + "\", ts=\"" + timestamp + "\", nonce=\"" + nonce + "\", mac=\"" + mac + "\", ext=\"" + ext + "\"";
	}

	public static String createAuthorizationHeaderWithPayloadValidation(URL url, String method, String timestamp, String nonce, HawkCredentials credentials, String payload, String ext, String contentType) throws Exception {
		
		if (url == null || method == null || timestamp == null || nonce == null || credentials == null)
			throw new Exception("url, method, timestamp, nonce and credentials are required!");
		
		String header = "hawk.1.payload";
	    contentType = contentType.toLowerCase();
	    payload = (payload == null) ? "" : payload;
	    ext = (ext == null) ? "" : ext;
	    
	    String normalized = header + "\n" + contentType + "\n" + payload + "\n";
	    String hash = generateMAC(normalized, credentials);
	    String mac = generateMAC(generateNormalizedString(url, method, timestamp, nonce, credentials, payload, ext), credentials);
	    
	    return "Hawk id=\"" + credentials.get_identifier() + "\", ts=\"" + timestamp + "\", nonce=\"" + nonce + "\", mac=\"" + mac + "\", ext=\"" + ext + "\", hash=\"" + hash + "\"";
	}
	
	private static String generateMAC(String normalized, HawkCredentials credentials) throws Exception {

		Mac mac = Mac.getInstance(Algorithm);
		mac.init(new SecretKeySpec(credentials.get_key().getBytes("UTF-8"), Algorithm));
		return BaseEncoding.base64().encode(mac.doFinal(normalized.getBytes("UTF8")));
	}

	private static String generateNormalizedString(URL url, String method, String timestamp, String nonce, HawkCredentials credentials, String payload, String ext) {
		
		// Preparing the variables.
		String header = "hawk.1.header";
		method = method.toUpperCase();
		String query = (url.getQuery() == null) ? "" : url.getQuery();
		String uri = url.getPath() + query;
		String host = url.getHost();

		// Not necessary in STracker.
		// int port = url.getPort();

		payload = (payload == null) ? "" : payload;
		ext = (ext == null) ? "" : ext;

		return header + "\n" + timestamp + "\n" + nonce + "\n" + method + "\n" + uri + "\n" + host + "\n" + payload + "\n" + ext + "\n";
	}
}