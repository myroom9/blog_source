package com.whahn.config;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class HttpErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        Default defaultErrorDecoder = new Default();
        Exception exception = defaultErrorDecoder.decode(methodKey, response);

        //if (response.status() != 200) {
            return new RetryableException(response.status(),
                    "api call for url: " + response.request().url() + " failed",
                    response.request().httpMethod(), exception.getCause(), null,
                    response.request());
        //}

        //return exception;
    }
}
