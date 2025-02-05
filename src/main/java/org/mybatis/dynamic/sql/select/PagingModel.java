/*
 *    Copyright 2016-2025 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.dynamic.sql.select;

import java.util.Optional;

import org.jspecify.annotations.Nullable;

public class PagingModel {

    private final @Nullable Long limit;
    private final @Nullable Long offset;
    private final @Nullable Long fetchFirstRows;

    private PagingModel(Builder builder) {
        super();
        limit = builder.limit;
        offset = builder.offset;
        fetchFirstRows = builder.fetchFirstRows;
    }

    public Optional<Long> limit() {
        return Optional.ofNullable(limit);
    }

    public Optional<Long> offset() {
        return Optional.ofNullable(offset);
    }

    public Optional<Long> fetchFirstRows() {
        return Optional.ofNullable(fetchFirstRows);
    }

    public static class Builder {
        private @Nullable Long limit;
        private @Nullable Long offset;
        private @Nullable Long fetchFirstRows;

        public Builder withLimit(@Nullable Long limit) {
            this.limit = limit;
            return this;
        }

        public Builder withOffset(@Nullable Long offset) {
            this.offset = offset;
            return this;
        }

        public Builder withFetchFirstRows(@Nullable Long fetchFirstRows) {
            this.fetchFirstRows = fetchFirstRows;
            return this;
        }

        public Optional<PagingModel> build() {
            if (limit == null && offset == null && fetchFirstRows == null) {
                return Optional.empty();
            }

            return Optional.of(new PagingModel(this));
        }
    }
}
