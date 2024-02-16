/*
 * generated by Xtext 2.33.0
 */
/*
 * Copyright (c) 2022 - 2024 Epistimis LLC (http://www.epistimis.com).
 */
package com.epistimis.uddl.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

//import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
//import org.eclipse.xtext.EcoreUtil2;
//import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.eclipse.xtext.scoping.impl.MapBasedScope;

import com.epistimis.uddl.ConceptualEntityProcessor;
import com.epistimis.uddl.LogicalEntityProcessor;
import com.epistimis.uddl.PlatformEntityProcessor;
import com.epistimis.uddl.UddlQNP;
import com.epistimis.uddl.uddl.ConceptualComposition;
import com.epistimis.uddl.uddl.ConceptualEntity;
import com.epistimis.uddl.uddl.LogicalComposition;
//import com.epistimis.uddl.uddl.LogicalComposition;
import com.epistimis.uddl.uddl.LogicalEntity;
import com.epistimis.uddl.uddl.LogicalEnumeratedBase;
import com.epistimis.uddl.uddl.LogicalEnumerationConstraint;
import com.epistimis.uddl.uddl.LogicalValueType;
import com.epistimis.uddl.uddl.LogicalValueTypeUnit;
//import com.epistimis.uddl.uddl.PlatformDataType;
import com.epistimis.uddl.uddl.PlatformEntity;

//import org.eclipse.emf.ecore.resource.Resource;

import com.epistimis.uddl.uddl.UddlPackage;
import com.epistimis.uddl.util.IndexUtilities;
import com.google.common.base.Objects;
import com.google.inject.Inject;

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
public class UddlScopeProvider extends AbstractUddlScopeProvider {

	UddlPackage epackage = UddlPackage.eINSTANCE;
	
	@Inject IndexUtilities ndxUtil;
	@Inject ConceptualEntityProcessor ceProc;
	@Inject LogicalEntityProcessor leProc;
	@Inject PlatformEntityProcessor peProc;
	@Inject UddlQNP qnp;

