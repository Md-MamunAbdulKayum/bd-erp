package bd.erp.service;

import java.util.List;


import bd.erp.model.CustomerApproval;

public interface ICustomerApprovalService {

	public void save(CustomerApproval customer) throws Exception;
	
	public CustomerApproval getCustomer(CustomerApproval  customer) ;

	public List<CustomerApproval> getCustomerList();

	public CustomerApproval find(Object id);

	public CustomerApproval update(CustomerApproval customer);
	 public void remove(CustomerApproval customer);
}
