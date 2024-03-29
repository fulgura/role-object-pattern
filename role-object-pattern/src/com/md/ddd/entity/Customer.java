/**
 * 
 */
package com.md.ddd.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * It's a ConcreteRole in the Role Object Pattern.<BR>
 * <b>Structure</b><BR>
 * - models and implements a context-specific extension of the Component
 * interface( {@link Person} )<BR>
 * - can be instantiated with a ComponentCore as argument ( {@link PersonCore} ) <BR>
 * 
 * @author diego
 * 
 */
@Entity
@Table(name = "CUSTOMER")
@PrimaryKeyJoinColumn
@NamedQuery(name = "Customer.all", query = "SELECT C FROM Customer C")
public class Customer extends PersonRole {

	private static final long serialVersionUID = 1L;

	@Column(name = "IDENTIFICATION")
	private String identification;

	Customer() {
		// ORM :(
	}

	public Customer(PersonCore personCore, String identification) {
		super(personCore);
		this.identification = identification;
		personCore.addRole(this);
	}

	@Override
	public String roleName() {
		return this.getClass().getCanonicalName();
	}

	public String getIdentification() {
		return identification;
	}
}
