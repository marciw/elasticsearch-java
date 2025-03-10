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

package co.elastic.clients.elasticsearch.core.reindex;

import co.elastic.clients.elasticsearch._types.OpType;
import co.elastic.clients.elasticsearch._types.VersionType;
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

// typedef: _global.reindex.Destination

/**
 *
 * @see <a href="../../doc-files/api-spec.html#_global.reindex.Destination">API
 *      specification</a>
 */
@JsonpDeserializable
public class Destination implements JsonpSerializable {
	private final String index;

	@Nullable
	private final OpType opType;

	@Nullable
	private final String pipeline;

	@Nullable
	private final String routing;

	@Nullable
	private final VersionType versionType;

	// ---------------------------------------------------------------------------------------------

	private Destination(Builder builder) {

		this.index = ApiTypeHelper.requireNonNull(builder.index, this, "index");
		this.opType = builder.opType;
		this.pipeline = builder.pipeline;
		this.routing = builder.routing;
		this.versionType = builder.versionType;

	}

	public static Destination of(Function<Builder, ObjectBuilder<Destination>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - The name of the data stream, index, or index alias you are copying
	 * to.
	 * <p>
	 * API name: {@code index}
	 */
	public final String index() {
		return this.index;
	}

	/**
	 * If it is <code>create</code>, the operation will only index documents that do
	 * not already exist (also known as &quot;put if absent&quot;).
	 * <p>
	 * IMPORTANT: To reindex to a data stream destination, this argument must be
	 * <code>create</code>.
	 * <p>
	 * API name: {@code op_type}
	 */
	@Nullable
	public final OpType opType() {
		return this.opType;
	}

	/**
	 * The name of the pipeline to use.
	 * <p>
	 * API name: {@code pipeline}
	 */
	@Nullable
	public final String pipeline() {
		return this.pipeline;
	}

	/**
	 * By default, a document's routing is preserved unless it's changed by the
	 * script. If it is <code>keep</code>, the routing on the bulk request sent for
	 * each match is set to the routing on the match. If it is <code>discard</code>,
	 * the routing on the bulk request sent for each match is set to
	 * <code>null</code>. If it is <code>=value</code>, the routing on the bulk
	 * request sent for each match is set to all value specified after the equals
	 * sign (<code>=</code>).
	 * <p>
	 * API name: {@code routing}
	 */
	@Nullable
	public final String routing() {
		return this.routing;
	}

	/**
	 * The versioning to use for the indexing operation.
	 * <p>
	 * API name: {@code version_type}
	 */
	@Nullable
	public final VersionType versionType() {
		return this.versionType;
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

		generator.writeKey("index");
		generator.write(this.index);

		if (this.opType != null) {
			generator.writeKey("op_type");
			this.opType.serialize(generator, mapper);
		}
		if (this.pipeline != null) {
			generator.writeKey("pipeline");
			generator.write(this.pipeline);

		}
		if (this.routing != null) {
			generator.writeKey("routing");
			generator.write(this.routing);

		}
		if (this.versionType != null) {
			generator.writeKey("version_type");
			this.versionType.serialize(generator, mapper);
		}

	}

	@Override
	public String toString() {
		return JsonpUtils.toString(this);
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link Destination}.
	 */

	public static class Builder extends WithJsonObjectBuilderBase<Builder> implements ObjectBuilder<Destination> {
		private String index;

		@Nullable
		private OpType opType;

		@Nullable
		private String pipeline;

		@Nullable
		private String routing;

		@Nullable
		private VersionType versionType;

		/**
		 * Required - The name of the data stream, index, or index alias you are copying
		 * to.
		 * <p>
		 * API name: {@code index}
		 */
		public final Builder index(String value) {
			this.index = value;
			return this;
		}

		/**
		 * If it is <code>create</code>, the operation will only index documents that do
		 * not already exist (also known as &quot;put if absent&quot;).
		 * <p>
		 * IMPORTANT: To reindex to a data stream destination, this argument must be
		 * <code>create</code>.
		 * <p>
		 * API name: {@code op_type}
		 */
		public final Builder opType(@Nullable OpType value) {
			this.opType = value;
			return this;
		}

		/**
		 * The name of the pipeline to use.
		 * <p>
		 * API name: {@code pipeline}
		 */
		public final Builder pipeline(@Nullable String value) {
			this.pipeline = value;
			return this;
		}

		/**
		 * By default, a document's routing is preserved unless it's changed by the
		 * script. If it is <code>keep</code>, the routing on the bulk request sent for
		 * each match is set to the routing on the match. If it is <code>discard</code>,
		 * the routing on the bulk request sent for each match is set to
		 * <code>null</code>. If it is <code>=value</code>, the routing on the bulk
		 * request sent for each match is set to all value specified after the equals
		 * sign (<code>=</code>).
		 * <p>
		 * API name: {@code routing}
		 */
		public final Builder routing(@Nullable String value) {
			this.routing = value;
			return this;
		}

		/**
		 * The versioning to use for the indexing operation.
		 * <p>
		 * API name: {@code version_type}
		 */
		public final Builder versionType(@Nullable VersionType value) {
			this.versionType = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link Destination}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public Destination build() {
			_checkSingleUse();

			return new Destination(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link Destination}
	 */
	public static final JsonpDeserializer<Destination> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			Destination::setupDestinationDeserializer);

	protected static void setupDestinationDeserializer(ObjectDeserializer<Destination.Builder> op) {

		op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
		op.add(Builder::opType, OpType._DESERIALIZER, "op_type");
		op.add(Builder::pipeline, JsonpDeserializer.stringDeserializer(), "pipeline");
		op.add(Builder::routing, JsonpDeserializer.stringDeserializer(), "routing");
		op.add(Builder::versionType, VersionType._DESERIALIZER, "version_type");

	}

}
