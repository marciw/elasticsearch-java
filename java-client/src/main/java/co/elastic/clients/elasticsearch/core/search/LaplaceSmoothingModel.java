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

package co.elastic.clients.elasticsearch.core.search;

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
import java.lang.Double;
import java.util.Objects;
import java.util.function.Function;

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

// typedef: _global.search._types.LaplaceSmoothingModel

/**
 *
 * @see <a href=
 *      "../../doc-files/api-spec.html#_global.search._types.LaplaceSmoothingModel">API
 *      specification</a>
 */
@JsonpDeserializable
public class LaplaceSmoothingModel implements SmoothingModelVariant, JsonpSerializable {
	private final double alpha;

	// ---------------------------------------------------------------------------------------------

	private LaplaceSmoothingModel(Builder builder) {

		this.alpha = ApiTypeHelper.requireNonNull(builder.alpha, this, "alpha", 0);

	}

	public static LaplaceSmoothingModel of(Function<Builder, ObjectBuilder<LaplaceSmoothingModel>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * SmoothingModel variant kind.
	 */
	@Override
	public SmoothingModel.Kind _smoothingModelKind() {
		return SmoothingModel.Kind.Laplace;
	}

	/**
	 * Required - A constant that is added to all counts to balance weights.
	 * <p>
	 * API name: {@code alpha}
	 */
	public final double alpha() {
		return this.alpha;
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

		generator.writeKey("alpha");
		generator.write(this.alpha);

	}

	@Override
	public String toString() {
		return JsonpUtils.toString(this);
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link LaplaceSmoothingModel}.
	 */

	public static class Builder extends WithJsonObjectBuilderBase<Builder>
			implements
				ObjectBuilder<LaplaceSmoothingModel> {
		private Double alpha;

		/**
		 * Required - A constant that is added to all counts to balance weights.
		 * <p>
		 * API name: {@code alpha}
		 */
		public final Builder alpha(double value) {
			this.alpha = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link LaplaceSmoothingModel}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public LaplaceSmoothingModel build() {
			_checkSingleUse();

			return new LaplaceSmoothingModel(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link LaplaceSmoothingModel}
	 */
	public static final JsonpDeserializer<LaplaceSmoothingModel> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, LaplaceSmoothingModel::setupLaplaceSmoothingModelDeserializer);

	protected static void setupLaplaceSmoothingModelDeserializer(ObjectDeserializer<LaplaceSmoothingModel.Builder> op) {

		op.add(Builder::alpha, JsonpDeserializer.doubleDeserializer(), "alpha");

	}

}
