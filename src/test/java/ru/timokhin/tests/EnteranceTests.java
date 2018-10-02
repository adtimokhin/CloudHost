package ru.timokhin.tests;

import org.apache.jackrabbit.rmi.client.RemoteRepositoryException;
import org.apache.jackrabbit.rmi.repository.URLRemoteRepository;
import org.junit.Ignore;
import org.junit.Test;

import javax.jcr.*;
import java.net.MalformedURLException;

public class EnteranceTests {
    private static final String URL = "http://localhost:8080/rmi";

    @Test
    public void TestAdmin() throws MalformedURLException, RepositoryException {
        final Repository repository = new URLRemoteRepository(URL);
         Session session = repository.login(new SimpleCredentials("admin", "admin".toCharArray()));
        session.logout();
    }
    @Test(expected = RemoteRepositoryException.class)
    public void TestUser() throws MalformedURLException, RepositoryException {
        final Repository repository = new URLRemoteRepository(URL);
         Session session = repository.login(new SimpleCredentials("qwerty","qwerty".toCharArray()));
        session.logout();
    }
}
