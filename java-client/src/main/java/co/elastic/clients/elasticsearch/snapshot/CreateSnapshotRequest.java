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

package co.elastic.clients.elasticsearch.snapshot;

import co.elastic.clients.elasticsearch._types.ErrorResponse;
import co.elastic.clients.elasticsearch._types.ExpandWildcard;
import co.elastic.clients.elasticsearch._types.RequestBase;
import co.elastic.clients.elasticsearch._types.Time;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpSerializable;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.transport.Endpoint;
import co.elastic.clients.transport.endpoints.SimpleEndpoint;
import co.elastic.clients.util.ApiTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.Boolean;
import java.lang.String;
import java.util.HashMap;
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

// typedef: snapshot.create.Request

/**
 * Create a snapshot. Take a snapshot of a cluster or of data streams and
 * indices.
 * 
 * @see <a href="../doc-files/api-spec.html#snapshot.create.Request">API
 *      specification</a>
 */
@JsonpDeserializable
public class CreateSnapshotRequest extends RequestBase implements JsonpSerializable {
	private final List<ExpandWildcard> expandWildcards;

	private final List<String> featureStates;

	@Nullable
	private final Boolean ignoreUnavailable;

	@Nullable
	private final Boolean includeGlobalState;

	private final List<String> indices;

	@Nullable
	private final Time masterTimeout;

	private final Map<String, JsonData> metadata;

	@Nullable
	private final Boolean partial;

	private final String repository;

	private final String snapshot;

	@Nullable
	private final Boolean waitForCompletion;

	// ---------------------------------------------------------------------------------------------

	private CreateSnapshotRequest(Builder builder) {

		this.expandWildcards = ApiTypeHelper.unmodifiable(builder.expandWildcards);
		this.featureStates = ApiTypeHelper.unmodifiable(builder.featureStates);
		this.ignoreUnavailable = builder.ignoreUnavailable;
		this.includeGlobalState = builder.includeGlobalState;
		this.indices = ApiTypeHelper.unmodifiable(builder.indices);
		this.masterTimeout = builder.masterTimeout;
		this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
		this.partial = builder.partial;
		this.repository = ApiTypeHelper.requireNonNull(builder.repository, this, "repository");
		this.snapshot = ApiTypeHelper.requireNonNull(builder.snapshot, this, "snapshot");
		this.waitForCompletion = builder.waitForCompletion;

	}

