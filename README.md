Write Junit test case for the below method. This method is under PrivateKeyFlowConfig class
/**

*Creates an {@link RSAKey) bean.

*This method loads a public key and a private key from the provided resources, and uses them to build an RSAKey.

*@param publicKeyVal The string representation of public key.

* @return An RSAKey built with the provided public key, private key, and Key ID.

* @throws Exception If there is an error loading the keys or building the RSAKey.

@Bean

public RSAKey rsakeyAzure(@Value("${oauth2.public-key-path}") String publicKeyVal, @Value("${oauth2.private-key-path)") String privateKeyPath) throws Exception {

log.info("Inside rsakeyAzure start");

Publickey publickey = KeyLoader.keys(publicKeyVal)

.toPublicKey();

Privatekey privateKey = KeyLoader.readPrivateKey(privateKeyPath);

log.info("Inside rsakeyAzure end");

return new RSAKey.Builder((RSAPublicKey) publickey).privateKey((RSAPrivateKey) privatekey)

.build();
}






I'm a fresher working as a backend developer in an ongoing project. I've given a big to resolve. This is related to security feature CORS. 
There is a customCorsFilter class. This works perfectly for GET APIs. There is a problem with POST APIs. 
The problem is: "From different origin, browser send origin in request header for both GET and POST request, but in same origin browser sends origin in request header only for POST request not for GET request. CORS filter is depend on origin sent by browser."
I'll provide the CustomCorsFilter Class code toom provide the solution on how to mitigate this issue.
Code:
@Component

@Order(Ordered.HIGHEST_PRECEDENCE)

public class CustomCorsFilter implements Filter {

@Value("${cors.access-control-allow-methods}")

private String allowMethods:

@Value("${cors.access-control-allow-headers}")

private String allowHeaders:

@Value("${cors.access-control-max-age}")

private String maxAge;

@Value("${cors-filter.access-control-allow-origin}")

private String origin;

@Value("${cors.cross-origin}")

private String crossOrigin;

@Override

public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

final HttpServletRequest request = (HttpServletRequest) req;

final HttpServletResponse response = (HttpServletResponse) res;

String requestOrigin = request.getHeader( "origin");

if(null == requestOrigin) {

response.setHeader("Access-Control-Allow-Origin", origin);

}

else if(requestOrigin.equalsIgnoreCase (crossOrigin)){
response.setHeader("Access-Control-Allow-Origin", crossOrigin);

response.setHeader("Access-Control-Allow-Credentials", s1: "true");
}

response.setHeader("Access-Control-Allow-Methods", allowMethods);

response.setHeader( "Access-Control-Allow-Headers", allowHeaders);

response.setHeader("Access-Control-Max-Age", maxAge);

if ("OPTIONS".equalsIgnoreCase(((HttpServletRequest) req).getMethod())) {

response.setStatus (HttpServletResponse.SC_OK);

} else {

chain.doFilter(req, res);

}

}

@Override 
public void destroy() {}

@Override
public void init(FilterConfig config) throws ServletException {}
}
