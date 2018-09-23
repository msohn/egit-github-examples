# EGit Github Examples

This repository contains examples how to use the [EGit Github client](https://git.eclipse.org/r/plugins/gitiles/egit/egit-github/+/refs/heads/master).

## Credentials
In order to set credentials used to authenticate with the Github REST API set the following system properties when starting the example:

```Java
-Dgithub.test.user=foo
-Dgithub.test.password=secret
```

Note that the rate limit enforced by Github is higher for authenticated users.

## Commits

The `Commits` class demonstrates how to use the `CommitService` to list commits of a repository.