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

// typedef: _types.analysis.NGramTokenFilter

/**
 *
 * @see <a href=
 *      "../../doc-files/api-spec.html#_types.analysis.NGramTokenFilter">API
 *      specification</a>
 */
@JsonpDeserializable
public class NGramTokenFilter extends TokenFilterBase implements TokenFilterDefinitionVariant {
	@Nullable
	private final Integer maxGram;

	@Nullable
	private final Integer minGram;

	@Nullable
	private final Boolean preserveOriginal;

	// ---------------------------------------------------------------------------------------------

	private NGramTokenFilter(Builder builder) {
		super(builder);

		this.maxGram = builder.maxGram;
		this.minGram = builder.minGram;
		this.preserveOriginal = builder.preserveOriginal;

	}

	public static NGramTokenFilter of(Function<Builder, ObjectBuilder<NGramTokenFilter>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * TokenFilterDefinition variant kind.
	 */
	@Override
	public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
		return TokenFilterDefinition.Kind.Ngram;
	}

	/**
	 * Maximum length of characters in a gram. Defaults to <code>2</code>.
	 * <p>
	 * API name: {@code max_gram}
	 */
	@Nullable
	public final Integer maxGram() {
		return this.maxGram;
	}

	/**
	 * Minimum length of characters in a gram. Defaults to <code>1</code>.
	 * <p>
	 * API name: {@code min_gram}
	 */
	@Nullable
	public final Integer minGram() {
		return this.minGram;
	}

	/**
	 * Emits original token when set to <code>true</code>. Defaults to
	 * <code>false</code>.
	 * <p>
	 * API name: {@code preserve_original}
	 */
	@Nullable
	public final Boolean preserveOriginal() {
		return this.preserveOriginal;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.write("type", "ngram");
		super.serializeInternal(generator, mapper);
		if (this.maxGram != null) {
			generator.writeKey("max_gram");
			generator.write(this.maxGram);

		}
		if (this.minGram != null) {
			generator.writeKey("min_gram");
			generator.write(this.minGram);

		}
		if (this.preserveOriginal != null) {
			generator.writeKey("preserve_original");
			generator.write(this.preserveOriginal);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link NGramTokenFilter}.
	 */

	public static class Builder extends TokenFilterBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<NGramTokenFilter> {
		@Nullable
		private Integer maxGram;

		@Nullable
		private Integer minGram;

		@Nullable
		private Boolean preserveOriginal;

		/**
		 * Maximum length of characters in a gram. Defaults to <code>2</code>.
		 * <p>
		 * API name: {@code max_gram}
		 */
		public final Builder maxGram(@Nullable Integer value) {
			this.maxGram = value;
			return this;
		}

		/**
		 * Minimum length of characters in a gram. Defaults to <code>1</code>.
		 * <p>
		 * API name: {@code min_gram}
		 */
		public final Builder minGram(@Nullable Integer value) {
			this.minGram = value;
			return this;
		}

		/**
		 * Emits original token when set to <code>true</code>. Defaults to
		 * <code>false</code>.
		 * <p>
		 * API name: {@code preserve_original}
		 */
		public final Builder preserveOriginal(@Nullable Boolean value) {
			this.preserveOriginal = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link NGramTokenFilter}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public NGramTokenFilter build() {
			_checkSingleUse();

			return new NGramTokenFilter(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link NGramTokenFilter}
	 */
	public static final JsonpDeserializer<NGramTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			NGramTokenFilter::setupNGramTokenFilterDeserializer);

	protected static void setupNGramTokenFilterDeserializer(ObjectDeserializer<NGramTokenFilter.Builder> op) {
		TokenFilterBase.setupTokenFilterBaseDeserializer(op);
		op.add(Builder::maxGram, JsonpDeserializer.integerDeserializer(), "max_gram");
		op.add(Builder::minGram, JsonpDeserializer.integerDeserializer(), "min_gram");
		op.add(Builder::preserveOriginal, JsonpDeserializer.booleanDeserializer(), "preserve_original");

		op.ignore("type");
	}

}
