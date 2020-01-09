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
 * Test Case for the ByteConverter class.
 *
 * @author Rodney Waldhoff
 * @version $Revision: 1.4 $ $Date: 2004/02/28 13:18:37 $
 */

public class ByteConverterTestCase extends NumberConverterTestBase {

    private Converter converter = null;

    // ------------------------------------------------------------------------

    public ByteConverterTestCase(String name) {
        super(name);
    }
    
    // ------------------------------------------------------------------------

    public void setUp() throws Exception {
        converter = makeConverter();
    }

    public static TestSuite suite() {
        return new TestSuite(ByteConverterTestCase.class);        
    }

    public void tearDown() throws Exception {
        converter = null;
    }

    // ------------------------------------------------------------------------
    
    protected Converter makeConverter() {
        return new ByteConverter();
    }
    
    protected Class getExpectedType() {
        return Byte.class;
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
            String.valueOf(Byte.MIN_VALUE),
            "-17",
            "-1",
            "0",
            "1",
            "17",
            String.valueOf(Byte.MAX_VALUE),
            new Byte((byte)7),
            new Short((short)8),
            new Integer(9),
            new Long(10),
            new Float(11.1),
            new Double(12.2)
        };
        
        Byte[] expected = { 
            new Byte(Byte.MIN_VALUE),
            new Byte((byte)-17),
            new Byte((byte)-1),
            new Byte((byte)0),
            new Byte((byte)1),
            new Byte((byte)17),
            new Byte(Byte.MAX_VALUE),
            new Byte((byte)7),
            new Byte((byte)8),
            new Byte((byte)9),
            new Byte((byte)10),
            new Byte((byte)11),
            new Byte((byte)12)
        };
        
        for(int i=0;i<expected.length;i++) {
            assertEquals(message[i] + " to Byte",expected[i],converter.convert(Byte.class,input[i]));
            assertEquals(message[i] + " to byte",expected[i],converter.convert(Byte.TYPE,input[i]));
            assertEquals(message[i] + " to null type",expected[i],converter.convert(null,input[i]));
        }
    }
    
}

