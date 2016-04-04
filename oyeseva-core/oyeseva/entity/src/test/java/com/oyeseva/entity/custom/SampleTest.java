package com.oyeseva.entity.custom;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oyeseva.entity.dao.SampleDAO;
import com.oyeseva.entity.generated.Sample;

public class SampleTest {

	// Create Spring application context
	private static ClassPathXmlApplicationContext ctx;

	// Get service from context. (service's dependency (ProductDAO) is autowired
	// in ProductService)
	private static SampleDAO sampleDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// mEntityManager.close();
		// mEmf.close();
	}

	@Before
	public void setUp() throws Exception {
		// Create Spring application context
		ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");

		// Get service from context. (service's dependency (ProductDAO) is
		// autowired in ProductService)
		sampleDAO = ctx.getBean(SampleDAO.class);
	}

	@After
	public void tearDown() throws Exception {
		ctx.close();
	}

	@Test
	public final void testSample() {

		Sample sample = new Sample();
		sample.setName("test_name2_" + System.currentTimeMillis());
		sampleDAO.persist(sample);
		System.out.println("listAll: " + sampleDAO.findAll());
	}

	/*
	 * @Test public final void testGetId() { fail("Not yet implemented"); //
	 * TODO }
	 * 
	 * @Test public final void testSetId() { fail("Not yet implemented"); //
	 * TODO }
	 * 
	 * @Test public final void testGetUuid() { fail("Not yet implemented"); //
	 * TODO }
	 * 
	 * @Test public final void testSetUuid() { fail("Not yet implemented"); //
	 * TODO }
	 * 
	 * @Test public final void testGetUserProfiles() {
	 * fail("Not yet implemented"); // TODO }
	 * 
	 * @Test public final void testSetUserProfiles() {
	 * fail("Not yet implemented"); // TODO }
	 * 
	 * @Test public final void testAddUserProfile() {
	 * fail("Not yet implemented"); // TODO }
	 * 
	 * @Test public final void testRemoveUserProfile() {
	 * fail("Not yet implemented"); // TODO }
	 */
}
