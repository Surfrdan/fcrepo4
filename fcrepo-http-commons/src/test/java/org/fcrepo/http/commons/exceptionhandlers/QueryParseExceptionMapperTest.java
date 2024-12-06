/*
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree.
 */
package org.fcrepo.http.commons.exceptionhandlers;

import static jakarta.ws.rs.core.Response.Status.BAD_REQUEST;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import jakarta.ws.rs.core.Response;

import org.apache.jena.query.QueryParseException;
import org.junit.Before;
import org.junit.Test;

/**
 * @author whikloj
 * @since September 10, 2014
 */
public class QueryParseExceptionMapperTest {

    private QueryParseExceptionMapper testObj;

    @Before
    public void setUp() {
        testObj = new QueryParseExceptionMapper();
    }

    @Test
    public void testInvalidNamespace() {
        final QueryParseException input = new QueryParseException(
            "Unresolved prefixed name: invalidNS:title", 14, 10);
        final Response actual = testObj.toResponse(input);
        assertEquals(BAD_REQUEST.getStatusCode(), actual.getStatus());
        assertEquals(actual.getEntity(), input.getMessage());
    }

    @Test
    public void testToResponse() {
        final QueryParseException input = new QueryParseException("An error occurred", 14, 10);
        final Response actual = testObj.toResponse(input);
        assertEquals(BAD_REQUEST.getStatusCode(), actual.getStatus());
        assertNotNull(actual.getEntity());
    }
}