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

package co.elastic.clients.elasticsearch.indices;

import co.elastic.clients.elasticsearch._types.ErrorResponse;
import co.elastic.clients.elasticsearch._types.RequestBase;
import co.elastic.clients.elasticsearch._types.Time;
import co.elastic.clients.elasticsearch._types.WaitForActiveShards;
import co.elastic.clients.elasticsearch._types.mapping.TypeMapping;
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

// typedef: indices.create.Request

/**
 * Create an index. You can use the create index API to add a new index to an
 * Elasticsearch cluster. When creating an index, you can specify the following:
 * <ul>
 * <li>Settings for the index.</li>
 * <li>Mappings for fields in the index.</li>
 * <li>Index aliases</li>
 * </ul>
 * <p>
 * <strong>Wait for active shards</strong>
 * <p>
 * By default, index creation will only return a response to the client when the
 * primary copies of each shard have been started, or the request times out. The
 * index creation response will indicate what happened. For example,
 * <code>acknowledged</code> indicates whether the index was successfully
 * created in the cluster, <code>while shards_acknowledged</code> indicates
 * whether the requisite number of shard copies were started for each shard in
 * the index before timing out. Note that it is still possible for either
 * <code>acknowledged</code> or <code>shards_acknowledged</code> to be
 * <code>false</code>, but for the index creation to be successful. These values
 * simply indicate whether the operation completed before the timeout. If
 * <code>acknowledged</code> is false, the request timed out before the cluster
 * state was updated with the newly created index, but it probably will be
 * created sometime soon. If <code>shards_acknowledged</code> is false, then the
 * request timed out before the requisite number of shards were started (by
 * default just the primaries), even if the cluster state was successfully
 * updated to reflect the newly created index (that is to say,
 * <code>acknowledged</code> is <code>true</code>).
 * <p>
 * You can change the default of only waiting for the primary shards to start
 * through the index setting <code>index.write.wait_for_active_shards</code>.
 * Note that changing this setting will also affect the
 * <code>wait_for_active_shards</code> value on all subsequent write operations.
 * 
 * @see <a href="../doc-files/api-spec.html#indices.create.Request">API
 *      specification</a>
 */
@JsonpDeserializable
public class CreateIndexRequest extends RequestBase implements JsonpSerializable {
	private final Map<String, Alias> aliases;

	private final String index;

	@Nullable
	private final TypeMapping mappings;

	@Nullable
	private final Time masterTimeout;

	@Nullable
	private final IndexSettings settings;

	@Nullable
	private final Time timeout;

	@Nullable
	private final WaitForActiveShards waitForActiveShards;

	// ---------------------------------------------------------------------------------------------

	private CreateIndexRequest(Builder builder) {

		this.aliases = ApiTypeHelper.unmodifiable(builder.aliases);
		this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
		this.mappings = builder.mappings;
		this.masterTimeout = builder.masterTimeout;
		this.settings = builder.settings;
		this.timeout = builder.timeout;
		this.waitForActiveShards = builder.waitForActiveShards;

	}

