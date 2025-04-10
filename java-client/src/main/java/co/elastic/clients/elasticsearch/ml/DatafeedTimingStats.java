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

package co.elastic.clients.elasticsearch.ml;

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
import java.lang.Double;
import java.lang.Long;
import java.lang.String;
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

// typedef: ml._types.DatafeedTimingStats

/**
 *
 * @see <a href="../doc-files/api-spec.html#ml._types.DatafeedTimingStats">API
 *      specification</a>
 */
@JsonpDeserializable
public class DatafeedTimingStats implements JsonpSerializable {
	private final long bucketCount;

	private final double exponentialAverageSearchTimePerHourMs;

	@Nullable
	private final ExponentialAverageCalculationContext exponentialAverageCalculationContext;

	private final String jobId;

	private final long searchCount;

	private final double totalSearchTimeMs;

	@Nullable
	private final Double averageSearchTimePerBucketMs;

	// ---------------------------------------------------------------------------------------------

	private DatafeedTimingStats(Builder builder) {

		this.bucketCount = ApiTypeHelper.requireNonNull(builder.bucketCount, this, "bucketCount", 0);
		this.exponentialAverageSearchTimePerHourMs = ApiTypeHelper.requireNonNull(
				builder.exponentialAverageSearchTimePerHourMs, this, "exponentialAverageSearchTimePerHourMs", 0);
		this.exponentialAverageCalculationContext = builder.exponentialAverageCalculationContext;
		this.jobId = ApiTypeHelper.requireNonNull(builder.jobId, this, "jobId");
		this.searchCount = ApiTypeHelper.requireNonNull(builder.searchCount, this, "searchCount", 0);
		this.totalSearchTimeMs = ApiTypeHelper.requireNonNull(builder.totalSearchTimeMs, this, "totalSearchTimeMs", 0);
		this.averageSearchTimePerBucketMs = builder.averageSearchTimePerBucketMs;

	}

