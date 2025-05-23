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

import co.elastic.clients.elasticsearch.security.query_api_keys.ApiKeyAggregate;
import co.elastic.clients.json.ExternallyTaggedUnion;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpSerializable;
import co.elastic.clients.json.JsonpUtils;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.util.ApiTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
import co.elastic.clients.util.WithJsonObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.lang.Integer;
import java.lang.String;
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

// typedef: security.query_api_keys.Response

/**
 *
 * @see <a href=
 *      "../doc-files/api-spec.html#security.query_api_keys.Response">API
 *      specification</a>
 */
@JsonpDeserializable
public class QueryApiKeysResponse implements JsonpSerializable {
	private final int total;

	private final int count;

	private final List<ApiKey> apiKeys;

	private final Map<String, ApiKeyAggregate> aggregations;

	// ---------------------------------------------------------------------------------------------

	private QueryApiKeysResponse(Builder builder) {

		this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total", 0);
		this.count = ApiTypeHelper.requireNonNull(builder.count, this, "count", 0);
		this.apiKeys = ApiTypeHelper.unmodifiableRequired(builder.apiKeys, this, "apiKeys");
		this.aggregations = ApiTypeHelper.unmodifiable(builder.aggregations);

	}

	public static QueryApiKeysResponse of(Function<Builder, ObjectBuilder<QueryApiKeysResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - The total number of API keys found.
	 * <p>
	 * API name: {@code total}
	 */
	public final int total() {
		return this.total;
	}

	/**
	 * Required - The number of API keys returned in the response.
	 * <p>
	 * API name: {@code count}
	 */
	public final int count() {
		return this.count;
	}

	/**
	 * Required - A list of API key information.
	 * <p>
	 * API name: {@code api_keys}
	 */
	public final List<ApiKey> apiKeys() {
		return this.apiKeys;
	}

	/**
	 * The aggregations result, if requested.
	 * <p>
	 * API name: {@code aggregations}
	 */
	public final Map<String, ApiKeyAggregate> aggregations() {
		return this.aggregations;
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

		generator.writeKey("total");
		generator.write(this.total);

		generator.writeKey("count");
		generator.write(this.count);

		if (ApiTypeHelper.isDefined(this.apiKeys)) {
			generator.writeKey("api_keys");
			generator.writeStartArray();
			for (ApiKey item0 : this.apiKeys) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}
		if (ApiTypeHelper.isDefined(this.aggregations)) {
			generator.writeKey("aggregations");
			ExternallyTaggedUnion.serializeTypedKeys(this.aggregations, generator, mapper);

		}

	}

	@Override
	public String toString() {
		return JsonpUtils.toString(this);
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link QueryApiKeysResponse}.
	 */

	public static class Builder extends WithJsonObjectBuilderBase<Builder>
			implements
				ObjectBuilder<QueryApiKeysResponse> {
		private Integer total;

		private Integer count;

		private List<ApiKey> apiKeys;

		@Nullable
		private Map<String, ApiKeyAggregate> aggregations;

		/**
		 * Required - The total number of API keys found.
		 * <p>
		 * API name: {@code total}
		 */
		public final Builder total(int value) {
			this.total = value;
			return this;
		}

		/**
		 * Required - The number of API keys returned in the response.
		 * <p>
		 * API name: {@code count}
		 */
		public final Builder count(int value) {
			this.count = value;
			return this;
		}

		/**
		 * Required - A list of API key information.
		 * <p>
		 * API name: {@code api_keys}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>apiKeys</code>.
		 */
		public final Builder apiKeys(List<ApiKey> list) {
			this.apiKeys = _listAddAll(this.apiKeys, list);
			return this;
		}

		/**
		 * Required - A list of API key information.
		 * <p>
		 * API name: {@code api_keys}
		 * <p>
		 * Adds one or more values to <code>apiKeys</code>.
		 */
		public final Builder apiKeys(ApiKey value, ApiKey... values) {
			this.apiKeys = _listAdd(this.apiKeys, value, values);
			return this;
		}

		/**
		 * Required - A list of API key information.
		 * <p>
		 * API name: {@code api_keys}
		 * <p>
		 * Adds a value to <code>apiKeys</code> using a builder lambda.
		 */
		public final Builder apiKeys(Function<ApiKey.Builder, ObjectBuilder<ApiKey>> fn) {
			return apiKeys(fn.apply(new ApiKey.Builder()).build());
		}

		/**
		 * The aggregations result, if requested.
		 * <p>
		 * API name: {@code aggregations}
		 * <p>
		 * Adds all entries of <code>map</code> to <code>aggregations</code>.
		 */
		public final Builder aggregations(Map<String, ApiKeyAggregate> map) {
			this.aggregations = _mapPutAll(this.aggregations, map);
			return this;
		}

		/**
		 * The aggregations result, if requested.
		 * <p>
		 * API name: {@code aggregations}
		 * <p>
		 * Adds an entry to <code>aggregations</code>.
		 */
		public final Builder aggregations(String key, ApiKeyAggregate value) {
			this.aggregations = _mapPut(this.aggregations, key, value);
			return this;
		}

		/**
		 * The aggregations result, if requested.
		 * <p>
		 * API name: {@code aggregations}
		 * <p>
		 * Adds an entry to <code>aggregations</code> using a builder lambda.
		 */
		public final Builder aggregations(String key,
				Function<ApiKeyAggregate.Builder, ObjectBuilder<ApiKeyAggregate>> fn) {
			return aggregations(key, fn.apply(new ApiKeyAggregate.Builder()).build());
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link QueryApiKeysResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public QueryApiKeysResponse build() {
			_checkSingleUse();

			return new QueryApiKeysResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link QueryApiKeysResponse}
	 */
	public static final JsonpDeserializer<QueryApiKeysResponse> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, QueryApiKeysResponse::setupQueryApiKeysResponseDeserializer);

	protected static void setupQueryApiKeysResponseDeserializer(ObjectDeserializer<QueryApiKeysResponse.Builder> op) {

		op.add(Builder::total, JsonpDeserializer.integerDeserializer(), "total");
		op.add(Builder::count, JsonpDeserializer.integerDeserializer(), "count");
		op.add(Builder::apiKeys, JsonpDeserializer.arrayDeserializer(ApiKey._DESERIALIZER), "api_keys");
		op.add(Builder::aggregations, ApiKeyAggregate._TYPED_KEYS_DESERIALIZER, "aggregations");

	}

}
