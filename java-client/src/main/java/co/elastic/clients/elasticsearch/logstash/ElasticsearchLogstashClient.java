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

package co.elastic.clients.elasticsearch.logstash;

import co.elastic.clients.ApiClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch._types.ErrorResponse;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.Endpoint;
import co.elastic.clients.transport.JsonEndpoint;
import co.elastic.clients.transport.Transport;
import co.elastic.clients.transport.TransportOptions;
import co.elastic.clients.transport.endpoints.BooleanResponse;
import co.elastic.clients.util.ObjectBuilder;
import java.io.IOException;
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

/**
 * Client for the logstash namespace.
 */
public class ElasticsearchLogstashClient extends ApiClient<ElasticsearchTransport, ElasticsearchLogstashClient> {

	public ElasticsearchLogstashClient(ElasticsearchTransport transport) {
		super(transport, null);
	}

	public ElasticsearchLogstashClient(ElasticsearchTransport transport, @Nullable TransportOptions transportOptions) {
		super(transport, transportOptions);
	}

	@Override
	public ElasticsearchLogstashClient withTransportOptions(@Nullable TransportOptions transportOptions) {
		return new ElasticsearchLogstashClient(this.transport, transportOptions);
	}

	// ----- Endpoint: logstash.delete_pipeline

	/**
	 * Delete a Logstash pipeline. Delete a pipeline that is used for Logstash
	 * Central Management. If the request succeeds, you receive an empty response
	 * with an appropriate status code.
	 * 
	 * @see <a href=
	 *      "https://www.elastic.co/docs/api/doc/elasticsearch/operation/operation-logstash-delete-pipeline">Documentation
	 *      on elastic.co</a>
	 */

	public BooleanResponse deletePipeline(DeletePipelineRequest request) throws IOException, ElasticsearchException {
		@SuppressWarnings("unchecked")
		Endpoint<DeletePipelineRequest, BooleanResponse, ErrorResponse> endpoint = (Endpoint<DeletePipelineRequest, BooleanResponse, ErrorResponse>) DeletePipelineRequest._ENDPOINT;

		return this.transport.performRequest(request, endpoint, this.transportOptions);
	}

	/**
	 * Delete a Logstash pipeline. Delete a pipeline that is used for Logstash
	 * Central Management. If the request succeeds, you receive an empty response
	 * with an appropriate status code.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link DeletePipelineRequest}
	 * @see <a href=
	 *      "https://www.elastic.co/docs/api/doc/elasticsearch/operation/operation-logstash-delete-pipeline">Documentation
	 *      on elastic.co</a>
	 */

	public final BooleanResponse deletePipeline(
			Function<DeletePipelineRequest.Builder, ObjectBuilder<DeletePipelineRequest>> fn)
			throws IOException, ElasticsearchException {
		return deletePipeline(fn.apply(new DeletePipelineRequest.Builder()).build());
	}

	// ----- Endpoint: logstash.get_pipeline

	/**
	 * Get Logstash pipelines. Get pipelines that are used for Logstash Central
	 * Management.
	 * 
	 * @see <a href=
	 *      "https://www.elastic.co/docs/api/doc/elasticsearch/operation/operation-logstash-get-pipeline">Documentation
	 *      on elastic.co</a>
	 */

	public GetPipelineResponse getPipeline(GetPipelineRequest request) throws IOException, ElasticsearchException {
		@SuppressWarnings("unchecked")
		JsonEndpoint<GetPipelineRequest, GetPipelineResponse, ErrorResponse> endpoint = (JsonEndpoint<GetPipelineRequest, GetPipelineResponse, ErrorResponse>) GetPipelineRequest._ENDPOINT;

		return this.transport.performRequest(request, endpoint, this.transportOptions);
	}

	/**
	 * Get Logstash pipelines. Get pipelines that are used for Logstash Central
	 * Management.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link GetPipelineRequest}
	 * @see <a href=
	 *      "https://www.elastic.co/docs/api/doc/elasticsearch/operation/operation-logstash-get-pipeline">Documentation
	 *      on elastic.co</a>
	 */

	public final GetPipelineResponse getPipeline(
			Function<GetPipelineRequest.Builder, ObjectBuilder<GetPipelineRequest>> fn)
			throws IOException, ElasticsearchException {
		return getPipeline(fn.apply(new GetPipelineRequest.Builder()).build());
	}

	/**
	 * Get Logstash pipelines. Get pipelines that are used for Logstash Central
	 * Management.
	 * 
	 * @see <a href=
	 *      "https://www.elastic.co/docs/api/doc/elasticsearch/operation/operation-logstash-get-pipeline">Documentation
	 *      on elastic.co</a>
	 */

	public GetPipelineResponse getPipeline() throws IOException, ElasticsearchException {
		return this.transport.performRequest(new GetPipelineRequest.Builder().build(), GetPipelineRequest._ENDPOINT,
				this.transportOptions);
	}

	// ----- Endpoint: logstash.put_pipeline

	/**
	 * Create or update a Logstash pipeline.
	 * <p>
	 * Create a pipeline that is used for Logstash Central Management. If the
	 * specified pipeline exists, it is replaced.
	 * 
	 * @see <a href=
	 *      "https://www.elastic.co/docs/api/doc/elasticsearch/operation/operation-logstash-put-pipeline">Documentation
	 *      on elastic.co</a>
	 */

	public BooleanResponse putPipeline(PutPipelineRequest request) throws IOException, ElasticsearchException {
		@SuppressWarnings("unchecked")
		Endpoint<PutPipelineRequest, BooleanResponse, ErrorResponse> endpoint = (Endpoint<PutPipelineRequest, BooleanResponse, ErrorResponse>) PutPipelineRequest._ENDPOINT;

		return this.transport.performRequest(request, endpoint, this.transportOptions);
	}

	/**
	 * Create or update a Logstash pipeline.
	 * <p>
	 * Create a pipeline that is used for Logstash Central Management. If the
	 * specified pipeline exists, it is replaced.
	 * 
	 * @param fn
	 *            a function that initializes a builder to create the
	 *            {@link PutPipelineRequest}
	 * @see <a href=
	 *      "https://www.elastic.co/docs/api/doc/elasticsearch/operation/operation-logstash-put-pipeline">Documentation
	 *      on elastic.co</a>
	 */

	public final BooleanResponse putPipeline(Function<PutPipelineRequest.Builder, ObjectBuilder<PutPipelineRequest>> fn)
			throws IOException, ElasticsearchException {
		return putPipeline(fn.apply(new PutPipelineRequest.Builder()).build());
	}

}
