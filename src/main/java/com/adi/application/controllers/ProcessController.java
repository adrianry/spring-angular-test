package com.adi.application.controllers;


import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.adi.application.entities.Process;

@RestController
public class ProcessController {

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("/process/{processId}")
    public Process getProcess(@PathVariable("processId") String processId) {
        Execution execution = runtimeService.createExecutionQuery().processInstanceId(processId).singleResult();
        Process process = new Process(execution.getId(),"");
        System.out.println("Query Return Process Object mapped: " + process.toString());
        return process;
    }

    @PostMapping("/process")
    public Process startProcess(@RequestBody String processName) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processName,"adisBusinesskey");
        System.out.println("New Process Instance created: " + processInstance.getId());
        Process process = new Process(processInstance.getId(),processInstance.getBusinessKey());
        System.out.println("New Process Object mapped: " + process.toString());
        return process;
    }
}
