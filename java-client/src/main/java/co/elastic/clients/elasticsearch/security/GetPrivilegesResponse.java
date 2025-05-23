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

import co.elastic.clients.elasticsearch.security.put_privileges.Actions;
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

// typedef: security.get_privileges.Response

/**
 *
 * @see <a href=
 *      "../doc-files/api-spec.html#security.get_privileges.Response">API
 *      specification</a>
 */
@JsonpDeserializable
public class GetPrivilegesResponse implements JsonpSerializable {
	private final Map<String, Map<String, Actions>> privileges;

	// ---------------------------------------------------------------------------------------------

	private GetPrivilegesResponse(Builder builder) {

		this.privileges = ApiTypeHelper.unmodifiableRequired(builder.privileges, this, "privileges");

	}

	public static GetPrivilegesResponse of(Function<Builder, ObjectBuilder<GetPrivilegesResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - Response value.
	 */
	public final Map<String, Map<String, Actions>> privileges() {
		return this.privileges;
	}

	/**
	 * Get an element of {@code privileges}.
	 */
	public final @Nullable Map<String, Actions> get(String key) {
		return this.privileges.get(key);
	}

	/**
	 * Serialize this value to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		for (Map.Entry<String, Map<String, Actions>> item0 : this.privileges.entrySet()) {
			generator.writeKey(item0.getKey());
			generator.writeStartObject();
			if (item0.getValue() != null) {
				for (Map.Entry<String, Actions> item1 : item0.getValue().entrySet()) {
					generator.writeKey(item1.getKey());
					item1.getValue().serialize(generator, mapper);

				}
			}
			generator.writeEnd();

		}
		generator.writeEnd();

	}

	@Override
	public String toString() {
		return JsonpUtils.toString(this);
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GetPrivilegesResponse}.
	 */

	public static class Builder extends WithJsonObjectBuilderBase<Builder>
			implements
				ObjectBuilder<GetPrivilegesResponse> {
		private Map<String, Map<String, Actions>> privileges = new HashMap<>();

		/**
		 * Required - Response value.
		 * <p>
		 * Adds all entries of <code>map</code> to <code>privileges</code>.
		 */
		public final Builder privileges(Map<String, Map<String, Actions>> map) {
			this.privileges = _mapPutAll(this.privileges, map);
			return this;
		}

		/**
		 * Required - Response value.
		 * <p>
		 * Adds an entry to <code>privileges</code>.
		 */
		public final Builder privileges(String key, Map<String, Actions> value) {
			this.privileges = _mapPut(this.privileges, key, value);
			return this;
		}

		@Override
		public Builder withJson(JsonParser parser, JsonpMapper mapper) {

			@SuppressWarnings("unchecked")
			Map<String, Map<String, Actions>> value = (Map<String, Map<String, Actions>>) JsonpDeserializer
					.stringMapDeserializer(JsonpDeserializer.stringMapDeserializer(Actions._DESERIALIZER))
					.deserialize(parser, mapper);
			return this.privileges(value);
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link GetPrivilegesResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GetPrivilegesResponse build() {
			_checkSingleUse();

			return new GetPrivilegesResponse(this);
		}
	}

	public static final JsonpDeserializer<GetPrivilegesResponse> _DESERIALIZER = createGetPrivilegesResponseDeserializer();
	protected static JsonpDeserializer<GetPrivilegesResponse> createGetPrivilegesResponseDeserializer() {

		JsonpDeserializer<Map<String, Map<String, Actions>>> valueDeserializer = JsonpDeserializer
				.stringMapDeserializer(JsonpDeserializer.stringMapDeserializer(Actions._DESERIALIZER));

		return JsonpDeserializer.of(valueDeserializer.acceptedEvents(), (parser, mapper, event) -> new Builder()
				.privileges(valueDeserializer.deserialize(parser, mapper, event)).build());
	}

}
