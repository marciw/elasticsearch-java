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

package co.elastic.clients.elasticsearch.core;

import co.elastic.clients.json.JsonData;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpSerializable;
import co.elastic.clients.json.JsonpSerializer;
import co.elastic.clients.json.JsonpUtils;
import co.elastic.clients.json.NamedDeserializer;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.util.ApiTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
import co.elastic.clients.util.WithJsonObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;
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

// typedef: _global.get_source.Response

/**
 *
 * @see <a href="../doc-files/api-spec.html#_global.get_source.Response">API
 *      specification</a>
 */
@JsonpDeserializable
public class GetSourceResponse<TDocument> implements JsonpSerializable {
	private final TDocument source;

	@Nullable
	private final JsonpSerializer<TDocument> tDocumentSerializer;

	// ---------------------------------------------------------------------------------------------

	private GetSourceResponse(Builder<TDocument> builder) {

		this.source = ApiTypeHelper.requireNonNull(builder.source, this, "source");
		this.tDocumentSerializer = builder.tDocumentSerializer;

	}

	public static <TDocument> GetSourceResponse<TDocument> of(
			Function<Builder<TDocument>, ObjectBuilder<GetSourceResponse<TDocument>>> fn) {
		return fn.apply(new Builder<>()).build();
	}

	/**
	 * Required - Response value.
	 */
	public final TDocument source() {
		return this.source;
	}

	/**
	 * Serialize this value to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		JsonpUtils.serialize(this.source, generator, tDocumentSerializer, mapper);

	}

	@Override
	public String toString() {
		return JsonpUtils.toString(this);
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GetSourceResponse}.
	 */

	public static class Builder<TDocument> extends WithJsonObjectBuilderBase<Builder<TDocument>>
			implements
				ObjectBuilder<GetSourceResponse<TDocument>> {
		private TDocument source;

		@Nullable
		private JsonpSerializer<TDocument> tDocumentSerializer;

		/**
		 * Required - Response value.
		 */
		public final Builder<TDocument> source(TDocument value) {
			this.source = value;
			return this;
		}

		/**
		 * Serializer for TDocument. If not set, an attempt will be made to find a
		 * serializer from the JSON context.
		 */
		public final Builder<TDocument> tDocumentSerializer(@Nullable JsonpSerializer<TDocument> value) {
			this.tDocumentSerializer = value;
			return this;
		}

		@Override
		public Builder<TDocument> withJson(JsonParser parser, JsonpMapper mapper) {
			JsonpDeserializer<JsonData> tDocumentDeserializer = JsonData._DESERIALIZER;

			@SuppressWarnings("unchecked")
			TDocument value = (TDocument) tDocumentDeserializer.deserialize(parser, mapper);
			return this.source(value);
		}

		@Override
		protected Builder<TDocument> self() {
			return this;
		}

		/**
		 * Builds a {@link GetSourceResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GetSourceResponse<TDocument> build() {
			_checkSingleUse();

			return new GetSourceResponse<TDocument>(this);
		}
	}

	/**
	 * Json deserializer for {@link GetSourceResponse} based on named deserializers
	 * provided by the calling {@code JsonMapper}.
	 */
	public static final JsonpDeserializer<GetSourceResponse<Object>> _DESERIALIZER = createGetSourceResponseDeserializer(
			new NamedDeserializer<>("co.elastic.clients:Deserializer:_global.get_source.Response.TDocument"));

	public static <TDocument> JsonpDeserializer<GetSourceResponse<TDocument>> createGetSourceResponseDeserializer(
			JsonpDeserializer<TDocument> tDocumentDeserializer) {

		JsonpDeserializer<TDocument> valueDeserializer = tDocumentDeserializer;

		return JsonpDeserializer.of(valueDeserializer.acceptedEvents(),
				(parser, mapper, event) -> new Builder<TDocument>()
						.source(valueDeserializer.deserialize(parser, mapper, event)).build());
	}

}
