package io.quarkus.rest.server.test.customproviders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;

import org.jboss.resteasy.reactive.ContainerResponseFilter;
import org.jboss.resteasy.reactive.server.spi.SimplifiedResourceInfo;

public class CustomContainerResponseFilter {

    @ContainerResponseFilter
    public void whatever(SimplifiedResourceInfo simplifiedResourceInfo, ContainerResponseContext responseContext,
            ContainerRequestContext requestContext, Throwable t) {
        assertNotNull(requestContext);
        assertNull(t);
        responseContext.getHeaders().putSingle("java-method", simplifiedResourceInfo.getMethodName());
    }
}
