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

package co.elastic.clients.elasticsearch.cluster;

import co.elastic.clients.elasticsearch.cluster.remote_info.ClusterRemoteInfo;
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

// typedef: cluster.remote_info.Response

/**
 *
 * @see <a href="../doc-files/api-spec.html#cluster.remote_info.Response">API
 *      specification</a>
 */
@JsonpDeserializable
public class RemoteInfoResponse implements JsonpSerializable {
	private final Map<String, ClusterRemoteInfo> infos;

	// ---------------------------------------------------------------------------------------------

	private RemoteInfoResponse(Builder builder) {

		this.infos = ApiTypeHelper.unmodifiableRequired(builder.infos, this, "infos");

	}

	public static RemoteInfoResponse of(Function<Builder, ObjectBuilder<RemoteInfoResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - Response value.
	 */
	public final Map<String, ClusterRemoteInfo> infos() {
		return this.infos;
	}

	/**
	 * Get an element of {@code infos}.
	 */
	public final @Nullable ClusterRemoteInfo get(String key) {
		return this.infos.get(key);
	}

	/**
	 * Serialize this value to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		for (Map.Entry<String, ClusterRemoteInfo> item0 : this.infos.entrySet()) {
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
	 * Builder for {@link RemoteInfoResponse}.
	 */

	public static class Builder extends WithJsonObjectBuilderBase<Builder>
			implements
				ObjectBuilder<RemoteInfoResponse> {
		private Map<String, ClusterRemoteInfo> infos = new HashMap<>();

		/**
		 * Required - Response value.
		 * <p>
		 * Adds all entries of <code>map</code> to <code>infos</code>.
		 */
		public final Builder infos(Map<String, ClusterRemoteInfo> map) {
			this.infos = _mapPutAll(this.infos, map);
			return this;
		}

		/**
		 * Required - Response value.
		 * <p>
		 * Adds an entry to <code>infos</code>.
		 */
		public final Builder infos(String key, ClusterRemoteInfo value) {
			this.infos = _mapPut(this.infos, key, value);
			return this;
		}

		/**
		 * Required - Response value.
		 * <p>
		 * Adds an entry to <code>infos</code> using a builder lambda.
		 */
		public final Builder infos(String key,
				Function<ClusterRemoteInfo.Builder, ObjectBuilder<ClusterRemoteInfo>> fn) {
			return infos(key, fn.apply(new ClusterRemoteInfo.Builder()).build());
		}

		@Override
		public Builder withJson(JsonParser parser, JsonpMapper mapper) {

			@SuppressWarnings("unchecked")
			Map<String, ClusterRemoteInfo> value = (Map<String, ClusterRemoteInfo>) JsonpDeserializer
					.stringMapDeserializer(ClusterRemoteInfo._DESERIALIZER).deserialize(parser, mapper);
			return this.infos(value);
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link RemoteInfoResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public RemoteInfoResponse build() {
			_checkSingleUse();

			return new RemoteInfoResponse(this);
		}
	}

	public static final JsonpDeserializer<RemoteInfoResponse> _DESERIALIZER = createRemoteInfoResponseDeserializer();
	protected static JsonpDeserializer<RemoteInfoResponse> createRemoteInfoResponseDeserializer() {

		JsonpDeserializer<Map<String, ClusterRemoteInfo>> valueDeserializer = JsonpDeserializer
				.stringMapDeserializer(ClusterRemoteInfo._DESERIALIZER);

		return JsonpDeserializer.of(valueDeserializer.acceptedEvents(), (parser, mapper, event) -> new Builder()
				.infos(valueDeserializer.deserialize(parser, mapper, event)).build());
	}

}
