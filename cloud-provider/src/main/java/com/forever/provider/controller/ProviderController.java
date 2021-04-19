package com.forever.provider.controller;

import com.forever.provider.db.ArtistTable;
import com.forever.provider.db.RecordTable;
import com.forever.provider.dto.Artist;
import com.forever.provider.dto.Record;
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
