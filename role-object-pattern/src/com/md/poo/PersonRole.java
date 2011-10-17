/**
 * 
 */
package com.md.poo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 * @author diego
 *
 */
@Entity
@NamedQuery(name = "PersonRole.all", query = "SELECT PR FROM PersonRole PR")
public abstract class PersonRole extends Person {

	private PersonCore personCore;
	
	PersonRole() {
		// ORM :(
	}
	
	
	
	public PersonRole(PersonCore personCore) {
		super();
		this.personCore = personCore;
	}
	/**
	 * 
	 * @return a role name 
	 */
	public abstract String roleName();


	public String getName() {
		return personCore.getName();
	}


	public Date getCreatedDate() {
		return personCore.getCreatedDate();
	}


	public void addRole(PersonRole personRole) {
		personCore.addRole(personRole);
	}


	public PersonRole getRole(Class<?> roleClass) {
		return personCore.getRole(roleClass);
	}
}
