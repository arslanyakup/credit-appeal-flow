package com.eteration.workflow.tasks;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service(value = "calculate")
public class Calculate implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Double salary = Double.valueOf(execution.getVariable("salary").toString());
		int creditNote = 500;
		if(salary > 2000) {
			creditNote = 1000;
		} else if(salary > 5000) {
			creditNote = 3000;
		}
		execution.setVariable("creditNote", creditNote);
	}

}
