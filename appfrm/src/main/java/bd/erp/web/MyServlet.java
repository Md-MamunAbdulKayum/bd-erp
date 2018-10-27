package bd.erp.web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.erp.model.Customer;
import bd.erp.service.ICustomerService;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ICustomerService iCustomerService;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Customer customer = new Customer();
		
		customer.setName("masum");
		try {
			iCustomerService.save(customer);
			//iCustomerService.getCustomerList();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
		List<Customer>	customers = iCustomerService.getCustomerList();
		System.out.println("customer : "+customers.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
