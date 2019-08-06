package com.qf.web;

import com.qf.bean.ExaminationQuestion4;
import com.qf.bean.Finished;
import com.qf.service.ExamQuestion4Service;
import com.qf.utils.DataView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class Suject4Controller {

@Resource
private ExamQuestion4Service examQuestion4Service;

    /**
     * 一: 顺序考试  (主键查询)
     * @param id
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/selectQuestion4")
    public DataView selectQuestion(Integer id){

      //调用service方法
        ExaminationQuestion4 byId = examQuestion4Service.findById(id);

         DataView dataView=new DataView();
         dataView.setCode(0);
         dataView.setMsg("成功");
         dataView.setData(byId);

        return dataView;
    }

    //二: 模拟考试  (全查)
    @RequestMapping(method = RequestMethod.POST,value = "/selectQuestion4ForExam")
    public DataView selectQuestionForExam(Integer model){

        //调用service方法,查询所有题
        List<ExaminationQuestion4> question4s = examQuestion4Service.selectAll(model);
        DataView dataView=new DataView();
        if (question4s!=null) {
            dataView.setMsg("成功");
            dataView.setCode(0);
            dataView.setDataList(question4s);
             return dataView;
        }
        return null;
    }

    //三, 随机练习   (条件查询+SELECT * FROM examination_question4 ORDER BY RAND())
    @RequestMapping(method = RequestMethod.POST,value = "/selectForRandom")
    public DataView selectForRandom(){
        DataView dataView=new DataView();
     //调用service
        List<ExaminationQuestion4> questions = examQuestion4Service.selectForRandom();
        if (questions!=null){
            dataView.setMsg("查询成功");
            dataView.setCode(0);
            dataView.setDataList(questions);
            return dataView;
        }
        return null;
    }

    /**
     * 四: 错题增加  (增加已做题)
     */
   @RequestMapping(method = RequestMethod.POST,value ="/addWrong")
    public DataView updateWrongNum(Integer uid,Integer qid,@RequestParam(defaultValue = "0") Integer colstatus){

       Finished finished=new Finished();
       finished.setQid(qid);
       finished.setUid(uid);
       finished.setRwstatus(1);
       finished.setColstatus(colstatus);
       //调用service方法
       DataView dataView=new DataView();
       int i = examQuestion4Service.insertFinished(finished);
       System.out.println(i+"-------这是i的值");
       if (i>0){
           dataView.setMsg("成功");
           dataView.setCode(0);
           return dataView;
       }
       dataView.setMsg("增加错题失败");
       dataView.setCode(0);
       return dataView;
   }

   //五: 专项练习  (条件查询)
    @RequestMapping(method = RequestMethod.POST,value = "/selectQuestionForSpec")
    public DataView selectForSpec(Integer tid){

       //调用service方法
        List<ExaminationQuestion4> question4s = examQuestion4Service.selectAllForSpec(tid);
        DataView dataView=new DataView();

       if (question4s!=null){
           dataView.setDataList(question4s);
           dataView.setMsg("成功");
           dataView.setCode(0);
           return dataView;

       }else {
           dataView.setMsg("打开失败");
           dataView.setCode(1);
           dataView.setDataList(null);

           return dataView;
       }
    }
    //六: 优先做未考题
    @RequestMapping(method = RequestMethod.POST,value = "/selectUndo")
    public DataView selectUndo() {
        DataView dataView = new DataView();
        List<ExaminationQuestion4> list = examQuestion4Service.selectUndo();

        if (list != null) {
            dataView.setDataList(list);
            dataView.setMsg("成功");
            dataView.setCode(0);
            return dataView;

        } else {
            dataView.setMsg("失败");
            dataView.setCode(1);
            dataView.setDataList(null);

            return dataView;
        }

    }
}
