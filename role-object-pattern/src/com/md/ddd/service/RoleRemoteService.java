/**
 * 
 */
package com.md.ddd.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.md.ddd.entity.Customer;
import com.md.ddd.entity.PersonCore;

/**
 * @author diego
 * 
 */
@Stateless
public class RoleRemoteService implements RoleService {

	@PersistenceContext(unitName = "role-pattern-unit", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PersonCore> personCoreList() throws ServiceException {
		return entityManager.createNamedQuery("PersonCore.all").getResultList();
	}

	@Override
	public List<Customer> allCustomer() throws ServiceException {
		return entityManager.createNamedQuery("Customer.all").getResultList();
	}

	@Override
	public PersonCore save(PersonCore personCore) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer save(Customer customer) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
