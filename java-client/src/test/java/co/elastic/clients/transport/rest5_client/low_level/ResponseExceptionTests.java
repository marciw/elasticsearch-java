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


import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.InputStreamEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicClassicHttpResponse;
import org.apache.hc.core5.http.message.RequestLine;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class ResponseExceptionTests extends RestClientTestCase {


    @Test
    public void testResponseException() throws IOException, ParseException {
        ProtocolVersion protocolVersion = new ProtocolVersion("http", 1, 1);
        BasicClassicHttpResponse httpResponse = new BasicClassicHttpResponse(500, "Internal Server Error");

        String responseBody = "{\"error\":{\"root_cause\": {}}}";
        boolean hasBody = randomBoolean();
        if (hasBody) {
            HttpEntity entity;
            if (randomBoolean()) {
                entity = new StringEntity(responseBody, ContentType.APPLICATION_JSON);
            } else {
                // test a non repeatable entity
                entity = new InputStreamEntity(
                    new ByteArrayInputStream(responseBody.getBytes(StandardCharsets.UTF_8)),
                    ContentType.APPLICATION_JSON
                );
            }
            httpResponse.setEntity(entity);
        }

        RequestLine requestLine = new RequestLine("GET", "/", protocolVersion);
        HttpHost httpHost = new HttpHost("localhost", 9200);
        Response response = new Response(requestLine, httpHost, httpResponse);
        ResponseException responseException = new ResponseException(response);

        assertSame(response, responseException.getResponse());
        if (hasBody) {
            assertEquals(responseBody, EntityUtils.toString(responseException.getResponse().getEntity()));
        } else {
            assertNull(responseException.getResponse().getEntity());
        }

        String message = String.format(
            Locale.ROOT,
            "method [%s], host [%s], URI [%s], status line [%s]",
            response.getRequestLine().getMethod(),
            response.getHost(),
            response.getRequestLine().getUri(),
            response.getStatusCode()
        );

        if (hasBody) {
            message += "\n" + responseBody;
        }
        assertEquals(message, responseException.getMessage());
    }
}
