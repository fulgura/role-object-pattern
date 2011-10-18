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
import com.md.ddd.entity.PersonRole;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> customerList() throws ServiceException {
		List<Customer> customerList = entityManager.createNamedQuery("Customer.all").getResultList();
		for (Customer customer : customerList) {
			customer.getPersonCore().getRoleList().isEmpty();
		}
		return customerList;
	}

	@Override
	public PersonCore save(PersonCore personCore) throws ServiceException {
		entityManager.persist(personCore);
		return personCore;
	}

//	@Override
//	public <T extends PersonRole> T save(T personRole) throws ServiceException {
//		entityManager.persist(personRole);
//		return personRole;
//	}

	@Override
	public Customer save(Customer customer) throws ServiceException {
		
		//entityManager.(arg0)
		//PersonCore personCore = entityManager.find(customer.getPersonCore().getClass(), customer.getPersonCore().getId());
		entityManager.refresh(customer.getPersonCore());
		entityManager.persist(customer);
		return customer;
	}

}
