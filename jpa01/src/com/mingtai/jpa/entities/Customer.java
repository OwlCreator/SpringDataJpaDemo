package com.mingtai.jpa.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Table(name = "jpa_customer")
@Entity
public class Customer {
	private Integer Id;
	private String lastName;
	private Integer age;
	private String email;
    private Date birth;
    private Date currentTime;
	
	/*@TableGenerator(table = "jpa_id_generator", name = "id_generator", 
			       pkColumnName = "PK_NAME", pkColumnValue = "customer_id", 
	
			       valueColumnName = "PK_VALUE", allocationSize = 100 )*/
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="id")
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.DATE)
	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Date getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}

	
	@Transient
	public String getInfo(){
		return "lastName"+lastName+"age"+age+"email"+email;
	}

	@Override
	public String toString() {
		return "Customer [Id=" + Id + ", lastName=" + lastName + ", age=" + age + ", email=" + email + ", birth="
				+ birth + ", currentTime=" + currentTime + "]";
	}
	
	
	
}
