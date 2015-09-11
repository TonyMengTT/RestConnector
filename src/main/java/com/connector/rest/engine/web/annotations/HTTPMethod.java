/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.connector.rest.engine.web.annotations;

import java.lang.annotation.*;

/**
 * Associates the name of a HTTP method with an annotation. A Java method annotated
 * with a runtime annotation that is itself annotated with this annotation will
 * be used to handle HTTP requests of the indicated HTTP method. It is an error
 * for a method to be annotated with more than one annotation that is annotated
 * with {@code HTTPMethod}.
 *
 * @author Paul Sandoz
 * @author Marc Hadley
 * @author Yong Tang
 * @since 0.4
 */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HTTPMethod {

    /**
     * HTTP GET method.
     */
    String GET = "GET";
    /**
     * HTTP POST method.
     */
    String POST = "POST";
    /**
     * HTTP PUT method.
     */
    String PUT = "PUT";
    /**
     * HTTP DELETE method.
     */
    String DELETE = "DELETE";
    /**
     * HTTP HEAD method.
     */
    String HEAD = "HEAD";
    /**
     * HTTP OPTIONS method.
     */
    String OPTIONS = "OPTIONS";
    /**
     * HTTP PATCH method.
     */
    String PATCH = "PATCH";

    /**
     * Specifies the name of a HTTP method. E.g. "GET".
     */
    String value();
}
