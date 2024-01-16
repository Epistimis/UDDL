/*
 * generated by Xtext 2.33.0
 */
/*
 * Copyright (c) 2022 - 2024 Epistimis LLC (http://www.epistimis.com).
 */
package com.epistimis.uddl.ui.contentassist;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

import com.epistimis.uddl.CLRealizationProcessor;
import com.epistimis.uddl.ConceptualEntityProcessor;
import com.epistimis.uddl.LPRealizationProcessor;
import com.epistimis.uddl.LogicalEntityProcessor;
import com.epistimis.uddl.PlatformEntityProcessor;
import com.epistimis.uddl.UddlQNP;
import com.epistimis.uddl.uddl.ConceptualAssociation;
import com.epistimis.uddl.uddl.ConceptualComposition;
import com.epistimis.uddl.uddl.ConceptualParticipant;
import com.epistimis.uddl.uddl.LogicalComposition;
import com.epistimis.uddl.uddl.LogicalEntity;
import com.epistimis.uddl.uddl.PlatformComposition;
import com.epistimis.uddl.uddl.PlatformEntity;
import com.google.inject.Inject;

/**
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist
 * on how to customize the content assistant.
 */
public class UddlProposalProvider extends AbstractUddlProposalProvider {

	@Inject UddlQNP 					qnp;
	@Inject	IScopeProvider 				sp;
	@Inject ConceptualEntityProcessor 	ceProc;
	@Inject LogicalEntityProcessor 		leProc;
	@Inject PlatformEntityProcessor 	peProc;
	@Inject CLRealizationProcessor		clrproc;
	@Inject LPRealizationProcessor		lprproc;
	
	private static String componentFormatString = " %s[%d:%d] \"%s\" -> %s;\n";
	private static String dummyType 			= "__ReplaceMe__";
	private static String defaultComment 		= "// Replace " + dummyType + " with the LogicalComposableElement type for each composition\n";
	private static String proposalPrefix 		= "(Default) ";
	private static String proposalSuffix 		= "";
	private static String realizeAll 			= "<<Default Realize All>>";
	private static String realizeRemaining 		= "<<Default Realize Remaining>>";

	 
	protected <T extends EObject,U extends EObject> QualifiedName relativeQualifiedName(T obj, U ctx) {
		return qnp.relativeQualifiedName(obj, ctx);
	}

//	/**
//	 * Get all the Compositions from this Entity - TODO: Make this part of
//	 * CLPExtractors
//	 * 
//	 * @param centity
//	 * @return
//	 */
//	protected List<ConceptualComposition> getCCsFromSpecialization(ConceptualEntity centity) {
//		ConceptualEntity curCE = centity;
//		EList<ConceptualComposition> ccs = curCE.getComposition();
//		while (curCE.getSpecializes() != null) {
//			curCE = curCE.getSpecializes();
//			ccs.addAll(curCE.getComposition());
//		}
//		return ccs;
//	}

//	protected List<ConceptualParticipant> getCPsFromSpecialization(ConceptualEntity centity) {
//		ConceptualEntity curCE = centity;
//		List<ConceptualParticipant> cps = new ArrayList<ConceptualParticipant>();
//		if (curCE instanceof ConceptualAssociation) {
//			ConceptualAssociation ca = (ConceptualAssociation) curCE;
//			cps.addAll(ca.getParticipant());
//		}
//		while (curCE.getSpecializes() != null) {
//			curCE = curCE.getSpecializes();
//			if (curCE instanceof ConceptualAssociation) {
//				ConceptualAssociation ca = (ConceptualAssociation) curCE;
//				cps.addAll(ca.getParticipant());
//			}
//		}
//		return cps;
//	}

	/** Logical -> Conceptual */
	
