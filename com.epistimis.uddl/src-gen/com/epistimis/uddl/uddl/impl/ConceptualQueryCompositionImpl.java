/**
 * generated by Xtext 2.30.0
 * Copyright (c) 2022, 2023 Epistimis LLC (http://www.epistimis.com) and others.
 */
package com.epistimis.uddl.uddl.impl;

import com.epistimis.uddl.uddl.ConceptualQueryComposition;
import com.epistimis.uddl.uddl.ConceptualView;
import com.epistimis.uddl.uddl.UddlPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conceptual Query Composition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.epistimis.uddl.uddl.impl.ConceptualQueryCompositionImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.epistimis.uddl.uddl.impl.ConceptualQueryCompositionImpl#getRolename <em>Rolename</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConceptualQueryCompositionImpl extends MinimalEObjectImpl.Container implements ConceptualQueryComposition
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected ConceptualView type;

  /**
   * The default value of the '{@link #getRolename() <em>Rolename</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRolename()
   * @generated
   * @ordered
   */
  protected static final String ROLENAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRolename() <em>Rolename</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRolename()
   * @generated
   * @ordered
   */
  protected String rolename = ROLENAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConceptualQueryCompositionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return UddlPackage.Literals.CONCEPTUAL_QUERY_COMPOSITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ConceptualView getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (ConceptualView)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UddlPackage.CONCEPTUAL_QUERY_COMPOSITION__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConceptualView basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setType(ConceptualView newType)
  {
    ConceptualView oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UddlPackage.CONCEPTUAL_QUERY_COMPOSITION__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getRolename()
  {
    return rolename;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRolename(String newRolename)
  {
    String oldRolename = rolename;
    rolename = newRolename;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UddlPackage.CONCEPTUAL_QUERY_COMPOSITION__ROLENAME, oldRolename, rolename));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case UddlPackage.CONCEPTUAL_QUERY_COMPOSITION__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case UddlPackage.CONCEPTUAL_QUERY_COMPOSITION__ROLENAME:
        return getRolename();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case UddlPackage.CONCEPTUAL_QUERY_COMPOSITION__TYPE:
        setType((ConceptualView)newValue);
        return;
      case UddlPackage.CONCEPTUAL_QUERY_COMPOSITION__ROLENAME:
        setRolename((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case UddlPackage.CONCEPTUAL_QUERY_COMPOSITION__TYPE:
        setType((ConceptualView)null);
        return;
      case UddlPackage.CONCEPTUAL_QUERY_COMPOSITION__ROLENAME:
        setRolename(ROLENAME_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case UddlPackage.CONCEPTUAL_QUERY_COMPOSITION__TYPE:
        return type != null;
      case UddlPackage.CONCEPTUAL_QUERY_COMPOSITION__ROLENAME:
        return ROLENAME_EDEFAULT == null ? rolename != null : !ROLENAME_EDEFAULT.equals(rolename);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (rolename: ");
    result.append(rolename);
    result.append(')');
    return result.toString();
  }

} //ConceptualQueryCompositionImpl
