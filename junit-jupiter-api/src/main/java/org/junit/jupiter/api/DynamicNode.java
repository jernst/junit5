/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package org.junit.jupiter.api;

import static org.apiguardian.api.API.Status.EXPERIMENTAL;

import java.util.Optional;

import org.apiguardian.api.API;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.TestSource;

/**
 * {@code DynamicNode} serves as the abstract base class for a container or a
 * test case generated at runtime.
 *
 * @since 5.0
 * @see DynamicTest
 * @see DynamicContainer
 */
@API(status = EXPERIMENTAL, since = "5.0")
public abstract class DynamicNode {

	private final String displayName;

	private TestSource testSource = null;

	DynamicNode(String displayName) {
		this.displayName = Preconditions.notBlank(displayName, "displayName must not be null or blank");
	}

	/**
	 * Get the display name of this {@code DynamicNode}.
	 */
	public String getDisplayName() {
		return this.displayName;
	}

	/**
	 * Get the optional test source of this {@code DynamicNode}.
	 *
	 * @see #withTestSource(TestSource)
	 */
	public Optional<TestSource> getTestSource() {
		return Optional.ofNullable(testSource);
	}

	DynamicNode setTestSource(TestSource testSource) {
		this.testSource = testSource;
		return this;
	}

	/**
	 * Create new instance of this dynamic container or test with a custom test source.
	 *
	 * @param testSource custom test source instance to associate with this node
	 * @return new node instance
	 * @see #getTestSource()
	 */
	public abstract DynamicNode withTestSource(TestSource testSource);

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("displayName", displayName).toString();
	}

}
