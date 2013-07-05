package Tests;

import java.net.URL;

import HawkClient.HawkClient;
import HawkClient.HawkCredentials;

public class Test {
	
	public static void main(String[] args) {
		
		try {
			URL url = new URL("http://strackerserverdev.apphb.com/api/user");
			String method = "GET";
			String nonce = "Ucbxsg";

			HawkCredentials credentials = new HawkCredentials("100005516760836", "werxhqb98rpaxn39848xrunpaw3489ruxnpa98w4rxn");

			String header = HawkClient.createAuthorizationHeader(url, method, "1373056", nonce, credentials, null, null);
			
			System.out.println(header);

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
