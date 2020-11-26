package io.quarkus.rest.server.test.resource.basic.resource;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.Assertions;

import io.quarkus.rest.server.test.simple.PortProviderUtil;

@Path("/UriInfoSimpleResource")
public class UriInfoSimpleResource {
    private static Logger logger = Logger.getLogger(UriInfoSimpleResource.class);
    @Context
    UriInfo myInfo;

    @Path("/simple")
    @GET
    public String get(@Context UriInfo info, @QueryParam("abs") String abs) {
        logger.info("abs query: " + abs);
        URI base = null;
        if (abs == null) {
            base = PortProviderUtil.createURI("/");
        } else {
            base = PortProviderUtil.createURI("/" + abs + "/");
        }

        logger.info("BASE URI: " + info.getBaseUri());
        logger.info("Request URI: " + info.getRequestUri());
        logger.info("Absolute URI: " + info.getAbsolutePath());
        Assertions.assertEquals(base.getPath(), info.getBaseUri().getPath());
        Assertions.assertEquals("/UriInfoSimpleResource/simple", info.getPath());
        return "CONTENT";
    }

    @Path("/simple/fromField")
    @GET
    public String getField(@QueryParam("abs") String abs) {
        logger.info("abs query: " + abs);
        URI base = null;
        if (abs == null) {
            base = PortProviderUtil.createURI("/");
        } else {
            base = PortProviderUtil.createURI("/" + abs + "/");
        }

        logger.info("BASE URI: " + myInfo.getBaseUri());
        logger.info("Request URI: " + myInfo.getRequestUri());
        Assertions.assertEquals(base.getPath(), myInfo.getBaseUri().getPath());
        Assertions.assertEquals("/UriInfoSimpleResource/simple/fromField", myInfo.getPath());
        return "CONTENT";
    }

}
