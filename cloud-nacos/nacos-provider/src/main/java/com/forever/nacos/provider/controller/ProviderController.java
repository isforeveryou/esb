package com.forever.nacos.provider.controller;

import com.forever.api.entity.Artist;
import com.forever.api.entity.Record;
import com.forever.db.ArtistTable;
import com.forever.db.RecordTable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WJX
 * @date 2021/4/15 11:20
 */
@RestController
@RequestMapping(value = "/provider")
public class ProviderController {

    @RequestMapping(value = "/select/artist")
    public @ResponseBody
    Artist selectArtist(Integer id) {
        return ArtistTable.getInstance().selectArtist(id);
    }

    @RequestMapping(value = "/insert/artist")
    public Integer insertArtist(@RequestBody Artist artist) {
        return ArtistTable.getInstance().insertArtist(artist);
    }

    @RequestMapping(value = "/select/record")
    public @ResponseBody
    Record selectRecord(Integer id) {
        return RecordTable.getInstance().selectRecord(id);
    }

    @RequestMapping(value = "/insert/record")
    public Integer insertRecord(@RequestBody Record record) {
        return RecordTable.getInstance().insertRecord(record);
    }

}
