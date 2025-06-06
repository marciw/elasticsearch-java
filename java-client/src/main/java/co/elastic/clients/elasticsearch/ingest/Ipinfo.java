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

package co.elastic.clients.elasticsearch.ingest;

import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpSerializable;
import co.elastic.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;

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
 *
 * @see <a href="../doc-files/api-spec.html#ingest._types.Ipinfo">API
 *      specification</a>
 */
@JsonpDeserializable
public class Ipinfo implements DatabaseConfigurationFullVariant, DatabaseConfigurationVariant, JsonpSerializable {

	/**
	 * DatabaseConfigurationFull variant kind.
	 */
	@Override
	public DatabaseConfigurationFull.Kind _databaseConfigurationFullKind() {
		return DatabaseConfigurationFull.Kind.Ipinfo;
	}

	/**
	 * DatabaseConfiguration variant kind.
	 */
	@Override
	public DatabaseConfiguration.Kind _databaseConfigurationKind() {
		return DatabaseConfiguration.Kind.Ipinfo;
	}

	public static final class Builder implements ObjectBuilder<Ipinfo> {
		@Override
		public Ipinfo build() {
			return Ipinfo._INSTANCE;
		}
	}

	/**
	 * Serialize this object to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		generator.writeEnd();
	}

	/**
	 * Singleton instance for empty class {@link Ipinfo}.
	 */
	public static final Ipinfo _INSTANCE = new Ipinfo();

	public static final JsonpDeserializer<Ipinfo> _DESERIALIZER = JsonpDeserializer.emptyObject(Ipinfo._INSTANCE);

}
