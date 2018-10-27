package bd.erp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import bd.erp.model.Customer;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class CustomerService implements ICustomerService {

	@PersistenceContext
	private EntityManager em;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Customer customer) throws Exception {

		em.persist(customer);
		em.flush();

		System.out.println("------------save ok -------------------");
	}
	
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	 public void update(Customer customer) {
		System.out.println("Trying to edit");
	       
		Customer editcustomer = find(customer.getId());
		System.out.println("id: "+customer);
		System.out.println("Name: "+customer.getName());
		    editcustomer.setName(customer.getName());
		    editcustomer.setBirthdate(customer.getBirthdate());
		    editcustomer.setBalance(customer.getBalance());
		    editcustomer.setIsActive(customer.getIsActive());
		    System.out.println("editcustomer : "+editcustomer.getName());
	        em.merge(editcustomer);
	         em.flush();
	    }
	
	

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	  public void remove(Customer entity) {
	        em.remove(em.merge(entity));
	    }

	public Customer getCustomer(Customer customer) {

		// Query query = em.createNativeQuery("select * from customer where id = :id", Customer.class);
		// Query query =em.createQuery("SELECT c FROM Customer c WHERE c.id = :id")
		Query query = em.createNamedQuery("Customer.findById");
		query.setParameter("id", customer.getId());
		Customer customerRs = (Customer) query.getSingleResult();
		return customerRs;
	}

	
	
	public List<Customer> getCustomerList() {
		
		Query query =em.createQuery("SELECT c FROM Customer c");
	    List<Customer> customerRss= (List<Customer>) query.getResultList();
		return customerRss;
}
	 public Customer find(Object id) {
	        return em.find(Customer.class, id);
	    }

	
}
