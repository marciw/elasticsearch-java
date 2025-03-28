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

package co.elastic.clients.elasticsearch.inference;

import co.elastic.clients.elasticsearch._types.ErrorResponse;
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

// typedef: inference.completion.Request

/**
 * Perform completion inference on the service
 * 
 * @see <a href="../doc-files/api-spec.html#inference.completion.Request">API
 *      specification</a>
 */
@JsonpDeserializable
public class CompletionRequest extends RequestBase implements JsonpSerializable {
	private final String inferenceId;

	private final List<String> input;

	@Nullable
	private final JsonData taskSettings;

	@Nullable
	private final Time timeout;

	// ---------------------------------------------------------------------------------------------

	private CompletionRequest(Builder builder) {

		this.inferenceId = ApiTypeHelper.requireNonNull(builder.inferenceId, this, "inferenceId");
		this.input = ApiTypeHelper.unmodifiableRequired(builder.input, this, "input");
		this.taskSettings = builder.taskSettings;
		this.timeout = builder.timeout;

	}

	public static CompletionRequest of(Function<Builder, ObjectBuilder<CompletionRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - The inference Id
	 * <p>
	 * API name: {@code inference_id}
	 */
	public final String inferenceId() {
		return this.inferenceId;
	}

	/**
	 * Required - Inference input. Either a string or an array of strings.
	 * <p>
	 * API name: {@code input}
	 */
	public final List<String> input() {
		return this.input;
	}

	/**
	 * Optional task settings
	 * <p>
	 * API name: {@code task_settings}
	 */
	@Nullable
	public final JsonData taskSettings() {
		return this.taskSettings;
	}

	/**
	 * Specifies the amount of time to wait for the inference request to complete.
	 * <p>
	 * API name: {@code timeout}
	 */
	@Nullable
	public final Time timeout() {
		return this.timeout;
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

		if (ApiTypeHelper.isDefined(this.input)) {
			generator.writeKey("input");
			generator.writeStartArray();
			for (String item0 : this.input) {
				generator.write(item0);

			}
			generator.writeEnd();

		}
		if (this.taskSettings != null) {
			generator.writeKey("task_settings");
			this.taskSettings.serialize(generator, mapper);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link CompletionRequest}.
	 */

	public static class Builder extends RequestBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<CompletionRequest> {
		private String inferenceId;

		private List<String> input;

		@Nullable
		private JsonData taskSettings;

		@Nullable
		private Time timeout;

		/**
		 * Required - The inference Id
		 * <p>
		 * API name: {@code inference_id}
		 */
		public final Builder inferenceId(String value) {
			this.inferenceId = value;
			return this;
		}

		/**
		 * Required - Inference input. Either a string or an array of strings.
		 * <p>
		 * API name: {@code input}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>input</code>.
		 */
		public final Builder input(List<String> list) {
			this.input = _listAddAll(this.input, list);
			return this;
		}

		/**
		 * Required - Inference input. Either a string or an array of strings.
		 * <p>
		 * API name: {@code input}
		 * <p>
		 * Adds one or more values to <code>input</code>.
		 */
		public final Builder input(String value, String... values) {
			this.input = _listAdd(this.input, value, values);
			return this;
		}

		/**
		 * Optional task settings
		 * <p>
		 * API name: {@code task_settings}
		 */
		public final Builder taskSettings(@Nullable JsonData value) {
			this.taskSettings = value;
			return this;
		}

		/**
		 * Specifies the amount of time to wait for the inference request to complete.
		 * <p>
		 * API name: {@code timeout}
		 */
		public final Builder timeout(@Nullable Time value) {
			this.timeout = value;
			return this;
		}

		/**
		 * Specifies the amount of time to wait for the inference request to complete.
		 * <p>
		 * API name: {@code timeout}
		 */
		public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
			return this.timeout(fn.apply(new Time.Builder()).build());
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link CompletionRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public CompletionRequest build() {
			_checkSingleUse();

			return new CompletionRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link CompletionRequest}
	 */
	public static final JsonpDeserializer<CompletionRequest> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, CompletionRequest::setupCompletionRequestDeserializer);

	protected static void setupCompletionRequestDeserializer(ObjectDeserializer<CompletionRequest.Builder> op) {

		op.add(Builder::input, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "input");
		op.add(Builder::taskSettings, JsonData._DESERIALIZER, "task_settings");

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code inference.completion}".
	 */
	public static final Endpoint<CompletionRequest, CompletionResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
			"es/inference.completion",

			// Request method
			request -> {
				return "POST";

			},

			// Request path
			request -> {
				final int _inferenceId = 1 << 0;

				int propsSet = 0;

				propsSet |= _inferenceId;

				if (propsSet == (_inferenceId)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_inference");
					buf.append("/completion");
					buf.append("/");
					SimpleEndpoint.pathEncode(request.inferenceId, buf);
					return buf.toString();
				}
				throw SimpleEndpoint.noPathTemplateFound("path");

			},

			// Path parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				final int _inferenceId = 1 << 0;

				int propsSet = 0;

				propsSet |= _inferenceId;

				if (propsSet == (_inferenceId)) {
					params.put("inferenceId", request.inferenceId);
				}
				return params;
			},

			// Request parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				if (request.timeout != null) {
					params.put("timeout", request.timeout._toJsonString());
				}
				return params;

			}, SimpleEndpoint.emptyMap(), true, CompletionResponse._DESERIALIZER);
}
