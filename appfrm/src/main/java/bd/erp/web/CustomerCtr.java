package bd.erp.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang.StringUtils;

import bd.erp.model.Customer;
import bd.erp.service.ICustomerService;

@Named
@ViewScoped
public class CustomerCtr implements Serializable {

	private static final long serialVersionUID = 1L;
	private String page;
	private String currentPage = "/views/customer/List.xhtml";
	private boolean isListview=false;
	private boolean isGridview=false;
	private String gridSearchKey;
	@EJB
	private ICustomerService iCustomerService;

	@Inject
	private Customer customer;

	private List<Customer> customers;
	 private List<Customer> filteredPartners;;
	
	

	@PostConstruct
	public void init() {

		System.out.println("-------------user------------->>>");
		customers = iCustomerService.getCustomerList();
        System.out.println(customers);
		filteredPartners = new ArrayList<>();
		filteredPartners.addAll(customers);
		System.out.println("-------------user- end------------>>>");
	}

	public void saveData() {

		System.out.println("data in save mrthod " + customer);

		try {
			iCustomerService.save(customer);
			//iCustomerService.getCustomer(customer);
			//System.out.println("-----------last customer is : " + customer.getId());
			currentPage = "/views/customer/View.xhtml";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		customers = iCustomerService.getCustomerList();

	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getCustomers() {
		//customers = iCustomerService.getCustomerList();
		System.out.println(customers);
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	 public String getPage() {
	        return currentPage;
	    }

	    public void setPage(String currentPage) {
	        this.currentPage = currentPage;
	    }
	    
	    public void prepareCreateCustomer() {
	    	customer = new Customer();
	    	currentPage = "/views/customer/Create.xhtml";
	    }
	    
        public void prepareViewCustomer() {
	    	
	    	currentPage = "/views/customer/View.xhtml";
	    }
	    
        public void prepareViewCustomer(int index, int id) {

            if ((customers != null) && (index < customers.size()) && (index >= 0) && (customers.get(index).getId() == id)) {
            	customer = customers.get(index);
                currentPage = "/views/customer/View.xhtml";
            }
        }
        
	    // Editing -----------
	    public void prepareEditCustomer(Integer id) {
	    	System.out.println("In edit, id: "+id);
	           if (customerExist(id)) {
	        	   System.out.println("Customer exist, customer id: "+id); 
	               currentPage = "/views/customer/Edit.xhtml";
	           }
	       }
	                  public void cancelCustomerEdit(Integer id) {
	                	  System.out.println("In edit cancel");
	           if (customerExist(id)) {
	        	   System.out.println("trying to cancel edit");
	               currentPage = "/views/customer/View.xhtml";
	           }
	       }
	                  
	                  private boolean customerExist(Integer id) {
	                      if (id != null) {
	                         Customer customer = iCustomerService.find(id);
	                          if (customer == null) {
	                        	  isListview=true;
	                              showCustomers();
	                              return false;
	                          } else {
	                              return true;
	                          }

	                      } else {
	                          return false;
	                      }
	                  }
	                  
	                  public void editCustomer(Integer id) {
	                	  System.out.println("Edit method called");
	                	  System.out.println("customer info:   "+customer);
	                      if (!customerExist(id)) {
	                          //JsfUtil.addWarningMessageDialog("InvalidAction", "ErrorProceedEdit");
	                    	  System.out.println("Customer Id is not found: "+id);
	                    	  currentPage = "/views/customer/View.xhtml";
	                      } else if (customer != null) {
	                    	  
	                    	  System.out.println("customer exists:   "+id);
	                    	  System.out.println("customer info then:   "+customer);
	                    	   iCustomerService.update(customer);
	                         
	                          currentPage = "/views/customer/View.xhtml";
	                      }
	                  }
	                  
	                  
	                  public void deleteCustomer(Integer id) {

	                      if (customerExist(id)) {
	                          try {
	                              iCustomerService.remove(customer);
	                              customers = iCustomerService.getCustomerList();
	                              currentPage = "/views/customer/List.xhtml";
	                          } catch (Exception e) {
	                              
	                              return;
	                          }

	                       
 
	                      } else {
	                         
	                      }
	                  }
	                  
	                  public void showCustomers() {
	                	  System.out.println("in show customer method");
	                     if(isListview){
	                    	 currentPage = "/views/customer/List.xhtml";
	                    	 System.out.println("list view");  
	                     }else if(isGridview){
	                    	 System.out.println("grid view");  
	                    	 currentPage = "/views/customer/GridView.xhtml";
	                    	 
	                     }else{
	                    	 
	                    	 currentPage = "/views/customer/List.xhtml";
	                     }
	                         
	                  }
	                  
	                  public void showCustomerListView(){
	                	  isListview=true;
	                	  isGridview = false;
	                	  System.out.println("in list view method");
	                	  showCustomers();
	                  }
	                  
	                  public void showCustomerGridView() {
	                	  System.out.println("in grid view method");
	                	  isListview=false;
	                      isGridview = true;
	                      showCustomers();
	                  }

	                  public void searchByName() {

	                      if (customers != null && filteredPartners != null) {
	                          if (gridSearchKey != null && !gridSearchKey.isEmpty()) {

	                        	  customers = new ArrayList<>();

	                              for (Customer part : filteredPartners) {
	                                  if (StringUtils.containsIgnoreCase(part.getName(), gridSearchKey)) {
	                                	  customers.add(part);
	                                  }
	                              }
	                          } else if (gridSearchKey != null && gridSearchKey.isEmpty()) {
	                        	  customers = new ArrayList<>();
	                        	  customers.addAll(filteredPartners);
	                          }
	                      }

	                      gridSearchKey = null;
	                  }
//	                  
	                  
					public String getGridSearchKey() {
						return gridSearchKey;
					}

					public void setGridSearchKey(String gridSearchKey) {
						this.gridSearchKey = gridSearchKey;
					}

					
	                  
	                  

	                  
	                
}