	@Override
	public IScope getScope(EObject context, EReference reference) {

        if (context instanceof ConceptualEntity
                && reference == UddlPackage.Literals.CONCEPTUAL_ENTITY__SPECIALIZES) {

        	// TODO: This finds everything but works only for leaf names. It breaks FQNs
        	//IScope existingScope = Scopes.scopeFor(ndxUtil.getVisibleObjects(context, UddlPackage.Literals.CONCEPTUAL_ENTITY));
        	IScope entScope = ceProc.entityScope(context);
            // Scope that filters out the context element from the candidates list
            return new FilteringScope(entScope, (e) -> !Objects.equal(e.getEObjectOrProxy(), context));
        }

        if (context instanceof LogicalEntity
                && reference == UddlPackage.Literals.LOGICAL_ENTITY__SPECIALIZES) {
        	
        	// TODO: This finds everything but works only for leaf names. It breaks FQNs
            IScope existingScope = Scopes.scopeFor(ndxUtil.getVisibleObjects(context, UddlPackage.Literals.LOGICAL_ENTITY));
                       
            // Scope that filters out the context element from the candidates list
            return new FilteringScope(existingScope, (e) -> !Objects.equal(e.getEObjectOrProxy(), context));
        }

        if (context instanceof PlatformEntity
                && reference == UddlPackage.Literals.PLATFORM_ENTITY__SPECIALIZES) {

        	// TODO: This finds everything but works only for leaf names. It breaks FQNs
        	IScope existingScope = Scopes.scopeFor(ndxUtil.getVisibleObjects(context, UddlPackage.Literals.PLATFORM_ENTITY));

        	// Scope that filters out the context element from the candidates list
            return new FilteringScope(existingScope, (e) -> !Objects.equal(e.getEObjectOrProxy(), context));
        }


        if (context instanceof LogicalEnumerationConstraint
                && reference == UddlPackage.Literals.LOGICAL_ENUMERATION_CONSTRAINT__ALLOWED_VALUE) {

    		LogicalValueTypeUnit vtu = (LogicalValueTypeUnit)context.eContainer();
    		LogicalValueType vt = vtu.getValueType();
    		List<LogicalEnumeratedBase> candidates = EcoreUtil2.getAllContentsOfType(vt, LogicalEnumeratedBase.class);
    		return Scopes.scopeFor(candidates);

        }
        
        
        // This code does not work - it appears to miss everything in a different resource?
//        if (context instanceof PlatformDataType
//        		&& reference == UddlPackage.Literals.PLATFORM_DATA_TYPE__REALIZES) {
//           	
//        	Iterable<EObject> meas = ndxUtil.getVisibleObjects(context, UddlPackage.Literals.LOGICAL_MEASUREMENT);
//        	Iterable<EObject> maxis = ndxUtil.getVisibleObjects(context, UddlPackage.Literals.LOGICAL_MEASUREMENT_AXIS);
//        	Iterable<EObject> vtu = ndxUtil.getVisibleObjects(context, epackage.getLogicalValueType());
//
//        	IScope existingScope = Scopes.scopeFor(meas,Scopes.scopeFor(vtu,Scopes.scopeFor(maxis,IScope.NULLSCOPE)));
//        	return existingScope;
//
////        	// Scope that filters out the context element from the candidates list
////            return new FilteringScope(existingScope, (e) -> !Objects.equal(e.getEObjectOrProxy(), context));
// 
//        }
        
        
//		if ((context instanceof LogicalComposition) && 
//				(reference == UddlPackage.Literals.LOGICAL_COMPOSITION__REALIZES )) {
//		
//			/**
//			 * Per https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping,
//			 * should be able to use FilteringScope to limit this to only things that will work
//			 */
//			LogicalEntity lentity = (LogicalEntity) context.eContainer();
//			ConceptualEntity centity = lentity.getRealizes();
//			/**
//			 * The individual compositions can only realize compositions from the ConceptualEntity the 
//			 * LogicalEntity realizes. However, Since, ConceptualEntities can specialize, we 
//			 * must shadow if the same rolename shows up in the specialization hierarchy
//			 */			   
////			EList<ConceptualComposition> candidates = ceProc.getComposition(centity);
////			List<IEObjectDescription> descriptions = new ArrayList<>();
////			for (ConceptualComposition cc: candidates) {
////				// TODO This is a horribly inefficient way to get the description for the EObject
////				descriptions.addAll(ndxUtil.searchAllVisibleEObjectDescriptions(cc,cc.eClass(),qnp.getFullyQualifiedName(cc).toString()));
////			}
////			return MapBasedScope.createScope(IScope.NULLSCOPE, descriptions);
//				
//            EObject rootElement = context; // EcoreUtil2.getRootContainer(context);
//            Resource resource = context.eResource();
//            List<ConceptualComposition> candidates = EcoreUtil2.getAllContentsOfType(rootElement, ConceptualComposition.class);
//            IScope existingScope = Scopes.scopeFor(candidates);
//            // Scope that filters out the context element from the candidates list
//            return new FilteringScope(existingScope, (IEObjectDescription description) -> {
//            	EObject instance = description.getEObjectOrProxy();
//    			if (instance.eIsProxy()) {
//    				instance = resource.getEObject(description.getEObjectURI().fragment());
//    			}
//    			return centity.getComposition().contains(instance);
//            });
//
//		}

		//		if (reference == epackage.getPlatformComposition_Realizes()) {
//			PlatformEntity pentity = (PlatformEntity) context.eContainer();
//			LogicalEntity lentity = pentity.getRealizes();
//			return Scopes.scopeFor(lentity.getComposition());
//		}
//		if (reference == epackage.getLogicalParticipant_Realizes()) {
//			LogicalAssociation lassoc = (LogicalAssociation) context.eContainer();
//			ConceptualAssociation cassoc = (ConceptualAssociation) lassoc.getRealizes();
//			return Scopes.scopeFor(cassoc.getParticipant());
//		}
//		if (reference == epackage.getPlatformParticipant_Realizes()) {
//			PlatformAssociation passoc = (PlatformAssociation) context.eContainer();
//			LogicalAssociation lassoc = (LogicalAssociation) passoc.getRealizes();
//			return Scopes.scopeFor(lassoc.getParticipant());
//		}
		// TODO Auto-generated method stub
		return super.getScope(context, reference);
	}
		
}
