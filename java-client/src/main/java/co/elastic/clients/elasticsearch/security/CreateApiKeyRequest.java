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
import co.elastic.clients.elasticsearch._types.Refresh;
import co.elastic.clients.elasticsearch._types.RequestBase;
import co.elastic.clients.elasticsearch._types.Time;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpSerializable;
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

// typedef: security.create_api_key.Request

/**
 * Create an API key.
 * <p>
 * Create an API key for access without requiring basic authentication.
 * <p>
 * IMPORTANT: If the credential that is used to authenticate this request is an
 * API key, the derived API key cannot have any privileges. If you specify
 * privileges, the API returns an error.
 * <p>
 * A successful request returns a JSON structure that contains the API key, its
 * unique id, and its name. If applicable, it also returns expiration
 * information for the API key in milliseconds.
 * <p>
 * NOTE: By default, API keys never expire. You can specify expiration
 * information when you create the API keys.
 * <p>
 * The API keys are created by the Elasticsearch API key service, which is
 * automatically enabled. To configure or turn off the API key service, refer to
 * API key service setting documentation.
 * 
 * @see <a href="../doc-files/api-spec.html#security.create_api_key.Request">API
 *      specification</a>
 */
@JsonpDeserializable
public class CreateApiKeyRequest extends RequestBase implements JsonpSerializable {
	@Nullable
	private final Time expiration;

	private final Map<String, JsonData> metadata;

	@Nullable
	private final String name;

	@Nullable
	private final Refresh refresh;

	private final Map<String, RoleDescriptor> roleDescriptors;

	// ---------------------------------------------------------------------------------------------

	private CreateApiKeyRequest(Builder builder) {

		this.expiration = builder.expiration;
		this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
		this.name = builder.name;
		this.refresh = builder.refresh;
		this.roleDescriptors = ApiTypeHelper.unmodifiable(builder.roleDescriptors);

	}

