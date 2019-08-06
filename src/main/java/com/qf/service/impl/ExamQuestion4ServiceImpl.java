package com.qf.service.impl;

import com.qf.bean.ExaminationQuestion4;
import com.qf.bean.Finished;
import com.qf.dao.ExaminationQuestion4Mapper;
import com.qf.dao.FinishedMapper;
import com.qf.service.ExamQuestion4Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExamQuestion4ServiceImpl implements ExamQuestion4Service {

    @Resource
    private ExaminationQuestion4Mapper question4Mapper;
    @Resource
    private FinishedMapper finishedMapper;

    /**
     * 查单个题
     * @param id
     * @return
     */
    @Override
    public ExaminationQuestion4 findById(Integer id) {

        ExaminationQuestion4 examinationQuestion4 = question4Mapper.selectByPrimaryKey(id);
        if (examinationQuestion4!=null){
            return examinationQuestion4;
        }
        return null;
    }

    //增加错题
    @Override
    public int insertFinished(Finished finished) {

        int i = finishedMapper.insert(finished);
        System.out.println(i+"++++this is where i start");
        if (i>0){
            return i;
        }

        return 0;
    }


    //模拟考试
    @Override
    public List<ExaminationQuestion4> selectAll(Integer model) {

        List<ExaminationQuestion4> all = question4Mapper.findAll();
        if (all!=null){
            return all;
        }
        return null;
    }

    //随机练习
    @Override
    public List<ExaminationQuestion4> selectForRandom() {
        List<ExaminationQuestion4> byRandom = question4Mapper.findByRandom();
        if (byRandom!=null){
            return byRandom;
        }
        return null;
    }

    //专项练习
    @Override
    public List<ExaminationQuestion4> selectAllForSpec(Integer tid) {
        List<ExaminationQuestion4> byTid = question4Mapper.findByTid(tid);
        if (byTid!=null){
            return byTid;
        }
        return null;
    }

    //优先做未做题
    @Override
    public List<ExaminationQuestion4> selectUndo() {
        List<ExaminationQuestion4> s = question4Mapper.selectUndo();
        System.out.println("这是Undo开始的地方");

        if (s!=null){
            return s;
        }
        return null;
    }
}
