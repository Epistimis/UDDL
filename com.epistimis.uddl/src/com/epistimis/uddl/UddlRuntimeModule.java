/*
 * generated by Xtext 2.28.0
 */
package com.epistimis.uddl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;

import com.epistimis.uddl.generator.QueryProcessor;
import com.epistimis.uddl.scoping.IndexUtilities;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class UddlRuntimeModule extends AbstractUddlRuntimeModule {

	/**
	 * Concept taken from org.eclipse.ocl.examples.pivot.tests.PivotTestCase.java
	 * It appears that the idea is to uniquely identify the plugin. So the question is 
	 * "Where should this identifier be?" 
	 * 
	 * It seemed to me that the RuntimeModule is a [Schelling point](https://en.wikipedia.org/wiki/Focal_point_(game_theory))
	 * 
	 * The value should be the package name. If we can dynamically determine this, so much the better.
	 */
	public static final @NonNull String PLUGIN_ID = "com.epistimis.uddl";

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		// TODO Auto-generated method stub
		return UddlQNP.class;
	}

	public Class<? extends IndexUtilities> bindIndexUtilities() {
		return IndexUtilities.class;
	}

	public Class<? extends QueryProcessor> bindQueryProcessor() {
		return QueryProcessor.class;
	}

	public Class<? extends IQualifiedNameConverter> bindIQualifiedNameConverter() {
		return IQualifiedNameConverter.DefaultImpl.class;
	}

	/**
	 * Enable this if there are performance issues with name resolution. And then
	 * look at the strategy to see what should be excluded from the index
	 */
//	public  Class<? extends IDefaultResourceDescriptionStrategy> bindIDefaultResourceDescriptionStrategy() {
//		return UddlResourceDescriptionStrategy.class;
//	}

	// Enable imports by uncommenting this. The default is to import anything visible in a project
	// See section 3.3.1,3.3.2 of the Advanced XText Manual PDF
//	@Override
//	public
//	Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
//		return ImportUriGlobalScopeProvider.class;
//	}

}
