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


package org.apache.commons.beanutils.priv;


/**
 * Interface that is directly implemented by PrivateBean.
 *
 * @author Craig R. McClanahan
 * @version $Revision: 1.6 $ $Date: 2004/02/28 13:18:37 $
 */

public interface PrivateDirect extends PrivateIndirect {


    // ------------------------------------------------------------- Properties


    /**
     * A property accessible via a directly implemented interface.
     */
    String getBar();


    /**
     * A method accessible via a directly implemented interface.
     */
    String methodBar(String in);

}
