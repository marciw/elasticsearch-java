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

package co.elastic.clients.elasticsearch.enrich;

import co.elastic.clients.elasticsearch.enrich.execute_policy.ExecuteEnrichPolicyStatus;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpSerializable;
import co.elastic.clients.json.JsonpUtils;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.util.ObjectBuilder;
import co.elastic.clients.util.WithJsonObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.lang.String;
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

// typedef: enrich.execute_policy.Response

/**
 *
 * @see <a href="../doc-files/api-spec.html#enrich.execute_policy.Response">API
 *      specification</a>
 */
@JsonpDeserializable
public class ExecutePolicyResponse implements JsonpSerializable {
	@Nullable
	private final ExecuteEnrichPolicyStatus status;

	@Nullable
	private final String task;

	// ---------------------------------------------------------------------------------------------

	private ExecutePolicyResponse(Builder builder) {

		this.status = builder.status;
		this.task = builder.task;

	}

	public static ExecutePolicyResponse of(Function<Builder, ObjectBuilder<ExecutePolicyResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * API name: {@code status}
	 */
	@Nullable
	public final ExecuteEnrichPolicyStatus status() {
		return this.status;
	}

	/**
	 * API name: {@code task}
	 */
	@Nullable
	public final String task() {
		return this.task;
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

		if (this.status != null) {
			generator.writeKey("status");
			this.status.serialize(generator, mapper);

		}
		if (this.task != null) {
			generator.writeKey("task");
			generator.write(this.task);

		}

	}

	@Override
	public String toString() {
		return JsonpUtils.toString(this);
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ExecutePolicyResponse}.
	 */

	public static class Builder extends WithJsonObjectBuilderBase<Builder>
			implements
				ObjectBuilder<ExecutePolicyResponse> {
		@Nullable
		private ExecuteEnrichPolicyStatus status;

		@Nullable
		private String task;

		/**
		 * API name: {@code status}
		 */
		public final Builder status(@Nullable ExecuteEnrichPolicyStatus value) {
			this.status = value;
			return this;
		}

		/**
		 * API name: {@code status}
		 */
		public final Builder status(
				Function<ExecuteEnrichPolicyStatus.Builder, ObjectBuilder<ExecuteEnrichPolicyStatus>> fn) {
			return this.status(fn.apply(new ExecuteEnrichPolicyStatus.Builder()).build());
		}

		/**
		 * API name: {@code task}
		 */
		public final Builder task(@Nullable String value) {
			this.task = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link ExecutePolicyResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ExecutePolicyResponse build() {
			_checkSingleUse();

			return new ExecutePolicyResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link ExecutePolicyResponse}
	 */
	public static final JsonpDeserializer<ExecutePolicyResponse> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, ExecutePolicyResponse::setupExecutePolicyResponseDeserializer);

	protected static void setupExecutePolicyResponseDeserializer(ObjectDeserializer<ExecutePolicyResponse.Builder> op) {

		op.add(Builder::status, ExecuteEnrichPolicyStatus._DESERIALIZER, "status");
		op.add(Builder::task, JsonpDeserializer.stringDeserializer(), "task");

	}

}
