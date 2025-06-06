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
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.HashMap;
import java.util.List;
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

// typedef: indices.put_template.Request

/**
 * Create or update a legacy index template. Index templates define settings,
 * mappings, and aliases that can be applied automatically to new indices.
 * Elasticsearch applies templates to new indices based on an index pattern that
 * matches the index name.
 * <p>
 * IMPORTANT: This documentation is about legacy index templates, which are
 * deprecated and will be replaced by the composable templates introduced in
 * Elasticsearch 7.8.
 * <p>
 * Composable templates always take precedence over legacy templates. If no
 * composable template matches a new index, matching legacy templates are
 * applied according to their order.
 * <p>
 * Index templates are only applied during index creation. Changes to index
 * templates do not affect existing indices. Settings and mappings specified in
 * create index API requests override any settings or mappings specified in an
 * index template.
 * <p>
 * You can use C-style <code>/* *\/</code> block comments in index templates.
 * You can include comments anywhere in the request body, except before the
 * opening curly bracket.
 * <p>
 * <strong>Indices matching multiple templates</strong>
 * <p>
 * Multiple index templates can potentially match an index, in this case, both
 * the settings and mappings are merged into the final configuration of the
 * index. The order of the merging can be controlled using the order parameter,
 * with lower order being applied first, and higher orders overriding them.
 * NOTE: Multiple matching templates with the same order value will result in a
 * non-deterministic merging order.
 * 
 * @see <a href="../doc-files/api-spec.html#indices.put_template.Request">API
 *      specification</a>
 * @deprecated 7.8.0
 */
@Deprecated
@JsonpDeserializable
public class PutTemplateRequest extends RequestBase implements JsonpSerializable {
	private final Map<String, Alias> aliases;

	@Nullable
	private final String cause;

	@Nullable
	private final Boolean create;

	private final List<String> indexPatterns;

	@Nullable
	private final TypeMapping mappings;

	@Nullable
	private final Time masterTimeout;

	private final String name;

	@Nullable
	private final Integer order;

	@Nullable
	private final IndexSettings settings;

	@Nullable
	private final Long version;

	// ---------------------------------------------------------------------------------------------

	private PutTemplateRequest(Builder builder) {

		this.aliases = ApiTypeHelper.unmodifiable(builder.aliases);
		this.cause = builder.cause;
		this.create = builder.create;
		this.indexPatterns = ApiTypeHelper.unmodifiable(builder.indexPatterns);
		this.mappings = builder.mappings;
		this.masterTimeout = builder.masterTimeout;
		this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
		this.order = builder.order;
		this.settings = builder.settings;
		this.version = builder.version;

	}

