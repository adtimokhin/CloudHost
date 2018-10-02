package ru.timokhin.tests;

import org.apache.jackrabbit.rmi.repository.URLRemoteRepository;
import org.junit.Test;

import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import java.net.MalformedURLException;
import java.util.UUID;

public class AddFileTests extends ConnectionTest {
    @Test
    public void WriteAdminTest() throws MalformedURLException, RepositoryException {
        /*final Repository repository = new URLRemoteRepository("http://localhost:8080/rmi");
        final Session session = repository.login(new SimpleCredentials("admin", "admin".toCharArray()));*/
        session.getRootNode().addNode(String.valueOf(UUID.randomUUID()));
        /*session.save();
        session.logout();*/
    }

}
