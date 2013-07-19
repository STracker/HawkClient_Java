HawkClient Java
==============

This project is an implementation of Hawk client for Java. For more information visit [hueniverse/hawk](https://github.com/hueniverse/hawk).  
This client don't use the port number when generates the MAC because some hosts services use load balancing.  
It is also available in this project, the function for creating a nonce.
  
#### Installation
From HawkClient1.0.0.jar file included in this repository.

#### Usage
With this client is possible to make a request with and without payload validation.  
Example without payload validation:  
<pre>
<code>
String header = HawkClient.createAuthorizationHeader(url, method, timestamp, nonce, credentials, null, payload, false);
</code>
</pre>
  
Example with payload validation:   
<pre>
<code> 
String header = HawkClient.createAuthorizationHeader(url, method, timestamp, nonce, credentials, null, payload, true);
</code>  
</pre>  

See unit tests project if you still in doubt.

#### Dependencies
- [Guava](https://code.google.com/p/guava-libraries/)