	public static DatafeedTimingStats of(Function<Builder, ObjectBuilder<DatafeedTimingStats>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Required - The number of buckets processed.
	 * <p>
	 * API name: {@code bucket_count}
	 */
	public final long bucketCount() {
		return this.bucketCount;
	}

	/**
	 * Required - The exponential average search time per hour, in milliseconds.
	 * <p>
	 * API name: {@code exponential_average_search_time_per_hour_ms}
	 */
	public final double exponentialAverageSearchTimePerHourMs() {
		return this.exponentialAverageSearchTimePerHourMs;
	}

	/**
	 * API name: {@code exponential_average_calculation_context}
	 */
	@Nullable
	public final ExponentialAverageCalculationContext exponentialAverageCalculationContext() {
		return this.exponentialAverageCalculationContext;
	}

	/**
	 * Required - Identifier for the anomaly detection job.
	 * <p>
	 * API name: {@code job_id}
	 */
	public final String jobId() {
		return this.jobId;
	}

	/**
	 * Required - The number of searches run by the datafeed.
	 * <p>
	 * API name: {@code search_count}
	 */
	public final long searchCount() {
		return this.searchCount;
	}

	/**
	 * Required - The total time the datafeed spent searching, in milliseconds.
	 * <p>
	 * API name: {@code total_search_time_ms}
	 */
	public final double totalSearchTimeMs() {
		return this.totalSearchTimeMs;
	}

	/**
	 * The average search time per bucket, in milliseconds.
	 * <p>
	 * API name: {@code average_search_time_per_bucket_ms}
	 */
	@Nullable
	public final Double averageSearchTimePerBucketMs() {
		return this.averageSearchTimePerBucketMs;
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

		generator.writeKey("bucket_count");
		generator.write(this.bucketCount);

		generator.writeKey("exponential_average_search_time_per_hour_ms");
		generator.write(this.exponentialAverageSearchTimePerHourMs);

		if (this.exponentialAverageCalculationContext != null) {
			generator.writeKey("exponential_average_calculation_context");
			this.exponentialAverageCalculationContext.serialize(generator, mapper);

		}
		generator.writeKey("job_id");
		generator.write(this.jobId);

		generator.writeKey("search_count");
		generator.write(this.searchCount);

		generator.writeKey("total_search_time_ms");
		generator.write(this.totalSearchTimeMs);

		if (this.averageSearchTimePerBucketMs != null) {
			generator.writeKey("average_search_time_per_bucket_ms");
			generator.write(this.averageSearchTimePerBucketMs);

		}

	}

	@Override
	public String toString() {
		return JsonpUtils.toString(this);
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link DatafeedTimingStats}.
	 */

	public static class Builder extends WithJsonObjectBuilderBase<Builder>
			implements
				ObjectBuilder<DatafeedTimingStats> {
		private Long bucketCount;

		private Double exponentialAverageSearchTimePerHourMs;

		@Nullable
		private ExponentialAverageCalculationContext exponentialAverageCalculationContext;

		private String jobId;

		private Long searchCount;

		private Double totalSearchTimeMs;

		@Nullable
		private Double averageSearchTimePerBucketMs;

		/**
		 * Required - The number of buckets processed.
		 * <p>
		 * API name: {@code bucket_count}
		 */
		public final Builder bucketCount(long value) {
			this.bucketCount = value;
			return this;
		}

		/**
		 * Required - The exponential average search time per hour, in milliseconds.
		 * <p>
		 * API name: {@code exponential_average_search_time_per_hour_ms}
		 */
		public final Builder exponentialAverageSearchTimePerHourMs(double value) {
			this.exponentialAverageSearchTimePerHourMs = value;
			return this;
		}

		/**
		 * API name: {@code exponential_average_calculation_context}
		 */
		public final Builder exponentialAverageCalculationContext(
				@Nullable ExponentialAverageCalculationContext value) {
			this.exponentialAverageCalculationContext = value;
			return this;
		}

		/**
		 * API name: {@code exponential_average_calculation_context}
		 */
		public final Builder exponentialAverageCalculationContext(
				Function<ExponentialAverageCalculationContext.Builder, ObjectBuilder<ExponentialAverageCalculationContext>> fn) {
			return this.exponentialAverageCalculationContext(
					fn.apply(new ExponentialAverageCalculationContext.Builder()).build());
		}

		/**
		 * Required - Identifier for the anomaly detection job.
		 * <p>
		 * API name: {@code job_id}
		 */
		public final Builder jobId(String value) {
			this.jobId = value;
			return this;
		}

		/**
		 * Required - The number of searches run by the datafeed.
		 * <p>
		 * API name: {@code search_count}
		 */
		public final Builder searchCount(long value) {
			this.searchCount = value;
			return this;
		}

		/**
		 * Required - The total time the datafeed spent searching, in milliseconds.
		 * <p>
		 * API name: {@code total_search_time_ms}
		 */
		public final Builder totalSearchTimeMs(double value) {
			this.totalSearchTimeMs = value;
			return this;
		}

		/**
		 * The average search time per bucket, in milliseconds.
		 * <p>
		 * API name: {@code average_search_time_per_bucket_ms}
		 */
		public final Builder averageSearchTimePerBucketMs(@Nullable Double value) {
			this.averageSearchTimePerBucketMs = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link DatafeedTimingStats}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public DatafeedTimingStats build() {
			_checkSingleUse();

			return new DatafeedTimingStats(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link DatafeedTimingStats}
	 */
	public static final JsonpDeserializer<DatafeedTimingStats> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, DatafeedTimingStats::setupDatafeedTimingStatsDeserializer);

	protected static void setupDatafeedTimingStatsDeserializer(ObjectDeserializer<DatafeedTimingStats.Builder> op) {

		op.add(Builder::bucketCount, JsonpDeserializer.longDeserializer(), "bucket_count");
		op.add(Builder::exponentialAverageSearchTimePerHourMs, JsonpDeserializer.doubleDeserializer(),
				"exponential_average_search_time_per_hour_ms");
		op.add(Builder::exponentialAverageCalculationContext, ExponentialAverageCalculationContext._DESERIALIZER,
				"exponential_average_calculation_context");
		op.add(Builder::jobId, JsonpDeserializer.stringDeserializer(), "job_id");
		op.add(Builder::searchCount, JsonpDeserializer.longDeserializer(), "search_count");
		op.add(Builder::totalSearchTimeMs, JsonpDeserializer.doubleDeserializer(), "total_search_time_ms");
		op.add(Builder::averageSearchTimePerBucketMs, JsonpDeserializer.doubleDeserializer(),
				"average_search_time_per_bucket_ms");

	}

}
