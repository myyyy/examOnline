package com.augmentum.examonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.augmentum.examonline.Constants;
import com.augmentum.examonline.model.Exam;
import com.augmentum.examonline.model.Pagination;
import com.augmentum.examonline.service.ExamService;
import com.augmentum.examonline.until.StringUtil;
@Controller
@RequestMapping(Constants.APP_URL_EXAM_PREFIX)
public class ExamController extends BaseController{
    ////SELECT *,FROM_UNIXTIME(UNIX_TIMESTAMP(effective_time),'%Y-%m-%d') AS effective_time from exam
    private ExamService examService;
    public ExamService getExamService() {
        return examService;
    }
    public void setExamService(ExamService examService) {
        this.examService = examService;
    }
    @Autowired
    public void setQuestionService(ExamService examService) {
        this.examService = examService;
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list (
                          @RequestParam(value = "pageNo", defaultValue = "1")
                          int pageNoStr,
                          @RequestParam(value = "key", defaultValue = "")
                          String key
                          ) {
    ModelAndView modelAndView = new ModelAndView();
    List<Exam>exams = null;
    Pagination pagination = new Pagination();
    pagination.setPageNo(pageNoStr);
    exams = examService.findlist(pageNoStr, pagination, key);
    modelAndView.addObject("Pagination", pagination);
    modelAndView.addObject("Exam", exams);
    modelAndView.addObject("key", key);
    modelAndView.setViewName("exam/show_exam");
    return modelAndView;
}

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create (){
        Exam exam = new Exam();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exam", exam);
        modelAndView.setViewName("exam/create_exam");
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit (
                              @RequestParam(value = "id", defaultValue = "")
                              int id){
        Exam exam = examService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exam", exam);
        modelAndView.setViewName("exam/create_exam");
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(Exam exam,
                            @RequestParam(value = "effectiveTimeTest", defaultValue = "")
                            String time) {
        System.out.println(time);
        exam.setEffectiveTime(StringUtil.stringToDate(time));
        ModelAndView modelAndView = new ModelAndView();
        examService.update(exam);
        modelAndView.setView(this.getRedirectView("exam/list"));
        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(
                                @RequestParam(value = "id", defaultValue = "")
                                String stringId,
                                @RequestParam(value = "pageNo", defaultValue = "")
                                String pageNo
                                ) {
        ModelAndView modelAndView = new ModelAndView();
        String[]dealId = stringId.split(",");
        for(int i=0; i<dealId.length; i++) {
           int id  = Integer.parseInt(dealId[i]);
            examService.delete(id);
        }
        modelAndView.addObject("pageNo", pageNo);
        modelAndView.setView(this.getRedirectView("exam/list"));
        return modelAndView;
    }

}