	public static CreateSnapshotRequest of(Function<Builder, ObjectBuilder<CreateSnapshotRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Determines how wildcard patterns in the <code>indices</code> parameter match
	 * data streams and indices. It supports comma-separated values such as
	 * <code>open,hidden</code>.
	 * <p>
	 * API name: {@code expand_wildcards}
	 */
	public final List<ExpandWildcard> expandWildcards() {
		return this.expandWildcards;
	}

	/**
	 * The feature states to include in the snapshot. Each feature state includes
	 * one or more system indices containing related data. You can view a list of
	 * eligible features using the get features API.
	 * <p>
	 * If <code>include_global_state</code> is <code>true</code>, all current
	 * feature states are included by default. If <code>include_global_state</code>
	 * is <code>false</code>, no feature states are included by default.
	 * <p>
	 * Note that specifying an empty array will result in the default behavior. To
	 * exclude all feature states, regardless of the
	 * <code>include_global_state</code> value, specify an array with only the value
	 * <code>none</code> (<code>[&quot;none&quot;]</code>).
	 * <p>
	 * API name: {@code feature_states}
	 */
	public final List<String> featureStates() {
		return this.featureStates;
	}

	/**
	 * If <code>true</code>, the request ignores data streams and indices in
	 * <code>indices</code> that are missing or closed. If <code>false</code>, the
	 * request returns an error for any data stream or index that is missing or
	 * closed.
	 * <p>
	 * API name: {@code ignore_unavailable}
	 */
	@Nullable
	public final Boolean ignoreUnavailable() {
		return this.ignoreUnavailable;
	}

	/**
	 * If <code>true</code>, the current cluster state is included in the snapshot.
	 * The cluster state includes persistent cluster settings, composable index
	 * templates, legacy index templates, ingest pipelines, and ILM policies. It
	 * also includes data stored in system indices, such as Watches and task records
	 * (configurable via <code>feature_states</code>).
	 * <p>
	 * API name: {@code include_global_state}
	 */
	@Nullable
	public final Boolean includeGlobalState() {
		return this.includeGlobalState;
	}

	/**
	 * A comma-separated list of data streams and indices to include in the
	 * snapshot. It supports a multi-target syntax. The default is an empty array
	 * (<code>[]</code>), which includes all regular data streams and regular
	 * indices. To exclude all data streams and indices, use <code>-*</code>.
	 * <p>
	 * You can't use this parameter to include or exclude system indices or system
	 * data streams from a snapshot. Use <code>feature_states</code> instead.
	 * <p>
	 * API name: {@code indices}
	 */
	public final List<String> indices() {
		return this.indices;
	}

	/**
	 * The period to wait for a connection to the master node. If no response is
	 * received before the timeout expires, the request fails and returns an error.
	 * <p>
	 * API name: {@code master_timeout}
	 */
	@Nullable
	public final Time masterTimeout() {
		return this.masterTimeout;
	}

	/**
	 * Arbitrary metadata to the snapshot, such as a record of who took the
	 * snapshot, why it was taken, or any other useful data. It can have any
	 * contents but it must be less than 1024 bytes. This information is not
	 * automatically generated by Elasticsearch.
	 * <p>
	 * API name: {@code metadata}
	 */
	public final Map<String, JsonData> metadata() {
		return this.metadata;
	}

	/**
	 * If <code>true</code>, it enables you to restore a partial snapshot of indices
	 * with unavailable shards. Only shards that were successfully included in the
	 * snapshot will be restored. All missing shards will be recreated as empty.
	 * <p>
	 * If <code>false</code>, the entire restore operation will fail if one or more
	 * indices included in the snapshot do not have all primary shards available.
	 * <p>
	 * API name: {@code partial}
	 */
	@Nullable
	public final Boolean partial() {
		return this.partial;
	}

	/**
	 * Required - The name of the repository for the snapshot.
	 * <p>
	 * API name: {@code repository}
	 */
	public final String repository() {
		return this.repository;
	}

	/**
	 * Required - The name of the snapshot. It supportes date math. It must be
	 * unique in the repository.
	 * <p>
	 * API name: {@code snapshot}
	 */
	public final String snapshot() {
		return this.snapshot;
	}

	/**
	 * If <code>true</code>, the request returns a response when the snapshot is
	 * complete. If <code>false</code>, the request returns a response when the
	 * snapshot initializes.
	 * <p>
	 * API name: {@code wait_for_completion}
	 */
	@Nullable
	public final Boolean waitForCompletion() {
		return this.waitForCompletion;
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

		if (ApiTypeHelper.isDefined(this.expandWildcards)) {
			generator.writeKey("expand_wildcards");
			generator.writeStartArray();
			for (ExpandWildcard item0 : this.expandWildcards) {
				item0.serialize(generator, mapper);
			}
			generator.writeEnd();

		}
		if (ApiTypeHelper.isDefined(this.featureStates)) {
			generator.writeKey("feature_states");
			generator.writeStartArray();
			for (String item0 : this.featureStates) {
				generator.write(item0);

			}
			generator.writeEnd();

		}
		if (this.ignoreUnavailable != null) {
			generator.writeKey("ignore_unavailable");
			generator.write(this.ignoreUnavailable);

		}
		if (this.includeGlobalState != null) {
			generator.writeKey("include_global_state");
			generator.write(this.includeGlobalState);

		}
		if (ApiTypeHelper.isDefined(this.indices)) {
			generator.writeKey("indices");
			generator.writeStartArray();
			for (String item0 : this.indices) {
				generator.write(item0);

			}
			generator.writeEnd();

		}
		if (ApiTypeHelper.isDefined(this.metadata)) {
			generator.writeKey("metadata");
			generator.writeStartObject();
			for (Map.Entry<String, JsonData> item0 : this.metadata.entrySet()) {
				generator.writeKey(item0.getKey());
				item0.getValue().serialize(generator, mapper);

			}
			generator.writeEnd();

		}
		if (this.partial != null) {
			generator.writeKey("partial");
			generator.write(this.partial);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link CreateSnapshotRequest}.
	 */

	public static class Builder extends RequestBase.AbstractBuilder<Builder>
			implements
				ObjectBuilder<CreateSnapshotRequest> {
		@Nullable
		private List<ExpandWildcard> expandWildcards;

		@Nullable
		private List<String> featureStates;

		@Nullable
		private Boolean ignoreUnavailable;

		@Nullable
		private Boolean includeGlobalState;

		@Nullable
		private List<String> indices;

		@Nullable
		private Time masterTimeout;

		@Nullable
		private Map<String, JsonData> metadata;

		@Nullable
		private Boolean partial;

		private String repository;

		private String snapshot;

		@Nullable
		private Boolean waitForCompletion;

		/**
		 * Determines how wildcard patterns in the <code>indices</code> parameter match
		 * data streams and indices. It supports comma-separated values such as
		 * <code>open,hidden</code>.
		 * <p>
		 * API name: {@code expand_wildcards}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>expandWildcards</code>.
		 */
		public final Builder expandWildcards(List<ExpandWildcard> list) {
			this.expandWildcards = _listAddAll(this.expandWildcards, list);
			return this;
		}

		/**
		 * Determines how wildcard patterns in the <code>indices</code> parameter match
		 * data streams and indices. It supports comma-separated values such as
		 * <code>open,hidden</code>.
		 * <p>
		 * API name: {@code expand_wildcards}
		 * <p>
		 * Adds one or more values to <code>expandWildcards</code>.
		 */
		public final Builder expandWildcards(ExpandWildcard value, ExpandWildcard... values) {
			this.expandWildcards = _listAdd(this.expandWildcards, value, values);
			return this;
		}

		/**
		 * The feature states to include in the snapshot. Each feature state includes
		 * one or more system indices containing related data. You can view a list of
		 * eligible features using the get features API.
		 * <p>
		 * If <code>include_global_state</code> is <code>true</code>, all current
		 * feature states are included by default. If <code>include_global_state</code>
		 * is <code>false</code>, no feature states are included by default.
		 * <p>
		 * Note that specifying an empty array will result in the default behavior. To
		 * exclude all feature states, regardless of the
		 * <code>include_global_state</code> value, specify an array with only the value
		 * <code>none</code> (<code>[&quot;none&quot;]</code>).
		 * <p>
		 * API name: {@code feature_states}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>featureStates</code>.
		 */
		public final Builder featureStates(List<String> list) {
			this.featureStates = _listAddAll(this.featureStates, list);
			return this;
		}

		/**
		 * The feature states to include in the snapshot. Each feature state includes
		 * one or more system indices containing related data. You can view a list of
		 * eligible features using the get features API.
		 * <p>
		 * If <code>include_global_state</code> is <code>true</code>, all current
		 * feature states are included by default. If <code>include_global_state</code>
		 * is <code>false</code>, no feature states are included by default.
		 * <p>
		 * Note that specifying an empty array will result in the default behavior. To
		 * exclude all feature states, regardless of the
		 * <code>include_global_state</code> value, specify an array with only the value
		 * <code>none</code> (<code>[&quot;none&quot;]</code>).
		 * <p>
		 * API name: {@code feature_states}
		 * <p>
		 * Adds one or more values to <code>featureStates</code>.
		 */
		public final Builder featureStates(String value, String... values) {
			this.featureStates = _listAdd(this.featureStates, value, values);
			return this;
		}

		/**
		 * If <code>true</code>, the request ignores data streams and indices in
		 * <code>indices</code> that are missing or closed. If <code>false</code>, the
		 * request returns an error for any data stream or index that is missing or
		 * closed.
		 * <p>
		 * API name: {@code ignore_unavailable}
		 */
		public final Builder ignoreUnavailable(@Nullable Boolean value) {
			this.ignoreUnavailable = value;
			return this;
		}

		/**
		 * If <code>true</code>, the current cluster state is included in the snapshot.
		 * The cluster state includes persistent cluster settings, composable index
		 * templates, legacy index templates, ingest pipelines, and ILM policies. It
		 * also includes data stored in system indices, such as Watches and task records
		 * (configurable via <code>feature_states</code>).
		 * <p>
		 * API name: {@code include_global_state}
		 */
		public final Builder includeGlobalState(@Nullable Boolean value) {
			this.includeGlobalState = value;
			return this;
		}

		/**
		 * A comma-separated list of data streams and indices to include in the
		 * snapshot. It supports a multi-target syntax. The default is an empty array
		 * (<code>[]</code>), which includes all regular data streams and regular
		 * indices. To exclude all data streams and indices, use <code>-*</code>.
		 * <p>
		 * You can't use this parameter to include or exclude system indices or system
		 * data streams from a snapshot. Use <code>feature_states</code> instead.
		 * <p>
		 * API name: {@code indices}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>indices</code>.
		 */
		public final Builder indices(List<String> list) {
			this.indices = _listAddAll(this.indices, list);
			return this;
		}

		/**
		 * A comma-separated list of data streams and indices to include in the
		 * snapshot. It supports a multi-target syntax. The default is an empty array
		 * (<code>[]</code>), which includes all regular data streams and regular
		 * indices. To exclude all data streams and indices, use <code>-*</code>.
		 * <p>
		 * You can't use this parameter to include or exclude system indices or system
		 * data streams from a snapshot. Use <code>feature_states</code> instead.
		 * <p>
		 * API name: {@code indices}
		 * <p>
		 * Adds one or more values to <code>indices</code>.
		 */
		public final Builder indices(String value, String... values) {
			this.indices = _listAdd(this.indices, value, values);
			return this;
		}

		/**
		 * The period to wait for a connection to the master node. If no response is
		 * received before the timeout expires, the request fails and returns an error.
		 * <p>
		 * API name: {@code master_timeout}
		 */
		public final Builder masterTimeout(@Nullable Time value) {
			this.masterTimeout = value;
			return this;
		}

		/**
		 * The period to wait for a connection to the master node. If no response is
		 * received before the timeout expires, the request fails and returns an error.
		 * <p>
		 * API name: {@code master_timeout}
		 */
		public final Builder masterTimeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
			return this.masterTimeout(fn.apply(new Time.Builder()).build());
		}

		/**
		 * Arbitrary metadata to the snapshot, such as a record of who took the
		 * snapshot, why it was taken, or any other useful data. It can have any
		 * contents but it must be less than 1024 bytes. This information is not
		 * automatically generated by Elasticsearch.
		 * <p>
		 * API name: {@code metadata}
		 * <p>
		 * Adds all entries of <code>map</code> to <code>metadata</code>.
		 */
		public final Builder metadata(Map<String, JsonData> map) {
			this.metadata = _mapPutAll(this.metadata, map);
			return this;
		}

		/**
		 * Arbitrary metadata to the snapshot, such as a record of who took the
		 * snapshot, why it was taken, or any other useful data. It can have any
		 * contents but it must be less than 1024 bytes. This information is not
		 * automatically generated by Elasticsearch.
		 * <p>
		 * API name: {@code metadata}
		 * <p>
		 * Adds an entry to <code>metadata</code>.
		 */
		public final Builder metadata(String key, JsonData value) {
			this.metadata = _mapPut(this.metadata, key, value);
			return this;
		}

		/**
		 * If <code>true</code>, it enables you to restore a partial snapshot of indices
		 * with unavailable shards. Only shards that were successfully included in the
		 * snapshot will be restored. All missing shards will be recreated as empty.
		 * <p>
		 * If <code>false</code>, the entire restore operation will fail if one or more
		 * indices included in the snapshot do not have all primary shards available.
		 * <p>
		 * API name: {@code partial}
		 */
		public final Builder partial(@Nullable Boolean value) {
			this.partial = value;
			return this;
		}

		/**
		 * Required - The name of the repository for the snapshot.
		 * <p>
		 * API name: {@code repository}
		 */
		public final Builder repository(String value) {
			this.repository = value;
			return this;
		}

		/**
		 * Required - The name of the snapshot. It supportes date math. It must be
		 * unique in the repository.
		 * <p>
		 * API name: {@code snapshot}
		 */
		public final Builder snapshot(String value) {
			this.snapshot = value;
			return this;
		}

		/**
		 * If <code>true</code>, the request returns a response when the snapshot is
		 * complete. If <code>false</code>, the request returns a response when the
		 * snapshot initializes.
		 * <p>
		 * API name: {@code wait_for_completion}
		 */
		public final Builder waitForCompletion(@Nullable Boolean value) {
			this.waitForCompletion = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link CreateSnapshotRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public CreateSnapshotRequest build() {
			_checkSingleUse();

			return new CreateSnapshotRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link CreateSnapshotRequest}
	 */
	public static final JsonpDeserializer<CreateSnapshotRequest> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, CreateSnapshotRequest::setupCreateSnapshotRequestDeserializer);

	protected static void setupCreateSnapshotRequestDeserializer(ObjectDeserializer<CreateSnapshotRequest.Builder> op) {

		op.add(Builder::expandWildcards, JsonpDeserializer.arrayDeserializer(ExpandWildcard._DESERIALIZER),
				"expand_wildcards");
		op.add(Builder::featureStates, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
				"feature_states");
		op.add(Builder::ignoreUnavailable, JsonpDeserializer.booleanDeserializer(), "ignore_unavailable");
		op.add(Builder::includeGlobalState, JsonpDeserializer.booleanDeserializer(), "include_global_state");
		op.add(Builder::indices, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
				"indices");
		op.add(Builder::metadata, JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER), "metadata");
		op.add(Builder::partial, JsonpDeserializer.booleanDeserializer(), "partial");

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code snapshot.create}".
	 */
	public static final Endpoint<CreateSnapshotRequest, CreateSnapshotResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
			"es/snapshot.create",

			// Request method
			request -> {
				return "PUT";

			},

			// Request path
			request -> {
				final int _repository = 1 << 0;
				final int _snapshot = 1 << 1;

				int propsSet = 0;

				propsSet |= _repository;
				propsSet |= _snapshot;

				if (propsSet == (_repository | _snapshot)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_snapshot");
					buf.append("/");
					SimpleEndpoint.pathEncode(request.repository, buf);
					buf.append("/");
					SimpleEndpoint.pathEncode(request.snapshot, buf);
					return buf.toString();
				}
				throw SimpleEndpoint.noPathTemplateFound("path");

			},

			// Path parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				final int _repository = 1 << 0;
				final int _snapshot = 1 << 1;

				int propsSet = 0;

				propsSet |= _repository;
				propsSet |= _snapshot;

				if (propsSet == (_repository | _snapshot)) {
					params.put("repository", request.repository);
					params.put("snapshot", request.snapshot);
				}
				return params;
			},

			// Request parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				if (request.masterTimeout != null) {
					params.put("master_timeout", request.masterTimeout._toJsonString());
				}
				if (request.waitForCompletion != null) {
					params.put("wait_for_completion", String.valueOf(request.waitForCompletion));
				}
				return params;

			}, SimpleEndpoint.emptyMap(), true, CreateSnapshotResponse._DESERIALIZER);
}
