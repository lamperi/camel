/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.language.script;

import org.apache.camel.test.junit4.LanguageTestSupport;
import org.junit.Test;

/**
 * @version 
 */
public class PythonLanguageTest extends LanguageTestSupport {

    @Test
    public void testLanguageExpressions() throws Exception {
        // the properties are stored in a set so ordering is not known
        assertExpression("exchange.in.headers", "{foo=abc, bar=123}", "{bar=123, foo=abc}");
        
        assertExpression("exchange.in.body", "<hello id='m123'>world!</hello>");
        assertExpression("exchange.in.headers.get('foo')", "abc");
        assertExpression("request.headers['foo']", "abc");
    }

    protected String getLanguageName() {
        return "jython";
    }
}
