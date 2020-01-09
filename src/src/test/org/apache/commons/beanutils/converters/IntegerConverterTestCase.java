/*
 * Copyright 2001-2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 

package org.apache.commons.beanutils.converters;

import junit.framework.TestSuite;

import org.apache.commons.beanutils.Converter;


/**
 * Test Case for the IntegerConverter class.
 *
 * @author Rodney Waldhoff
 * @version $Revision: 1.4 $ $Date: 2004/02/28 13:18:37 $
 */

public class IntegerConverterTestCase extends NumberConverterTestBase {

    private Converter converter = null;

    // ------------------------------------------------------------------------

    public IntegerConverterTestCase(String name) {
        super(name);
    }
    
    // ------------------------------------------------------------------------

    public void setUp() throws Exception {
        converter = makeConverter();
    }

    public static TestSuite suite() {
        return new TestSuite(IntegerConverterTestCase.class);        
    }

    public void tearDown() throws Exception {
        converter = null;
    }

    // ------------------------------------------------------------------------
    
    protected Converter makeConverter() {
        return new IntegerConverter();
    }
    
    protected Class getExpectedType() {
        return Integer.class;
    }

    // ------------------------------------------------------------------------

    public void testSimpleConversion() throws Exception {
        String[] message= { 
            "from String",
            "from String",
            "from String",
            "from String",
            "from String",
            "from String",
            "from String",
            "from Byte",
            "from Short",
            "from Integer",
            "from Long",
            "from Float",
            "from Double"
        };
        
        Object[] input = { 
            String.valueOf(Integer.MIN_VALUE),
            "-17",
            "-1",
            "0",
            "1",
            "17",
            String.valueOf(Integer.MAX_VALUE),
            new Byte((byte)7),
            new Short((short)8),
            new Integer(9),
            new Long(10),
            new Float(11.1),
            new Double(12.2)
        };
        
        Integer[] expected = { 
            new Integer(Integer.MIN_VALUE),
            new Integer(-17),
            new Integer(-1),
            new Integer(0),
            new Integer(1),
            new Integer(17),
            new Integer(Integer.MAX_VALUE),
            new Integer(7),
            new Integer(8),
            new Integer(9),
            new Integer(10),
            new Integer(11),
            new Integer(12)
        };
        
        for(int i=0;i<expected.length;i++) {
            assertEquals(message[i] + " to Integer",expected[i],converter.convert(Integer.class,input[i]));
            assertEquals(message[i] + " to int",expected[i],converter.convert(Integer.TYPE,input[i]));
            assertEquals(message[i] + " to null type",expected[i],converter.convert(null,input[i]));
        }
    }
    
}