	public static CreateApiKeyRequest of(Function<Builder, ObjectBuilder<CreateApiKeyRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * The expiration time for the API key. By default, API keys never expire.
	 * <p>
	 * API name: {@code expiration}
	 */
	@Nullable
	public final Time expiration() {
		return this.expiration;
	}

	/**
	 * Arbitrary metadata that you want to associate with the API key. It supports
	 * nested data structure. Within the metadata object, keys beginning with
	 * <code>_</code> are reserved for system usage.
	 * <p>
	 * API name: {@code metadata}
	 */
	public final Map<String, JsonData> metadata() {
		return this.metadata;
	}

	/**
	 * A name for the API key.
	 * <p>
	 * API name: {@code name}
	 */
	@Nullable
	public final String name() {
		return this.name;
	}

	/**
	 * If <code>true</code> (the default) then refresh the affected shards to make
	 * this operation visible to search, if <code>wait_for</code> then wait for a
	 * refresh to make this operation visible to search, if <code>false</code> then
	 * do nothing with refreshes.
	 * <p>
	 * API name: {@code refresh}
	 */
	@Nullable
	public final Refresh refresh() {
		return this.refresh;
	}

	/**
	 * An array of role descriptors for this API key. When it is not specified or it
	 * is an empty array, the API key will have a point in time snapshot of
	 * permissions of the authenticated user. If you supply role descriptors, the
	 * resultant permissions are an intersection of API keys permissions and the
	 * authenticated user's permissions thereby limiting the access scope for API
	 * keys. The structure of role descriptor is the same as the request for the
	 * create role API. For more details, refer to the create or update roles API.
	 * <p>
	 * NOTE: Due to the way in which this permission intersection is calculated, it
	 * is not possible to create an API key that is a child of another API key,
	 * unless the derived key is created without any privileges. In this case, you
	 * must explicitly specify a role descriptor with no privileges. The derived API
	 * key can be used for authentication; it will not have authority to call
	 * Elasticsearch APIs.
	 * <p>
	 * API name: {@code role_descriptors}
	 */
	public final Map<String, RoleDescriptor> roleDescriptors() {
		return this.roleDescriptors;
	}

	/**
	 * Serialize this object to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		serializeInternal(generator, mapper);
		generator.writeEnd();
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		if (this.expiration != null) {
			generator.writeKey("expiration");
			this.expiration.serialize(generator, mapper);

		}
		if (ApiTypeHelper.isDefined(this.metadata)) {
			generator.writeKey("metadata");
			generator.writeStartObject();
			for (Map.Entry<String, JsonData> item0 : this.metadata.entrySet()) {
				generator.writeKey(item0.getKey());
				item0.getValue().serialize(generator, mapper);

			}
			generator.writeEnd();

		}
		if (this.name != null) {
			generator.writeKey("name");
			generator.write(this.name);

		}
		if (ApiTypeHelper.isDefined(this.roleDescriptors)) {
			generator.writeKey("role_descriptors");
			generator.writeStartObject();
			for (Map.Entry<String, RoleDescriptor> item0 : this.roleDescriptors.entrySet()) {
				generator.writeKey(item0.getKey());
				item0.getValue().serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link CreateApiKeyRequest}.
	 */

	public static class Builder extends RequestBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<CreateApiKeyRequest> {
		@Nullable
		private Time expiration;

		@Nullable
		private Map<String, JsonData> metadata;

		@Nullable
		private String name;

		@Nullable
		private Refresh refresh;

		@Nullable
		private Map<String, RoleDescriptor> roleDescriptors;

		/**
		 * The expiration time for the API key. By default, API keys never expire.
		 * <p>
		 * API name: {@code expiration}
		 */
		public final Builder expiration(@Nullable Time value) {
			this.expiration = value;
			return this;
		}

		/**
		 * The expiration time for the API key. By default, API keys never expire.
		 * <p>
		 * API name: {@code expiration}
		 */
		public final Builder expiration(Function<Time.Builder, ObjectBuilder<Time>> fn) {
			return this.expiration(fn.apply(new Time.Builder()).build());
		}

		/**
		 * Arbitrary metadata that you want to associate with the API key. It supports
		 * nested data structure. Within the metadata object, keys beginning with
		 * <code>_</code> are reserved for system usage.
		 * <p>
		 * API name: {@code metadata}
		 * <p>
		 * Adds all entries of <code>map</code> to <code>metadata</code>.
		 */
		public final Builder metadata(Map<String, JsonData> map) {
			this.metadata = _mapPutAll(this.metadata, map);
			return this;
		}

		/**
		 * Arbitrary metadata that you want to associate with the API key. It supports
		 * nested data structure. Within the metadata object, keys beginning with
		 * <code>_</code> are reserved for system usage.
		 * <p>
		 * API name: {@code metadata}
		 * <p>
		 * Adds an entry to <code>metadata</code>.
		 */
		public final Builder metadata(String key, JsonData value) {
			this.metadata = _mapPut(this.metadata, key, value);
			return this;
		}

		/**
		 * A name for the API key.
		 * <p>
		 * API name: {@code name}
		 */
		public final Builder name(@Nullable String value) {
			this.name = value;
			return this;
		}

		/**
		 * If <code>true</code> (the default) then refresh the affected shards to make
		 * this operation visible to search, if <code>wait_for</code> then wait for a
		 * refresh to make this operation visible to search, if <code>false</code> then
		 * do nothing with refreshes.
		 * <p>
		 * API name: {@code refresh}
		 */
		public final Builder refresh(@Nullable Refresh value) {
			this.refresh = value;
			return this;
		}

		/**
		 * An array of role descriptors for this API key. When it is not specified or it
		 * is an empty array, the API key will have a point in time snapshot of
		 * permissions of the authenticated user. If you supply role descriptors, the
		 * resultant permissions are an intersection of API keys permissions and the
		 * authenticated user's permissions thereby limiting the access scope for API
		 * keys. The structure of role descriptor is the same as the request for the
		 * create role API. For more details, refer to the create or update roles API.
		 * <p>
		 * NOTE: Due to the way in which this permission intersection is calculated, it
		 * is not possible to create an API key that is a child of another API key,
		 * unless the derived key is created without any privileges. In this case, you
		 * must explicitly specify a role descriptor with no privileges. The derived API
		 * key can be used for authentication; it will not have authority to call
		 * Elasticsearch APIs.
		 * <p>
		 * API name: {@code role_descriptors}
		 * <p>
		 * Adds all entries of <code>map</code> to <code>roleDescriptors</code>.
		 */
		public final Builder roleDescriptors(Map<String, RoleDescriptor> map) {
			this.roleDescriptors = _mapPutAll(this.roleDescriptors, map);
			return this;
		}

		/**
		 * An array of role descriptors for this API key. When it is not specified or it
		 * is an empty array, the API key will have a point in time snapshot of
		 * permissions of the authenticated user. If you supply role descriptors, the
		 * resultant permissions are an intersection of API keys permissions and the
		 * authenticated user's permissions thereby limiting the access scope for API
		 * keys. The structure of role descriptor is the same as the request for the
		 * create role API. For more details, refer to the create or update roles API.
		 * <p>
		 * NOTE: Due to the way in which this permission intersection is calculated, it
		 * is not possible to create an API key that is a child of another API key,
		 * unless the derived key is created without any privileges. In this case, you
		 * must explicitly specify a role descriptor with no privileges. The derived API
		 * key can be used for authentication; it will not have authority to call
		 * Elasticsearch APIs.
		 * <p>
		 * API name: {@code role_descriptors}
		 * <p>
		 * Adds an entry to <code>roleDescriptors</code>.
		 */
		public final Builder roleDescriptors(String key, RoleDescriptor value) {
			this.roleDescriptors = _mapPut(this.roleDescriptors, key, value);
			return this;
		}

		/**
		 * An array of role descriptors for this API key. When it is not specified or it
		 * is an empty array, the API key will have a point in time snapshot of
		 * permissions of the authenticated user. If you supply role descriptors, the
		 * resultant permissions are an intersection of API keys permissions and the
		 * authenticated user's permissions thereby limiting the access scope for API
		 * keys. The structure of role descriptor is the same as the request for the
		 * create role API. For more details, refer to the create or update roles API.
		 * <p>
		 * NOTE: Due to the way in which this permission intersection is calculated, it
		 * is not possible to create an API key that is a child of another API key,
		 * unless the derived key is created without any privileges. In this case, you
		 * must explicitly specify a role descriptor with no privileges. The derived API
		 * key can be used for authentication; it will not have authority to call
		 * Elasticsearch APIs.
		 * <p>
		 * API name: {@code role_descriptors}
		 * <p>
		 * Adds an entry to <code>roleDescriptors</code> using a builder lambda.
		 */
		public final Builder roleDescriptors(String key,
				Function<RoleDescriptor.Builder, ObjectBuilder<RoleDescriptor>> fn) {
			return roleDescriptors(key, fn.apply(new RoleDescriptor.Builder()).build());
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link CreateApiKeyRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public CreateApiKeyRequest build() {
			_checkSingleUse();

			return new CreateApiKeyRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link CreateApiKeyRequest}
	 */
	public static final JsonpDeserializer<CreateApiKeyRequest> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, CreateApiKeyRequest::setupCreateApiKeyRequestDeserializer);

	protected static void setupCreateApiKeyRequestDeserializer(ObjectDeserializer<CreateApiKeyRequest.Builder> op) {

		op.add(Builder::expiration, Time._DESERIALIZER, "expiration");
		op.add(Builder::metadata, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "metadata");
		op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
		op.add(Builder::roleDescriptors, JsonpDeserializer.stringMapDeserializer(RoleDescriptor._DESERIALIZER),
				"role_descriptors");

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code security.create_api_key}".
	 */
	public static final Endpoint<CreateApiKeyRequest, CreateApiKeyResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
			"es/security.create_api_key",

			// Request method
			request -> {
				return "PUT";

			},

			// Request path
			request -> {
				return "/_security/api_key";

			},

			// Path parameters
			request -> {
				return Collections.emptyMap();
			},

			// Request parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				if (request.refresh != null) {
					params.put("refresh", request.refresh.jsonValue());
				}
				return params;

			}, SimpleEndpoint.emptyMap(), true, CreateApiKeyResponse._DESERIALIZER);
}
