/**
 * 
 */
package com.md.ddd.service;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.openejb.api.LocalClient;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.md.ddd.entity.PersonCore;

/**
 * @author diego
 * 
 */
@LocalClient
public class RoleServiceTest {

	@EJB
	private RoleService roleService;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Properties p = new Properties();
		p.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.apache.openejb.client.LocalInitialContextFactory");
		p.put("lastfmDatabase", "new://Resource?type=DataSource");
		p.put("lastfmDatabase.JdbcDriver", "org.postgresql.Driver");
		p.put("lastfmDatabase.JdbcUrl",
				"jdbc:postgresql://localhost/role-pattern");
		p.put("lastfmDatabase.UserName", "rp");
		p.put("lastfmDatabase.Password", "rp");

		InitialContext initialContext = new InitialContext(p);
		initialContext.bind("inject", this);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.md.ddd.service.RoleService#personCoreList()}.
	 * 
	 * @throws ServiceException
	 */
	@Test
	public final void testPersonCoreList() throws ServiceException {
		List<PersonCore> personCoreList = roleService.personCoreList();
		Assert.assertTrue(personCoreList.isEmpty());
	}

	/**
	 * Test method for {@link com.md.ddd.service.RoleService#allCustomer()}.
	 */
	@Test
	public final void testAllCustomer() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link com.md.ddd.service.RoleService#save(com.md.ddd.entity.PersonCore)}
	 * .
	 */
	@Test
	public final void testSavePersonCore() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link com.md.ddd.service.RoleService#save(com.md.ddd.entity.Customer)}.
	 */
	@Test
	public final void testSaveCustomer() {
		fail("Not yet implemented"); // TODO
	}

}