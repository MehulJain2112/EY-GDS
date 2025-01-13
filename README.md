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
