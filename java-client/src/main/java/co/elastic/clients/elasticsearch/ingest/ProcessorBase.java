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

import co.elastic.clients.elasticsearch._types.Script;
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
import java.lang.Boolean;
import java.lang.String;
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

// typedef: ingest._types.ProcessorBase

/**
 *
 * @see <a href="../doc-files/api-spec.html#ingest._types.ProcessorBase">API
 *      specification</a>
 */

public abstract class ProcessorBase implements JsonpSerializable {
	@Nullable
	private final String description;

	@Nullable
	private final Script if_;

	@Nullable
	private final Boolean ignoreFailure;

	private final List<Processor> onFailure;

	@Nullable
	private final String tag;

	// ---------------------------------------------------------------------------------------------

	protected ProcessorBase(AbstractBuilder<?> builder) {

		this.description = builder.description;
		this.if_ = builder.if_;
		this.ignoreFailure = builder.ignoreFailure;
		this.onFailure = ApiTypeHelper.unmodifiable(builder.onFailure);
		this.tag = builder.tag;

	}

	/**
	 * Description of the processor. Useful for describing the purpose of the
	 * processor or its configuration.
	 * <p>
	 * API name: {@code description}
	 */
	@Nullable
	public final String description() {
		return this.description;
	}

	/**
	 * Conditionally execute the processor.
	 * <p>
	 * API name: {@code if}
	 */
	@Nullable
	public final Script if_() {
		return this.if_;
	}

	/**
	 * Ignore failures for the processor.
	 * <p>
	 * API name: {@code ignore_failure}
	 */
	@Nullable
	public final Boolean ignoreFailure() {
		return this.ignoreFailure;
	}

	/**
	 * Handle failures for the processor.
	 * <p>
	 * API name: {@code on_failure}
	 */
	public final List<Processor> onFailure() {
		return this.onFailure;
	}

	/**
	 * Identifier for the processor. Useful for debugging and metrics.
	 * <p>
	 * API name: {@code tag}
	 */
	@Nullable
	public final String tag() {
		return this.tag;
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

		if (this.description != null) {
			generator.writeKey("description");
			generator.write(this.description);

		}
		if (this.if_ != null) {
			generator.writeKey("if");
			this.if_.serialize(generator, mapper);

		}
		if (this.ignoreFailure != null) {
			generator.writeKey("ignore_failure");
			generator.write(this.ignoreFailure);

		}
		if (ApiTypeHelper.isDefined(this.onFailure)) {
			generator.writeKey("on_failure");
			generator.writeStartArray();
			for (Processor item0 : this.onFailure) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}
		if (this.tag != null) {
			generator.writeKey("tag");
			generator.write(this.tag);

		}

	}

	@Override
	public String toString() {
		return JsonpUtils.toString(this);
	}

	public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>>
			extends
				WithJsonObjectBuilderBase<BuilderT> {
		@Nullable
		private String description;

		@Nullable
		private Script if_;

		@Nullable
		private Boolean ignoreFailure;

		@Nullable
		private List<Processor> onFailure;

		@Nullable
		private String tag;

		/**
		 * Description of the processor. Useful for describing the purpose of the
		 * processor or its configuration.
		 * <p>
		 * API name: {@code description}
		 */
		public final BuilderT description(@Nullable String value) {
			this.description = value;
			return self();
		}

		/**
		 * Conditionally execute the processor.
		 * <p>
		 * API name: {@code if}
		 */
		public final BuilderT if_(@Nullable Script value) {
			this.if_ = value;
			return self();
		}

		/**
		 * Conditionally execute the processor.
		 * <p>
		 * API name: {@code if}
		 */
		public final BuilderT if_(Function<Script.Builder, ObjectBuilder<Script>> fn) {
			return this.if_(fn.apply(new Script.Builder()).build());
		}

		/**
		 * Ignore failures for the processor.
		 * <p>
		 * API name: {@code ignore_failure}
		 */
		public final BuilderT ignoreFailure(@Nullable Boolean value) {
			this.ignoreFailure = value;
			return self();
		}

		/**
		 * Handle failures for the processor.
		 * <p>
		 * API name: {@code on_failure}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>onFailure</code>.
		 */
		public final BuilderT onFailure(List<Processor> list) {
			this.onFailure = _listAddAll(this.onFailure, list);
			return self();
		}

		/**
		 * Handle failures for the processor.
		 * <p>
		 * API name: {@code on_failure}
		 * <p>
		 * Adds one or more values to <code>onFailure</code>.
		 */
		public final BuilderT onFailure(Processor value, Processor... values) {
			this.onFailure = _listAdd(this.onFailure, value, values);
			return self();
		}

		/**
		 * Handle failures for the processor.
		 * <p>
		 * API name: {@code on_failure}
		 * <p>
		 * Adds one or more values to <code>onFailure</code>.
		 */
		public final BuilderT onFailure(ProcessorVariant value, ProcessorVariant... values) {
			this.onFailure = _listAdd(this.onFailure, value._toProcessor());
			for (ProcessorVariant v : values) {
				_listAdd(this.onFailure, v._toProcessor());
			}
			return self();
		}

		/**
		 * Handle failures for the processor.
		 * <p>
		 * API name: {@code on_failure}
		 * <p>
		 * Adds a value to <code>onFailure</code> using a builder lambda.
		 */
		public final BuilderT onFailure(Function<Processor.Builder, ObjectBuilder<Processor>> fn) {
			return onFailure(fn.apply(new Processor.Builder()).build());
		}

		/**
		 * Identifier for the processor. Useful for debugging and metrics.
		 * <p>
		 * API name: {@code tag}
		 */
		public final BuilderT tag(@Nullable String value) {
			this.tag = value;
			return self();
		}

		protected abstract BuilderT self();

	}

	// ---------------------------------------------------------------------------------------------
	protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupProcessorBaseDeserializer(
			ObjectDeserializer<BuilderT> op) {

		op.add(AbstractBuilder::description, JsonpDeserializer.stringDeserializer(), "description");
		op.add(AbstractBuilder::if_, Script._DESERIALIZER, "if");
		op.add(AbstractBuilder::ignoreFailure, JsonpDeserializer.booleanDeserializer(), "ignore_failure");
		op.add(AbstractBuilder::onFailure, JsonpDeserializer.arrayDeserializer(Processor._DESERIALIZER), "on_failure");
		op.add(AbstractBuilder::tag, JsonpDeserializer.stringDeserializer(), "tag");

	}

}
