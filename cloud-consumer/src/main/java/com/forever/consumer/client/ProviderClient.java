package com.forever.consumer.client;

import com.forever.consumer.dto.Artist;
import com.forever.consumer.dto.Record;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author WJX
 * @date 2021/4/15 14:22
 */
@FeignClient(name = "cloud-service-provider")
@RequestMapping(value = "/provider")
public interface ProviderClient {

    @RequestMapping(value = "/select/artist")
    Artist selectArtist(@RequestParam("id") Integer id);

    @RequestMapping(value = "/insert/artist")
    Integer insertArtist(@RequestBody Artist artist);

    @RequestMapping(value = "/select/record")
    Record selectRecord(@RequestParam("id") Integer id);

    @RequestMapping(value = "/insert/record")
    Integer insertRecord(@RequestBody Record record);

}
