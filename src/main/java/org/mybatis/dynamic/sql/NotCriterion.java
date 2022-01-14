/*
 *    Copyright 2016-2022 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.dynamic.sql;

import java.util.Objects;

/**
 * This class represents a criteria group with a NOT.
 *
 * @author Jeff Butler
 * @since 1.4.0
 */
public class NotCriterion extends SqlCriterion {
    private final SqlCriterion initialCriterion;

    private NotCriterion(Builder builder) {
        super(builder);
        initialCriterion = Objects.requireNonNull(builder.initialCriterion);
    }

    public SqlCriterion initialCriterion() {
        return initialCriterion;
    }

    @Override
    public <R> R accept(SqlCriterionVisitor<R> visitor) {
        return visitor.visit(this);
    }

    public static class Builder extends AbstractBuilder<Builder> {
        private SqlCriterion initialCriterion;

        public Builder withInitialCriterion(SqlCriterion initialCriterion) {
            this.initialCriterion = initialCriterion;
            return this;
        }

        public NotCriterion build() {
            return new NotCriterion(this);
        }

        @Override
        protected Builder getThis() {
            return this;
        }
    }
}
