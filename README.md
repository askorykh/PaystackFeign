# PaystackFeign -- WIP

Library for easy interaction with Paystack API

To start using you need to create a PaystackPaymentAPI bean.

    @Bean
    public PaystackPaymentAPI paystackPaymentAPI()
    {
        return Feign.builder()
            .encoder(new JacksonEncoder()) // You can uses Gson as well
            .decoder(new JacksonDecoder()) // You can uses Gson as well
            .requestInterceptor(new AuthorizationInterceptor(secretKey))
            .target(PaystackPaymentAPI.class, "https://api.paystack.co");

    }
