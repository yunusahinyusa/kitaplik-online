//package com.kitaplik.library.service.client;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.kitaplik.library.service.exception.BookNotFoundException;
//import com.kitaplik.library.service.exception.ExceptionMessage;
//import feign.Response;
//import feign.codec.ErrorDecoder;
//import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.io.InputStream;
//
//@Component
//public class RetreiveMessageErrorDecoder  implements ErrorDecoder {
//    private final ResponseEntityDecoder errorDecoder;
//
//    public RetreiveMessageErrorDecoder(ResponseEntityDecoder errorDecoder) {
//        this.errorDecoder = errorDecoder;
//    }
//
//    @Override
//    public Exception decode(String methodKey, Response response) {
//        ExceptionMessage message = null;
//        try(InputStream bodyIs = response.body().asInputStream()){
//            ObjectMapper mapper = new ObjectMapper();
//            message = mapper.readValue(bodyIs,ExceptionMessage.class);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        switch (response.status()){
//            case 404:
//                throw new BookNotFoundException(message.message() != null ? message.message() : "Not found");
//        }
//        return null;
//    }
//}
