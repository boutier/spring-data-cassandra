/*
 * Copyright 2013-2014 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.cassandra.test.integration.config.xml;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cassandra.core.CqlOperations;
import org.springframework.cassandra.test.integration.AbstractKeyspaceCreatingIntegrationTest;
import org.springframework.cassandra.test.integration.config.IntegrationTestUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.datastax.driver.core.Session;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MinimalXmlConfigTest extends AbstractKeyspaceCreatingIntegrationTest {

	public static final String KEYSPACE = "minimalxmlconfigtest";

	public MinimalXmlConfigTest() {
		super(KEYSPACE);
	}

	@Inject
	Session s;

	@Inject
	CqlOperations ops;

	@Test
	public void test() {
		IntegrationTestUtils.assertSession(s);
		IntegrationTestUtils.assertKeyspaceExists(KEYSPACE, s);

		assertNotNull(ops);
	}
}
