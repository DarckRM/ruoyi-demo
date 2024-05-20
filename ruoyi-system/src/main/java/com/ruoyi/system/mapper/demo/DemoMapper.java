package com.ruoyi.system.mapper.demo;

import com.ruoyi.system.domain.demo.Record;

import java.util.List;

public interface DemoMapper {
    public int insertRecord(Record record);

    public int deleteRecord(Long id);

    public int updateRecord(Record record);

    public List<Record> selectRecords(Record record);
}
