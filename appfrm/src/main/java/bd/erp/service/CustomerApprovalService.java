package bd.erp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import bd.erp.model.CustomerApproval;
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class CustomerApprovalService implements ICustomerApprovalService{
	@PersistenceContext
	private EntityManager em;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(CustomerApproval customer) throws Exception {

		em.persist(customer);
		em.flush();

		System.out.println("------------save ok -------------------");
	}
	
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	 public CustomerApproval update(CustomerApproval customer) {
		System.out.println("Trying to edit: "+customer);
	   
	        em.merge(customer);
	         em.flush();
	         System.out.println("updated");
	         return customer;
		        

	    }
	
	

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	  public void remove(CustomerApproval entity) {
	        em.remove(em.merge(entity));
	    }

	public CustomerApproval getCustomer(CustomerApproval customer) {

		// Query query = em.createNativeQuery("select * from customer where id = :id", Customer.class);
		// Query query =em.createQuery("SELECT c FROM Customer c WHERE c.id = :id")
		Query query = em.createNamedQuery("Customer.findById");
		query.setParameter("id", customer.getId());
		CustomerApproval customerRs = (CustomerApproval) query.getSingleResult();
		return customerRs;
	}

	
	
	public List<CustomerApproval> getCustomerList() {
		
		Query query =em.createQuery("SELECT c FROM CustomerApproval c");
	    List<CustomerApproval> customerRss= (List<CustomerApproval>) query.getResultList();
		return customerRss;
}
	 public CustomerApproval find(Object id) {
	        return em.find(CustomerApproval.class, id);
	    }

}
