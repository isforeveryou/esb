package com.forever.api.client;

import com.forever.api.entity.Artist;
import com.forever.api.entity.Record;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "nacos-service-provider")
@RequestMapping(value = "/nacos/provider")
public interface NacosProviderClient {

    @RequestMapping(value = "/select/artist")
    Artist selectArtist(@RequestParam("id") Integer id);

    @RequestMapping(value = "/insert/artist")
    Integer insertArtist(@RequestBody Artist artist);

    @RequestMapping(value = "/select/record")
    Record selectRecord(@RequestParam("id") Integer id);

    @RequestMapping(value = "/insert/record")
    Integer insertRecord(@RequestBody Record record);

}
