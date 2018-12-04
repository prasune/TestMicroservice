package com.example.demo.rest.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class User {
	
	private String id;

	@NotNull(message="First name cannot be missing or empty")
    @Size(min=2, message="First name must not be less than 2 characters")
	private String firstName;
	
	@NotNull(message="Last name cannot be missing or empty")
    @Size(min=2, message="Last name must not be less than 2 characters")
	private String lastName;
	
	@Email
	private String email;
	
	@NotNull(message="Password is a required field")
    @Size(min=8, max=16, 
    message="Password must be equal to or greater than 8 characters and less than 16 characters")
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return ObjectUtils.nullSafeHashCode(this.id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}	
}
