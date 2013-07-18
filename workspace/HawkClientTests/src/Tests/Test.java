package Tests;

import java.net.URL;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import HawkClient.HawkClient;
import HawkClient.HawkCredentials;

@RunWith(JUnit4.class)
public class Test {
	
	@org.junit.Test
	public void testGenerateAuthorizationHeader() {
		
		HawkCredentials credentials = new HawkCredentials("100000004098766", "werxhqb98rpaxn39848xrunpaw3489ruxnpa98w4rxn");
		
		String nonce = "09B8AFD6-B784-4981-ADD5-BEFF55C9E60D";
	    String timestamp = "1374079191";
	    String method = "GET";

		try {
			URL url = new URL("http://example.com/test/100005742427425");
			
			String header = HawkClient.createAuthorizationHeader(url, method, timestamp, nonce, credentials, null, null, false);
			
		    Assert.assertEquals("Hawk id=\"100000004098766\", ts=\"1374079191\", nonce=\"09B8AFD6-B784-4981-ADD5-BEFF55C9E60D\", ext=\"\", mac=\"gzslhz6MERFF0ODS2BMw7LCSrjB/wa7W765M4epPmkQ=\"", header);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@org.junit.Test
	public void testeGenerateAuthorizationHeaderWithPayload() {
		
		HawkCredentials credentials = new HawkCredentials("100000004098766", "werxhqb98rpaxn39848xrunpaw3489ruxnpa98w4rxn");
		
		String nonce = "09B8AFD6-B784-4981-ADD5-BEFF55C9E60D";
	    String timestamp = "1374079796";
	    String method = "POST";
	    String payload = "Some payload.";
	    
	    try {
	    	URL url = new URL("http://example.com/test");
	    	
	    	String header = HawkClient.createAuthorizationHeader(url, method, timestamp, nonce, credentials, null, payload, true);
	    	
	    	Assert.assertEquals("Hawk id=\"100000004098766\", ts=\"1374079796\", nonce=\"09B8AFD6-B784-4981-ADD5-BEFF55C9E60D\", hash=\"BtJQcST2BgfVHsmtXOopFzX2dJdZRwKMeuaj7nCcaQg=\", ext=\"\", mac=\"Sj78StVH2zGfmNbPEWZtie/nMyxGf2VCEO5oWvcBoZ8=\"", header);
	    } catch (Exception e) {
	    	System.out.println(e.getMessage());
	    }
	}
	
	@org.junit.Test (expected = Exception.class)
	public void testException() throws Exception {
		
		HawkCredentials credentials = new HawkCredentials("100000004098766", "werxhqb98rpaxn39848xrunpaw3489ruxnpa98w4rxn");
		
		HawkClient.createAuthorizationHeader(null, null, null, null, credentials, null, null, false);
	}
}