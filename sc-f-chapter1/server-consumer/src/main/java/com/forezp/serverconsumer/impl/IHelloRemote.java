package com.forezp.serverconsumer.impl;

import com.forezp.serverconsumer.api.HelloRemote;
import org.springframework.stereotype.Service;

@Service
public class IHelloRemote implements HelloRemote {

    @Override
    public String hello(String name) {
        return name;
    }
}
