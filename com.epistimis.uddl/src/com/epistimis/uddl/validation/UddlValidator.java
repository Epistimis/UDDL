/*
 * generated by Xtext 2.28.0
 */
package com.epistimis.uddl.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;
import org.eclipse.ocl.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.EValidatorRegistrar;

import com.epistimis.uddl.CLPExtractors;
import com.epistimis.uddl.uddl.ConceptualCharacteristic;
import com.epistimis.uddl.uddl.ConceptualEntity;
import com.epistimis.uddl.uddl.LogicalEntity;
import com.epistimis.uddl.uddl.PlatformEntity;
import com.epistimis.uddl.uddl.UddlElement;
import com.epistimis.uddl.uddl.UddlPackage;

/**
 * This class contains custom validation rules.
 *
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class UddlValidator extends AbstractUddlValidator {
	
	static Logger logger = Logger.getLogger(UddlValidator.class);
	//static OCL ocl = OCL.newInstance();

	protected static String ISSUE_CODE_PREFIX = "com.epistimis.uddl.";
	public static String ENTITY_NEEDS_2_ELEMENTS = ISSUE_CODE_PREFIX + "EntityNeeds2Elements";

	static {
		// Per https://help.eclipse.org/latest/index.jsp?topic=%2Forg.eclipse.ocl.doc%2Fhelp%2FPivotThreadSafety.html
		org.eclipse.ocl.pivot.utilities.ValueUtil.initAllStatics();
	}
	public EPackage getPackage() {
		return UddlPackage.eINSTANCE;
	}

	protected void loadAndRegister(EValidatorRegistrar registrar, String resourceAddress) {
		EPackage ePackage = getPackage();
		loadAndRegister(registrar,resourceAddress,ePackage);
	}

	protected void loadAndRegister(EValidatorRegistrar registrar, String resourceAddress, EPackage ePackage) {
		/**
		 * NOTE: AbstractInjectableValidator::register registers 'this' validator for the
		 * entire inheritance hierarchy ( because of the base class implementation of
		 * getEPackages() ). 
		 * 
		 * ?We do something similar here because the OCL could refer to any of the packages in the hierarchy?
		 * 
		 * 
		 * See
		 * https://help.eclipse.org/latest/index.jsp?topic=%2Forg.eclipse.ocl.doc%2Fhelp%2FInstallation.html
		 * for sample code
		 * 
		 * getInputURI replaces that example's URI creation
		 */
		URI oclURI = getInputURI(resourceAddress);
		CompleteOCLEObjectValidator v = new CompleteOCLEObjectValidator(ePackage, oclURI);
		for (EPackage pkg : getEPackages()) {
			registrar.register(pkg, v);
		}
		//registrar.register(ePackage, v);
	}
	protected void loadOCLAndRegister(EValidatorRegistrar registrar, String resourceAddress, EPackage ePackage, @NonNull String pluginId) {
		/**
		 * NOTE: AbstractInjectableValidator::register registers validators for the
		 * entire inheritance hierarchy ( because of the base class implementation of
		 * getEPackages() )
		 * 
		 * This does not do that. Each OCL file is associated with a specific package,
		 * so it need not be registered to others. If there is a need, manually
		 * re-register the OCL file for multiple packages.
		 * 
		 * See
		 * https://help.eclipse.org/latest/index.jsp?topic=%2Forg.eclipse.ocl.doc%2Fhelp%2FInstallation.html
		 * for sample code
		 * 
		 * getInputURI replaces that example's URI creation
		 */
		URI oclURI = getInputURI(resourceAddress, pluginId);
		registrar.register(ePackage, new CompleteOCLEObjectValidator(ePackage, oclURI));
	}

	@Override
	public void register(EValidatorRegistrar registrar) {
		super.register(registrar);


		/**
		 * Registrations here are for OCL we ALWAYS want available.
		 * These provide foundational rules about the UDDL metamodel
		 */	
//		loadOCLAndRegister(registrar, "src/com/epistimis/uddl/constraints/uddl.ocl"					,UddlPackage.eINSTANCE,com.epistimis.uddl.UddlRuntimeModule.PLUGIN_ID);
//		loadOCLAndRegister(registrar, "src/com/epistimis/uddl/constraints/datamodel.ocl"			,UddlPackage.eINSTANCE,com.epistimis.uddl.UddlRuntimeModule.PLUGIN_ID);
//		loadOCLAndRegister(registrar, "src/com/epistimis/uddl/constraints/conceptual.ocl"			,UddlPackage.eINSTANCE,com.epistimis.uddl.UddlRuntimeModule.PLUGIN_ID);
//		loadOCLAndRegister(registrar, "src/com/epistimis/uddl/constraints/logical.ocl"				,UddlPackage.eINSTANCE,com.epistimis.uddl.UddlRuntimeModule.PLUGIN_ID);
//		loadOCLAndRegister(registrar, "src/com/epistimis/uddl/constraints/platform.ocl"				,UddlPackage.eINSTANCE,com.epistimis.uddl.UddlRuntimeModule.PLUGIN_ID);

		/**
		 * These will be automatically loaded as needed by other files
		 */
//		loadOCLAndRegister(registrar, "src/com/epistimis/uddl/constraints/helpers.ocl"				,UddlPackage.eINSTANCE,com.epistimis.uddl.UddlRuntimeModule.PLUGIN_ID);
//		loadOCLAndRegister(registrar, "src/com/epistimis/uddl/constraints/conceptualExtensions.ocl"	,UddlPackage.eINSTANCE,com.epistimis.uddl.UddlRuntimeModule.PLUGIN_ID);
//		loadOCLAndRegister(registrar, "src/com/epistimis/uddl/constraints/logicalExtensions.ocl"	,UddlPackage.eINSTANCE,com.epistimis.uddl.UddlRuntimeModule.PLUGIN_ID);
//		loadOCLAndRegister(registrar, "src/com/epistimis/uddl/constraints/platformExtensions.ocl"	,UddlPackage.eINSTANCE,com.epistimis.uddl.UddlRuntimeModule.PLUGIN_ID);

		// TODO: May want to use this - or not - this should be recreated in the above
//      loadOCLAndRegister(registrar,"src/com/epistimis/uddl/constraints/realizedObservables.ocl"	,UddlPackage.eINSTANCE,com.epistimis.uddl.UddlRuntimeModule.PLUGIN_ID);
		/**
		 * TODO: These don't appear to be having any effect. It could be because we have
		 * no way to invoke the validators created here. Or that they are invoked and
		 * fail silently.  Or is it because they are created by a newly created environmentFactory (i.e., should the 
		 * CompleteOCLEObjectValidator constructor take more parameters?)
		 * 
		 * Commented out to eliminate potential performance problems. These should be loaded and run only 
		 * on command - not here where they get triggered in the editor constantly.
		 */


		// Per https://www.eclipse.org/forums/index.php/t/1092285/, calling this before registering OCL validators
		// may have made thing worse in the past - so call it here - after registration but before use
		OCLstdlib.install();
		
}

	/**
	 * Copied from org.eclipse.ocl.examples.pivot.tests.PivotTestCase.java:
	 * getModelURI See
	 * https://eclipse.googlesource.com/ocl/org.eclipse.ocl/+/refs/heads/master/tests/org.eclipse.ocl.examples.xtext.tests/src/org/eclipse/ocl/examples/pivot/tests/PivotTestCase.java
	 * and
	 * https://eclipse.googlesource.com/ocl/org.eclipse.ocl/+/refs/heads/master/tests/org.eclipse.ocl.examples.xtext.tests/src/org/eclipse/ocl/examples/test/xtext/PivotDocumentationExamples.java
	 * and
	 * https://eclipse.googlesource.com/ocl/org.eclipse.ocl/+/refs/heads/master/tests/org.eclipse.ocl.examples.xtext.tests/models/documentation/parsingDocumentsExample.ocl?autodive=0%2F%2F
	 * 
	 * @param localFileName - relative to the plugin root directory (not the Maven
	 *                      parent directory) - see examples
	 * @return a properly constructed URI
	 */
	protected @NonNull URI getInputURI(@NonNull String localFileName) {
		return getInputURI(localFileName, com.epistimis.uddl.UddlRuntimeModule.PLUGIN_ID);
	}

	/**
	 * Get the URI to file from the specified plugin
	 * @param localFileName The filename (relative to/ inside of) the specified plugin
	 * @param pluginId The ID of the plugin containing the file
	 * @return URI to the desired file
	 */
	protected static @NonNull URI getInputURI(@NonNull String localFileName, @NonNull String pluginId) {
		String plugInPrefix = pluginId + "/";
		URI plugURI = EcorePlugin.IS_ECLIPSE_RUNNING ? URI.createPlatformPluginURI(plugInPrefix, true)
				: URI.createPlatformResourceURI(plugInPrefix, true);
		URI localURI = URI.createURI(localFileName.startsWith("/") ? localFileName.substring(1) : localFileName);
		return localURI.resolve(plugURI);
		// NOTE: See alternative implementation at 
		// https://stackoverflow.com/questions/40086759/how-to-access-the-member-files-and-folders-of-a-plug-in-in-eclipse
		
	}


	protected void augmentRegistry(EPackage.Registry registry) {
		registry.put(UddlPackage.eNS_URI, UddlPackage.eINSTANCE);
	}

	/**
	 * In case we need a minimal registry (standalone runs - where we need to create
	 * the resource set as well) See
	 * https://eclipse.googlesource.com/ocl/org.eclipse.ocl/+/refs/heads/master/tests/org.eclipse.ocl.examples.xtext.tests/src/org/eclipse/ocl/examples/test/xtext/PivotDocumentationExamples.java
	 * 
	 * @return a Package Registry for this package
	 */
	protected EPackage.Registry createMinimalRegistry() {
		EPackage.Registry registry = new EPackageRegistryImpl();
		registry.put(UddlPackage.eNS_URI, UddlPackage.eINSTANCE);
		return registry;
	}

	/**
	 * Structures must have more than 1 member - but they can be inherited - so
	 * check entire specialization hierarchy for: (C/L/P)Entity TODO: Actually,
	 * since participants are for Associations, there must be at least 2
	 * Participants also. Also -must check both composition and participant lists -
	 * The net across all of them must be at least 2
	 */

	@SuppressWarnings("unchecked")
	private static <Entity extends UddlElement, Characteristic, Association extends Entity, Participant extends Characteristic> List<Characteristic> getEntityCharacteristics(
			Entity ent) {

		List<Characteristic> results = new ArrayList<>();
		
		/**
		 * First, check to see if we inherit anything. We do this first because if we later want to override
		 * something inherited, we can.
		 */
		UddlElement spec = CLPExtractors.getSpecializes(ent);
		if ( spec != null) {
			// If this specializes, then recursively get everything from what it specializes
			Entity ce = (Entity) spec;
			results.addAll(getEntityCharacteristics(ce));
		}

		/**
		 * If this is an association, get the participant info next.
		 */
		if (CLPExtractors.isAssociation(ent)) {
			Association ca = (Association) CLPExtractors.conv2Association(ent);
			results.addAll((Collection<? extends Characteristic>) CLPExtractors.getParticipant(ca));
		}

		/**
		 * Now add all the locally defined characteristics
		 */
		results.addAll((Collection<? extends Characteristic>) CLPExtractors.getComposition(ent));

		return results;
	}

	/**
	 * Every entity must have at least 2 characteristics.
	 * @param ent
	 */
	@Check(CheckType.EXPENSIVE)
	public void checkCharacteristicCount(ConceptualEntity ent) {
		List<ConceptualCharacteristic> chars = getEntityCharacteristics(ent);
		if (chars.size() < 2) {
			/**
			 * Since we don't know if this ent has any composition elements declared locally, we just
			 * attach the error to the name attribute
			 */
			error("Entity '" + ent.getName() + "' should have at least 2 characteristics",ent,
					UddlPackage.eINSTANCE.getUddlElement_Name(), ENTITY_NEEDS_2_ELEMENTS, ent.getName());
		}
	}

	/**
	 * Every entity must have at least 2 characteristics.
	 * @param ent
	 */
	@Check(CheckType.EXPENSIVE)
	public void checkCharacteristicCount(LogicalEntity ent) {
		List<ConceptualCharacteristic> chars = getEntityCharacteristics(ent);
		if (chars.size() < 2) {
			/**
			 * Since we don't know if this ent has any composition elements declared locally, we just
			 * attach the error to the name attribute
			 */
			error("Entity '" + ent.getName() + "' should have at least 2 characteristics",ent,
					UddlPackage.eINSTANCE.getUddlElement_Name(), ENTITY_NEEDS_2_ELEMENTS, ent.getName());
		}
	}

	/**
	 * Every entity must have at least 2 characteristics.
	 * @param ent
	 */
	@Check(CheckType.EXPENSIVE)
	public void checkCharacteristicCount(PlatformEntity ent) {
		List<ConceptualCharacteristic> chars = getEntityCharacteristics(ent);
		if (chars.size() < 2) {
			/**
			 * Since we don't know if this ent has any composition elements declared locally, we just
			 * attach the error to the name attribute
			 */
			error("Entity '" + ent.getName() + "' should have at least 2 characteristics",ent,
					UddlPackage.eINSTANCE.getUddlElement_Name(), ENTITY_NEEDS_2_ELEMENTS, ent.getName());
		}
	}
}
