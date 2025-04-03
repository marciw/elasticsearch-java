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

package co.elastic.clients.elasticsearch.security;

import co.elastic.clients.elasticsearch.security.query_user.QueryUser;
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
import java.lang.Integer;
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

// typedef: security.query_user.Response

/**
 *
 * @see <a href="../doc-files/api-spec.html#security.query_user.Response">API
 *      specification</a>
 */
@JsonpDeserializable
public class QueryUserResponse implements JsonpSerializable {
	private final int total;

	private final int count;

	private final List<QueryUser> users;

	// ---------------------------------------------------------------------------------------------

	private QueryUserResponse(Builder builder) {

		this.total = ApiTypeHelper.requireNonNull(builder.total, this, "total", 0);
		this.count = ApiTypeHelper.requireNonNull(builder.count, this, "count", 0);
		this.users = ApiTypeHelper.unmodifiableRequired(builder.users, this, "users");

	}

	public static QueryUserResponse of(Function<Builder, ObjectBuilder<QueryUserResponse>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - The total number of users found.
	 * <p>
	 * API name: {@code total}
	 */
	public final int total() {
		return this.total;
	}

	/**
	 * Required - The number of users returned in the response.
	 * <p>
	 * API name: {@code count}
	 */
	public final int count() {
		return this.count;
	}

	/**
	 * Required - A list of users that match the query.
	 * <p>
	 * API name: {@code users}
	 */
	public final List<QueryUser> users() {
		return this.users;
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

		generator.writeKey("total");
		generator.write(this.total);

		generator.writeKey("count");
		generator.write(this.count);

		if (ApiTypeHelper.isDefined(this.users)) {
			generator.writeKey("users");
			generator.writeStartArray();
			for (QueryUser item0 : this.users) {
				item0.serialize(generator, mapper);

			}
			generator.writeEnd();

		}

	}

	@Override
	public String toString() {
		return JsonpUtils.toString(this);
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link QueryUserResponse}.
	 */

	public static class Builder extends WithJsonObjectBuilderBase<Builder> implements ObjectBuilder<QueryUserResponse> {
		private Integer total;

		private Integer count;

		private List<QueryUser> users;

		/**
		 * Required - The total number of users found.
		 * <p>
		 * API name: {@code total}
		 */
		public final Builder total(int value) {
			this.total = value;
			return this;
		}

		/**
		 * Required - The number of users returned in the response.
		 * <p>
		 * API name: {@code count}
		 */
		public final Builder count(int value) {
			this.count = value;
			return this;
		}

		/**
		 * Required - A list of users that match the query.
		 * <p>
		 * API name: {@code users}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>users</code>.
		 */
		public final Builder users(List<QueryUser> list) {
			this.users = _listAddAll(this.users, list);
			return this;
		}

		/**
		 * Required - A list of users that match the query.
		 * <p>
		 * API name: {@code users}
		 * <p>
		 * Adds one or more values to <code>users</code>.
		 */
		public final Builder users(QueryUser value, QueryUser... values) {
			this.users = _listAdd(this.users, value, values);
			return this;
		}

		/**
		 * Required - A list of users that match the query.
		 * <p>
		 * API name: {@code users}
		 * <p>
		 * Adds a value to <code>users</code> using a builder lambda.
		 */
		public final Builder users(Function<QueryUser.Builder, ObjectBuilder<QueryUser>> fn) {
			return users(fn.apply(new QueryUser.Builder()).build());
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link QueryUserResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public QueryUserResponse build() {
			_checkSingleUse();

			return new QueryUserResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link QueryUserResponse}
	 */
	public static final JsonpDeserializer<QueryUserResponse> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, QueryUserResponse::setupQueryUserResponseDeserializer);

	protected static void setupQueryUserResponseDeserializer(ObjectDeserializer<QueryUserResponse.Builder> op) {

		op.add(Builder::total, JsonpDeserializer.integerDeserializer(), "total");
		op.add(Builder::count, JsonpDeserializer.integerDeserializer(), "count");
		op.add(Builder::users, JsonpDeserializer.arrayDeserializer(QueryUser._DESERIALIZER), "users");

	}

}