	// TODO: Before enabling this code, we must change how these references are parsed. They should
	// be parsed to match the RIG
//	@Override
//	public void completeConceptualCharacteristicPathNode_ProjectedCharacteristic(EObject obj, Assignment assignment,
//			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
//		EObject container = obj.eContainer();
//		// Start with the prior path node or, if this is the first one, the participant
//		// type as the anchor.
//		// list all the characteristic rolenames for the type
//		if (container instanceof ConceptualParticipant) {
//			// This is the first path node
//			ConceptualParticipant cp = (ConceptualParticipant) container;
//			ConceptualEntity type = cp.getType();
//			for (ConceptualComposition cc : getCCsFromSpecialization(type)) {
//				acceptor.accept(createCompletionProposal(qnp.relativeQualifiedName(cc, container).toString(),
//						cc.getRolename(), null, context));
//			}
//		}
//		if (container instanceof ConceptualParticipantPathNode) {
//			// This is not the first thing in the path - get context from the prior node
//			ConceptualParticipantPathNode cpn = (ConceptualParticipantPathNode) container;
//			ConceptualEntity type = cpn.getProjectedParticipant().getType();
//			for (ConceptualComposition cc : getCCsFromSpecialization(type)) {
//				acceptor.accept(createCompletionProposal(qnp.relativeQualifiedName(cc, container).toString(),
//						cc.getRolename(), null, context));
//			}
//		}
//		if (container instanceof ConceptualCharacteristicPathNode) {
//			// This is not the first thing in the path - get context from the prior node
//			ConceptualCharacteristicPathNode cpn = (ConceptualCharacteristicPathNode) container;
//			ConceptualCharacteristic cchar = cpn.getProjectedCharacteristic();
//
//			if (cchar instanceof ConceptualComposition) {
//				ConceptualComposableElement cce = ((ConceptualComposition) cchar).getType();
//				if (cce instanceof ConceptualEntity) {
//					ConceptualEntity ce = (ConceptualEntity) cce;
//					for (ConceptualComposition cc : getCCsFromSpecialization(ce)) {
//						acceptor.accept(createCompletionProposal(qnp.relativeQualifiedName(cc, container).toString(),
//								cc.getRolename(), null, context));
//					}
//				}
//				// NOTE: We ignore ConceptualObservables because there is no further path
//				// We include ConceptualAssociations because we may want to forward navigate
//				// through a participant (just like we do through a composition)
//				if (cce instanceof ConceptualAssociation) {
//					ConceptualAssociation ca = (ConceptualAssociation) cce;
//					for (ConceptualParticipant cc : ceProc.allParticipants(ca).values()) {
//						acceptor.accept(createCompletionProposal(qnp.relativeQualifiedName(cc, container).toString(),
//								cc.getRolename(), null, context));
//					}
//				}
//			}
//		}
//	}

	protected void processParticipant(ConceptualParticipant cp, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		ConceptualAssociation ca = (ConceptualAssociation)cp.eContainer();
		for (ConceptualParticipant cc: ceProc.allParticipants(ca).values()) {
			if (cc.getType().equals(cp.getType())) {
				acceptor.accept(createCompletionProposal(qnp.relativeQualifiedName(cc,cp).toString(),cc.getRolename(),null,context));					
			}
		}		
		
	}
//	/**
//	 * The set of choices for a projectedParticipant are all of the
//	 * assoc/participant combos where the participant type is the same as the
//	 * current entity. This is because we want to move from this entity back to
//	 * the assoc - so it has to be an assoc that could forward navigate to this
//	 * entity. We can only reverse navigate via participants, so we ignore compositions
//	 * that have this type. TODO: Is that right?
//	 */
//	@Override
//	public void completeConceptualParticipantPathNode_ProjectedParticipant(EObject obj, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
//		EObject container = obj.eContainer();
//		// Start with the prior path node or, if this is the first one, the participant type as the anchor.
//		// list all the characteristic rolenames for the type
//		if (container instanceof ConceptualParticipant) {
//			// This is the first path node - so go to the containing association and find all participants
//			// that match the type of this participant
//			ConceptualParticipant cp = (ConceptualParticipant)container;
//			processParticipant(cp,assignment,context, acceptor);
//		}
//		if (container instanceof ConceptualParticipantPathNode) {
//			// This is not the first thing in the path - get context from the prior node
//			ConceptualParticipantPathNode cpn = (ConceptualParticipantPathNode)container;
//			ConceptualEntity type = cpn.getProjectedParticipant().getType();
//			for (ConceptualParticipant cp: ceProc.allParticipants(type).values()) {
//				processParticipant(cp,assignment,context,acceptor);
//			}
//		}
//		if (container instanceof ConceptualCharacteristicPathNode) {
//			// This is not the first thing in the path - get context from the prior node
//			ConceptualCharacteristicPathNode cpn = (ConceptualCharacteristicPathNode)container;
//			ConceptualCharacteristic cchar  = cpn.getProjectedCharacteristic();
//			
//			if (cchar instanceof ConceptualComposition) {
//				ConceptualComposableElement cce  = ((ConceptualComposition)cchar).getType();
//				if (cce instanceof ConceptualAssociation) {
//					ConceptualAssociation ce = (ConceptualAssociation)cce;
//					for (ConceptualParticipant cp: ceProc.allParticipants(ce).values()) {
//						processParticipant(cp,assignment,context,acceptor);
//					}				
//				}
//				// NOTE: We ignore ConceptualObservables because there is no further path
//			}
//		}
//	}

