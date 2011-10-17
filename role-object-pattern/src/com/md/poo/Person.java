/**
 * 
 */
package com.md.poo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author diego
 * 
 */
@Entity
@NamedQuery(name = "Person.all", query = "SELECT P FROM Person P")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	
	Person() {
		// ORM nedeed :(
	}

	
	
}
