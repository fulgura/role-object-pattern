/**
 * 
 */
package com.md.poo;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 * @author diego
 *
 */
@Entity
@NamedQuery(name = "PersonRole.all", query = "SELECT PR FROM PersonRole PR")
public abstract class PersonRole extends Person {

	PersonRole() {
		// ORM :(
	}

	/**
	 * 
	 * @return a role name 
	 */
	public abstract String roleName();
}
