package com.forever.provider.db;

import com.alibaba.fastjson.JSON;
import com.forever.provider.dto.Artist;
import com.forever.provider.dto.Record;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WJX
 * @date 2021/4/16 11:31
 */
@Component
public class ReadDataFileRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        readArtistFile();
        readRecordFile();
    }


    private void readArtistFile() {
        try {
            Map<Integer, Artist> artistTable = new HashMap<>(15);
            BufferedReader reader = new BufferedReader(new FileReader(WriteScheduled.ARTIST_TABLE_PATH));

            String line;
            int readLine = 0;
            while ((line = reader.readLine()) != null) {
                readLine++;
                String[] entry = line.split(WriteScheduled.KEY_VALUE_SIGN);
                artistTable.put(Integer.parseInt(entry[0]), JSON.parseObject(entry[1], Artist.class));
            }

            ArtistTable.getInstance().setArtistTable(artistTable);
            System.out.println("ReadDataFileRunner:read artist file end,total " + readLine + " line");

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void readRecordFile() {
        try {
            Map<Integer, Record> recordTable = new HashMap<>(60);
            BufferedReader reader = new BufferedReader(new FileReader(WriteScheduled.RECORD_TABLE_PATH));

            String line;
            int readLine = 0;
            while ((line = reader.readLine()) != null) {
                readLine++;
                String[] entry = line.split(WriteScheduled.KEY_VALUE_SIGN);
                recordTable.put(Integer.parseInt(entry[0]), JSON.parseObject(entry[1], Record.class));
            }

            RecordTable.getInstance().setRecordTable(recordTable);
            System.out.println("ReadDataFileRunner:read record file end,total " + readLine + " line");

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
