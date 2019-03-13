package com.training.categoryweb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.categoryweb.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class publishController {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(
            value = "/publish",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String publish() throws Exception{
        Category category = new Category(1L, "Fables and Animal Story");
        String json = objectMapper.writeValueAsString(category);

        kafkaTemplate.send("categories",json);
        return "OK";
    }

}
