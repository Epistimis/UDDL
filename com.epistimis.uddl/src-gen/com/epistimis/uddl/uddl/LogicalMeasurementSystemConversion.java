/**
 * generated by Xtext 2.30.0
 * Copyright (c) 2022, 2023 Epistimis LLC (http://www.epistimis.com) and others.
 */
package com.epistimis.uddl.uddl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logical Measurement System Conversion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.epistimis.uddl.uddl.LogicalMeasurementSystemConversion#getSource <em>Source</em>}</li>
 *   <li>{@link com.epistimis.uddl.uddl.LogicalMeasurementSystemConversion#getDestination <em>Destination</em>}</li>
 *   <li>{@link com.epistimis.uddl.uddl.LogicalMeasurementSystemConversion#getEquation <em>Equation</em>}</li>
 *   <li>{@link com.epistimis.uddl.uddl.LogicalMeasurementSystemConversion#getConversionLossDescription <em>Conversion Loss Description</em>}</li>
 * </ul>
 *
 * @see com.epistimis.uddl.uddl.UddlPackage#getLogicalMeasurementSystemConversion()
 * @model
 * @generated
 */
public interface LogicalMeasurementSystemConversion extends LogicalElement
{
  /**
   * Returns the value of the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference.
   * @see #setSource(LogicalMeasurementSystem)
   * @see com.epistimis.uddl.uddl.UddlPackage#getLogicalMeasurementSystemConversion_Source()
   * @model
   * @generated
   */
  LogicalMeasurementSystem getSource();

  /**
   * Sets the value of the '{@link com.epistimis.uddl.uddl.LogicalMeasurementSystemConversion#getSource <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' reference.
   * @see #getSource()
   * @generated
   */
  void setSource(LogicalMeasurementSystem value);

  /**
   * Returns the value of the '<em><b>Destination</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Destination</em>' reference.
   * @see #setDestination(LogicalMeasurementSystem)
   * @see com.epistimis.uddl.uddl.UddlPackage#getLogicalMeasurementSystemConversion_Destination()
   * @model
   * @generated
   */
  LogicalMeasurementSystem getDestination();

  /**
   * Sets the value of the '{@link com.epistimis.uddl.uddl.LogicalMeasurementSystemConversion#getDestination <em>Destination</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Destination</em>' reference.
   * @see #getDestination()
   * @generated
   */
  void setDestination(LogicalMeasurementSystem value);

  /**
   * Returns the value of the '<em><b>Equation</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Equation</em>' attribute list.
   * @see com.epistimis.uddl.uddl.UddlPackage#getLogicalMeasurementSystemConversion_Equation()
   * @model unique="false"
   * @generated
   */
  EList<String> getEquation();

  /**
   * Returns the value of the '<em><b>Conversion Loss Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conversion Loss Description</em>' attribute.
   * @see #setConversionLossDescription(String)
   * @see com.epistimis.uddl.uddl.UddlPackage#getLogicalMeasurementSystemConversion_ConversionLossDescription()
   * @model
   * @generated
   */
  String getConversionLossDescription();

  /**
   * Sets the value of the '{@link com.epistimis.uddl.uddl.LogicalMeasurementSystemConversion#getConversionLossDescription <em>Conversion Loss Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Conversion Loss Description</em>' attribute.
   * @see #getConversionLossDescription()
   * @generated
   */
  void setConversionLossDescription(String value);

} // LogicalMeasurementSystemConversion
