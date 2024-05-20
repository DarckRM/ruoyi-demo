package com.ruoyi.system.domain.demo;

public class Record {
    public Integer id;
    public String data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }
}