	@Override
	public void complete_LogicalComposition(EObject obj, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Get all the standard stuff first
		super.complete_LogicalComposition(obj, ruleCall, context, acceptor);
		LogicalEntity lentity = (LogicalEntity) obj;

		// Now add customization here
		// When doing this, propose that all ConceptualCompositions be realized - but
		// only those that
		List<ConceptualComposition> realized = clrproc.getRealizedCompositions(lentity);
		Collection<ConceptualComposition> unrealized = clrproc.getUnrealizedCompositions(lentity);
		List<ConceptualParticipant> realizedParticipants = clrproc.getRealizedParticipants(lentity);
		Collection<ConceptualParticipant> unrealizedParticipants = clrproc.getUnrealizedParticipants(lentity);
		
		String result = defaultComment;
		for (ConceptualComposition cc : unrealized) {
				// If this one isn't already realized, then add it to the proposal
				String oneRealizedCC = String.format(dummyType + componentFormatString, cc.getRolename(),
						cc.getLowerBound(), cc.getUpperBound(), cc.getDescription(),
						qnp.getFullyQualifiedName(cc).toString());
				acceptor.accept(createCompletionProposal(oneRealizedCC,
						proposalPrefix + cc.getRolename() + proposalSuffix, null, context));
				result += oneRealizedCC;		
		}
		 if (!unrealizedParticipants.isEmpty()) {
			 result += "\n participants: [";
			 
			 for (ConceptualParticipant cp: unrealizedParticipants) {
					// If this one isn't already realized, then add it to the proposal
					String oneRealizedCP = String.format(dummyType + componentFormatString, cp.getRolename(),
							cp.getLowerBound(), cp.getUpperBound(), cp.getDescription(),
							qnp.getFullyQualifiedName(cp).toString());
					acceptor.accept(createCompletionProposal(oneRealizedCP,
							proposalPrefix + cp.getRolename() + proposalSuffix, null, context));
					result += oneRealizedCP;						 
			 }
			 result += "]";
		 }
		/**
		 * Only do the "all" if nothing has been done yet
		 */
		if (realized.isEmpty() && realizedParticipants.isEmpty()) {
			acceptor.accept(createCompletionProposal(result, realizeAll, null, context));
		}
		else if (!unrealized.isEmpty() || !unrealizedParticipants.isEmpty()) {
			acceptor.accept(createCompletionProposal(result, realizeRemaining, null, context));
		}

//		// Now add customization here
//		// When doing this, propose that all ConceptualCompositions be realized - but
//		// only those that
//		List<ConceptualComposition> realizedCCs = clrproc.getRealizedCompositions(lentity);
//		ConceptualEntity centity = lentity.getRealizes();
//		if (centity != null) {
//			String result = defaultComment;
//			EList<ConceptualComposition> ccs = centity.getComposition();
//			for (ConceptualComposition cc : ccs) {
//				if (!realizedCCs.contains(cc)) {
//					// If this one isn't already realized, then add it to the proposal
//					String oneRealizedCC = String.format(dummyType + componentFormatString, cc.getRolename(),
//							cc.getLowerBound(), cc.getUpperBound(), cc.getDescription(),
//							qnp.getFullyQualifiedName(cc).toString());
//					acceptor.accept(createCompletionProposal(oneRealizedCC,
//							proposalPrefix + cc.getRolename() + proposalSuffix, null, context));
//					result += oneRealizedCC;
//				}
//			}
//			/**
//			 * Only do the "all" if nothing has been done yet
//			 */
//			if (realizedCCs.isEmpty()) {
//				acceptor.accept(createCompletionProposal(result, realizeAll, null, context));
//			}
//		}
	}

