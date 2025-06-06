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

package co.elastic.clients.elasticsearch.core;

import co.elastic.clients.elasticsearch._types.ErrorResponse;
import co.elastic.clients.elasticsearch._types.RequestBase;
import co.elastic.clients.elasticsearch._types.ScriptSource;
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
import java.util.Collections;
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

// typedef: _global.render_search_template.Request

/**
 * Render a search template.
 * <p>
 * Render a search template as a search request body.
 * 
 * @see <a href=
 *      "../doc-files/api-spec.html#_global.render_search_template.Request">API
 *      specification</a>
 */
@JsonpDeserializable
public class RenderSearchTemplateRequest extends RequestBase implements JsonpSerializable {
	@Nullable
	private final String file;

	@Nullable
	private final String id;

	private final Map<String, JsonData> params;

	@Nullable
	private final ScriptSource source;

	// ---------------------------------------------------------------------------------------------

	private RenderSearchTemplateRequest(Builder builder) {

		this.file = builder.file;
		this.id = builder.id;
		this.params = ApiTypeHelper.unmodifiable(builder.params);
		this.source = builder.source;

	}

	public static RenderSearchTemplateRequest of(Function<Builder, ObjectBuilder<RenderSearchTemplateRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * API name: {@code file}
	 */
	@Nullable
	public final String file() {
		return this.file;
	}

	/**
	 * The ID of the search template to render. If no <code>source</code> is
	 * specified, this or the <code>&lt;template-id&gt;</code> request path
	 * parameter is required. If you specify both this parameter and the
	 * <code>&lt;template-id&gt;</code> parameter, the API uses only
	 * <code>&lt;template-id&gt;</code>.
	 * <p>
	 * API name: {@code id}
	 */
	@Nullable
	public final String id() {
		return this.id;
	}

	/**
	 * Key-value pairs used to replace Mustache variables in the template. The key
	 * is the variable name. The value is the variable value.
	 * <p>
	 * API name: {@code params}
	 */
	public final Map<String, JsonData> params() {
		return this.params;
	}

	/**
	 * An inline search template. It supports the same parameters as the search
	 * API's request body. These parameters also support Mustache variables. If no
	 * <code>id</code> or <code>&lt;templated-id&gt;</code> is specified, this
	 * parameter is required.
	 * <p>
	 * API name: {@code source}
	 */
	@Nullable
	public final ScriptSource source() {
		return this.source;
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

		if (this.file != null) {
			generator.writeKey("file");
			generator.write(this.file);

		}
		if (this.id != null) {
			generator.writeKey("id");
			generator.write(this.id);

		}
		if (ApiTypeHelper.isDefined(this.params)) {
			generator.writeKey("params");
			generator.writeStartObject();
			for (Map.Entry<String, JsonData> item0 : this.params.entrySet()) {
				generator.writeKey(item0.getKey());
				item0.getValue().serialize(generator, mapper);

			}
			generator.writeEnd();

		}
		if (this.source != null) {
			generator.writeKey("source");
			this.source.serialize(generator, mapper);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link RenderSearchTemplateRequest}.
	 */

	public static class Builder extends RequestBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<RenderSearchTemplateRequest> {
		@Nullable
		private String file;

		@Nullable
		private String id;

		@Nullable
		private Map<String, JsonData> params;

		@Nullable
		private ScriptSource source;

		/**
		 * API name: {@code file}
		 */
		public final Builder file(@Nullable String value) {
			this.file = value;
			return this;
		}

		/**
		 * The ID of the search template to render. If no <code>source</code> is
		 * specified, this or the <code>&lt;template-id&gt;</code> request path
		 * parameter is required. If you specify both this parameter and the
		 * <code>&lt;template-id&gt;</code> parameter, the API uses only
		 * <code>&lt;template-id&gt;</code>.
		 * <p>
		 * API name: {@code id}
		 */
		public final Builder id(@Nullable String value) {
			this.id = value;
			return this;
		}

		/**
		 * Key-value pairs used to replace Mustache variables in the template. The key
		 * is the variable name. The value is the variable value.
		 * <p>
		 * API name: {@code params}
		 * <p>
		 * Adds all entries of <code>map</code> to <code>params</code>.
		 */
		public final Builder params(Map<String, JsonData> map) {
			this.params = _mapPutAll(this.params, map);
			return this;
		}

		/**
		 * Key-value pairs used to replace Mustache variables in the template. The key
		 * is the variable name. The value is the variable value.
		 * <p>
		 * API name: {@code params}
		 * <p>
		 * Adds an entry to <code>params</code>.
		 */
		public final Builder params(String key, JsonData value) {
			this.params = _mapPut(this.params, key, value);
			return this;
		}

		/**
		 * An inline search template. It supports the same parameters as the search
		 * API's request body. These parameters also support Mustache variables. If no
		 * <code>id</code> or <code>&lt;templated-id&gt;</code> is specified, this
		 * parameter is required.
		 * <p>
		 * API name: {@code source}
		 */
		public final Builder source(@Nullable ScriptSource value) {
			this.source = value;
			return this;
		}

		/**
		 * An inline search template. It supports the same parameters as the search
		 * API's request body. These parameters also support Mustache variables. If no
		 * <code>id</code> or <code>&lt;templated-id&gt;</code> is specified, this
		 * parameter is required.
		 * <p>
		 * API name: {@code source}
		 */
		public final Builder source(Function<ScriptSource.Builder, ObjectBuilder<ScriptSource>> fn) {
			return this.source(fn.apply(new ScriptSource.Builder()).build());
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link RenderSearchTemplateRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public RenderSearchTemplateRequest build() {
			_checkSingleUse();

			return new RenderSearchTemplateRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link RenderSearchTemplateRequest}
	 */
	public static final JsonpDeserializer<RenderSearchTemplateRequest> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, RenderSearchTemplateRequest::setupRenderSearchTemplateRequestDeserializer);

	protected static void setupRenderSearchTemplateRequestDeserializer(
			ObjectDeserializer<RenderSearchTemplateRequest.Builder> op) {

		op.add(Builder::file, JsonpDeserializer.stringDeserializer(), "file");
		op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
		op.add(Builder::params, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "params");
		op.add(Builder::source, ScriptSource._DESERIALIZER, "source");

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code render_search_template}".
	 */
	public static final Endpoint<RenderSearchTemplateRequest, RenderSearchTemplateResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
			"es/render_search_template",

			// Request method
			request -> {
				return "POST";

			},

			// Request path
			request -> {
				return "/_render/template";

			},

			// Path parameters
			request -> {
				return Collections.emptyMap();
			},

			// Request parameters
			request -> {
				return Collections.emptyMap();

			}, SimpleEndpoint.emptyMap(), true, RenderSearchTemplateResponse._DESERIALIZER);
}
