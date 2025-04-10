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

package co.elastic.clients.elasticsearch._types.query_dsl;

import co.elastic.clients.elasticsearch.security.query_api_keys.ApiKeyQuery;
import co.elastic.clients.elasticsearch.security.query_api_keys.ApiKeyQueryVariant;
import co.elastic.clients.elasticsearch.security.query_role.RoleQuery;
import co.elastic.clients.elasticsearch.security.query_role.RoleQueryVariant;
import co.elastic.clients.elasticsearch.security.query_user.UserQuery;
import co.elastic.clients.elasticsearch.security.query_user.UserQueryVariant;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.util.ApiTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
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

// typedef: _types.query_dsl.BoolQuery

/**
 *
 * @see <a href="../../doc-files/api-spec.html#_types.query_dsl.BoolQuery">API
 *      specification</a>
 */
@JsonpDeserializable
public class BoolQuery extends QueryBase
		implements
			ApiKeyQueryVariant,
			QueryVariant,
			RoleQueryVariant,
			UserQueryVariant {
	private final List<Query> filter;

	@Nullable
	private final String minimumShouldMatch;

	private final List<Query> must;

	private final List<Query> mustNot;

	private final List<Query> should;

	// ---------------------------------------------------------------------------------------------

	private BoolQuery(Builder builder) {
		super(builder);

		this.filter = ApiTypeHelper.unmodifiable(builder.filter);
		this.minimumShouldMatch = builder.minimumShouldMatch;
		this.must = ApiTypeHelper.unmodifiable(builder.must);
		this.mustNot = ApiTypeHelper.unmodifiable(builder.mustNot);
		this.should = ApiTypeHelper.unmodifiable(builder.should);

	}

	public static BoolQuery of(Function<Builder, ObjectBuilder<BoolQuery>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * ApiKeyQuery variant kind.
	 */
	@Override
	public ApiKeyQuery.Kind _apiKeyQueryKind() {
		return ApiKeyQuery.Kind.Bool;
	}

	/**
	 * Query variant kind.
	 */
	@Override
	public Query.Kind _queryKind() {
		return Query.Kind.Bool;
	}

	/**
	 * RoleQuery variant kind.
	 */
	@Override
	public RoleQuery.Kind _roleQueryKind() {
		return RoleQuery.Kind.Bool;
	}

	/**
	 * UserQuery variant kind.
	 */
	@Override
	public UserQuery.Kind _userQueryKind() {
		return UserQuery.Kind.Bool;
	}

	/**
	 * The clause (query) must appear in matching documents. However, unlike
	 * <code>must</code>, the score of the query will be ignored.
	 * <p>
	 * API name: {@code filter}
	 */
	public final List<Query> filter() {
		return this.filter;
	}

	/**
	 * Specifies the number or percentage of <code>should</code> clauses returned
	 * documents must match.
	 * <p>
	 * API name: {@code minimum_should_match}
	 */
	@Nullable
	public final String minimumShouldMatch() {
		return this.minimumShouldMatch;
	}

	/**
	 * The clause (query) must appear in matching documents and will contribute to
	 * the score.
	 * <p>
	 * API name: {@code must}
	 */
	public final List<Query> must() {
		return this.must;
	}

	/**
	 * The clause (query) must not appear in the matching documents. Because scoring
	 * is ignored, a score of <code>0</code> is returned for all documents.
	 * <p>
	 * API name: {@code must_not}
	 */
	public final List<Query> mustNot() {
		return this.mustNot;
	}

	/**
	 * The clause (query) should appear in the matching document.
	 * <p>
	 * API name: {@code should}
	 */
	public final List<Query> should() {
		return this.should;
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		super.serializeInternal(generator, mapper);
		if (ApiTypeHelper.isDefined(this.filter)) {
			generator.writeKey("filter");
			generator.writeStartArray();
			for (Query item0 : this.filter) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}
		if (this.minimumShouldMatch != null) {
			generator.writeKey("minimum_should_match");
			generator.write(this.minimumShouldMatch);

		}
		if (ApiTypeHelper.isDefined(this.must)) {
			generator.writeKey("must");
			generator.writeStartArray();
			for (Query item0 : this.must) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}
		if (ApiTypeHelper.isDefined(this.mustNot)) {
			generator.writeKey("must_not");
			generator.writeStartArray();
			for (Query item0 : this.mustNot) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}
		if (ApiTypeHelper.isDefined(this.should)) {
			generator.writeKey("should");
			generator.writeStartArray();
			for (Query item0 : this.should) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link BoolQuery}.
	 */

	public static class Builder extends QueryBase.AbstractBuilder<Builder> implements ObjectBuilder<BoolQuery> {
		@Nullable
		private List<Query> filter;

		@Nullable
		private String minimumShouldMatch;

		@Nullable
		private List<Query> must;

		@Nullable
		private List<Query> mustNot;

		@Nullable
		private List<Query> should;

		/**
		 * The clause (query) must appear in matching documents. However, unlike
		 * <code>must</code>, the score of the query will be ignored.
		 * <p>
		 * API name: {@code filter}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>filter</code>.
		 */
		public final Builder filter(List<Query> list) {
			this.filter = _listAddAll(this.filter, list);
			return this;
		}

		/**
		 * The clause (query) must appear in matching documents. However, unlike
		 * <code>must</code>, the score of the query will be ignored.
		 * <p>
		 * API name: {@code filter}
		 * <p>
		 * Adds one or more values to <code>filter</code>.
		 */
		public final Builder filter(Query value, Query... values) {
			this.filter = _listAdd(this.filter, value, values);
			return this;
		}

		/**
		 * The clause (query) must appear in matching documents. However, unlike
		 * <code>must</code>, the score of the query will be ignored.
		 * <p>
		 * API name: {@code filter}
		 * <p>
		 * Adds one or more values to <code>filter</code>.
		 */
		public final Builder filter(QueryVariant value, QueryVariant... values) {
			this.filter = _listAdd(this.filter, value._toQuery());
			for (QueryVariant v : values) {
				_listAdd(this.filter, v._toQuery());
			}
			return this;
		}

		/**
		 * The clause (query) must appear in matching documents. However, unlike
		 * <code>must</code>, the score of the query will be ignored.
		 * <p>
		 * API name: {@code filter}
		 * <p>
		 * Adds a value to <code>filter</code> using a builder lambda.
		 */
		public final Builder filter(Function<Query.Builder, ObjectBuilder<Query>> fn) {
			return filter(fn.apply(new Query.Builder()).build());
		}

		/**
		 * Specifies the number or percentage of <code>should</code> clauses returned
		 * documents must match.
		 * <p>
		 * API name: {@code minimum_should_match}
		 */
		public final Builder minimumShouldMatch(@Nullable String value) {
			this.minimumShouldMatch = value;
			return this;
		}

		/**
		 * The clause (query) must appear in matching documents and will contribute to
		 * the score.
		 * <p>
		 * API name: {@code must}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>must</code>.
		 */
		public final Builder must(List<Query> list) {
			this.must = _listAddAll(this.must, list);
			return this;
		}

		/**
		 * The clause (query) must appear in matching documents and will contribute to
		 * the score.
		 * <p>
		 * API name: {@code must}
		 * <p>
		 * Adds one or more values to <code>must</code>.
		 */
		public final Builder must(Query value, Query... values) {
			this.must = _listAdd(this.must, value, values);
			return this;
		}

		/**
		 * The clause (query) must appear in matching documents and will contribute to
		 * the score.
		 * <p>
		 * API name: {@code must}
		 * <p>
		 * Adds one or more values to <code>must</code>.
		 */
		public final Builder must(QueryVariant value, QueryVariant... values) {
			this.must = _listAdd(this.must, value._toQuery());
			for (QueryVariant v : values) {
				_listAdd(this.must, v._toQuery());
			}
			return this;
		}

		/**
		 * The clause (query) must appear in matching documents and will contribute to
		 * the score.
		 * <p>
		 * API name: {@code must}
		 * <p>
		 * Adds a value to <code>must</code> using a builder lambda.
		 */
		public final Builder must(Function<Query.Builder, ObjectBuilder<Query>> fn) {
			return must(fn.apply(new Query.Builder()).build());
		}

		/**
		 * The clause (query) must not appear in the matching documents. Because scoring
		 * is ignored, a score of <code>0</code> is returned for all documents.
		 * <p>
		 * API name: {@code must_not}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>mustNot</code>.
		 */
		public final Builder mustNot(List<Query> list) {
			this.mustNot = _listAddAll(this.mustNot, list);
			return this;
		}

		/**
		 * The clause (query) must not appear in the matching documents. Because scoring
		 * is ignored, a score of <code>0</code> is returned for all documents.
		 * <p>
		 * API name: {@code must_not}
		 * <p>
		 * Adds one or more values to <code>mustNot</code>.
		 */
		public final Builder mustNot(Query value, Query... values) {
			this.mustNot = _listAdd(this.mustNot, value, values);
			return this;
		}

		/**
		 * The clause (query) must not appear in the matching documents. Because scoring
		 * is ignored, a score of <code>0</code> is returned for all documents.
		 * <p>
		 * API name: {@code must_not}
		 * <p>
		 * Adds one or more values to <code>mustNot</code>.
		 */
		public final Builder mustNot(QueryVariant value, QueryVariant... values) {
			this.mustNot = _listAdd(this.mustNot, value._toQuery());
			for (QueryVariant v : values) {
				_listAdd(this.mustNot, v._toQuery());
			}
			return this;
		}

		/**
		 * The clause (query) must not appear in the matching documents. Because scoring
		 * is ignored, a score of <code>0</code> is returned for all documents.
		 * <p>
		 * API name: {@code must_not}
		 * <p>
		 * Adds a value to <code>mustNot</code> using a builder lambda.
		 */
		public final Builder mustNot(Function<Query.Builder, ObjectBuilder<Query>> fn) {
			return mustNot(fn.apply(new Query.Builder()).build());
		}

		/**
		 * The clause (query) should appear in the matching document.
		 * <p>
		 * API name: {@code should}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>should</code>.
		 */
		public final Builder should(List<Query> list) {
			this.should = _listAddAll(this.should, list);
			return this;
		}

		/**
		 * The clause (query) should appear in the matching document.
		 * <p>
		 * API name: {@code should}
		 * <p>
		 * Adds one or more values to <code>should</code>.
		 */
		public final Builder should(Query value, Query... values) {
			this.should = _listAdd(this.should, value, values);
			return this;
		}

		/**
		 * The clause (query) should appear in the matching document.
		 * <p>
		 * API name: {@code should}
		 * <p>
		 * Adds one or more values to <code>should</code>.
		 */
		public final Builder should(QueryVariant value, QueryVariant... values) {
			this.should = _listAdd(this.should, value._toQuery());
			for (QueryVariant v : values) {
				_listAdd(this.should, v._toQuery());
			}
			return this;
		}

		/**
		 * The clause (query) should appear in the matching document.
		 * <p>
		 * API name: {@code should}
		 * <p>
		 * Adds a value to <code>should</code> using a builder lambda.
		 */
		public final Builder should(Function<Query.Builder, ObjectBuilder<Query>> fn) {
			return should(fn.apply(new Query.Builder()).build());
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link BoolQuery}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public BoolQuery build() {
			_checkSingleUse();

			return new BoolQuery(this);
		}

		/**
		 * Returns <code>true</code> if this query has at least one should, must, must
		 * not or filter clause.
		 */
		public boolean hasClauses() {
			return !(this.must == null || this.must.isEmpty()) || !(this.mustNot == null || this.mustNot.isEmpty())
					|| !(this.should == null || this.should.isEmpty())
					|| !(this.filter == null || this.filter.isEmpty());
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link BoolQuery}
	 */
	public static final JsonpDeserializer<BoolQuery> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			BoolQuery::setupBoolQueryDeserializer);

	protected static void setupBoolQueryDeserializer(ObjectDeserializer<BoolQuery.Builder> op) {
		QueryBase.setupQueryBaseDeserializer(op);
		op.add(Builder::filter, JsonpDeserializer.arrayDeserializer(Query._DESERIALIZER), "filter");
		op.add(Builder::minimumShouldMatch, JsonpDeserializer.stringDeserializer(), "minimum_should_match");
		op.add(Builder::must, JsonpDeserializer.arrayDeserializer(Query._DESERIALIZER), "must");
		op.add(Builder::mustNot, JsonpDeserializer.arrayDeserializer(Query._DESERIALIZER), "must_not");
		op.add(Builder::should, JsonpDeserializer.arrayDeserializer(Query._DESERIALIZER), "should");

	}

	/**
	 * Returns <code>true</code> if this query has at least one should, must, must
	 * not or filter clause.
	 */
	public boolean hasClauses() {
		return !(this.must == null || this.must.isEmpty()) || !(this.mustNot == null || this.mustNot.isEmpty())
				|| !(this.should == null || this.should.isEmpty()) || !(this.filter == null || this.filter.isEmpty());
	}
}