	@Override
	public void completeLogicalComposition_Rolename(EObject obj, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		super.completeLogicalComposition_Rolename(obj, assignment, context, acceptor);

		// Pick out the roles from the list of unrealized ConceptualCompositions
		LogicalEntity lentity = (LogicalEntity) obj.eContainer();
		for (ConceptualComposition cc : clrproc.getUnrealizedCompositions(lentity)) {
				// If this one isn't already realized, then add it to the proposal
				String oneRealizedCC = String.format(componentFormatString, cc.getRolename(), cc.getLowerBound(),
						cc.getUpperBound(), cc.getDescription(), qnp.getFullyQualifiedName(cc).toString());
				acceptor.accept(createCompletionProposal(oneRealizedCC,
						proposalPrefix + cc.getRolename() + proposalSuffix, null, context));
		}
		
		
		
//		List<ConceptualComposition> realizedCCs = clrproc.getRealizedCompositions(lentity);
//		ConceptualEntity centity = lentity.getRealizes();
//		if (centity != null) {
//			EList<ConceptualComposition> ccs = centity.getComposition();
//			for (ConceptualComposition cc : ccs) {
//				if (!realizedCCs.contains(cc)) {
//					// If this one isn't already realized, then add it to the proposal
//					String oneRealizedCC = String.format(componentFormatString, cc.getRolename(), cc.getLowerBound(),
//							cc.getUpperBound(), cc.getDescription(), qnp.getFullyQualifiedName(cc).toString());
//					acceptor.accept(createCompletionProposal(oneRealizedCC,
//							proposalPrefix + cc.getRolename() + proposalSuffix, null, context));
//				}
//			}
//		}
	}

	@Override
	public void completeLogicalComposition_Realizes(EObject obj, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		LogicalEntity lentity = (LogicalEntity) obj.eContainer();

		for (ConceptualComposition c : clrproc.getUnrealizedCompositions(lentity)) {
				acceptor.accept(createCompletionProposal(qnp.getFullyQualifiedName(c).toString(),
						proposalPrefix + c.getRolename() + proposalSuffix, null, context));
		}
		
//		List<ConceptualComposition> realizedCCs = clrproc.getRealizedCompositions(lentity);
//		ConceptualEntity centity = lentity.getRealizes();
//		for (ConceptualComposition c : centity.getComposition()) {
//			if (!realizedCCs.contains(c)) {
//				acceptor.accept(createCompletionProposal(qnp.getFullyQualifiedName(c).toString(),
//						proposalPrefix + c.getRolename() + proposalSuffix, null, context));
//			}
//		}
	}

