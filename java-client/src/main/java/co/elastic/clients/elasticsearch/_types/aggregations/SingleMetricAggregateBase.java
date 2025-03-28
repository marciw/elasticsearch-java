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

package co.elastic.clients.elasticsearch._types.aggregations;

import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.util.ObjectBuilder;
import co.elastic.clients.util.WithJsonObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.lang.Double;
import java.lang.String;
import java.util.Objects;
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

// typedef: _types.aggregations.SingleMetricAggregateBase

/**
 *
 * @see <a href=
 *      "../../doc-files/api-spec.html#_types.aggregations.SingleMetricAggregateBase">API
 *      specification</a>
 */

public abstract class SingleMetricAggregateBase extends AggregateBase {
	@Nullable
	private final Double value;

	@Nullable
	private final String valueAsString;

	// ---------------------------------------------------------------------------------------------

	protected SingleMetricAggregateBase(AbstractBuilder<?> builder) {
		super(builder);

		this.value = builder.value;
		this.valueAsString = builder.valueAsString;

	}

	/**
	 * The metric value. A missing value generally means that there was no data to
	 * aggregate, unless specified otherwise.
	 * <p>
	 * API name: {@code value}
	 */
	@Nullable
	public final Double value() {
		return this.value;
	}

	/**
	 * API name: {@code value_as_string}
	 */
	@Nullable
	public final String valueAsString() {
		return this.valueAsString;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		super.serializeInternal(generator, mapper);
		if (this.value != null) {
			generator.writeKey("value");
			generator.write(this.value);

		}
		if (this.valueAsString != null) {
			generator.writeKey("value_as_string");
			generator.write(this.valueAsString);

		}

	}

	public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>>
			extends
				AggregateBase.AbstractBuilder<BuilderT> {
		@Nullable
		private Double value;

		@Nullable
		private String valueAsString;

		/**
		 * The metric value. A missing value generally means that there was no data to
		 * aggregate, unless specified otherwise.
		 * <p>
		 * API name: {@code value}
		 */
		public final BuilderT value(@Nullable Double value) {
			this.value = value;
			return self();
		}

		/**
		 * API name: {@code value_as_string}
		 */
		public final BuilderT valueAsString(@Nullable String value) {
			this.valueAsString = value;
			return self();
		}

	}

	// ---------------------------------------------------------------------------------------------
	protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupSingleMetricAggregateBaseDeserializer(
			ObjectDeserializer<BuilderT> op) {
		AggregateBase.setupAggregateBaseDeserializer(op);
		op.add(AbstractBuilder::value, JsonpDeserializer.doubleDeserializer(), "value");
		op.add(AbstractBuilder::valueAsString, JsonpDeserializer.stringDeserializer(), "value_as_string");

	}

}
