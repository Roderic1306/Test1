/*
 * Copyright (c) 2011 - 2016, Apinauten GmbH
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.apiomat.nativemodule.mymodule;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.apiomat.nativemodule.*;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import com.apiomat.nativemodule.mymodule2.Klasse2;

import com.apiomat.nativemodule.basics.*;
import com.apiomat.nativemodule.mymodule2.*;
import com.apiomat.nativemodule.AuthState;
/**
* Generated class for your Klasse1 data model
*
* DO NOT CHANGE ANY CODE EXCEPT CLASS ANNOTATIONS OR CLASS ATTRIBUTES HERE!
* EVERYTHING ELSE WILL GET OVERWRITTEN!
*
*/
@SuppressWarnings( "unused" )
@Model( moduleName = "MyModule",
    hooksClassNameTransient = "com.apiomat.nativemodule.mymodule.Klasse1HooksTransient", 
    hooksClassNameNonTransient = "com.apiomat.nativemodule.mymodule.Klasse1HooksNonTransient", 
            isTransient = false,    requiredUserRoleCreate=UserRole.User, requiredUserRoleRead=UserRole.User,
    requiredUserRoleWrite=UserRole.Owner, restrictResourceAccess=false,
    allowedRolesCreate={}, allowedRolesRead={},
    allowedRolesWrite={}, allowedRolesGrant={})
public class Klasse1 extends Klasse2
{
    /**
     * Contains the name of the module that this model belongs to
     */
    public static final String MODULE_NAME = "MyModule";
    /**
     * Contains the name of the model
     */
    public static final String MODEL_NAME = "Klasse1";

    /** class specific attributes */
    private com.apiomat.nativemodule.mymodule2.Klasse2 reffd = null;
    /**
     * Protected constructor; to create a new instance, use the createObject() method
     */
    public Klasse1 ()
    {}

    /**
     * Returns the name of the module where this class belongs to
     */
    @Override
    public String getModuleName( )
    {
        return MODULE_NAME;
    }

    /**
     * Returns the name of the model
     */
    @Override
    public String getModelName( )
    {
        return MODEL_NAME;
    }

    public com.apiomat.nativemodule.mymodule2.Klasse2 getReffd()
    { 
        if(this.reffd == null)
        {
            /* do this by reflection to be backward compartible */
            try
            {
                Method m = AbstractClientDataModel.class.getMethod( "loadReference", String.class,  Class.class );
                this.reffd =  ( com.apiomat.nativemodule.mymodule2.Klasse2 ) m.invoke( this, "reffd", com.apiomat.nativemodule.mymodule2.Klasse2.class );
            }
            catch ( NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e )
            {
                 //silently ignored
            }
        }   
        return this.reffd;
    }

    public void postReffd( final com.apiomat.nativemodule.mymodule2.Klasse2 refData )
    {
        addReference( "reffd", refData );
        this.reffd = refData;
    }

    public void removeReffd( final com.apiomat.nativemodule.mymodule2.Klasse2 refData )
    {
        removeReference( "reffd", refData );
        this.reffd = null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void write( final Kryo kryo, final Output output )
    {
        super.write( kryo, output );
            int reffdDepth = kryo.getContext( ).get( "reffdDepth") != null? (int)kryo.getContext( ).get( "reffdDepth") : 0;
        int reffdMaxDepth = (int) kryo.getContext( ).get( "maxDepth");
        kryo.getContext( ).put( "reffdDepth", reffdDepth +1 );

        output.writeBoolean( this.reffd != null && reffdDepth < reffdMaxDepth);
        if( this.reffd != null && reffdDepth < reffdMaxDepth)
        {
            output.writeString( this.reffd.getModuleName( ) );
            output.writeString( this.reffd.getModelName( ) );
            this.reffd.setMethods( this.methods );
            this.reffd.setResourceMethods( this.resourceMethods );
            this.reffd.write( kryo, output );
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void read( final Kryo kryo, final Input input )
    {
        super.read( kryo, input );

        final Request req = (Request)kryo.getContext( ).get( "creq" );
        req.toString( );
            final IStaticMethods AOMreffd = (IStaticMethods)kryo.getContext( ).get( "AOM" );
        if( input.readBoolean() )
        {
            final String reffdModule = input.readString();
            final String reffdClass = input.readString();
            this.reffd = ( com.apiomat.nativemodule.mymodule2.Klasse2 ) AOMreffd.createObject( kryo.getContext( ).get( "appName").toString( ), reffdModule, reffdClass, req);
            this.reffd.read( kryo, input );
        }
    }
}
