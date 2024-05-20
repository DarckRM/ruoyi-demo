package com.ruoyi.system.service;

import com.ruoyi.system.domain.demo.Record;

import java.util.List;

public interface IDemoService {
    public int insertRecord(Record record);
    public int deleteRecord(Long id);
    public int updateRecord(Record record);
    public List<Record> selectRecords(Record record);
}
