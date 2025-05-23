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

// typedef: _types.analysis.ElisionTokenFilter

/**
 *
 * @see <a href=
 *      "../../doc-files/api-spec.html#_types.analysis.ElisionTokenFilter">API
 *      specification</a>
 */
@JsonpDeserializable
public class ElisionTokenFilter extends TokenFilterBase implements TokenFilterDefinitionVariant {
	private final List<String> articles;

	@Nullable
	private final String articlesPath;

	@Nullable
	private final Boolean articlesCase;

	// ---------------------------------------------------------------------------------------------

	private ElisionTokenFilter(Builder builder) {
		super(builder);

		this.articles = ApiTypeHelper.unmodifiable(builder.articles);
		this.articlesPath = builder.articlesPath;
		this.articlesCase = builder.articlesCase;

	}

	public static ElisionTokenFilter of(Function<Builder, ObjectBuilder<ElisionTokenFilter>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * TokenFilterDefinition variant kind.
	 */
	@Override
	public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
		return TokenFilterDefinition.Kind.Elision;
	}

	/**
	 * List of elisions to remove. To be removed, the elision must be at the
	 * beginning of a token and be immediately followed by an apostrophe. Both the
	 * elision and apostrophe are removed. For custom <code>elision</code> filters,
	 * either this parameter or <code>articles_path</code> must be specified.
	 * <p>
	 * API name: {@code articles}
	 */
	public final List<String> articles() {
		return this.articles;
	}

	/**
	 * Path to a file that contains a list of elisions to remove. This path must be
	 * absolute or relative to the <code>config</code> location, and the file must
	 * be UTF-8 encoded. Each elision in the file must be separated by a line break.
	 * To be removed, the elision must be at the beginning of a token and be
	 * immediately followed by an apostrophe. Both the elision and apostrophe are
	 * removed. For custom <code>elision</code> filters, either this parameter or
	 * <code>articles</code> must be specified.
	 * <p>
	 * API name: {@code articles_path}
	 */
	@Nullable
	public final String articlesPath() {
		return this.articlesPath;
	}

	/**
	 * If <code>true</code>, elision matching is case insensitive. If
	 * <code>false</code>, elision matching is case sensitive. Defaults to
	 * <code>false</code>.
	 * <p>
	 * API name: {@code articles_case}
	 */
	@Nullable
	public final Boolean articlesCase() {
		return this.articlesCase;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.write("type", "elision");
		super.serializeInternal(generator, mapper);
		if (ApiTypeHelper.isDefined(this.articles)) {
			generator.writeKey("articles");
			generator.writeStartArray();
			for (String item0 : this.articles) {
				generator.write(item0);

			}
			generator.writeEnd();

		}
		if (this.articlesPath != null) {
			generator.writeKey("articles_path");
			generator.write(this.articlesPath);

		}
		if (this.articlesCase != null) {
			generator.writeKey("articles_case");
			generator.write(this.articlesCase);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link ElisionTokenFilter}.
	 */

	public static class Builder extends TokenFilterBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<ElisionTokenFilter> {
		@Nullable
		private List<String> articles;

		@Nullable
		private String articlesPath;

		@Nullable
		private Boolean articlesCase;

		/**
		 * List of elisions to remove. To be removed, the elision must be at the
		 * beginning of a token and be immediately followed by an apostrophe. Both the
		 * elision and apostrophe are removed. For custom <code>elision</code> filters,
		 * either this parameter or <code>articles_path</code> must be specified.
		 * <p>
		 * API name: {@code articles}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>articles</code>.
		 */
		public final Builder articles(List<String> list) {
			this.articles = _listAddAll(this.articles, list);
			return this;
		}

		/**
		 * List of elisions to remove. To be removed, the elision must be at the
		 * beginning of a token and be immediately followed by an apostrophe. Both the
		 * elision and apostrophe are removed. For custom <code>elision</code> filters,
		 * either this parameter or <code>articles_path</code> must be specified.
		 * <p>
		 * API name: {@code articles}
		 * <p>
		 * Adds one or more values to <code>articles</code>.
		 */
		public final Builder articles(String value, String... values) {
			this.articles = _listAdd(this.articles, value, values);
			return this;
		}

		/**
		 * Path to a file that contains a list of elisions to remove. This path must be
		 * absolute or relative to the <code>config</code> location, and the file must
		 * be UTF-8 encoded. Each elision in the file must be separated by a line break.
		 * To be removed, the elision must be at the beginning of a token and be
		 * immediately followed by an apostrophe. Both the elision and apostrophe are
		 * removed. For custom <code>elision</code> filters, either this parameter or
		 * <code>articles</code> must be specified.
		 * <p>
		 * API name: {@code articles_path}
		 */
		public final Builder articlesPath(@Nullable String value) {
			this.articlesPath = value;
			return this;
		}

		/**
		 * If <code>true</code>, elision matching is case insensitive. If
		 * <code>false</code>, elision matching is case sensitive. Defaults to
		 * <code>false</code>.
		 * <p>
		 * API name: {@code articles_case}
		 */
		public final Builder articlesCase(@Nullable Boolean value) {
			this.articlesCase = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link ElisionTokenFilter}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public ElisionTokenFilter build() {
			_checkSingleUse();

			return new ElisionTokenFilter(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link ElisionTokenFilter}
	 */
	public static final JsonpDeserializer<ElisionTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, ElisionTokenFilter::setupElisionTokenFilterDeserializer);

	protected static void setupElisionTokenFilterDeserializer(ObjectDeserializer<ElisionTokenFilter.Builder> op) {
		TokenFilterBase.setupTokenFilterBaseDeserializer(op);
		op.add(Builder::articles, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
				"articles");
		op.add(Builder::articlesPath, JsonpDeserializer.stringDeserializer(), "articles_path");
		op.add(Builder::articlesCase, JsonpDeserializer.booleanDeserializer(), "articles_case");

		op.ignore("type");
	}

}
