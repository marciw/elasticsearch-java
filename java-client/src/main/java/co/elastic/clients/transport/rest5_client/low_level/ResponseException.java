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

package co.elastic.clients.transport.rest5_client.low_level;

import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.BufferedHttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;
import java.util.Locale;

/**
 * Exception thrown when an elasticsearch node responds to a request with a status code that indicates an error.
 * Holds the response that was returned.
 */
public final class ResponseException extends IOException {

    private final Response response;

    public ResponseException(Response response) throws IOException {
        super(buildMessage(response));
        this.response = response;
    }

    static String buildMessage(Response response) throws IOException {
        String message = String.format(
            Locale.ROOT,
            "method [%s], host [%s], URI [%s], status line [%s]",
            response.getRequestLine().getMethod(),
            response.getHost(),
            response.getRequestLine().getUri(),
            response.getStatusCode()
        );

        if (response.hasWarnings()) {
            message += "\nWarnings: " + response.getWarnings();
        }

        HttpEntity entity = response.getEntity();
        if (entity != null) {
            if (!entity.isRepeatable()) {
                entity = new BufferedHttpEntity(entity);
                response.getHttpResponse().setEntity(entity);
            }
            try {
                message += "\n" + EntityUtils.toString(entity);
            } catch (ParseException e) {
                throw new IOException("Could not parse headers: " + e);
            }
        }
        return message;
    }

    /**
     * Returns the {@link Response} that caused this exception to be thrown.
     */
    public Response getResponse() {
        return response;
    }
}