	/** Platform -> Logical */
	@Override
	public void complete_PlatformComposition(EObject obj, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Get all the standard stuff first
		super.complete_PlatformComposition(obj, ruleCall, context, acceptor);
		// Now add customization here
		// When doing this, propose that all ConceptualCompositions be realized - but
		// only those that
		PlatformEntity pentity = (PlatformEntity) obj;
		List<LogicalComposition> realized = lprproc.getRealizedCompositions(pentity);
		Collection<LogicalComposition> unrealized = lprproc.getUnrealizedCompositions(pentity);

		String result = defaultComment;
		for (LogicalComposition cc : unrealized) {
				// If this one isn't already realized, then add it to the proposal
				String oneRealizedCC = String.format(dummyType + componentFormatString, cc.getRolename(),
						cc.getLowerBound(), cc.getUpperBound(), cc.getDescription(),
						qnp.getFullyQualifiedName(cc).toString());
				acceptor.accept(createCompletionProposal(oneRealizedCC,
						proposalPrefix + cc.getRolename() + proposalSuffix, null, context));
				result += oneRealizedCC;		
		}
		/**
		 * Only do the "all" if nothing has been done yet
		 */
		if (realized.isEmpty()) {
			acceptor.accept(createCompletionProposal(result, realizeAll, null, context));
		}
		else if (!unrealized.isEmpty()) {
			acceptor.accept(createCompletionProposal(result, realizeRemaining, null, context));
		}
		
//		List<LogicalComposition> realizedCCs = lprproc.getRealizedCompositions(pentity);
//		LogicalEntity lentity = pentity.getRealizes();
//		if (lentity != null) {
//			String result = defaultComment;
//			EList<LogicalComposition> ccs = lentity.getComposition();
//			for (LogicalComposition cc : ccs) {
//				if (!realizedCCs.contains(cc)) {
//					// If this one isn't already realized, then add it to the proposal
//					String oneRealizedCC = String.format(dummyType + componentFormatString, cc.getRolename(),
//							cc.getLowerBound(), cc.getUpperBound(), cc.getDescription(),
//							qnp.getFullyQualifiedName(cc).toString());
//					acceptor.accept(createCompletionProposal(oneRealizedCC,
//							proposalPrefix + cc.getRolename() + proposalSuffix, null, context));
//					result += oneRealizedCC;
//				}
//			}
//			/**
//			 * Only do the "all" if nothing has been done yet
//			 */
//			if (realizedCCs.isEmpty()) {
//				acceptor.accept(createCompletionProposal(result, realizeAll, null, context));
//			}
//		}
	}

	@Override
	public void completePlatformComposition_Rolename(EObject obj, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		super.completeLogicalComposition_Rolename(obj, assignment, context, acceptor);

		// Pick out the roles from the list of unrealized ConceptualCompositions
		PlatformEntity pentity = (PlatformEntity) obj.eContainer();

		for (LogicalComposition cc : lprproc.getUnrealizedCompositions(pentity)) {
			// If this one isn't already realized, then add it to the proposal
			String oneRealizedCC = String.format(componentFormatString, cc.getRolename(), cc.getLowerBound(),
					cc.getUpperBound(), cc.getDescription(), qnp.getFullyQualifiedName(cc).toString());
			acceptor.accept(createCompletionProposal(oneRealizedCC,
					proposalPrefix + cc.getRolename() + proposalSuffix, null, context));
	}
		
		
		
//		List<LogicalComposition> realizedCCs = lprproc.getRealizedCompositions(pentity);
//		LogicalEntity lentity = pentity.getRealizes();
//		if (lentity != null) {
//			EList<LogicalComposition> ccs = lentity.getComposition();
//			for (LogicalComposition cc : ccs) {
//				if (!realizedCCs.contains(cc)) {
//					// If this one isn't already realized, then add it to the proposal
//					String oneRealizedCC = String.format(componentFormatString, cc.getRolename(), cc.getLowerBound(),
//							cc.getUpperBound(), cc.getDescription(), qnp.getFullyQualifiedName(cc).toString());
//					acceptor.accept(createCompletionProposal(oneRealizedCC,
//							proposalPrefix + cc.getRolename() + proposalSuffix, null, context));
//				}
//			}
//		}
	}

	@Override
	public void completePlatformComposition_Realizes(EObject obj, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		PlatformEntity pentity = (PlatformEntity) obj.eContainer();
		for (LogicalComposition c : lprproc.getUnrealizedCompositions(pentity)) {
			acceptor.accept(createCompletionProposal(qnp.getFullyQualifiedName(c).toString(),
					proposalPrefix + c.getRolename() + proposalSuffix, null, context));
		}

		
//		List<LogicalComposition> realizedCCs = lprproc.getRealizedCompositions(pentity);
//		LogicalEntity lentity = pentity.getRealizes();
//		for (LogicalComposition c : lentity.getComposition()) {
//			if (!realizedCCs.contains(c)) {
//				acceptor.accept(createCompletionProposal(qnp.getFullyQualifiedName(c).toString(),
//						proposalPrefix + c.getRolename() + proposalSuffix, null, context));
//			}
//		}
	}
}
