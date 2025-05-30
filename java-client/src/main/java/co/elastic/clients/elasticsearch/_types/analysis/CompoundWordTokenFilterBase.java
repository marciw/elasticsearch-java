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
import co.elastic.clients.util.WithJsonObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
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

// typedef: _types.analysis.CompoundWordTokenFilterBase

/**
 *
 * @see <a href=
 *      "../../doc-files/api-spec.html#_types.analysis.CompoundWordTokenFilterBase">API
 *      specification</a>
 */

public abstract class CompoundWordTokenFilterBase extends TokenFilterBase {
	@Nullable
	private final Integer maxSubwordSize;

	@Nullable
	private final Integer minSubwordSize;

	@Nullable
	private final Integer minWordSize;

	@Nullable
	private final Boolean onlyLongestMatch;

	private final List<String> wordList;

	@Nullable
	private final String wordListPath;

	// ---------------------------------------------------------------------------------------------

	protected CompoundWordTokenFilterBase(AbstractBuilder<?> builder) {
		super(builder);

		this.maxSubwordSize = builder.maxSubwordSize;
		this.minSubwordSize = builder.minSubwordSize;
		this.minWordSize = builder.minWordSize;
		this.onlyLongestMatch = builder.onlyLongestMatch;
		this.wordList = ApiTypeHelper.unmodifiable(builder.wordList);
		this.wordListPath = builder.wordListPath;

	}

	/**
	 * Maximum subword character length. Longer subword tokens are excluded from the
	 * output. Defaults to <code>15</code>.
	 * <p>
	 * API name: {@code max_subword_size}
	 */
	@Nullable
	public final Integer maxSubwordSize() {
		return this.maxSubwordSize;
	}

	/**
	 * Minimum subword character length. Shorter subword tokens are excluded from
	 * the output. Defaults to <code>2</code>.
	 * <p>
	 * API name: {@code min_subword_size}
	 */
	@Nullable
	public final Integer minSubwordSize() {
		return this.minSubwordSize;
	}

	/**
	 * Minimum word character length. Shorter word tokens are excluded from the
	 * output. Defaults to <code>5</code>.
	 * <p>
	 * API name: {@code min_word_size}
	 */
	@Nullable
	public final Integer minWordSize() {
		return this.minWordSize;
	}

	/**
	 * If <code>true</code>, only include the longest matching subword. Defaults to
	 * <code>false</code>.
	 * <p>
	 * API name: {@code only_longest_match}
	 */
	@Nullable
	public final Boolean onlyLongestMatch() {
		return this.onlyLongestMatch;
	}

	/**
	 * A list of subwords to look for in the token stream. If found, the subword is
	 * included in the token output. Either this parameter or
	 * <code>word_list_path</code> must be specified.
	 * <p>
	 * API name: {@code word_list}
	 */
	public final List<String> wordList() {
		return this.wordList;
	}

	/**
	 * Path to a file that contains a list of subwords to find in the token stream.
	 * If found, the subword is included in the token output. This path must be
	 * absolute or relative to the config location, and the file must be UTF-8
	 * encoded. Each token in the file must be separated by a line break. Either
	 * this parameter or <code>word_list</code> must be specified.
	 * <p>
	 * API name: {@code word_list_path}
	 */
	@Nullable
	public final String wordListPath() {
		return this.wordListPath;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		super.serializeInternal(generator, mapper);
		if (this.maxSubwordSize != null) {
			generator.writeKey("max_subword_size");
			generator.write(this.maxSubwordSize);

		}
		if (this.minSubwordSize != null) {
			generator.writeKey("min_subword_size");
			generator.write(this.minSubwordSize);

		}
		if (this.minWordSize != null) {
			generator.writeKey("min_word_size");
			generator.write(this.minWordSize);

		}
		if (this.onlyLongestMatch != null) {
			generator.writeKey("only_longest_match");
			generator.write(this.onlyLongestMatch);

		}
		if (ApiTypeHelper.isDefined(this.wordList)) {
			generator.writeKey("word_list");
			generator.writeStartArray();
			for (String item0 : this.wordList) {
				generator.write(item0);

			}
			generator.writeEnd();

		}
		if (this.wordListPath != null) {
			generator.writeKey("word_list_path");
			generator.write(this.wordListPath);

		}

	}

