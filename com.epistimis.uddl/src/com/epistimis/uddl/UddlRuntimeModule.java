/*
 * generated by Xtext 2.33.0
 */
/*
 * Copyright (c) 2022 - 2024 Epistimis LLC (http://www.epistimis.com).
 */
package com.epistimis.uddl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
//import org.eclipse.xtext.scoping.IGlobalScopeProvider;

import com.epistimis.uddl.extension.ConceptualComposableElementExt;
import com.epistimis.uddl.extension.ConceptualEntityExt;
import com.epistimis.uddl.extension.ConceptualObservableExt;
import com.epistimis.uddl.extension.UddlElementExt;
import com.epistimis.uddl.scoping.IndexUtilities;
//import com.epistimis.uddl.scoping.UddlGlobalScopeProvider;
import com.epistimis.uddl.scoping.UddlResourceDescriptionStrategy;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
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

	/**
	 * Enable this if there are performance issues with name resolution. And then
	 * look at the strategy to see what should be excluded from the index
	 */
	public  Class<? extends IDefaultResourceDescriptionStrategy> bindIDefaultResourceDescriptionStrategy() {
		return UddlResourceDescriptionStrategy.class;
	}

//	// Enable imports by uncommenting this. The default is to import anything visible in a project
//	// See section 3.3.1,3.3.2 of the Advanced XText Manual PDF 
//	// or https://blogs.itemis.com/en/in-five-minutes-to-transitive-imports-within-a-dsl-with-xtext
//	@Override
//	public
//	Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
//		return UddlGlobalScopeProvider.class;
//	}
	
	public Class<? extends IQualifiedNameConverter> bindIQualifiedNameConverter() {
		return IQualifiedNameConverter.DefaultImpl.class;
	}

    public Class<? extends IValueConverterService> bindIValueConverterService() {
        return UddlValueConverters.class ;
    }
	
	/** 
	 * Inject this if you want the additional methods provided by this QNP
	 * @return
	 */
	public Class<? extends UddlQNP> bindIUddlQNP() {
		// TODO Auto-generated method stub
		return UddlQNP.class;
	}

	public Class<? extends IndexUtilities> bindIndexUtilities() {
		return IndexUtilities.class;
	}
	public Class<? extends ModelFilters> bindModelFilters() {
		return ModelFilters.class;
	}

	
	// ------------- Entity processing

	public Class<? extends com.epistimis.uddl.CLPExtractors> bindCLPExtractors() {
		return CLPExtractors.class;
	}
	
	public Class<? extends ConceptualQueryProcessor> bindConceptualQueryProcessor() {
		return ConceptualQueryProcessor.class;
	}
	public Class<? extends LogicalQueryProcessor> bindLogicalQueryProcessor() {
		return LogicalQueryProcessor.class;
	}
	public Class<? extends PlatformQueryProcessor> bindPlatformQueryProcessor() {
		return PlatformQueryProcessor.class;
	}

	// ----------- Taxonomy processors
	public Class<? extends com.epistimis.uddl.LogicalEnumeratedProcessor> bindLogicalEnumeratedProcessor() {
		return LogicalEnumeratedProcessor.class;
	}
	public Class<? extends com.epistimis.uddl.TaxonomyBaseProcessor> bindTaxonomyBaseProcessor() {
		return TaxonomyBaseProcessor.class;
	}
	

	// ----------- Extension classes
	public Class<? extends com.epistimis.uddl.extension.UddlElementExt> bindUddlElementExt() {
		return UddlElementExt.class;
	}
	public Class<? extends com.epistimis.uddl.extension.ConceptualComposableElementExt> bindConceptualComposableElementExt() {
		return ConceptualComposableElementExt.class;
	}
	public Class<? extends com.epistimis.uddl.extension.ConceptualObservableExt> bindConceptualObservableExt() {
		return ConceptualObservableExt.class;
	}
	public Class<? extends com.epistimis.uddl.extension.ConceptualEntityExt> bindConceptualEntityExt() {
		return ConceptualEntityExt.class;
	}
	
}
