package org.jboss.resteasy.reactive.server.spi;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

public interface QuarkusRestContainerResponseFilter extends ContainerResponseFilter {
    @Override
    default void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        filter((QuarkusRestContainerRequestContext) requestContext, responseContext);
    }

    void filter(QuarkusRestContainerRequestContext requestContext, ContainerResponseContext responseContext);
}
