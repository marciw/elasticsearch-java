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

package co.elastic.clients.elasticsearch.ingest;

import co.elastic.clients.json.JsonData;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.util.ApiTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.Boolean;
import java.lang.String;
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

// typedef: ingest._types.InferenceProcessor

/**
 *
 * @see <a href=
 *      "../doc-files/api-spec.html#ingest._types.InferenceProcessor">API
 *      specification</a>
 */
@JsonpDeserializable
public class InferenceProcessor extends ProcessorBase implements ProcessorVariant {
	private final String modelId;

	@Nullable
	private final String targetField;

	private final Map<String, JsonData> fieldMap;

	@Nullable
	private final InferenceConfig inferenceConfig;

	private final List<InputConfig> inputOutput;

	@Nullable
	private final Boolean ignoreMissing;

	// ---------------------------------------------------------------------------------------------

	private InferenceProcessor(Builder builder) {
		super(builder);

		this.modelId = ApiTypeHelper.requireNonNull(builder.modelId, this, "modelId");
		this.targetField = builder.targetField;
		this.fieldMap = ApiTypeHelper.unmodifiable(builder.fieldMap);
		this.inferenceConfig = builder.inferenceConfig;
		this.inputOutput = ApiTypeHelper.unmodifiable(builder.inputOutput);
		this.ignoreMissing = builder.ignoreMissing;

	}

