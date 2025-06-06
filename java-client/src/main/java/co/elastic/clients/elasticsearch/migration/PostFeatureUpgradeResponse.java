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

package co.elastic.clients.elasticsearch.migration;

import co.elastic.clients.elasticsearch.migration.post_feature_upgrade.MigrationFeature;
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

// typedef: migration.post_feature_upgrade.Response

/**
 *
 * @see <a href=
 *      "../doc-files/api-spec.html#migration.post_feature_upgrade.Response">API
 *      specification</a>
 */
@JsonpDeserializable
public class PostFeatureUpgradeResponse implements JsonpSerializable {
	private final boolean accepted;

	private final List<MigrationFeature> features;

	@Nullable
	private final String reason;

	// ---------------------------------------------------------------------------------------------

	private PostFeatureUpgradeResponse(Builder builder) {

		this.accepted = ApiTypeHelper.requireNonNull(builder.accepted, this, "accepted", false);
		this.features = ApiTypeHelper.unmodifiable(builder.features);
		this.reason = builder.reason;

	}

	public static PostFeatureUpgradeResponse of(Function<Builder, ObjectBuilder<PostFeatureUpgradeResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code accepted}
	 */
	public final boolean accepted() {
		return this.accepted;
	}

	/**
	 * API name: {@code features}
	 */
	public final List<MigrationFeature> features() {
		return this.features;
	}

	/**
	 * API name: {@code reason}
	 */
	@Nullable
	public final String reason() {
		return this.reason;
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

		generator.writeKey("accepted");
		generator.write(this.accepted);

		if (ApiTypeHelper.isDefined(this.features)) {
			generator.writeKey("features");
			generator.writeStartArray();
			for (MigrationFeature item0 : this.features) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}
		if (this.reason != null) {
			generator.writeKey("reason");
			generator.write(this.reason);

		}

	}

	@Override
	public String toString() {
		return JsonpUtils.toString(this);
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link PostFeatureUpgradeResponse}.
	 */

	public static class Builder extends WithJsonObjectBuilderBase<Builder>
			implements
				ObjectBuilder<PostFeatureUpgradeResponse> {
		private Boolean accepted;

		@Nullable
		private List<MigrationFeature> features;

		@Nullable
		private String reason;

		/**
		 * Required - API name: {@code accepted}
		 */
		public final Builder accepted(boolean value) {
			this.accepted = value;
			return this;
		}

		/**
		 * API name: {@code features}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>features</code>.
		 */
		public final Builder features(List<MigrationFeature> list) {
			this.features = _listAddAll(this.features, list);
			return this;
		}

		/**
		 * API name: {@code features}
		 * <p>
		 * Adds one or more values to <code>features</code>.
		 */
		public final Builder features(MigrationFeature value, MigrationFeature... values) {
			this.features = _listAdd(this.features, value, values);
			return this;
		}

		/**
		 * API name: {@code features}
		 * <p>
		 * Adds a value to <code>features</code> using a builder lambda.
		 */
		public final Builder features(Function<MigrationFeature.Builder, ObjectBuilder<MigrationFeature>> fn) {
			return features(fn.apply(new MigrationFeature.Builder()).build());
		}

		/**
		 * API name: {@code reason}
		 */
		public final Builder reason(@Nullable String value) {
			this.reason = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link PostFeatureUpgradeResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public PostFeatureUpgradeResponse build() {
			_checkSingleUse();

			return new PostFeatureUpgradeResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link PostFeatureUpgradeResponse}
	 */
	public static final JsonpDeserializer<PostFeatureUpgradeResponse> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, PostFeatureUpgradeResponse::setupPostFeatureUpgradeResponseDeserializer);

	protected static void setupPostFeatureUpgradeResponseDeserializer(
			ObjectDeserializer<PostFeatureUpgradeResponse.Builder> op) {

		op.add(Builder::accepted, JsonpDeserializer.booleanDeserializer(), "accepted");
		op.add(Builder::features, JsonpDeserializer.arrayDeserializer(MigrationFeature._DESERIALIZER), "features");
		op.add(Builder::reason, JsonpDeserializer.stringDeserializer(), "reason");

	}

}
