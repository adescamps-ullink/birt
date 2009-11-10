/*******************************************************************************
 * Copyright (c) 2004 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.model.adapter.oda.impl;

import org.eclipse.birt.report.model.adapter.oda.impl.ResultSetCriteriaAdapter.DynamicFilter;
import org.eclipse.birt.report.model.api.DynamicFilterParameterHandle;
import org.eclipse.birt.report.model.api.OdaDataSetHandle;
import org.eclipse.birt.report.model.api.activity.SemanticException;
import org.eclipse.datatools.connectivity.oda.design.DataSetDesign;
import org.eclipse.datatools.connectivity.oda.design.ParameterDefinition;

/**
 * Converts values between a report scalar parameter and ODA Design Session
 * Request.
 * 
 */

class DynamicFilterParameterAdapter extends AbstractReportParameterAdapter
{

	/**
	 * The data set handle.
	 */

	private final OdaDataSetHandle setHandle;

	/**
	 * The data set design.
	 */

	private final DataSetDesign setDesign;

	/**
	 * Default constructor.
	 * 
	 * @param setHandle
	 * @param setDesign
	 */

	DynamicFilterParameterAdapter( OdaDataSetHandle setHandle,
			DataSetDesign setDesign )
	{
		this.setHandle = setHandle;
		this.setDesign = setDesign;
	}

	/**
	 * @param paramDefn
	 * @param dynamicParamHandle
	 */
	
	protected void updateODADynamicFilter( ParameterDefinition paramDefn,
			DynamicFilterParameterHandle dynamicParamHandle )
	{
		updateParameterDefinitionFromReportParam( paramDefn,
				dynamicParamHandle, setDesign );
	}

	/**
	 * @param filterConditionHandle
	 * @param dynamicFilter
	 * @param dynamicFilterParamHandle
	 * @throws SemanticException
	 */

	protected void updateROMDynamicFilterParameter(
			DynamicFilter dynamicFilter,
			DynamicFilterParameterHandle dynamicFilterParamHandle )
			throws SemanticException
	{
		updateAbstractScalarParameter( dynamicFilterParamHandle,
				dynamicFilter.exprParamDefn.getDynamicInputParameter( ), null,
				setHandle );
	}
}