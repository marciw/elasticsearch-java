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

package co.elastic.clients.elasticsearch.cat;

import co.elastic.clients.elasticsearch.cat.ml_datafeeds.DatafeedsRecord;
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
import java.util.List;
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

// typedef: cat.ml_datafeeds.Response

/**
 *
 * @see <a href="../doc-files/api-spec.html#cat.ml_datafeeds.Response">API
 *      specification</a>
 */
@JsonpDeserializable
public class MlDatafeedsResponse implements JsonpSerializable {
	private final List<DatafeedsRecord> datafeeds;

	// ---------------------------------------------------------------------------------------------

	private MlDatafeedsResponse(Builder builder) {

		this.datafeeds = ApiTypeHelper.unmodifiableRequired(builder.datafeeds, this, "datafeeds");

	}

	public static MlDatafeedsResponse of(Function<Builder, ObjectBuilder<MlDatafeedsResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - Response value.
	 */
	public final List<DatafeedsRecord> datafeeds() {
		return this.datafeeds;
	}

	/**
	 * Serialize this value to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartArray();
		for (DatafeedsRecord item0 : this.datafeeds) {
			item0.serialize(generator, mapper);

		}
		generator.writeEnd();

	}

	@Override
	public String toString() {
		return JsonpUtils.toString(this);
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link MlDatafeedsResponse}.
	 */

	public static class Builder extends WithJsonObjectBuilderBase<Builder>
			implements
				ObjectBuilder<MlDatafeedsResponse> {
		private List<DatafeedsRecord> datafeeds;

		/**
		 * Required - Response value.
		 * <p>
		 * Adds all elements of <code>list</code> to <code>datafeeds</code>.
		 */
		public final Builder datafeeds(List<DatafeedsRecord> list) {
			this.datafeeds = _listAddAll(this.datafeeds, list);
			return this;
		}

		/**
		 * Required - Response value.
		 * <p>
		 * Adds one or more values to <code>datafeeds</code>.
		 */
		public final Builder datafeeds(DatafeedsRecord value, DatafeedsRecord... values) {
			this.datafeeds = _listAdd(this.datafeeds, value, values);
			return this;
		}

		/**
		 * Required - Response value.
		 * <p>
		 * Adds a value to <code>datafeeds</code> using a builder lambda.
		 */
		public final Builder datafeeds(Function<DatafeedsRecord.Builder, ObjectBuilder<DatafeedsRecord>> fn) {
			return datafeeds(fn.apply(new DatafeedsRecord.Builder()).build());
		}

		@Override
		public Builder withJson(JsonParser parser, JsonpMapper mapper) {

			@SuppressWarnings("unchecked")
			List<DatafeedsRecord> value = (List<DatafeedsRecord>) JsonpDeserializer
					.arrayDeserializer(DatafeedsRecord._DESERIALIZER).deserialize(parser, mapper);
			return this.datafeeds(value);
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link MlDatafeedsResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public MlDatafeedsResponse build() {
			_checkSingleUse();

			return new MlDatafeedsResponse(this);
		}
	}

	public static final JsonpDeserializer<MlDatafeedsResponse> _DESERIALIZER = createMlDatafeedsResponseDeserializer();
	protected static JsonpDeserializer<MlDatafeedsResponse> createMlDatafeedsResponseDeserializer() {

		JsonpDeserializer<List<DatafeedsRecord>> valueDeserializer = JsonpDeserializer
				.arrayDeserializer(DatafeedsRecord._DESERIALIZER);

		return JsonpDeserializer.of(valueDeserializer.acceptedEvents(), (parser, mapper, event) -> new Builder()
				.datafeeds(valueDeserializer.deserialize(parser, mapper, event)).build());
	}

}
