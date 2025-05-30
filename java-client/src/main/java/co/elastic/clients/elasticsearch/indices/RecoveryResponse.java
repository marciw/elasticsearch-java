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

import co.elastic.clients.elasticsearch.indices.recovery.RecoveryStatus;
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
import jakarta.json.stream.JsonParser;
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

// typedef: indices.recovery.Response

/**
 *
 * @see <a href="../doc-files/api-spec.html#indices.recovery.Response">API
 *      specification</a>
 */
@JsonpDeserializable
public class RecoveryResponse implements JsonpSerializable {
	private final Map<String, RecoveryStatus> statuses;

	// ---------------------------------------------------------------------------------------------

	private RecoveryResponse(Builder builder) {

		this.statuses = ApiTypeHelper.unmodifiableRequired(builder.statuses, this, "statuses");

	}

	public static RecoveryResponse of(Function<Builder, ObjectBuilder<RecoveryResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - Response value.
	 */
	public final Map<String, RecoveryStatus> statuses() {
		return this.statuses;
	}

	/**
	 * Get an element of {@code statuses}.
	 */
	public final @Nullable RecoveryStatus get(String key) {
		return this.statuses.get(key);
	}

	/**
	 * Serialize this value to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		for (Map.Entry<String, RecoveryStatus> item0 : this.statuses.entrySet()) {
			generator.writeKey(item0.getKey());
			item0.getValue().serialize(generator, mapper);

		}
		generator.writeEnd();

	}

	@Override
	public String toString() {
		return JsonpUtils.toString(this);
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link RecoveryResponse}.
	 */

	public static class Builder extends WithJsonObjectBuilderBase<Builder> implements ObjectBuilder<RecoveryResponse> {
		private Map<String, RecoveryStatus> statuses = new HashMap<>();

		/**
		 * Required - Response value.
		 * <p>
		 * Adds all entries of <code>map</code> to <code>statuses</code>.
		 */
		public final Builder statuses(Map<String, RecoveryStatus> map) {
			this.statuses = _mapPutAll(this.statuses, map);
			return this;
		}

		/**
		 * Required - Response value.
		 * <p>
		 * Adds an entry to <code>statuses</code>.
		 */
		public final Builder statuses(String key, RecoveryStatus value) {
			this.statuses = _mapPut(this.statuses, key, value);
			return this;
		}

		/**
		 * Required - Response value.
		 * <p>
		 * Adds an entry to <code>statuses</code> using a builder lambda.
		 */
		public final Builder statuses(String key, Function<RecoveryStatus.Builder, ObjectBuilder<RecoveryStatus>> fn) {
			return statuses(key, fn.apply(new RecoveryStatus.Builder()).build());
		}

		@Override
		public Builder withJson(JsonParser parser, JsonpMapper mapper) {

			@SuppressWarnings("unchecked")
			Map<String, RecoveryStatus> value = (Map<String, RecoveryStatus>) JsonpDeserializer
					.stringMapDeserializer(RecoveryStatus._DESERIALIZER).deserialize(parser, mapper);
			return this.statuses(value);
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link RecoveryResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public RecoveryResponse build() {
			_checkSingleUse();

			return new RecoveryResponse(this);
		}
	}

	public static final JsonpDeserializer<RecoveryResponse> _DESERIALIZER = createRecoveryResponseDeserializer();
	protected static JsonpDeserializer<RecoveryResponse> createRecoveryResponseDeserializer() {

		JsonpDeserializer<Map<String, RecoveryStatus>> valueDeserializer = JsonpDeserializer
				.stringMapDeserializer(RecoveryStatus._DESERIALIZER);

		return JsonpDeserializer.of(valueDeserializer.acceptedEvents(), (parser, mapper, event) -> new Builder()
				.statuses(valueDeserializer.deserialize(parser, mapper, event)).build());
	}

}
