package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.demo.Record;
import com.ruoyi.system.mapper.demo.DemoMapper;
import com.ruoyi.system.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements IDemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public int insertRecord(Record record) {
        return demoMapper.insertRecord(record);
    }

    @Override
    public int deleteRecord(Long id) {
        return demoMapper.deleteRecord(id);
    }

    @Override
    public int updateRecord(Record record) {
        return demoMapper.updateRecord(record);
    }

    @Override
    public List<Record> selectRecords(Record record) {
        return demoMapper.selectRecords(record);
    }
}
