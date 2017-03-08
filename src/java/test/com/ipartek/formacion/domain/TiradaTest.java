package com.ipartek.formacion.domain;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TiradaTest {
	
	static final int ID = 2;
	static final Date FECHATIRADA = new Date();
	
	static Tirada tirada = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tirada = new Tirada();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		tirada = null;
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {

		assertEquals(-1, tirada.getIdTirada());
		assertEquals("", tirada.getFechaTirada());
		
		tirada = null;

		tirada = new Tirada(ID, FECHATIRADA);
		assertEquals(ID, tirada.getIdTirada());
		assertEquals(FECHATIRADA, tirada.getFechaTirada());
		
}
	@Test
	public void testSetterGetter() {

		tirada.setIdTirada(ID);
		assertEquals(ID, tirada.getIdTirada());

		tirada.setFechaTirada(FECHATIRADA);
		

}
	
}
