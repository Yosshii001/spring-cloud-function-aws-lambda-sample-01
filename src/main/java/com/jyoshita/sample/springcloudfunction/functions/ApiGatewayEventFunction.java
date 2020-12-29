package com.jyoshita.sample.springcloudfunction.functions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import com.jyoshita.sample.springcloudfunction.model.Input;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiGatewayEventFunction implements Function<Message<Input>, Message<String>> {
  @Override
  public Message<String> apply(Message<Input> inputMessage) {
      log.info("Message : " + inputMessage.getPayload().getTest());
      return new Message<String>() {
          @Override
          public String getPayload() {
              return "Complete!";
          }

          @Override
          public MessageHeaders getHeaders() {
              Map<String, Object> headers = new HashMap<>();
              return new MessageHeaders(headers);
          }
      };
  }
}
