package com.forever.consumer.controller;

import com.forever.consumer.client.ProviderClient;
import com.forever.consumer.dto.Artist;
import com.forever.consumer.dto.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author WJX
 * @date 2021/4/15 14:27
 */
@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {

    @Autowired
    private ProviderClient providerClient;

    @RequestMapping(value = "/select/artist/{id}")
    public @ResponseBody
    Artist selectArtist(@PathVariable Integer id) {
        return providerClient.selectArtist(id);
    }

    @RequestMapping(value = "/insert/artist")
    public Integer insertArtist(@RequestBody Artist artist) {
        return providerClient.insertArtist(artist);
    }

    @RequestMapping(value = "/select/record/{id}")
    public @ResponseBody
    Record selectRecord(@PathVariable Integer id) {
        return providerClient.selectRecord(id);
    }

    @RequestMapping(value = "/insert/record")
    public Integer insertRecord(@RequestBody Record record) {
        return providerClient.insertRecord(record);
    }

}
