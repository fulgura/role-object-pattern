/**
 * 
 */
package com.md.ddd.entity;

import java.io.Serializable;

/**
 * Implementation of Role Object Pattern. <BR>
 * <BR>
 * It's a Component in the Role Object Pattern.<BR>
 * <b>INTENT</b> <BR>
 * Adapt an object to different client’s needs through transparently attached
 * role objects, each one representing a role the object has to play in that
 * client’s context. The object manages its role set dynamically. By
 * representing roles as individual objects, different contexts are kept
 * separate and system configuration is simplified. <BR>
 * 
 * 
 * <b>Structure</b><BR>
 * - models a particular key abstraction by defining its interface <BR>
 * - specifies the protocol for adding, removing, testing and querying for role
 * objects. A Client supplies a specification for a ConcreteRole subclass. In
 * the simplest case, it is identified by a string. <BR>
 * <BR>
 * <b>Participants</b><br>
 * - Component ( {@link Person} )<br>
 * - ComponentCore ( {@link PersonCore} )<br>
 * - ComponentRole ( {@link PersonRole} )<br>
 * - ConcreteRole ( {@link Customer} , {@link Borrower} )<br>
 * <br>
 * <br>
 * 
 * @see <a href="http://hillside.net/plop/plop97/Proceedings/riehle.pdf">Role
 *      Object Pattern paper</a>
 * @author diego
 * 
 */
public interface Person extends Serializable {

	/**
	 * Add a new role in a person object. Each time you need to retrieve this
	 * this new role you must use {@link Person#getRole(Class)} following the
	 * API.
	 * 
	 * @param personRole
	 *            a concrete instance of {@link PersonRole} hierarchy.
	 */
	public abstract void addRole(PersonRole personRole);

	/**
	 * Answer if a person object has or not an specific role.
	 * 
	 * @param roleClass
	 *            an class in {@link PersonRole} hierarchy.
	 * @return true if person has this role or false if It hasn't.
	 */
	public abstract boolean hasRole(Class<? extends PersonRole> roleClass);

	public abstract <T extends PersonRole> T getRole(Class<T> roleClass);

	public abstract boolean removeRole(Class<? extends PersonRole> roleClass);

	public abstract String getName();

}
