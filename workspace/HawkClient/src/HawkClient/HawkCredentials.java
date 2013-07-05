package HawkClient;

public class HawkCredentials {
	
	private String _identifier;
	private String _key;
	
	public String get_identifier() {
		return _identifier;
	}

	public String get_key() {
		return _key;
	}

	public HawkCredentials(String identifier, String key) {
		_identifier = identifier;
		_key = key;
	}
}
