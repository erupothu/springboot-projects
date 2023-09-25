package com.erupothu.redis.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/redis")
public class WelcomeController {

    public static final String STRING_KEY_PREFIX = "MENU-ITEM";
    @Autowired
    private RedisTemplate<String, String> template;

    @GetMapping("welcome")
    public String welcome() {
        return "welcome to Spring boot Redis Application";
    }

    @PostMapping("/strings")
    public Map.Entry<String, String> setString(@RequestBody Map.Entry<String, String> kvp) {
    template.opsForValue().set(STRING_KEY_PREFIX + kvp.getKey(), kvp.getValue());

    return kvp;
    }

    @GetMapping("/strings/{key}")
    public Map.Entry<String, String> getString(@PathVariable("key") String key) {
    String value = template.opsForValue().get(STRING_KEY_PREFIX + key);

    if (value == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "key not found");
    }
    Map result = new HashMap();
    result.put(key, value);

    return (Entry<String, String>) result;
    }

}