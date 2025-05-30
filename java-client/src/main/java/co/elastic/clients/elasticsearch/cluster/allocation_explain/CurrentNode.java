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

package co.elastic.clients.elasticsearch.cluster.allocation_explain;

import co.elastic.clients.elasticsearch._types.NodeRole;
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
import java.lang.String;
import java.util.List;
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

// typedef: cluster.allocation_explain.CurrentNode

/**
 *
 * @see <a href=
 *      "../../doc-files/api-spec.html#cluster.allocation_explain.CurrentNode">API
 *      specification</a>
 */
@JsonpDeserializable
public class CurrentNode implements JsonpSerializable {
	private final String id;

	private final String name;

	private final List<NodeRole> roles;

	private final Map<String, String> attributes;

	private final String transportAddress;

	private final int weightRanking;

	// ---------------------------------------------------------------------------------------------

	private CurrentNode(Builder builder) {

		this.id = ApiTypeHelper.requireNonNull(builder.id, this, "id");
		this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
		this.roles = ApiTypeHelper.unmodifiableRequired(builder.roles, this, "roles");
		this.attributes = ApiTypeHelper.unmodifiableRequired(builder.attributes, this, "attributes");
		this.transportAddress = ApiTypeHelper.requireNonNull(builder.transportAddress, this, "transportAddress");
		this.weightRanking = ApiTypeHelper.requireNonNull(builder.weightRanking, this, "weightRanking", 0);

	}

	public static CurrentNode of(Function<Builder, ObjectBuilder<CurrentNode>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - API name: {@code id}
	 */
	public final String id() {
		return this.id;
	}

	/**
	 * Required - API name: {@code name}
	 */
	public final String name() {
		return this.name;
	}

	/**
	 * Required - API name: {@code roles}
	 */
	public final List<NodeRole> roles() {
		return this.roles;
	}

	/**
	 * Required - API name: {@code attributes}
	 */
	public final Map<String, String> attributes() {
		return this.attributes;
	}

	/**
	 * Required - API name: {@code transport_address}
	 */
	public final String transportAddress() {
		return this.transportAddress;
	}

	/**
	 * Required - API name: {@code weight_ranking}
	 */
	public final int weightRanking() {
		return this.weightRanking;
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

		generator.writeKey("id");
		generator.write(this.id);

		generator.writeKey("name");
		generator.write(this.name);

		if (ApiTypeHelper.isDefined(this.roles)) {
			generator.writeKey("roles");
			generator.writeStartArray();
			for (NodeRole item0 : this.roles) {
				item0.serialize(generator, mapper);
			}
			generator.writeEnd();

		}
		if (ApiTypeHelper.isDefined(this.attributes)) {
			generator.writeKey("attributes");
			generator.writeStartObject();
			for (Map.Entry<String, String> item0 : this.attributes.entrySet()) {
				generator.writeKey(item0.getKey());
				generator.write(item0.getValue());

			}
			generator.writeEnd();

		}
		generator.writeKey("transport_address");
		generator.write(this.transportAddress);

		generator.writeKey("weight_ranking");
		generator.write(this.weightRanking);

	}

	@Override
	public String toString() {
		return JsonpUtils.toString(this);
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link CurrentNode}.
	 */

	public static class Builder extends WithJsonObjectBuilderBase<Builder> implements ObjectBuilder<CurrentNode> {
		private String id;

		private String name;

		private List<NodeRole> roles;

		private Map<String, String> attributes;

		private String transportAddress;

		private Integer weightRanking;

		/**
		 * Required - API name: {@code id}
		 */
		public final Builder id(String value) {
			this.id = value;
			return this;
		}

		/**
		 * Required - API name: {@code name}
		 */
		public final Builder name(String value) {
			this.name = value;
			return this;
		}

		/**
		 * Required - API name: {@code roles}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>roles</code>.
		 */
		public final Builder roles(List<NodeRole> list) {
			this.roles = _listAddAll(this.roles, list);
			return this;
		}

		/**
		 * Required - API name: {@code roles}
		 * <p>
		 * Adds one or more values to <code>roles</code>.
		 */
		public final Builder roles(NodeRole value, NodeRole... values) {
			this.roles = _listAdd(this.roles, value, values);
			return this;
		}

		/**
		 * Required - API name: {@code attributes}
		 * <p>
		 * Adds all entries of <code>map</code> to <code>attributes</code>.
		 */
		public final Builder attributes(Map<String, String> map) {
			this.attributes = _mapPutAll(this.attributes, map);
			return this;
		}

		/**
		 * Required - API name: {@code attributes}
		 * <p>
		 * Adds an entry to <code>attributes</code>.
		 */
		public final Builder attributes(String key, String value) {
			this.attributes = _mapPut(this.attributes, key, value);
			return this;
		}

		/**
		 * Required - API name: {@code transport_address}
		 */
		public final Builder transportAddress(String value) {
			this.transportAddress = value;
			return this;
		}

		/**
		 * Required - API name: {@code weight_ranking}
		 */
		public final Builder weightRanking(int value) {
			this.weightRanking = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link CurrentNode}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public CurrentNode build() {
			_checkSingleUse();

			return new CurrentNode(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link CurrentNode}
	 */
	public static final JsonpDeserializer<CurrentNode> _DESERIALIZER = ObjectBuilderDeserializer.lazy(Builder::new,
			CurrentNode::setupCurrentNodeDeserializer);

	protected static void setupCurrentNodeDeserializer(ObjectDeserializer<CurrentNode.Builder> op) {

		op.add(Builder::id, JsonpDeserializer.stringDeserializer(), "id");
		op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
		op.add(Builder::roles, JsonpDeserializer.arrayDeserializer(NodeRole._DESERIALIZER), "roles");
		op.add(Builder::attributes, JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.stringDeserializer()),
				"attributes");
		op.add(Builder::transportAddress, JsonpDeserializer.stringDeserializer(), "transport_address");
		op.add(Builder::weightRanking, JsonpDeserializer.integerDeserializer(), "weight_ranking");

	}

}
