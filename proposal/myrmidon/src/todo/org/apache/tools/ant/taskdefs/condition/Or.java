/*
 * Copyright (C) The Apache Software Foundation. All rights reserved.
 *
 * This software is published under the terms of the Apache Software License
 * version 1.1, a copy of which has been included with this distribution in
 * the LICENSE file.
 */
package org.apache.tools.ant.taskdefs.condition;

import java.util.Iterator;
import java.util.Enumeration;
import org.apache.myrmidon.api.TaskException;

/**
 * &lt;or&gt; condition container. <p>
 *
 * Iterates over all conditions and returns true as soon as one evaluates to
 * true.</p>
 *
 * @author <a href="mailto:stefan.bodewig@epost.de">Stefan Bodewig</a>
 * @version $Revision$
 */
public class Or extends ConditionBase implements Condition
{

    public boolean eval()
        throws TaskException
    {
        Enumeration enum = getConditions();
        while( enum.hasMoreElements() )
        {
            Condition c = (Condition)enum.nextElement();
            if( c.eval() )
            {
                return true;
            }
        }
        return false;
    }

}
