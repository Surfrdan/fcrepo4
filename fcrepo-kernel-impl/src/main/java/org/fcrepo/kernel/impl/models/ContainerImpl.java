/*
 * Licensed to DuraSpace under one or more contributor license agreements.
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership.
 *
 * DuraSpace licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fcrepo.kernel.impl.models;

import org.fcrepo.kernel.api.identifiers.FedoraId;
import org.fcrepo.kernel.api.models.Container;
import org.fcrepo.kernel.api.models.FedoraResource;
import org.fcrepo.kernel.api.models.ResourceFactory;
import org.fcrepo.persistence.api.PersistentStorageSessionManager;

import java.net.URI;
import java.util.List;

import static org.fcrepo.kernel.api.RdfLexicon.CONTAINER;
import static org.fcrepo.kernel.api.RdfLexicon.FEDORA_CONTAINER;
import static org.fcrepo.kernel.api.RdfLexicon.FEDORA_RESOURCE;
import static org.fcrepo.kernel.api.RdfLexicon.RDF_SOURCE;


/**
 * Implementation of an LDP Container resource
 *
 * @author bbpennel
 */
public class ContainerImpl extends FedoraResourceImpl implements Container {

    /**
     * Construct the container
     *
     * @param fedoraID internal identifier
     * @param txId transaction id
     * @param pSessionManager session manager
     * @param resourceFactory resource factory
     */
    public ContainerImpl(final FedoraId fedoraID, final String txId,
                         final PersistentStorageSessionManager pSessionManager, final ResourceFactory resourceFactory) {
        super(fedoraID, txId, pSessionManager, resourceFactory);
    }

    @Override
    public FedoraResource getDescribedResource() {
        return this;
    }

    @Override
    public List<URI> getSystemTypes(final boolean forRdf) {
        final var types = super.getSystemTypes(forRdf);
        types.addAll(List.of(URI.create(RDF_SOURCE.toString()), URI.create(CONTAINER.toString()),
                URI.create(FEDORA_CONTAINER.toString()), URI.create(FEDORA_RESOURCE.toString())));
        return types;
    }

}
