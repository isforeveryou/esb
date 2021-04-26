package com.forever.db;


import com.forever.api.entity.Record;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WJX
 * @date 2021/4/15 11:32
 */
public class RecordTable {

    private static volatile RecordTable RECORD_TABLE;

    private boolean writeStatus = false;

    private Map<Integer, Record> recordTable = new HashMap<>();

    private RecordTable() {}

    public static RecordTable getInstance() {
        if (RECORD_TABLE == null) {
            synchronized (RecordTable.class) {
                if (RECORD_TABLE == null) {
                    RECORD_TABLE = new RecordTable();
                }
            }
        }
        return RECORD_TABLE;
    }

    boolean getWriteStatus() {
        return writeStatus;
    }

    void setWriteStatus(boolean status) {
        writeStatus = status;
    }

    void setRecordTable(Map<Integer, Record> recordMap) {
        recordTable = recordMap;
    }

    Map<Integer, Record> getRecordTable() {
        return recordTable;
    }

    public Record selectRecord(Integer key) {
        return recordTable.get(key);
    }

    public Integer insertRecord(Record record) {
        int size = recordTable.size() + 1;
        recordTable.put(size, record);
        setWriteStatus(true);
        return size;
    }

    public void insertRecord(Integer key, Record record) {
        recordTable.put(key, record);
        setWriteStatus(true);
    }


}
