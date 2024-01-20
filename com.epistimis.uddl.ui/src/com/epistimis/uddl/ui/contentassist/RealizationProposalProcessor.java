/**
 * 
 */
package com.epistimis.uddl.ui.contentassist;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

import com.epistimis.uddl.EntityProcessor;
import com.epistimis.uddl.RealizationProcessor;
import com.epistimis.uddl.uddl.UddlElement;
import com.google.inject.Inject;

/**
 * 
 */
abstract class RealizationProposalProcessor<
		BaseEntity extends EObject, RealizingEntity extends UddlElement, 
		BaseCharacteristic extends EObject, RealizingCharacteristic extends EObject, 
		BaseComposition extends BaseCharacteristic, RealizingComposition extends RealizingCharacteristic, 
		BaseParticipant extends BaseCharacteristic, RealizingParticipant extends RealizingCharacteristic, 
		BaseAssociation extends BaseEntity, RealizingAssociation extends RealizingEntity,
		RezProcessor extends RealizationProcessor<BaseEntity, RealizingEntity, BaseCharacteristic, RealizingCharacteristic, BaseComposition, RealizingComposition, BaseParticipant, RealizingParticipant, BaseAssociation, RealizingAssociation, BaseProcessor, RealizingProcessor>,
		BaseProcessor extends EntityProcessor<?, BaseCharacteristic, BaseEntity, BaseAssociation, BaseComposition, BaseParticipant, ?, ?>, 
		RealizingProcessor extends EntityProcessor<?, RealizingCharacteristic, RealizingEntity, RealizingAssociation, RealizingComposition, RealizingParticipant, ?, ?>> 
{

	protected static String compositionFormatString = " %s[%d:%d] \"%s\" -> %s;\n";
	protected static String participantFormatString = " %s[%d:%d] \"%s\" -> %s { source: [ %s : %d ] };\n";
	protected static String dummyType 			= "__ReplaceMe__";
	protected static String defaultComment 		= "// Replace " + dummyType + " with the ComposableElement type for each composition\n";
	protected static String proposalPrefix 		= "(Default) ";
	protected static String proposalSuffix 		= "";
	protected static String realizeAll 			= "<<Default Realize All>>";
	protected static String realizeRemaining 	= "<<Default Realize Remaining>>";
	
	@Inject IQualifiedNameProvider qnp;
		
	abstract protected void completeSuperRealizingComposition(UddlProposalProvider pp, EObject obj, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) ;
	abstract protected void completeSuperRealizingComposition_Rolename(UddlProposalProvider pp, EObject obj, Assignment assignment,ContentAssistContext context, ICompletionProposalAcceptor acceptor) ;

	abstract protected String proposalDisplayString(BaseCharacteristic bc);
	abstract protected String compositionInsertionString(BaseComposition bc);
	abstract protected String participantInsertionString(BaseParticipant bc);

	/**
	 * Get the type parameters for this generic class See also
	 * https://stackoverflow.com/questions/4213972/java-generics-get-class-of-generic-methods-return-type
	 * 
	 * @param ndx the index into the list of type parameters
	 * @return
	 */
	public Class<?> returnedTypeParameter(int ndx) {
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		return (Class<?>) parameterizedType.getActualTypeArguments()[ndx];
	}

	/**
	 * Methods to return each of the parameter types - these warnings must remain
	 * because the alternative is a compile error when these values get used.
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Class getBaseEntityType() {
		return returnedTypeParameter(0);
	}

	@SuppressWarnings("rawtypes")
	public Class getRealizingEntityType() {
		return returnedTypeParameter(1);
	}

	@SuppressWarnings("rawtypes")
	public Class getBaseCharacteristicType() {
		return returnedTypeParameter(2);
	}

	@SuppressWarnings("rawtypes")
	public Class getRealizingCharacteristicType() {
		return returnedTypeParameter(3);
	}

	@SuppressWarnings("rawtypes")
	public Class getBaseCompositionType() {
		return returnedTypeParameter(4);
	}

	@SuppressWarnings("rawtypes")
	public Class getRealizingCompositionType() {
		return returnedTypeParameter(5);
	}

	@SuppressWarnings("rawtypes")
	public Class getBaseParticipantType() {
		return returnedTypeParameter(6);
	}

	@SuppressWarnings("rawtypes")
	public Class getRealizingParticipantType() {
		return returnedTypeParameter(7);
	}
	
	@SuppressWarnings("rawtypes")
	public Class getBaseAssociationType() {
		return returnedTypeParameter(8);
	}

	@SuppressWarnings("rawtypes")
	public Class getRealizingAssociationType() {
		return returnedTypeParameter(9);
	}
	@SuppressWarnings("rawtypes")
	public Class getRezProcessorType() {
		return returnedTypeParameter(10);
	}
	@SuppressWarnings("rawtypes")
	public Class getBaseProcessorType() {
		return returnedTypeParameter(11);
	}
	@SuppressWarnings("rawtypes")
	public Class getRealizingProcessorType() {
		return returnedTypeParameter(12);
	}
	
	
	public void complete_Composition(UddlProposalProvider pp,RezProcessor rproc,
			RealizingEntity rentity, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		// Get all the standard stuff first
		completeSuperRealizingComposition(pp, rentity, ruleCall, context, acceptor);

		// Now add customization here
		// When doing this, propose that all ConceptualCompositions be realized - but
		// only those that
		List<BaseComposition> realized = rproc.getRealizedCompositions(rentity);
		Collection<BaseComposition> unrealized = rproc.getUnrealizedCompositions(rentity);
		List<BaseParticipant> realizedParticipants = rproc.getRealizedParticipants(rentity);
		Collection<BaseParticipant> unrealizedParticipants = rproc.getUnrealizedParticipants(rentity);
		
		String result = defaultComment;
		for (BaseComposition cc : unrealized) {
				// If this one isn't already realized, then add it to the proposal
				String oneRealizedCC = compositionInsertionString(cc) ;
				String displayString = proposalDisplayString(cc);
				acceptor.accept(pp.createCompletionProposal(oneRealizedCC, displayString,null, context));
				result += oneRealizedCC;		
		}
		 if (!unrealizedParticipants.isEmpty()) {
			 result += "\n participants: [";
			 
			 for (BaseParticipant cp: unrealizedParticipants) {
					// If this one isn't already realized, then add it to the proposal
					String oneRealizedCP = participantInsertionString(cp); 
					String proposalString = proposalDisplayString(cp);
					acceptor.accept(pp.createCompletionProposal(oneRealizedCP,proposalString, null, context));
					result += oneRealizedCP;						 
			 }
			 result += "]";
		 }
		/**
		 * Only do the "all" if nothing has been done yet
		 */
		if (realized.isEmpty() && realizedParticipants.isEmpty()) {
			acceptor.accept(pp.createCompletionProposal(result, realizeAll, null, context));
		}
		else if (!unrealized.isEmpty() || !unrealizedParticipants.isEmpty()) {
			acceptor.accept(pp.createCompletionProposal(result, realizeRemaining, null, context));
		}

	}

	public void completeComposition_Rolename(UddlProposalProvider pp,RezProcessor rproc,RealizingEntity rentity, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeSuperRealizingComposition_Rolename(pp, rentity, assignment, context, acceptor);

		// Pick out the roles from the list of unrealized Compositions
		for (BaseComposition cc : rproc.getUnrealizedCompositions(rentity)) {
				// If this one isn't already realized, then add it to the proposal
			String oneRealizedCC = compositionInsertionString(cc) ;
			String displayString = proposalDisplayString(cc);
				acceptor.accept(pp.createCompletionProposal(oneRealizedCC, displayString, null, context));
		}
	}

	public void completeComposition_Realizes(UddlProposalProvider pp,RezProcessor rproc,RealizingEntity rentity, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {

		for (BaseComposition cc : rproc.getUnrealizedCompositions(rentity)) {
				String displayString = proposalDisplayString(cc);		
				acceptor.accept(pp.createCompletionProposal(qnp.getFullyQualifiedName(cc).toString(),
						displayString, null, context));
		}
		
	}

}
