# PaystackFeign -- WIP

------
Library for easy interaction with Paystack API using [Feign](https://github.com/OpenFeign/feign).

Feign is a Java to HTTP client binder inspired by Retrofit, JAXRS-2.0, and WebSocket.

# Requirements

------

* Java 11

#### Dependencies defined in pom.xml:

[@FasterXML/jackson-annotations](https://github.com/FasterXML/jackson-annotations) com.fasterxml.jackson.core:jackson-annotations 2.12.1 \
[@FasterXML/jackson-databind](https://github.com/FasterXML/jackson-databind) com.fasterxml.jackson.core:jackson-databind >= 2.9.10.7 \
[@OpenFeign/feign](https://github.com/OpenFeign/feign) io.github.openfeign:feign-core 10.12 \
[@apache/maven-plugins](https://github.com/apache/maven-plugins) org.apache.maven.plugins:maven-compiler-plugin 3.8.1 \
[@projectlombok/lombok](https://github.com/projectlombok/lombok) org.projectlombok:lombok 1.18.20

# Getting started

------
This library is using Jackson at the moment, but goal is to introduce 2 modules to support both Jackson and Gson depending what is already on the classpath.

To start using you need to create a PaystackPaymentAPI bean using Feign, also HystrixFeign can be used or Resilience4jFeign if you want to have CircuitBreaker. \
`Secret Key` is the one that you can get from Paystack Dashboard, and add to the bean from Environment Variables, or application properties, or just hard-code(not advised)

    @Bean
    public PaystackPaymentAPI paystackPaymentAPI()
    {
        return Feign.builder()
            .encoder(new JacksonEncoder()) // You can uses Gson as well
            .decoder(new JacksonDecoder()) // You can uses Gson as well
            .requestInterceptor(new AuthorizationInterceptor(secretKey))
            .target(PaystackPaymentAPI.class, "https://api.paystack.co");

    }

### Current supported entities and endpoints

-----

#### Transaction:

* InitializeTransaction
* VerifyTransaction
* FetchTransaction

#### Customer:

* CreateCustomer

#### Plans:

* CreatePlan

# ToDos

-----

- [ ] divide library into 3 modules: core, paystackfeign-gson, paystackfeign-jackson
- [ ] check what library currently used in the classpath and load respective module