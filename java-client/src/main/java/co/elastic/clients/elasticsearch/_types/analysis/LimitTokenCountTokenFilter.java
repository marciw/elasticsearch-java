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

package co.elastic.clients.elasticsearch._types.analysis;

import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.Boolean;
import java.lang.Integer;
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

// typedef: _types.analysis.LimitTokenCountTokenFilter

/**
 *
 * @see <a href=
 *      "../../doc-files/api-spec.html#_types.analysis.LimitTokenCountTokenFilter">API
 *      specification</a>
 */
@JsonpDeserializable
public class LimitTokenCountTokenFilter extends TokenFilterBase implements TokenFilterDefinitionVariant {
	@Nullable
	private final Boolean consumeAllTokens;

	@Nullable
	private final Integer maxTokenCount;

	// ---------------------------------------------------------------------------------------------

	private LimitTokenCountTokenFilter(Builder builder) {
		super(builder);

		this.consumeAllTokens = builder.consumeAllTokens;
		this.maxTokenCount = builder.maxTokenCount;

	}

	public static LimitTokenCountTokenFilter of(Function<Builder, ObjectBuilder<LimitTokenCountTokenFilter>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * TokenFilterDefinition variant kind.
	 */
	@Override
	public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
		return TokenFilterDefinition.Kind.Limit;
	}

	/**
	 * If <code>true</code>, the limit filter exhausts the token stream, even if the
	 * <code>max_token_count</code> has already been reached. Defaults to
	 * <code>false</code>.
	 * <p>
	 * API name: {@code consume_all_tokens}
	 */
	@Nullable
	public final Boolean consumeAllTokens() {
		return this.consumeAllTokens;
	}

	/**
	 * Maximum number of tokens to keep. Once this limit is reached, any remaining
	 * tokens are excluded from the output. Defaults to <code>1</code>.
	 * <p>
	 * API name: {@code max_token_count}
	 */
	@Nullable
	public final Integer maxTokenCount() {
		return this.maxTokenCount;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.write("type", "limit");
		super.serializeInternal(generator, mapper);
		if (this.consumeAllTokens != null) {
			generator.writeKey("consume_all_tokens");
			generator.write(this.consumeAllTokens);

		}
		if (this.maxTokenCount != null) {
			generator.writeKey("max_token_count");
			generator.write(this.maxTokenCount);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link LimitTokenCountTokenFilter}.
	 */

	public static class Builder extends TokenFilterBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<LimitTokenCountTokenFilter> {
		@Nullable
		private Boolean consumeAllTokens;

		@Nullable
		private Integer maxTokenCount;

		/**
		 * If <code>true</code>, the limit filter exhausts the token stream, even if the
		 * <code>max_token_count</code> has already been reached. Defaults to
		 * <code>false</code>.
		 * <p>
		 * API name: {@code consume_all_tokens}
		 */
		public final Builder consumeAllTokens(@Nullable Boolean value) {
			this.consumeAllTokens = value;
			return this;
		}

		/**
		 * Maximum number of tokens to keep. Once this limit is reached, any remaining
		 * tokens are excluded from the output. Defaults to <code>1</code>.
		 * <p>
		 * API name: {@code max_token_count}
		 */
		public final Builder maxTokenCount(@Nullable Integer value) {
			this.maxTokenCount = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link LimitTokenCountTokenFilter}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public LimitTokenCountTokenFilter build() {
			_checkSingleUse();

			return new LimitTokenCountTokenFilter(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link LimitTokenCountTokenFilter}
	 */
	public static final JsonpDeserializer<LimitTokenCountTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, LimitTokenCountTokenFilter::setupLimitTokenCountTokenFilterDeserializer);

	protected static void setupLimitTokenCountTokenFilterDeserializer(
			ObjectDeserializer<LimitTokenCountTokenFilter.Builder> op) {
		TokenFilterBase.setupTokenFilterBaseDeserializer(op);
		op.add(Builder::consumeAllTokens, JsonpDeserializer.booleanDeserializer(), "consume_all_tokens");
		op.add(Builder::maxTokenCount, JsonpDeserializer.integerDeserializer(), "max_token_count");

		op.ignore("type");
	}

}
