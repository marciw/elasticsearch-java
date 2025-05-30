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

// typedef: _types.analysis.AsciiFoldingTokenFilter

/**
 *
 * @see <a href=
 *      "../../doc-files/api-spec.html#_types.analysis.AsciiFoldingTokenFilter">API
 *      specification</a>
 */
@JsonpDeserializable
public class AsciiFoldingTokenFilter extends TokenFilterBase implements TokenFilterDefinitionVariant {
	@Nullable
	private final Boolean preserveOriginal;

	// ---------------------------------------------------------------------------------------------

	private AsciiFoldingTokenFilter(Builder builder) {
		super(builder);

		this.preserveOriginal = builder.preserveOriginal;

	}

	public static AsciiFoldingTokenFilter of(Function<Builder, ObjectBuilder<AsciiFoldingTokenFilter>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * TokenFilterDefinition variant kind.
	 */
	@Override
	public TokenFilterDefinition.Kind _tokenFilterDefinitionKind() {
		return TokenFilterDefinition.Kind.Asciifolding;
	}

	/**
	 * If <code>true</code>, emit both original tokens and folded tokens. Defaults
	 * to <code>false</code>.
	 * <p>
	 * API name: {@code preserve_original}
	 */
	@Nullable
	public final Boolean preserveOriginal() {
		return this.preserveOriginal;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		generator.write("type", "asciifolding");
		super.serializeInternal(generator, mapper);
		if (this.preserveOriginal != null) {
			generator.writeKey("preserve_original");
			generator.write(this.preserveOriginal);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link AsciiFoldingTokenFilter}.
	 */

	public static class Builder extends TokenFilterBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<AsciiFoldingTokenFilter> {
		@Nullable
		private Boolean preserveOriginal;

		/**
		 * If <code>true</code>, emit both original tokens and folded tokens. Defaults
		 * to <code>false</code>.
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
		 * Builds a {@link AsciiFoldingTokenFilter}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public AsciiFoldingTokenFilter build() {
			_checkSingleUse();

			return new AsciiFoldingTokenFilter(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link AsciiFoldingTokenFilter}
	 */
	public static final JsonpDeserializer<AsciiFoldingTokenFilter> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, AsciiFoldingTokenFilter::setupAsciiFoldingTokenFilterDeserializer);

	protected static void setupAsciiFoldingTokenFilterDeserializer(
			ObjectDeserializer<AsciiFoldingTokenFilter.Builder> op) {
		TokenFilterBase.setupTokenFilterBaseDeserializer(op);
		op.add(Builder::preserveOriginal, JsonpDeserializer.booleanDeserializer(), "preserve_original");

		op.ignore("type");
	}

}
