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
import java.util.List;

import org.eclipse.egit.github.core.Commit;
import org.eclipse.egit.github.core.CommitFile;
import org.eclipse.egit.github.core.RepositoryCommit;
import org.eclipse.egit.github.core.RepositoryId;
import org.eclipse.egit.github.core.service.CommitService;

public class Commits {

	public static void main(String[] args) throws IOException {
		CommitService cs = Client.getCommitService();
		RepositoryId repo = new RepositoryId("msohn", "HelloWorld");
		List<RepositoryCommit> commits = cs.getCommits(repo);
		for (RepositoryCommit rc : commits) {
			Commit c = rc.getCommit();
			System.out.println("Commit: "+ rc.getSha());
			System.out.println("Author: " + c.getAuthor().getName() + " <" + c.getAuthor().getEmail() + ">");
			System.out.println("Date: " + c.getAuthor().getDate());
			String message = c.getMessage();
			System.out.println();
			for (String line: message.split("\n")) {
				System.out.println("    " + line);
			}
			System.out.println();
			rc = cs.getCommit(repo, rc.getSha());
			for (CommitFile f : rc.getFiles()) {
				System.out.println(f.getFilename());
			}
			System.out.println();
		}
	}
}
