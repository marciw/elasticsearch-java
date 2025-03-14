/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package co.elastic.clients.elasticsearch.cluster;

import co.elastic.clients.elasticsearch._types.ErrorResponse;
import co.elastic.clients.elasticsearch._types.RequestBase;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.transport.Endpoint;
import co.elastic.clients.transport.endpoints.SimpleEndpoint;
import co.elastic.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.util.Collections;
import java.util.Objects;

//----------------------------------------------------------------
//       THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------------------
//
// This code is generated from the Elasticsearch API specification
// at https://github.com/elastic/elasticsearch-specification
//
// Manual updates to this file will be lost when the code is
// re-generated.
//
// If you find a property that is missing or wrongly typed, please
// open an issue or a PR on the API specification repository.
//
//----------------------------------------------------------------

// typedef: cluster.remote_info.Request

/**
 * Get remote cluster information.
 * <p>
 * Get information about configured remote clusters. The API returns connection
 * and endpoint information keyed by the configured remote cluster alias.
 * <blockquote>
 * <p>
 * info This API returns information that reflects current state on the local
 * cluster. The <code>connected</code> field does not necessarily reflect
 * whether a remote cluster is down or unavailable, only whether there is
 * currently an open connection to it. Elasticsearch does not spontaneously try
 * to reconnect to a disconnected remote cluster. To trigger a reconnection,
 * attempt a cross-cluster search, ES|QL cross-cluster search, or try the
 * <a href=
 * "https://www.elastic.co/docs/api/doc/elasticsearch/operation/operation-indices-resolve-cluster">resolve
 * cluster endpoint</a>.
 * </p>
 * </blockquote>
 *
 * @see <a href="../doc-files/api-spec.html#cluster.remote_info.Request">API
 *      specification</a>
 */

public class RemoteInfoRequest extends RequestBase {
	public RemoteInfoRequest() {
	}

	/**
	 * Singleton instance for {@link RemoteInfoRequest}.
	 */
	public static final RemoteInfoRequest _INSTANCE = new RemoteInfoRequest();

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code cluster.remote_info}".
	 */
	public static final Endpoint<RemoteInfoRequest, RemoteInfoResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
			"es/cluster.remote_info",

			// Request method
			request -> {
				return "GET";

			},

			// Request path
			request -> {
				return "/_remote/info";

			},

			// Path parameters
			request -> {
				return Collections.emptyMap();
			},

			// Request parameters
			request -> {
				return Collections.emptyMap();

			}, SimpleEndpoint.emptyMap(), false, RemoteInfoResponse._DESERIALIZER);
}
