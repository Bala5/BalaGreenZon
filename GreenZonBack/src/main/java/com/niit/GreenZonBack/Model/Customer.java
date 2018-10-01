package com.niit.GreenZonBack.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Customer 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int cartid;
	
 @Column(unique=true,nullable=false)
 @NotEmpty(message="Email Id cannot blank")
 @Email(regexp="[a-z0-9_.$]+@[a-z]+\\.[a-z]{2,3}",message="please enter the valid Email id")
 private String emailid;
 
 @Column(nullable=false)
 @NotEmpty(message="Name cannot be blank")
 private String name;
 
 @Column(unique=true,nullable=false)
 @NotEmpty(message="Mobile number shouldn't be blank")
 @Pattern(regexp="[9876][0-9]{9}",message="Please give valid mobile  number")
 private String phoneNo;
 
 @Transient
 @NotEmpty(message="Please enter the password")
 @Pattern(regexp="[a-zA-Z0-9]{8,12}",message="Password must contain 8-12 values")
 private String password;

public String getEmailid()
{
	return emailid;
}

public void setEmailid(String emailid) 
{
	this.emailid = emailid;
}

public String getName() 
{
	return name;
}

public void setName(String name)
{
	this.name = name;
}

public String getPhoneNo()
{
	return phoneNo;
}

public void setPhoneNo(String phoneNo) 
{
	this.phoneNo = phoneNo;
}

public String getPassword()
{
	return password;
}

public void setPassword(String password)
{
	this.password = password;
}
 
 
	
}
