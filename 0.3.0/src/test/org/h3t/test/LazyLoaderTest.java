package org.h3t.test;

import junit.framework.TestCase;
import net.sf.cglib.proxy.LazyLoader;

import org.h3t.aspect.FieldLazyLoader;
import org.h3t.aspect.MethodLazyLoader;
import org.h3t.test.entity.FieldAccessEntity;
import org.h3t.test.entity.MethodAccessEntity;
import org.h3t.test.entity.RelatedEntity;
import org.h3t.test.util.TestLoadServiceFactory;

public class LazyLoaderTest extends TestCase  {

	private final static String MT = "methodTest";

	private final static String FT = "fieldTest";

	@Override
	protected void setUp() throws Exception {
	}

	@Override
	protected void tearDown() throws Exception {
		TestLoadServiceFactory.clearQueue();
	}

	public void testField() throws Exception {
		TestLoadServiceFactory.queueResult(new RelatedEntity(FT));
		LazyLoader loader = new FieldLazyLoader(new FieldAccessEntity(),
				FieldAccessEntity.class.getField("oneToOneEager"));
		RelatedEntity related = (RelatedEntity) loader.loadObject();
		assertEquals(FT, related.s());
	}

	public void testMethod() throws Exception {
		TestLoadServiceFactory.queueResult(new RelatedEntity(MT));
		LazyLoader loader = new MethodLazyLoader(new MethodAccessEntity(),
				MethodAccessEntity.class.getMethod("getOneToOneEager", new Class[0]));
		RelatedEntity related = (RelatedEntity) loader.loadObject();
		assertEquals(MT, related.s());
	}



}
