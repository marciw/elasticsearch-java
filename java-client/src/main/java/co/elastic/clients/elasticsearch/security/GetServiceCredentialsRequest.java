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

package co.elastic.clients.elasticsearch.security;

import co.elastic.clients.elasticsearch._types.ErrorResponse;
import co.elastic.clients.elasticsearch._types.RequestBase;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.transport.Endpoint;
import co.elastic.clients.transport.endpoints.SimpleEndpoint;
import co.elastic.clients.util.ApiTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.String;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nullable;

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

// typedef: security.get_service_credentials.Request

/**
 * Get service account credentials.
 * <p>
 * To use this API, you must have at least the <code>read_security</code>
 * cluster privilege (or a greater privilege such as
 * <code>manage_service_account</code> or <code>manage_security</code>).
 * <p>
 * The response includes service account tokens that were created with the
 * create service account tokens API as well as file-backed tokens from all
 * nodes of the cluster.
 * <p>
 * NOTE: For tokens backed by the <code>service_tokens</code> file, the API
 * collects them from all nodes of the cluster. Tokens with the same name from
 * different nodes are assumed to be the same token and are only counted once
 * towards the total number of service tokens.
 * 
 * @see <a href=
 *      "../doc-files/api-spec.html#security.get_service_credentials.Request">API
 *      specification</a>
 */

public class GetServiceCredentialsRequest extends RequestBase {
	private final String namespace;

	private final String service;

	// ---------------------------------------------------------------------------------------------

	private GetServiceCredentialsRequest(Builder builder) {

		this.namespace = ApiTypeHelper.requireNonNull(builder.namespace, this, "namespace");
		this.service = ApiTypeHelper.requireNonNull(builder.service, this, "service");

	}

	public static GetServiceCredentialsRequest of(Function<Builder, ObjectBuilder<GetServiceCredentialsRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - The name of the namespace.
	 * <p>
	 * API name: {@code namespace}
	 */
	public final String namespace() {
		return this.namespace;
	}

	/**
	 * Required - The service name.
	 * <p>
	 * API name: {@code service}
	 */
	public final String service() {
		return this.service;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GetServiceCredentialsRequest}.
	 */

	public static class Builder extends RequestBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<GetServiceCredentialsRequest> {
		private String namespace;

		private String service;

		/**
		 * Required - The name of the namespace.
		 * <p>
		 * API name: {@code namespace}
		 */
		public final Builder namespace(String value) {
			this.namespace = value;
			return this;
		}

		/**
		 * Required - The service name.
		 * <p>
		 * API name: {@code service}
		 */
		public final Builder service(String value) {
			this.service = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link GetServiceCredentialsRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GetServiceCredentialsRequest build() {
			_checkSingleUse();

			return new GetServiceCredentialsRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code security.get_service_credentials}".
	 */
	public static final Endpoint<GetServiceCredentialsRequest, GetServiceCredentialsResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
			"es/security.get_service_credentials",

			// Request method
			request -> {
				return "GET";

			},

			// Request path
			request -> {
				final int _service = 1 << 0;
				final int _namespace = 1 << 1;

				int propsSet = 0;

				propsSet |= _service;
				propsSet |= _namespace;

				if (propsSet == (_namespace | _service)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_security");
					buf.append("/service");
					buf.append("/");
					SimpleEndpoint.pathEncode(request.namespace, buf);
					buf.append("/");
					SimpleEndpoint.pathEncode(request.service, buf);
					buf.append("/credential");
					return buf.toString();
				}
				throw SimpleEndpoint.noPathTemplateFound("path");

			},

			// Path parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				final int _service = 1 << 0;
				final int _namespace = 1 << 1;

				int propsSet = 0;

				propsSet |= _service;
				propsSet |= _namespace;

				if (propsSet == (_namespace | _service)) {
					params.put("namespace", request.namespace);
					params.put("service", request.service);
				}
				return params;
			},

			// Request parameters
			request -> {
				return Collections.emptyMap();

			}, SimpleEndpoint.emptyMap(), false, GetServiceCredentialsResponse._DESERIALIZER);
}
