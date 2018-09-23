/*******************************************************************************
 * Copyright (C) 2018 Matthias Sohn <matthias.sohn@sap.com>
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package io.github.msohn.github.examples;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.CommitService;

public class Client {
	private static GitHubClient client = createClient("https://api.github.com/");

	static CommitService getCommitService() {
		return new CommitService(client);
	}

	/**
	 * Create client for url
	 *
	 * @param url
	 * @return client
	 * @throws IOException
	 */
	private static GitHubClient createClient(String url) {
		GitHubClient client = null;
		if (url != null) {
			URL parsed;
			try {
				parsed = new URL(url);
			} catch (MalformedURLException e) {
				e.printStackTrace();
				return null;
			}
			client = new GitHubClient(parsed.getHost(), parsed.getPort(), parsed.getProtocol());
		} else {
			client = new GitHubClient();
		}
		return configure(client);
	}

	/**
	 * Configure client
	 *
	 * @param client
	 * @return specified client
	 */
	private static GitHubClient configure(GitHubClient client) {
		String user = System.getProperty("github.test.user");
		String password = System.getProperty("github.test.password");
		client.setCredentials(user, password);
		return client;
	}
}
