/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.yongchristophertang.engine.web.response;

import com.github.yongchristophertang.engine.web.ResultMatcher;
import org.hamcrest.Matcher;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import static org.hamcrest.CoreMatchers.is;

/**
 * Static, factory methods for {@link ResultMatcher}-based result actions.
 *
 * @author Yong Tang
 * @since 0.4
 */
public abstract class HttpResultMatchers {
    /**
     * Access to http response status assertions.
     */
    public static StatusResultMatchers status() {
        return new StatusResultMatchers();
    }

    /**
     * Access to response body assertions using a <a
     * href="http://goessner.net/articles/JsonPath/">JSONPath</a> expression to
     * inspect a specific subset of the body and a Hamcrest match for asserting
     * the value found at the JSON path.
     *
     * @param expression the JSON path expression
     * @param matcher    a matcher for the value expected at the JSON path
     */
    public static <T> ResultMatcher jsonPath(String expression, Matcher<T> matcher) {
        return new JsonPathResultMatchers(expression).value(matcher);
    }

    /**
     * Inspect a specific subset of the body and compare it with the expected value {@code expected}.
     *
     * @param expression the JSON path expression
     * @param expected expcted value
     */
    public static <T> ResultMatcher jsonPath(String expression, T expected) {
        return jsonPath(expression, is(expected));
    }

    public static ResultMatcher xPath(String expression, String expected)
        throws XPathExpressionException, ParserConfigurationException {
        return new XPathResultMatcher(expression).value(expected);
    }

    /**
     * Access to response body assertions using a <a
     * href="http://goessner.net/articles/JsonPath/">JSONPath</a> expression to
     * inspect a specific subset of the body.
     *
     * @param expression the JSON path expression
     */
    public static JsonPathResultMatchers jsonPath(String expression) {
        return new JsonPathResultMatchers(expression);
    }

    /**
     * Access to http response assertions.
     */
    public static ContentResultMatchers content() {
        return new ContentResultMatchers();
    }
}
