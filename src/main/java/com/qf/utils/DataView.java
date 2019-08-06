package com.qf.utils;

import com.qf.bean.ExaminationQuestion4;

import java.util.List;

public class DataView<T>{
    private String msg;
    private Integer code;
   private ExaminationQuestion4 data;

   private List<ExaminationQuestion4> dataList;

    public List<ExaminationQuestion4> getDataList() {
        return dataList;
    }

    public void setDataList(List<ExaminationQuestion4> dataList) {
        this.dataList = dataList;
    }

    public DataView() {
    }

    public DataView(String msg, Integer code, ExaminationQuestion4 data, List<ExaminationQuestion4> dataList) {
        this.msg = msg;
        this.code = code;
        this.data = data;
        this.dataList = dataList;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ExaminationQuestion4 getData() {
        return data;
    }

    public void setData(ExaminationQuestion4 data) {
        this.data = data;
    }
}
