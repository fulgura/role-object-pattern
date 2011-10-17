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
@NamedQuery(name = "PersonCore.all", query = "SELECT PC FROM PersonCore PC")
public class PersonCore extends Person {

	
}