	public static CreateIndexRequest of(Function<Builder, ObjectBuilder<CreateIndexRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Aliases for the index.
	 * <p>
	 * API name: {@code aliases}
	 */
	public final Map<String, Alias> aliases() {
		return this.aliases;
	}

	/**
	 * Required - Name of the index you wish to create. Index names must meet the
	 * following criteria:
	 * <ul>
	 * <li>Lowercase only</li>
	 * <li>Cannot include <code>\</code>, <code>/</code>, <code>*</code>,
	 * <code>?</code>, <code>&quot;</code>, <code>&lt;</code>, <code>&gt;</code>,
	 * <code>|</code>, <code> </code> (space character), <code>,</code>, or
	 * <code>#</code></li>
	 * <li>Indices prior to 7.0 could contain a colon (<code>:</code>), but that has
	 * been deprecated and will not be supported in later versions</li>
	 * <li>Cannot start with <code>-</code>, <code>_</code>, or <code>+</code></li>
	 * <li>Cannot be <code>.</code> or <code>..</code></li>
	 * <li>Cannot be longer than 255 bytes (note thtat it is bytes, so multi-byte
	 * characters will reach the limit faster)</li>
	 * <li>Names starting with <code>.</code> are deprecated, except for hidden
	 * indices and internal indices managed by plugins</li>
	 * </ul>
	 * <p>
	 * API name: {@code index}
	 */
	public final String index() {
		return this.index;
	}

	/**
	 * Mapping for fields in the index. If specified, this mapping can include:
	 * <ul>
	 * <li>Field names</li>
	 * <li>Field data types</li>
	 * <li>Mapping parameters</li>
	 * </ul>
	 * <p>
	 * API name: {@code mappings}
	 */
	@Nullable
	public final TypeMapping mappings() {
		return this.mappings;
	}

	/**
	 * Period to wait for a connection to the master node. If no response is
	 * received before the timeout expires, the request fails and returns an error.
	 * <p>
	 * API name: {@code master_timeout}
	 */
	@Nullable
	public final Time masterTimeout() {
		return this.masterTimeout;
	}

	/**
	 * Configuration options for the index.
	 * <p>
	 * API name: {@code settings}
	 */
	@Nullable
	public final IndexSettings settings() {
		return this.settings;
	}

	/**
	 * Period to wait for a response. If no response is received before the timeout
	 * expires, the request fails and returns an error.
	 * <p>
	 * API name: {@code timeout}
	 */
	@Nullable
	public final Time timeout() {
		return this.timeout;
	}

	/**
	 * The number of shard copies that must be active before proceeding with the
	 * operation. Set to <code>all</code> or any positive integer up to the total
	 * number of shards in the index (<code>number_of_replicas+1</code>).
	 * <p>
	 * API name: {@code wait_for_active_shards}
	 */
	@Nullable
	public final WaitForActiveShards waitForActiveShards() {
		return this.waitForActiveShards;
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

		if (ApiTypeHelper.isDefined(this.aliases)) {
			generator.writeKey("aliases");
			generator.writeStartObject();
			for (Map.Entry<String, Alias> item0 : this.aliases.entrySet()) {
				generator.writeKey(item0.getKey());
				item0.getValue().serialize(generator, mapper);

			}
			generator.writeEnd();

		}
		if (this.mappings != null) {
			generator.writeKey("mappings");
			this.mappings.serialize(generator, mapper);

		}
		if (this.settings != null) {
			generator.writeKey("settings");
			this.settings.serialize(generator, mapper);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link CreateIndexRequest}.
	 */

	public static class Builder extends RequestBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<CreateIndexRequest> {
		@Nullable
		private Map<String, Alias> aliases;

		private String index;

		@Nullable
		private TypeMapping mappings;

		@Nullable
		private Time masterTimeout;

		@Nullable
		private IndexSettings settings;

		@Nullable
		private Time timeout;

		@Nullable
		private WaitForActiveShards waitForActiveShards;

		/**
		 * Aliases for the index.
		 * <p>
		 * API name: {@code aliases}
		 * <p>
		 * Adds all entries of <code>map</code> to <code>aliases</code>.
		 */
		public final Builder aliases(Map<String, Alias> map) {
			this.aliases = _mapPutAll(this.aliases, map);
			return this;
		}

		/**
		 * Aliases for the index.
		 * <p>
		 * API name: {@code aliases}
		 * <p>
		 * Adds an entry to <code>aliases</code>.
		 */
		public final Builder aliases(String key, Alias value) {
			this.aliases = _mapPut(this.aliases, key, value);
			return this;
		}

		/**
		 * Aliases for the index.
		 * <p>
		 * API name: {@code aliases}
		 * <p>
		 * Adds an entry to <code>aliases</code> using a builder lambda.
		 */
		public final Builder aliases(String key, Function<Alias.Builder, ObjectBuilder<Alias>> fn) {
			return aliases(key, fn.apply(new Alias.Builder()).build());
		}

		/**
		 * Required - Name of the index you wish to create. Index names must meet the
		 * following criteria:
		 * <ul>
		 * <li>Lowercase only</li>
		 * <li>Cannot include <code>\</code>, <code>/</code>, <code>*</code>,
		 * <code>?</code>, <code>&quot;</code>, <code>&lt;</code>, <code>&gt;</code>,
		 * <code>|</code>, <code> </code> (space character), <code>,</code>, or
		 * <code>#</code></li>
		 * <li>Indices prior to 7.0 could contain a colon (<code>:</code>), but that has
		 * been deprecated and will not be supported in later versions</li>
		 * <li>Cannot start with <code>-</code>, <code>_</code>, or <code>+</code></li>
		 * <li>Cannot be <code>.</code> or <code>..</code></li>
		 * <li>Cannot be longer than 255 bytes (note thtat it is bytes, so multi-byte
		 * characters will reach the limit faster)</li>
		 * <li>Names starting with <code>.</code> are deprecated, except for hidden
		 * indices and internal indices managed by plugins</li>
		 * </ul>
		 * <p>
		 * API name: {@code index}
		 */
		public final Builder index(String value) {
			this.index = value;
			return this;
		}

		/**
		 * Mapping for fields in the index. If specified, this mapping can include:
		 * <ul>
		 * <li>Field names</li>
		 * <li>Field data types</li>
		 * <li>Mapping parameters</li>
		 * </ul>
		 * <p>
		 * API name: {@code mappings}
		 */
		public final Builder mappings(@Nullable TypeMapping value) {
			this.mappings = value;
			return this;
		}

		/**
		 * Mapping for fields in the index. If specified, this mapping can include:
		 * <ul>
		 * <li>Field names</li>
		 * <li>Field data types</li>
		 * <li>Mapping parameters</li>
		 * </ul>
		 * <p>
		 * API name: {@code mappings}
		 */
		public final Builder mappings(Function<TypeMapping.Builder, ObjectBuilder<TypeMapping>> fn) {
			return this.mappings(fn.apply(new TypeMapping.Builder()).build());
		}

		/**
		 * Period to wait for a connection to the master node. If no response is
		 * received before the timeout expires, the request fails and returns an error.
		 * <p>
		 * API name: {@code master_timeout}
		 */
		public final Builder masterTimeout(@Nullable Time value) {
			this.masterTimeout = value;
			return this;
		}

		/**
		 * Period to wait for a connection to the master node. If no response is
		 * received before the timeout expires, the request fails and returns an error.
		 * <p>
		 * API name: {@code master_timeout}
		 */
		public final Builder masterTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
			return this.masterTimeout(fn.apply(new Time.Builder()).build());
		}

		/**
		 * Configuration options for the index.
		 * <p>
		 * API name: {@code settings}
		 */
		public final Builder settings(@Nullable IndexSettings value) {
			this.settings = value;
			return this;
		}

		/**
		 * Configuration options for the index.
		 * <p>
		 * API name: {@code settings}
		 */
		public final Builder settings(Function<IndexSettings.Builder, ObjectBuilder<IndexSettings>> fn) {
			return this.settings(fn.apply(new IndexSettings.Builder()).build());
		}

		/**
		 * Period to wait for a response. If no response is received before the timeout
		 * expires, the request fails and returns an error.
		 * <p>
		 * API name: {@code timeout}
		 */
		public final Builder timeout(@Nullable Time value) {
			this.timeout = value;
			return this;
		}

		/**
		 * Period to wait for a response. If no response is received before the timeout
		 * expires, the request fails and returns an error.
		 * <p>
		 * API name: {@code timeout}
		 */
		public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
			return this.timeout(fn.apply(new Time.Builder()).build());
		}

		/**
		 * The number of shard copies that must be active before proceeding with the
		 * operation. Set to <code>all</code> or any positive integer up to the total
		 * number of shards in the index (<code>number_of_replicas+1</code>).
		 * <p>
		 * API name: {@code wait_for_active_shards}
		 */
		public final Builder waitForActiveShards(@Nullable WaitForActiveShards value) {
			this.waitForActiveShards = value;
			return this;
		}

		/**
		 * The number of shard copies that must be active before proceeding with the
		 * operation. Set to <code>all</code> or any positive integer up to the total
		 * number of shards in the index (<code>number_of_replicas+1</code>).
		 * <p>
		 * API name: {@code wait_for_active_shards}
		 */
		public final Builder waitForActiveShards(
				Function<WaitForActiveShards.Builder, ObjectBuilder<WaitForActiveShards>> fn) {
			return this.waitForActiveShards(fn.apply(new WaitForActiveShards.Builder()).build());
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link CreateIndexRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public CreateIndexRequest build() {
			_checkSingleUse();

			return new CreateIndexRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link CreateIndexRequest}
	 */
	public static final JsonpDeserializer<CreateIndexRequest> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, CreateIndexRequest::setupCreateIndexRequestDeserializer);

	protected static void setupCreateIndexRequestDeserializer(ObjectDeserializer<CreateIndexRequest.Builder> op) {

		op.add(Builder::aliases, JsonpDeserializer.stringMapDeserializer(Alias._DESERIALIZER), "aliases");
		op.add(Builder::mappings, TypeMapping._DESERIALIZER, "mappings");
		op.add(Builder::settings, IndexSettings._DESERIALIZER, "settings");

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code indices.create}".
	 */
	public static final Endpoint<CreateIndexRequest, CreateIndexResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
			"es/indices.create",

			// Request method
			request -> {
				return "PUT";

			},

			// Request path
			request -> {
				final int _index = 1 << 0;

				int propsSet = 0;

				propsSet |= _index;

				if (propsSet == (_index)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/");
					SimpleEndpoint.pathEncode(request.index, buf);
					return buf.toString();
				}
				throw SimpleEndpoint.noPathTemplateFound("path");

			},

			// Path parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				final int _index = 1 << 0;

				int propsSet = 0;

				propsSet |= _index;

				if (propsSet == (_index)) {
					params.put("index", request.index);
				}
				return params;
			},

			// Request parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				if (request.masterTimeout != null) {
					params.put("master_timeout", request.masterTimeout._toJsonString());
				}
				if (request.waitForActiveShards != null) {
					params.put("wait_for_active_shards", request.waitForActiveShards._toJsonString());
				}
				if (request.timeout != null) {
					params.put("timeout", request.timeout._toJsonString());
				}
				return params;

			}, SimpleEndpoint.emptyMap(), true, CreateIndexResponse._DESERIALIZER);
}
