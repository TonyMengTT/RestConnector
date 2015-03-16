/*
 *
 *  * Copyright 2014-2015 the original author or authors.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.github.connector.test.web.request;

import com.github.connector.test.web.http.BodyFormBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;

import java.net.URISyntaxException;

/**
 * Created by YongTang on 2015/3/9.
 *
 * @author Yong Tang
 * @since 0.4
 */
public class HttpMultipartRequestBuilders extends HttpRequestBuilders {
    private HttpEntity httpEntity;

    /**
     * Package private constructor. To get an instance, use static factory
     * methods in {@link com.github.connector.test.web.request.TestRequestBuilders}.
     * <p>
     * <p>Although this class cannot be extended, additional ways to initialize
     * the {@code MockHttpServletRequest} can be plugged in via
     * {@link #with(RequestPostProcessor)}.
     *
     * @param httpRequest
     * @param urlTemplate  a URL template; the resulting URL will be encoded
     * @param urlVariables zero or more URL variables
     */
    HttpMultipartRequestBuilders(HttpRequestBase httpRequest, String urlTemplate,
            Object... urlVariables) {
        super(httpRequest, urlTemplate, urlVariables);
    }

    @Override
    public HttpRequestBase buildRequest() throws URISyntaxException {
        HttpEntityEnclosingRequestBase requestBase = (HttpEntityEnclosingRequestBase) super.buildRequest();
        requestBase.setEntity(httpEntity);
        return requestBase;
    }

    /**
     * Set the multipart body
     *
     * @param bodyFormBuilder factory builder for {@link com.github.connector.test.web.http.BodyForm}
     */
    public HttpRequestBuilders body(BodyFormBuilder bodyFormBuilder) {
        this.httpEntity = bodyFormBuilder.buildBody().getHttpEntity();
        return this;
    }

}