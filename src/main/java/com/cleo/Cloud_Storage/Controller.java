package com.cleo.Cloud_Storage;

import com.cleo.Cloud_Storage.common.Foo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final KafkaTemplate<Object,Object> template;

    @Autowired
    public Controller(KafkaTemplate<Object, Object> template) {
        this.template = template;
    }
    @PostMapping(path = "/send/foo/{what}")
    public void sendFoo(@PathVariable String what) {
        this.template.send("first", new Foo1(what));
    }
}
