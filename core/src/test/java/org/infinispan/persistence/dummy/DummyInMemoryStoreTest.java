package org.infinispan.persistence.dummy;

import org.infinispan.persistence.BaseCacheStoreTest;
import org.infinispan.persistence.BaseCacheStoreTest;
import org.infinispan.persistence.CacheLoaderException;
import org.infinispan.persistence.DummyLoaderContext;
import org.infinispan.persistence.DummyLoaderContext;
import org.infinispan.persistence.spi.AdvancedLoadWriteStore;
import org.infinispan.test.fwk.TestCacheManagerFactory;
import org.testng.annotations.Test;

@Test(groups = "unit", testName = "loaders.dummy.DummyInMemoryStoreTest")
public class DummyInMemoryStoreTest extends BaseCacheStoreTest {

   @Override
   protected AdvancedLoadWriteStore createStore() throws CacheLoaderException {
      DummyInMemoryStore cl = new DummyInMemoryStore();
      final DummyInMemoryStoreConfigurationBuilder loader = TestCacheManagerFactory
            .getDefaultCacheConfiguration(false)
            .persistence()
            .addStore(DummyInMemoryStoreConfigurationBuilder.class);
      loader
         .storeName(getClass().getName());
      cl.init(new DummyLoaderContext(loader.create(), getCache(), getMarshaller()));
      cl.start();
      csc = loader.create();
      return cl;
   }
}