	public static InferenceProcessor of(Function<Builder, ObjectBuilder<InferenceProcessor>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Processor variant kind.
	 */
	@Override
	public Processor.Kind _processorKind() {
		return Processor.Kind.Inference;
	}

	/**
	 * Required - The ID or alias for the trained model, or the ID of the
	 * deployment.
	 * <p>
	 * API name: {@code model_id}
	 */
	public final String modelId() {
		return this.modelId;
	}

	/**
	 * Field added to incoming documents to contain results objects.
	 * <p>
	 * API name: {@code target_field}
	 */
	@Nullable
	public final String targetField() {
		return this.targetField;
	}

	/**
	 * Maps the document field names to the known field names of the model. This
	 * mapping takes precedence over any default mappings provided in the model
	 * configuration.
	 * <p>
	 * API name: {@code field_map}
	 */
	public final Map<String, JsonData> fieldMap() {
		return this.fieldMap;
	}

	/**
	 * Contains the inference type and its options.
	 * <p>
	 * API name: {@code inference_config}
	 */
	@Nullable
	public final InferenceConfig inferenceConfig() {
		return this.inferenceConfig;
	}

	/**
	 * Input fields for inference and output (destination) fields for the inference
	 * results. This option is incompatible with the target_field and field_map
	 * options.
	 * <p>
	 * API name: {@code input_output}
	 */
	public final List<InputConfig> inputOutput() {
		return this.inputOutput;
	}

	/**
	 * If true and any of the input fields defined in input_ouput are missing then
	 * those missing fields are quietly ignored, otherwise a missing field causes a
	 * failure. Only applies when using input_output configurations to explicitly
	 * list the input fields.
	 * <p>
	 * API name: {@code ignore_missing}
	 */
	@Nullable
	public final Boolean ignoreMissing() {
		return this.ignoreMissing;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		super.serializeInternal(generator, mapper);
		generator.writeKey("model_id");
		generator.write(this.modelId);

		if (this.targetField != null) {
			generator.writeKey("target_field");
			generator.write(this.targetField);

		}
		if (ApiTypeHelper.isDefined(this.fieldMap)) {
			generator.writeKey("field_map");
			generator.writeStartObject();
			for (Map.Entry<String, JsonData> item0 : this.fieldMap.entrySet()) {
				generator.writeKey(item0.getKey());
				item0.getValue().serialize(generator, mapper);

			}
			generator.writeEnd();

		}
		if (this.inferenceConfig != null) {
			generator.writeKey("inference_config");
			this.inferenceConfig.serialize(generator, mapper);

		}
		if (ApiTypeHelper.isDefined(this.inputOutput)) {
			generator.writeKey("input_output");
			generator.writeStartArray();
			for (InputConfig item0 : this.inputOutput) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}
		if (this.ignoreMissing != null) {
			generator.writeKey("ignore_missing");
			generator.write(this.ignoreMissing);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link InferenceProcessor}.
	 */

	public static class Builder extends ProcessorBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<InferenceProcessor> {
		private String modelId;

		@Nullable
		private String targetField;

		@Nullable
		private Map<String, JsonData> fieldMap;

		@Nullable
		private InferenceConfig inferenceConfig;

		@Nullable
		private List<InputConfig> inputOutput;

		@Nullable
		private Boolean ignoreMissing;

		/**
		 * Required - The ID or alias for the trained model, or the ID of the
		 * deployment.
		 * <p>
		 * API name: {@code model_id}
		 */
		public final Builder modelId(String value) {
			this.modelId = value;
			return this;
		}

		/**
		 * Field added to incoming documents to contain results objects.
		 * <p>
		 * API name: {@code target_field}
		 */
		public final Builder targetField(@Nullable String value) {
			this.targetField = value;
			return this;
		}

		/**
		 * Maps the document field names to the known field names of the model. This
		 * mapping takes precedence over any default mappings provided in the model
		 * configuration.
		 * <p>
		 * API name: {@code field_map}
		 * <p>
		 * Adds all entries of <code>map</code> to <code>fieldMap</code>.
		 */
		public final Builder fieldMap(Map<String, JsonData> map) {
			this.fieldMap = _mapPutAll(this.fieldMap, map);
			return this;
		}

		/**
		 * Maps the document field names to the known field names of the model. This
		 * mapping takes precedence over any default mappings provided in the model
		 * configuration.
		 * <p>
		 * API name: {@code field_map}
		 * <p>
		 * Adds an entry to <code>fieldMap</code>.
		 */
		public final Builder fieldMap(String key, JsonData value) {
			this.fieldMap = _mapPut(this.fieldMap, key, value);
			return this;
		}

		/**
		 * Contains the inference type and its options.
		 * <p>
		 * API name: {@code inference_config}
		 */
		public final Builder inferenceConfig(@Nullable InferenceConfig value) {
			this.inferenceConfig = value;
			return this;
		}

		/**
		 * Contains the inference type and its options.
		 * <p>
		 * API name: {@code inference_config}
		 */
		public final Builder inferenceConfig(Function<InferenceConfig.Builder, ObjectBuilder<InferenceConfig>> fn) {
			return this.inferenceConfig(fn.apply(new InferenceConfig.Builder()).build());
		}

		/**
		 * Contains the inference type and its options.
		 * <p>
		 * API name: {@code inference_config}
		 */
		public final Builder inferenceConfig(InferenceConfigVariant value) {
			this.inferenceConfig = value._toInferenceConfig();
			return this;
		}

		/**
		 * Input fields for inference and output (destination) fields for the inference
		 * results. This option is incompatible with the target_field and field_map
		 * options.
		 * <p>
		 * API name: {@code input_output}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>inputOutput</code>.
		 */
		public final Builder inputOutput(List<InputConfig> list) {
			this.inputOutput = _listAddAll(this.inputOutput, list);
			return this;
		}

		/**
		 * Input fields for inference and output (destination) fields for the inference
		 * results. This option is incompatible with the target_field and field_map
		 * options.
		 * <p>
		 * API name: {@code input_output}
		 * <p>
		 * Adds one or more values to <code>inputOutput</code>.
		 */
		public final Builder inputOutput(InputConfig value, InputConfig... values) {
			this.inputOutput = _listAdd(this.inputOutput, value, values);
			return this;
		}

		/**
		 * Input fields for inference and output (destination) fields for the inference
		 * results. This option is incompatible with the target_field and field_map
		 * options.
		 * <p>
		 * API name: {@code input_output}
		 * <p>
		 * Adds a value to <code>inputOutput</code> using a builder lambda.
		 */
		public final Builder inputOutput(Function<InputConfig.Builder, ObjectBuilder<InputConfig>> fn) {
			return inputOutput(fn.apply(new InputConfig.Builder()).build());
		}

		/**
		 * If true and any of the input fields defined in input_ouput are missing then
		 * those missing fields are quietly ignored, otherwise a missing field causes a
		 * failure. Only applies when using input_output configurations to explicitly
		 * list the input fields.
		 * <p>
		 * API name: {@code ignore_missing}
		 */
		public final Builder ignoreMissing(@Nullable Boolean value) {
			this.ignoreMissing = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link InferenceProcessor}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public InferenceProcessor build() {
			_checkSingleUse();

			return new InferenceProcessor(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link InferenceProcessor}
	 */
	public static final JsonpDeserializer<InferenceProcessor> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, InferenceProcessor::setupInferenceProcessorDeserializer);

	protected static void setupInferenceProcessorDeserializer(ObjectDeserializer<InferenceProcessor.Builder> op) {
		ProcessorBase.setupProcessorBaseDeserializer(op);
		op.add(Builder::modelId, JsonpDeserializer.stringDeserializer(), "model_id");
		op.add(Builder::targetField, JsonpDeserializer.stringDeserializer(), "target_field");
		op.add(Builder::fieldMap, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "field_map");
		op.add(Builder::inferenceConfig, InferenceConfig._DESERIALIZER, "inference_config");
		op.add(Builder::inputOutput, JsonpDeserializer.arrayDeserializer(InputConfig._DESERIALIZER), "input_output");
		op.add(Builder::ignoreMissing, JsonpDeserializer.booleanDeserializer(), "ignore_missing");

	}

}
