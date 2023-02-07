/*
 * generated by Xtext 2.28.0
 */
package com.epistimis.uddl.generator;

import com.epistimis.uddl.UddlStandaloneSetup;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

public class Main {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Aborting: no path to EMF resource provided!");
			return;
		}
		Injector injector = new UddlStandaloneSetup().createInjectorAndDoEMFRegistration();

		// Injector queryInjector = new
		// UddlStandaloneSetup().createInjectorAndDoEMFRegistration();
		Main main = injector.getInstance(Main.class);
		main.runGenerator(args);
	}

	@Inject
	private Provider<ResourceSet> resourceSetProvider;

	@Inject
	private IResourceValidator validator;

	@Inject
	private GeneratorDelegate generator;

	@Inject
	private JavaIoFileSystemAccess fileAccess;

	protected void runGenerator(String[] args) {
		// For all specified files, load them
		ResourceSet set = resourceSetProvider.get();

		// Replace all '.xmi' extensions with '.ecore'
		URI originalURI = URI.createFileURI(args[0]);
		String ext = originalURI.fileExtension().toLowerCase();
		if (ext.equals("xmi")) {
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put( 
					"ecore", new EcoreResourceFactoryImpl()); 
			// This is a metamodel - convert it to ecore
			String destPath = args[0].substring(0,args[0].lastIndexOf('.'))+ ".ecore";
			URI destinationURI = URI.createURI(destPath);
			XMIResource sourceRes = new XMIResourceImpl(originalURI);
			try {
				sourceRes.load(null);
				Resource destRes = set.createResource(destinationURI);
				destRes.getContents().add(sourceRes.getContents().get(0));
				var options = new HashMap<String, Boolean>();
				options.put(XMIResource.OPTION_SCHEMA_LOCATION, true);	

//				fileAccess.setOutputPath("src-gen/");					
//				fsa.generateFile(ROOT_DIR + generateHeaderName(pdtContainer),pdtContainer.compile)
				var ostream = new FileOutputStream(new File(destPath));
				destRes.save(ostream, options);
					

			} catch (Exception excp) {
				System.out.println("Exception: " + excp.getLocalizedMessage());
				excp.printStackTrace();
				return;
			}
			System.out.println("Finished processing " + args[0]);
		}
		
		for (String arg: args) {
			// Load the resource
			//Resource resource = 
					set.getResource(URI.createFileURI(arg), true);
		}

		/**
		 * Validate the resources - since validation depends on resolving cross references, do that first
		 * This should? do most of the work when resolving the first resource - it shouldn't repeat work?
		 */
		for (Resource resource: set.getResources()) {
			EcoreUtil.resolveAll(resource);
			List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
			if (!list.isEmpty()) {
				for (Issue issue : list) {
					System.err.println(issue);
				}
				return;
			}
		}
		/**
		 * Generate for the first resource only - the others were just there to resolve references
		 */
		URI uri = URI.createURI(args[0]);
		Resource res2Gen = set.getResource(uri, false);
		// Configure and start the generator
		fileAccess.setOutputPath("src-gen/");
		GeneratorContext context = new GeneratorContext();
		context.setCancelIndicator(CancelIndicator.NullImpl);
		generator.generate(res2Gen, fileAccess, context);

		System.out.println("Code generation finished.");
	}
}
