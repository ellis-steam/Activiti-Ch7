package org.bpmnwithactiviti.chapter7.errorevent;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.bpmnwithactiviti.chapter7.ws.CustomerServiceService;

public class StoreOpportunityTask implements JavaDelegate{
	
	private CustomerServiceService customerService = new CustomerServiceService();

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		CustomerVariable customer = (CustomerVariable) execution.getVariable("customer");
		String product =(String) execution.getVariable("product");
		Long expectedQuantity = (Long) execution.getVariable("quantity");
		String description = (String) execution.getVariable("description");
		
		customerService.getCustomerServicePort().storeSalesOpportunity(product, expectedQuantity, description, customer.getCustomerId());
	}
}
