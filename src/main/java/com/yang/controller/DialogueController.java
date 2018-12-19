package com.yang.controller;

import com.yang.entity.DialogueInfo;
import com.yang.service.DialogueService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/dialogue")
public class DialogueController {
    @Resource
    private DialogueService dialogueService;

    @RequestMapping("/getDialogueInfos")
    public List<DialogueInfo> getDialogueInfos() {
    return this.dialogueService.getDialogueInfos();
    }

    @RequestMapping("/selectDialogueById")
    public DialogueInfo selectDialogueById(Long did) {
        return this.dialogueService.selectDialogueById(did);
    }
}
