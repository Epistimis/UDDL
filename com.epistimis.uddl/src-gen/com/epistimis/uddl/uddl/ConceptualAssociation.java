/**
 * generated by Xtext 2.30.0
 * Copyright (c) 2022, 2023 Epistimis LLC (http://www.epistimis.com) and others.
 */
package com.epistimis.uddl.uddl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conceptual Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.epistimis.uddl.uddl.ConceptualAssociation#getConceptualBasisEntity <em>Conceptual Basis Entity</em>}</li>
 *   <li>{@link com.epistimis.uddl.uddl.ConceptualAssociation#getParticipant <em>Participant</em>}</li>
 * </ul>
 *
 * @see com.epistimis.uddl.uddl.UddlPackage#getConceptualAssociation()
 * @model
 * @generated
 */
public interface ConceptualAssociation extends ConceptualEntity
{
  /**
   * Returns the value of the '<em><b>Conceptual Basis Entity</b></em>' reference list.
   * The list contents are of type {@link com.epistimis.uddl.uddl.ConceptualBasisEntity}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conceptual Basis Entity</em>' reference list.
   * @see com.epistimis.uddl.uddl.UddlPackage#getConceptualAssociation_ConceptualBasisEntity()
   * @model
   * @generated
   */
  EList<ConceptualBasisEntity> getConceptualBasisEntity();

  /**
   * Returns the value of the '<em><b>Participant</b></em>' containment reference list.
   * The list contents are of type {@link com.epistimis.uddl.uddl.ConceptualParticipant}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Participant</em>' containment reference list.
   * @see com.epistimis.uddl.uddl.UddlPackage#getConceptualAssociation_Participant()
   * @model containment="true"
   * @generated
   */
  EList<ConceptualParticipant> getParticipant();

} // ConceptualAssociation
