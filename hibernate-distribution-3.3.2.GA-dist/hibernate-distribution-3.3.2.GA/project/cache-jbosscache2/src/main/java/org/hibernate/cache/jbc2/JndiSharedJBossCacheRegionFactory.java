/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2007, Red Hat Middleware LLC or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Middleware LLC.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.cache.jbc2;

import java.util.Properties;

import org.hibernate.cache.jbc2.builder.JndiSharedCacheInstanceManager;

/**
 * {@link JBossCacheRegionFactory} that uses
 * {@link JndiSharedCacheInstanceManager} as its
 * {@link #getCacheInstanceManager() CacheInstanceManager}.
 * <p>
 * Basically, uses a single shared JBoss Cache for entities, collections,
 * queries and timestamps. The JBoss Cache instance is found in JNDI
 * using the value of the {@link JndiSharedCacheInstanceManager#CACHE_RESOURCE_PROP}
 * configuration property as the name to look up. 
 * </p>
 * 
 * @author Brian Stansberry
 * @version $Revision$
 */
public class JndiSharedJBossCacheRegionFactory extends JBossCacheRegionFactory {

    /**
     * FIXME Per the RegionFactory class Javadoc, this constructor version
     * should not be necessary.
     * 
     * @param props The configuration properties
     */
    public JndiSharedJBossCacheRegionFactory(Properties props) {
        this();
    }

    /**
     * Create a new MultiplexedJBossCacheRegionFactory.
     * 
     */
    public JndiSharedJBossCacheRegionFactory() {
        super(new JndiSharedCacheInstanceManager());
    }

}
