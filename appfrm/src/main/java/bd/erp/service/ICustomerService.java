package bd.erp.service;

import java.util.List;

import javax.ejb.Local;

import bd.erp.model.Customer;

@Local
public interface ICustomerService {

	public void save(Customer customer) throws Exception;
	
	public Customer getCustomer(Customer  customer) ;

	public List<Customer> getCustomerList();

	public Customer find(Object id);

	public void update(Customer customer);
	 public void remove(Customer customer);
}
