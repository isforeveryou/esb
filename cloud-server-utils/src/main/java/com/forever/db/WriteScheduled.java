package com.forever.db;

import com.alibaba.fastjson.JSON;
import com.forever.api.entity.Artist;
import com.forever.api.entity.Record;
import com.forever.utils.FileUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * @author WJX
 * @date 2021/4/16 10:52
 */
@Component
public class WriteScheduled {

    static final String KEY_VALUE_SIGN = "===>";
    static final String ARTIST_TABLE_PATH = "D:" + File.separator + "MyFile" + File.separator + "artist.txt";
    static final String RECORD_TABLE_PATH = "D:" + File.separator + "MyFile" + File.separator + "record.txt";


    @Scheduled(fixedDelay = 300000)
    public void writeArtistTask() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            ArtistTable artistTable = ArtistTable.getInstance();

            if (artistTable.getWriteStatus()) {
                for (Map.Entry<Integer, Artist> entry : artistTable.getArtistTable().entrySet()) {
                    stringBuilder.append(entry.getKey()).append(KEY_VALUE_SIGN).append(JSON.toJSON(entry.getValue())).append('\n');
                }

                if (stringBuilder.length() <= 0) {
                    System.out.println("ArtistWriteTask:artist table is empty,not need write to artist file");
                } else {
                    FileWriter fileWriter = new FileWriter(FileUtils.getFile(ARTIST_TABLE_PATH));
                    fileWriter.write(stringBuilder.toString());
                    fileWriter.close();
                    artistTable.setWriteStatus(false);
                    System.out.println("ArtistWriteTask:artist file write end,this time write " + artistTable.getArtistTable().size() + " recording");
                }
            } else {
                System.out.println("ArtistWriteTask:artist table is not update,not need write to artist file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedDelay = 60000)
    public void writeRecordTask() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            RecordTable recordTable = RecordTable.getInstance();

            if (recordTable.getWriteStatus()) {
                for (Map.Entry<Integer, Record> entry : recordTable.getRecordTable().entrySet()) {
                    stringBuilder.append(entry.getKey()).append(KEY_VALUE_SIGN).append(JSON.toJSON(entry.getValue())).append('\n');
                }

                if (stringBuilder.length() <= 0) {
                    System.out.println("RecordWriteTask:record table is empty,not need write to record file");
                } else {
                    FileWriter fileWriter = new FileWriter(FileUtils.getFile(RECORD_TABLE_PATH));
                    fileWriter.write(stringBuilder.toString());
                    fileWriter.close();
                    recordTable.setWriteStatus(false);
                    System.out.println("RecordWriteTask:record file write end,this time write " + recordTable.getRecordTable().size() + " recording");
                }
            } else {
                System.out.println("RecordWriteTask:record table is not update,not need write to record file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
