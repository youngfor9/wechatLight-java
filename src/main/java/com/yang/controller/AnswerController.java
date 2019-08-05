package com.yang.controller;
import com.yang.Utils.JsonUtils;
import com.yang.service.AnswerService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@EnableAutoConfiguration
@RequestMapping("/answer")
public class AnswerController {
    @Resource
    private AnswerService answerService;

    @RequestMapping("/getAnsInfos")
    public String getAnsInfos(Long[] num) {
        return JsonUtils.toJsonString(this.answerService.getAnsInfos(num));
    }
}
