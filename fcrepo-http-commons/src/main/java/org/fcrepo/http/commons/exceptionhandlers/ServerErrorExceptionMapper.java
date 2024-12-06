/*
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree.
 */
package org.fcrepo.http.commons.exceptionhandlers;

import static jakarta.ws.rs.core.Response.fromResponse;
import static org.fcrepo.http.commons.domain.RDFMediaType.TEXT_PLAIN_WITH_CHARSET;
import static org.slf4j.LoggerFactory.getLogger;

import jakarta.ws.rs.ServerErrorException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import org.slf4j.Logger;

/**
 * @author awoods
 * @since 11/20/14
 */
@Provider
public class ServerErrorExceptionMapper implements
        ExceptionMapper<ServerErrorException>, ExceptionDebugLogging {

    private static final Logger LOGGER =
            getLogger(ServerErrorExceptionMapper.class);

    @Override
    public Response toResponse(final ServerErrorException e) {
        LOGGER.warn("Server error", e);
        return fromResponse(e.getResponse()).entity(e.getMessage()).type(TEXT_PLAIN_WITH_CHARSET).build();
    }
}