	public static PutTemplateRequest of(Function<Builder, ObjectBuilder<PutTemplateRequest>> fn) {
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
	 * User defined reason for creating/updating the index template
	 * <p>
	 * API name: {@code cause}
	 */
	@Nullable
	public final String cause() {
		return this.cause;
	}

	/**
	 * If true, this request cannot replace or update existing index templates.
	 * <p>
	 * API name: {@code create}
	 */
	@Nullable
	public final Boolean create() {
		return this.create;
	}

	/**
	 * Array of wildcard expressions used to match the names of indices during
	 * creation.
	 * <p>
	 * API name: {@code index_patterns}
	 */
	public final List<String> indexPatterns() {
		return this.indexPatterns;
	}

	/**
	 * Mapping for fields in the index.
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
	 * Required - The name of the template
	 * <p>
	 * API name: {@code name}
	 */
	public final String name() {
		return this.name;
	}

	/**
	 * Order in which Elasticsearch applies this template if index matches multiple
	 * templates.
	 * <p>
	 * Templates with lower 'order' values are merged first. Templates with higher
	 * 'order' values are merged later, overriding templates with lower values.
	 * <p>
	 * API name: {@code order}
	 */
	@Nullable
	public final Integer order() {
		return this.order;
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
	 * Version number used to manage index templates externally. This number is not
	 * automatically generated by Elasticsearch. To unset a version, replace the
	 * template without specifying one.
	 * <p>
	 * API name: {@code version}
	 */
	@Nullable
	public final Long version() {
		return this.version;
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
		if (ApiTypeHelper.isDefined(this.indexPatterns)) {
			generator.writeKey("index_patterns");
			generator.writeStartArray();
			for (String item0 : this.indexPatterns) {
				generator.write(item0);

			}
			generator.writeEnd();

		}
		if (this.mappings != null) {
			generator.writeKey("mappings");
			this.mappings.serialize(generator, mapper);

		}
		if (this.order != null) {
			generator.writeKey("order");
			generator.write(this.order);

		}
		if (this.settings != null) {
			generator.writeKey("settings");
			this.settings.serialize(generator, mapper);

		}
		if (this.version != null) {
			generator.writeKey("version");
			generator.write(this.version);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link PutTemplateRequest}.
	 */
	@Deprecated
	public static class Builder extends RequestBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<PutTemplateRequest> {
		@Nullable
		private Map<String, Alias> aliases;

		@Nullable
		private String cause;

		@Nullable
		private Boolean create;

		@Nullable
		private List<String> indexPatterns;

		@Nullable
		private TypeMapping mappings;

		@Nullable
		private Time masterTimeout;

		private String name;

		@Nullable
		private Integer order;

		@Nullable
		private IndexSettings settings;

		@Nullable
		private Long version;

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
		 * User defined reason for creating/updating the index template
		 * <p>
		 * API name: {@code cause}
		 */
		public final Builder cause(@Nullable String value) {
			this.cause = value;
			return this;
		}

		/**
		 * If true, this request cannot replace or update existing index templates.
		 * <p>
		 * API name: {@code create}
		 */
		public final Builder create(@Nullable Boolean value) {
			this.create = value;
			return this;
		}

		/**
		 * Array of wildcard expressions used to match the names of indices during
		 * creation.
		 * <p>
		 * API name: {@code index_patterns}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>indexPatterns</code>.
		 */
		public final Builder indexPatterns(List<String> list) {
			this.indexPatterns = _listAddAll(this.indexPatterns, list);
			return this;
		}

		/**
		 * Array of wildcard expressions used to match the names of indices during
		 * creation.
		 * <p>
		 * API name: {@code index_patterns}
		 * <p>
		 * Adds one or more values to <code>indexPatterns</code>.
		 */
		public final Builder indexPatterns(String value, String... values) {
			this.indexPatterns = _listAdd(this.indexPatterns, value, values);
			return this;
		}

		/**
		 * Mapping for fields in the index.
		 * <p>
		 * API name: {@code mappings}
		 */
		public final Builder mappings(@Nullable TypeMapping value) {
			this.mappings = value;
			return this;
		}

		/**
		 * Mapping for fields in the index.
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
		 * Required - The name of the template
		 * <p>
		 * API name: {@code name}
		 */
		public final Builder name(String value) {
			this.name = value;
			return this;
		}

		/**
		 * Order in which Elasticsearch applies this template if index matches multiple
		 * templates.
		 * <p>
		 * Templates with lower 'order' values are merged first. Templates with higher
		 * 'order' values are merged later, overriding templates with lower values.
		 * <p>
		 * API name: {@code order}
		 */
		public final Builder order(@Nullable Integer value) {
			this.order = value;
			return this;
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
		 * Version number used to manage index templates externally. This number is not
		 * automatically generated by Elasticsearch. To unset a version, replace the
		 * template without specifying one.
		 * <p>
		 * API name: {@code version}
		 */
		public final Builder version(@Nullable Long value) {
			this.version = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link PutTemplateRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public PutTemplateRequest build() {
			_checkSingleUse();

			return new PutTemplateRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link PutTemplateRequest}
	 */
	public static final JsonpDeserializer<PutTemplateRequest> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, PutTemplateRequest::setupPutTemplateRequestDeserializer);

	protected static void setupPutTemplateRequestDeserializer(ObjectDeserializer<PutTemplateRequest.Builder> op) {

		op.add(Builder::aliases, JsonpDeserializer.stringMapDeserializer(Alias._DESERIALIZER), "aliases");
		op.add(Builder::indexPatterns, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
				"index_patterns");
		op.add(Builder::mappings, TypeMapping._DESERIALIZER, "mappings");
		op.add(Builder::order, JsonpDeserializer.integerDeserializer(), "order");
		op.add(Builder::settings, IndexSettings._DESERIALIZER, "settings");
		op.add(Builder::version, JsonpDeserializer.longDeserializer(), "version");

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code indices.put_template}".
	 */
	public static final Endpoint<PutTemplateRequest, PutTemplateResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
			"es/indices.put_template",

			// Request method
			request -> {
				return "PUT";

			},

			// Request path
			request -> {
				final int _name = 1 << 0;

				int propsSet = 0;

				propsSet |= _name;

				if (propsSet == (_name)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_template");
					buf.append("/");
					SimpleEndpoint.pathEncode(request.name, buf);
					return buf.toString();
				}
				throw SimpleEndpoint.noPathTemplateFound("path");

			},

			// Path parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				final int _name = 1 << 0;

				int propsSet = 0;

				propsSet |= _name;

				if (propsSet == (_name)) {
					params.put("name", request.name);
				}
				return params;
			},

			// Request parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				if (request.masterTimeout != null) {
					params.put("master_timeout", request.masterTimeout._toJsonString());
				}
				if (request.create != null) {
					params.put("create", String.valueOf(request.create));
				}
				if (request.cause != null) {
					params.put("cause", request.cause);
				}
				return params;

			}, SimpleEndpoint.emptyMap(), true, PutTemplateResponse._DESERIALIZER);
}
