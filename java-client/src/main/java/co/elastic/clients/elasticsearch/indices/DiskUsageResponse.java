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

import co.elastic.clients.json.JsonData;
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

// typedef: indices.disk_usage.Response

/**
 *
 * @see <a href="../doc-files/api-spec.html#indices.disk_usage.Response">API
 *      specification</a>
 */
@JsonpDeserializable
public class DiskUsageResponse implements JsonpSerializable {
	private final JsonData diskUsage;

	// ---------------------------------------------------------------------------------------------

	private DiskUsageResponse(Builder builder) {

		this.diskUsage = ApiTypeHelper.requireNonNull(builder.diskUsage, this, "diskUsage");

	}

	public static DiskUsageResponse of(Function<Builder, ObjectBuilder<DiskUsageResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - Response value.
	 */
	public final JsonData diskUsage() {
		return this.diskUsage;
	}

	/**
	 * Serialize this value to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		this.diskUsage.serialize(generator, mapper);

	}

	@Override
	public String toString() {
		return JsonpUtils.toString(this);
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link DiskUsageResponse}.
	 */

	public static class Builder extends WithJsonObjectBuilderBase<Builder> implements ObjectBuilder<DiskUsageResponse> {
		private JsonData diskUsage;

		/**
		 * Required - Response value.
		 */
		public final Builder diskUsage(JsonData value) {
			this.diskUsage = value;
			return this;
		}

		@Override
		public Builder withJson(JsonParser parser, JsonpMapper mapper) {

			@SuppressWarnings("unchecked")
			JsonData value = (JsonData) JsonData._DESERIALIZER.deserialize(parser, mapper);
			return this.diskUsage(value);
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link DiskUsageResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public DiskUsageResponse build() {
			_checkSingleUse();

			return new DiskUsageResponse(this);
		}
	}

	public static final JsonpDeserializer<DiskUsageResponse> _DESERIALIZER = createDiskUsageResponseDeserializer();
	protected static JsonpDeserializer<DiskUsageResponse> createDiskUsageResponseDeserializer() {

		JsonpDeserializer<JsonData> valueDeserializer = JsonData._DESERIALIZER;

		return JsonpDeserializer.of(valueDeserializer.acceptedEvents(), (parser, mapper, event) -> new Builder()
				.diskUsage(valueDeserializer.deserialize(parser, mapper, event)).build());
	}

}