	public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>>
			extends
				TokenFilterBase.AbstractBuilder<BuilderT> {
		@Nullable
		private Integer maxSubwordSize;

		@Nullable
		private Integer minSubwordSize;

		@Nullable
		private Integer minWordSize;

		@Nullable
		private Boolean onlyLongestMatch;

		@Nullable
		private List<String> wordList;

		@Nullable
		private String wordListPath;

		/**
		 * Maximum subword character length. Longer subword tokens are excluded from the
		 * output. Defaults to <code>15</code>.
		 * <p>
		 * API name: {@code max_subword_size}
		 */
		public final BuilderT maxSubwordSize(@Nullable Integer value) {
			this.maxSubwordSize = value;
			return self();
		}

		/**
		 * Minimum subword character length. Shorter subword tokens are excluded from
		 * the output. Defaults to <code>2</code>.
		 * <p>
		 * API name: {@code min_subword_size}
		 */
		public final BuilderT minSubwordSize(@Nullable Integer value) {
			this.minSubwordSize = value;
			return self();
		}

		/**
		 * Minimum word character length. Shorter word tokens are excluded from the
		 * output. Defaults to <code>5</code>.
		 * <p>
		 * API name: {@code min_word_size}
		 */
		public final BuilderT minWordSize(@Nullable Integer value) {
			this.minWordSize = value;
			return self();
		}

		/**
		 * If <code>true</code>, only include the longest matching subword. Defaults to
		 * <code>false</code>.
		 * <p>
		 * API name: {@code only_longest_match}
		 */
		public final BuilderT onlyLongestMatch(@Nullable Boolean value) {
			this.onlyLongestMatch = value;
			return self();
		}

		/**
		 * A list of subwords to look for in the token stream. If found, the subword is
		 * included in the token output. Either this parameter or
		 * <code>word_list_path</code> must be specified.
		 * <p>
		 * API name: {@code word_list}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>wordList</code>.
		 */
		public final BuilderT wordList(List<String> list) {
			this.wordList = _listAddAll(this.wordList, list);
			return self();
		}

		/**
		 * A list of subwords to look for in the token stream. If found, the subword is
		 * included in the token output. Either this parameter or
		 * <code>word_list_path</code> must be specified.
		 * <p>
		 * API name: {@code word_list}
		 * <p>
		 * Adds one or more values to <code>wordList</code>.
		 */
		public final BuilderT wordList(String value, String... values) {
			this.wordList = _listAdd(this.wordList, value, values);
			return self();
		}

		/**
		 * Path to a file that contains a list of subwords to find in the token stream.
		 * If found, the subword is included in the token output. This path must be
		 * absolute or relative to the config location, and the file must be UTF-8
		 * encoded. Each token in the file must be separated by a line break. Either
		 * this parameter or <code>word_list</code> must be specified.
		 * <p>
		 * API name: {@code word_list_path}
		 */
		public final BuilderT wordListPath(@Nullable String value) {
			this.wordListPath = value;
			return self();
		}

	}

	// ---------------------------------------------------------------------------------------------
	protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupCompoundWordTokenFilterBaseDeserializer(
			ObjectDeserializer<BuilderT> op) {
		TokenFilterBase.setupTokenFilterBaseDeserializer(op);
		op.add(AbstractBuilder::maxSubwordSize, JsonpDeserializer.integerDeserializer(), "max_subword_size");
		op.add(AbstractBuilder::minSubwordSize, JsonpDeserializer.integerDeserializer(), "min_subword_size");
		op.add(AbstractBuilder::minWordSize, JsonpDeserializer.integerDeserializer(), "min_word_size");
		op.add(AbstractBuilder::onlyLongestMatch, JsonpDeserializer.booleanDeserializer(), "only_longest_match");
		op.add(AbstractBuilder::wordList, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
				"word_list");
		op.add(AbstractBuilder::wordListPath, JsonpDeserializer.stringDeserializer(), "word_list_path");

	}

}
