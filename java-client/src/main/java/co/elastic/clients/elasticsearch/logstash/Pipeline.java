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

package co.elastic.clients.elasticsearch.logstash;

import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpSerializable;
import co.elastic.clients.json.JsonpUtils;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.util.ApiTypeHelper;
import co.elastic.clients.util.DateTime;
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

// typedef: logstash._types.Pipeline

/**
 *
 * @see <a href="../doc-files/api-spec.html#logstash._types.Pipeline">API
 *      specification</a>
 */
@JsonpDeserializable
public class Pipeline implements JsonpSerializable {
	private final String description;

	private final DateTime lastModified;

	private final String pipeline;

	private final PipelineMetadata pipelineMetadata;

	private final PipelineSettings pipelineSettings;

	private final String username;

	// ---------------------------------------------------------------------------------------------

	private Pipeline(Builder builder) {

		this.description = ApiTypeHelper.requireNonNull(builder.description, this, "description");
		this.lastModified = ApiTypeHelper.requireNonNull(builder.lastModified, this, "lastModified");
		this.pipeline = ApiTypeHelper.requireNonNull(builder.pipeline, this, "pipeline");
		this.pipelineMetadata = ApiTypeHelper.requireNonNull(builder.pipelineMetadata, this, "pipelineMetadata");
		this.pipelineSettings = ApiTypeHelper.requireNonNull(builder.pipelineSettings, this, "pipelineSettings");
		this.username = ApiTypeHelper.requireNonNull(builder.username, this, "username");

	}

	public static Pipeline of(Function<Builder, ObjectBuilder<Pipeline>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - A description of the pipeline. This description is not used by
	 * Elasticsearch or Logstash.
	 * <p>
	 * API name: {@code description}
	 */
	public final String description() {
		return this.description;
	}

	/**
	 * Required - The date the pipeline was last updated. It must be in the
	 * <code>yyyy-MM-dd'T'HH:mm:ss.SSSZZ</code> strict_date_time format.
	 * <p>
	 * API name: {@code last_modified}
	 */
	public final DateTime lastModified() {
		return this.lastModified;
	}

	/**
	 * Required - The configuration for the pipeline.
	 * <p>
	 * API name: {@code pipeline}
	 */
	public final String pipeline() {
		return this.pipeline;
	}

	/**
	 * Required - Optional metadata about the pipeline, which can have any contents.
	 * This metadata is not generated or used by Elasticsearch or Logstash.
	 * <p>
	 * API name: {@code pipeline_metadata}
	 */
	public final PipelineMetadata pipelineMetadata() {
		return this.pipelineMetadata;
	}

	/**
	 * Required - Settings for the pipeline. It supports only flat keys in dot
	 * notation.
	 * <p>
	 * API name: {@code pipeline_settings}
	 */
	public final PipelineSettings pipelineSettings() {
		return this.pipelineSettings;
	}

	/**
	 * Required - The user who last updated the pipeline.
	 * <p>
	 * API name: {@code username}
	 */
	public final String username() {
		return this.username;
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

		generator.writeKey("description");
		generator.write(this.description);

		generator.writeKey("last_modified");
		this.lastModified.serialize(generator, mapper);
		generator.writeKey("pipeline");
		generator.write(this.pipeline);

		generator.writeKey("pipeline_metadata");
		this.pipelineMetadata.serialize(generator, mapper);

		generator.writeKey("pipeline_settings");
		this.pipelineSettings.serialize(generator, mapper);

		generator.writeKey("username");
		generator.write(this.username);

	}

	@Override
	public String toString() {
		return JsonpUtils.toString(this);
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link Pipeline}.
	 */

	public static class Builder extends WithJsonObjectBuilderBase<Builder> implements ObjectBuilder<Pipeline> {
		private String description;

		private DateTime lastModified;

		private String pipeline;

		private PipelineMetadata pipelineMetadata;

		private PipelineSettings pipelineSettings;

		private String username;

		/**
		 * Required - A description of the pipeline. This description is not used by
		 * Elasticsearch or Logstash.
		 * <p>
		 * API name: {@code description}
		 */
		public final Builder description(String value) {
			this.description = value;
			return this;
		}

		/**
		 * Required - The date the pipeline was last updated. It must be in the
		 * <code>yyyy-MM-dd'T'HH:mm:ss.SSSZZ</code> strict_date_time format.
		 * <p>
		 * API name: {@code last_modified}
		 */
		public final Builder lastModified(DateTime value) {
			this.lastModified = value;
			return this;
		}

		/**
		 * Required - The configuration for the pipeline.
		 * <p>
		 * API name: {@code pipeline}
		 */
		public final Builder pipeline(String value) {
			this.pipeline = value;
			return this;
		}

		/**
		 * Required - Optional metadata about the pipeline, which can have any contents.
		 * This metadata is not generated or used by Elasticsearch or Logstash.
		 * <p>
		 * API name: {@code pipeline_metadata}
		 */
		public final Builder pipelineMetadata(PipelineMetadata value) {
			this.pipelineMetadata = value;
			return this;
		}

		/**
		 * Required - Optional metadata about the pipeline, which can have any contents.
		 * This metadata is not generated or used by Elasticsearch or Logstash.
		 * <p>
		 * API name: {@code pipeline_metadata}
		 */
		public final Builder pipelineMetadata(Function<PipelineMetadata.Builder, ObjectBuilder<PipelineMetadata>> fn) {
			return this.pipelineMetadata(fn.apply(new PipelineMetadata.Builder()).build());
		}

		/**
		 * Required - Settings for the pipeline. It supports only flat keys in dot
		 * notation.
		 * <p>
		 * API name: {@code pipeline_settings}
		 */
		public final Builder pipelineSettings(PipelineSettings value) {
			this.pipelineSettings = value;
			return this;
		}

		/**
		 * Required - Settings for the pipeline. It supports only flat keys in dot
		 * notation.
		 * <p>
		 * API name: {@code pipeline_settings}
		 */
		public final Builder pipelineSettings(Function<PipelineSettings.Builder, ObjectBuilder<PipelineSettings>> fn) {
			return this.pipelineSettings(fn.apply(new PipelineSettings.Builder()).build());
		}

		/**
		 * Required - The user who last updated the pipeline.
		 * <p>
		 * API name: {@code username}
		 */
		public final Builder username(String value) {
			this.username = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link Pipeline}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public Pipeline build() {
			_checkSingleUse();

			return new Pipeline(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link Pipeline}
	 */
	public static final JsonpDeserializer<Pipeline> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			Pipeline::setupPipelineDeserializer);

	protected static void setupPipelineDeserializer(ObjectDeserializer<Pipeline.Builder> op) {

		op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
		op.add(Builder::lastModified, DateTime._DESERIALIZER, "last_modified");
		op.add(Builder::pipeline, JsonpDeserializer.stringDeserializer(), "pipeline");
		op.add(Builder::pipelineMetadata, PipelineMetadata._DESERIALIZER, "pipeline_metadata");
		op.add(Builder::pipelineSettings, PipelineSettings._DESERIALIZER, "pipeline_settings");
		op.add(Builder::username, JsonpDeserializer.stringDeserializer(), "username");

	}

}
