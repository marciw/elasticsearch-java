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
import co.elastic.clients.util.ApiTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
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

// typedef: _types.analysis.KeepWordsTokenFilter

/**
 *
 * @see <a href=
 *      "../../doc-files/api-spec.html#_types.analysis.KeepWordsTokenFilter">API
 *      specification</a>
 */
@JsonpDeserializable
public class KeepWordsTokenFilter extends TokenFilterBase implements TokenFilterDefinitionVariant {
	private final List<String> keepWords;

	@Nullable
	private final Boolean keepWordsCase;

	@Nullable
	private final String keepWordsPath;

	// ---------------------------------------------------------------------------------------------

	private KeepWordsTokenFilter(Builder builder) {
		super(builder);

		this.keepWords = ApiTypeHelper.unmodifiable(builder.keepWords);
		this.keepWordsCase = builder.keepWordsCase;
		this.keepWordsPath = builder.keepWordsPath;

	}

	public static KeepWordsTokenFilter of(Function<Builder, ObjectBuilder<KeepWordsTokenFilter>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * TokenFilterDefinition variant kind.
	 */
	@Override
	public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
		return TokenFilterDefinition.Kind.Keep;
	}

	/**
	 * List of words to keep. Only tokens that match words in this list are included
	 * in the output. Either this parameter or <code>keep_words_path</code> must be
	 * specified.
	 * <p>
	 * API name: {@code keep_words}
	 */
	public final List<String> keepWords() {
		return this.keepWords;
	}

	/**
	 * If <code>true</code>, lowercase all keep words. Defaults to
	 * <code>false</code>.
	 * <p>
	 * API name: {@code keep_words_case}
	 */
	@Nullable
	public final Boolean keepWordsCase() {
		return this.keepWordsCase;
	}

	/**
	 * Path to a file that contains a list of words to keep. Only tokens that match
	 * words in this list are included in the output. This path must be absolute or
	 * relative to the <code>config</code> location, and the file must be UTF-8
	 * encoded. Each word in the file must be separated by a line break. Either this
	 * parameter or <code>keep_words</code> must be specified.
	 * <p>
	 * API name: {@code keep_words_path}
	 */
	@Nullable
	public final String keepWordsPath() {
		return this.keepWordsPath;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.write("type", "keep");
		super.serializeInternal(generator, mapper);
		if (ApiTypeHelper.isDefined(this.keepWords)) {
			generator.writeKey("keep_words");
			generator.writeStartArray();
			for (String item0 : this.keepWords) {
				generator.write(item0);

			}
			generator.writeEnd();

		}
		if (this.keepWordsCase != null) {
			generator.writeKey("keep_words_case");
			generator.write(this.keepWordsCase);

		}
		if (this.keepWordsPath != null) {
			generator.writeKey("keep_words_path");
			generator.write(this.keepWordsPath);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link KeepWordsTokenFilter}.
	 */

	public static class Builder extends TokenFilterBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<KeepWordsTokenFilter> {
		@Nullable
		private List<String> keepWords;

		@Nullable
		private Boolean keepWordsCase;

		@Nullable
		private String keepWordsPath;

		/**
		 * List of words to keep. Only tokens that match words in this list are included
		 * in the output. Either this parameter or <code>keep_words_path</code> must be
		 * specified.
		 * <p>
		 * API name: {@code keep_words}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>keepWords</code>.
		 */
		public final Builder keepWords(List<String> list) {
			this.keepWords = _listAddAll(this.keepWords, list);
			return this;
		}

		/**
		 * List of words to keep. Only tokens that match words in this list are included
		 * in the output. Either this parameter or <code>keep_words_path</code> must be
		 * specified.
		 * <p>
		 * API name: {@code keep_words}
		 * <p>
		 * Adds one or more values to <code>keepWords</code>.
		 */
		public final Builder keepWords(String value, String... values) {
			this.keepWords = _listAdd(this.keepWords, value, values);
			return this;
		}

		/**
		 * If <code>true</code>, lowercase all keep words. Defaults to
		 * <code>false</code>.
		 * <p>
		 * API name: {@code keep_words_case}
		 */
		public final Builder keepWordsCase(@Nullable Boolean value) {
			this.keepWordsCase = value;
			return this;
		}

		/**
		 * Path to a file that contains a list of words to keep. Only tokens that match
		 * words in this list are included in the output. This path must be absolute or
		 * relative to the <code>config</code> location, and the file must be UTF-8
		 * encoded. Each word in the file must be separated by a line break. Either this
		 * parameter or <code>keep_words</code> must be specified.
		 * <p>
		 * API name: {@code keep_words_path}
		 */
		public final Builder keepWordsPath(@Nullable String value) {
			this.keepWordsPath = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link KeepWordsTokenFilter}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public KeepWordsTokenFilter build() {
			_checkSingleUse();

			return new KeepWordsTokenFilter(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link KeepWordsTokenFilter}
	 */
	public static final JsonpDeserializer<KeepWordsTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, KeepWordsTokenFilter::setupKeepWordsTokenFilterDeserializer);

	protected static void setupKeepWordsTokenFilterDeserializer(ObjectDeserializer<KeepWordsTokenFilter.Builder> op) {
		TokenFilterBase.setupTokenFilterBaseDeserializer(op);
		op.add(Builder::keepWords, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
				"keep_words");
		op.add(Builder::keepWordsCase, JsonpDeserializer.booleanDeserializer(), "keep_words_case");
		op.add(Builder::keepWordsPath, JsonpDeserializer.stringDeserializer(), "keep_words_path");

		op.ignore("type");
	}

}
