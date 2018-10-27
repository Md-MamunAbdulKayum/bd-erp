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
import bd.erp.model.CustomerApproval;
import bd.erp.service.ICustomerApprovalService;


@Named
@ViewScoped
public class CustomerApprovalCtr implements Serializable {

	private static final long serialVersionUID = 1L;
	private String page;
	private String currentPage = "/views/customer-approval/List.xhtml";
	private boolean isListview=false;
	private boolean isGridview=false;
	private String gridSearchKey;
	@EJB
	private ICustomerApprovalService iCustomerApprovalService;

	@Inject
	private CustomerApproval customer;

	private List<CustomerApproval> customers;
	 private List<CustomerApproval> filteredPartners;;
	
	

	@PostConstruct
	public void init() {

		System.out.println("-------------user------------->>>");
		customers = iCustomerApprovalService.getCustomerList();
        System.out.println(customers);
		filteredPartners = new ArrayList<>();
		filteredPartners.addAll(customers);
		System.out.println("-------------user- end------------>>>");
	}

	public void saveData() {

		System.out.println("data in save mrthod " + customer);

		try {
			customer.setState("Draft");
			iCustomerApprovalService.save(customer);
			//iCustomerApprovalService.getCustomer(customer);
			//System.out.println("-----------last customer is : " + customer.getId());
			System.out.println("saved: " + customer);

			currentPage = "/views/customer-approval/View.xhtml";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		customers = iCustomerApprovalService.getCustomerList();

	}
	
	public void confirmCustomer(Integer id){
		System.out.println("In confirm method");
		   if (customerExist(id)) {
	            if (customer.getState().equals("Draft")) {
	            	customer.setState("Make");
	            	customer = iCustomerApprovalService.update(customer);
	            	//customers.set(customers.indexOf(customer), customer);
	            } else {
	                //JsfUtil.addWarningMessageDialog("InvalidAction", "ErrorAlreadyModified");
	            }
	        }
	}
	
	public void checkCustomer(Integer id){
		System.out.println("In Check method");
		   if (customerExist(id)) {
	            if (customer.getState().equals("Make")) {
	            	customer.setState("Check");
	            	customer = iCustomerApprovalService.update(customer);
	            	//customers.set(customers.indexOf(customer), customer);
	            } else {
	                //JsfUtil.addWarningMessageDialog("InvalidAction", "ErrorAlreadyModified");
	            }
	        }
	}

	public CustomerApproval getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerApproval customer) {
		this.customer = customer;
	}

	public List<CustomerApproval> getCustomers() {
		//customers = iCustomerApprovalService.getCustomerList();
		System.out.println(customers);
		return customers;
	}

	public void setCustomers(List<CustomerApproval> customers) {
		this.customers = customers;
	}
	
	 public String getPage() {
	        return currentPage;
	    }

	    public void setPage(String currentPage) {
	        this.currentPage = currentPage;
	    }
	    
	    public void prepareCreateCustomer() {
	    	customer = new CustomerApproval();
	    	currentPage = "/views/customer-approval/Create.xhtml";
	    }
	    
        public void prepareViewCustomer() {
	    	
	    	currentPage = "/views/customer-approval/View.xhtml";
	    }
	    
        public void prepareViewCustomer(int index, int id) {

            if ((customers != null) && (index < customers.size()) && (index >= 0) && (customers.get(index).getId() == id)) {
            	customer = customers.get(index);
                currentPage = "/views/customer-approval/View.xhtml";
            }
        }
        
	    // Editing -----------
	    public void prepareEditCustomer(Integer id) {
	    	System.out.println("In edit, id: "+id);
	           if (customerExist(id)) {
	        	   System.out.println("Customer exist, customer id: "+id); 
	               currentPage = "/views/customer-approval/Edit.xhtml";
	           }
	       }
	                  public void cancelCustomerEdit(Integer id) {
	                	  System.out.println("In edit cancel");
	           if (customerExist(id)) {
	        	   System.out.println("trying to cancel edit");
	               currentPage = "/views/customer-approval/View.xhtml";
	           }
	       }
	                  
	                  private boolean customerExist(Integer id) {
	                      if (id != null) {
	                    	  CustomerApproval customer = iCustomerApprovalService.find(id);
	                          if (customer == null) {
	                        	  System.out.println("Customer is not exists, ID: ");
	                        	  isListview=true;
	                              showCustomers();
	                              return false;
	                          } else {
	                        	  System.out.println("Customer exists, ID: "+id);
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
	                    	  currentPage = "/views/customer-approval/View.xhtml";
	                      } else if (customer != null) {
	                    	  
	                    	  System.out.println("customer exists:   "+id);
	                    	  System.out.println("customer info then:   "+customer);
	                    	   iCustomerApprovalService.update(customer);
	                         
	                          currentPage = "/views/customer-approval/View.xhtml";
	                      }
	                  }
	                  
	                  
	                  public void deleteCustomer(Integer id) {

	                      if (customerExist(id)) {
	                          try {
	                              iCustomerApprovalService.remove(customer);
	                              customers = iCustomerApprovalService.getCustomerList();
	                              currentPage = "/views/customer-approval/List.xhtml";
	                          } catch (Exception e) {
	                              
	                              return;
	                          }
	                       
	                      } else {
	                         
	                      }
	                  }
	                  
	                  public void showCustomers() {
	                	  System.out.println("in show customer method");
	                     if(isListview){
	                    	 currentPage = "/views/customer-approval/List.xhtml";
	                    	 System.out.println("list view");  
	                     }else if(isGridview){
	                    	 System.out.println("grid view");  
	                    	 currentPage = "/views/customer-approval/GridView.xhtml";
	                    	 
	                     }else{
	                    	 
	                    	 currentPage = "/views/customer-approval/List.xhtml";
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

	                              for (CustomerApproval part : filteredPartners) {
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
