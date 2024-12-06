/*
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree.
 */
package org.fcrepo.http.commons.exceptionhandlers;

import static jakarta.ws.rs.core.Response.fromResponse;
import static org.fcrepo.http.commons.domain.RDFMediaType.TEXT_PLAIN_WITH_CHARSET;
import static org.slf4j.LoggerFactory.getLogger;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ParamException;
import org.slf4j.Logger;

/**
 * Handle Jersey ParamException
 *
 * @author awoods
 * @since 2015-01-20
 */
@Provider
public class ParamExceptionMapper implements
        ExceptionMapper<ParamException>, ExceptionDebugLogging {

    private static final Logger LOGGER = getLogger(ParamExceptionMapper.class);

    @Override
    public Response toResponse(final ParamException e) {
        debugException(this, e, LOGGER);

        final String msg = "Error parsing parameter: " + e.getParameterName() + ", of type: " +
                e.getParameterType().getSimpleName();
        return fromResponse(e.getResponse()).entity(msg).type(TEXT_PLAIN_WITH_CHARSET).build();
    }

}
