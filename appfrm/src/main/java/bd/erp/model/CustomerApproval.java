package bd.erp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "customer")
@NamedQueries({
	    @NamedQuery(name = "CustomerApproval.findAll", query = "SELECT c FROM CustomerApproval c"),
	    @NamedQuery(name = "CustomerApproval.findById", query = "SELECT c FROM CustomerApproval c WHERE c.id = :id")
    })
public class CustomerApproval implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    
    @Column(name = "balance")
    private Long balance;
    
    @Column(name = "age")
    private Integer age;
    
    @Column(name = "isActive")
    private Boolean isActive;
    
    @Column(name = "state")
    private String state;
    
    
    public CustomerApproval() {
    }

    public CustomerApproval(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
    	System.out.println("Name is model: "+name);
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
    

    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerApproval)) {
            return false;
        }
        CustomerApproval other = (CustomerApproval) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "CustomerApproval [id=" + id + ", name=" + name + ", birthdate=" + birthdate + ", balance=" + balance
				+ ", age=" + age + ", isActive=" + isActive + ", state=" + state + "]";
	}

//	@Override
//	public String toString() {
//		return "Customer [id=" + id + ", name=" + name + ", birthdate=" + birthdate + ", balance=" + balance + ", age="
//				+ age + ", isActive=" + isActive + "]";
//	}

   
    
}
