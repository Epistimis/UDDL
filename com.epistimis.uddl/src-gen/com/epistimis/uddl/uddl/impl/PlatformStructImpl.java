/**
 * generated by Xtext 2.30.0
 * Copyright (c) 2022, 2023 Epistimis LLC (http://www.epistimis.com) and others.
 */
package com.epistimis.uddl.uddl.impl;

import com.epistimis.uddl.uddl.PlatformStruct;
import com.epistimis.uddl.uddl.PlatformStructMember;
import com.epistimis.uddl.uddl.UddlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Platform Struct</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.epistimis.uddl.uddl.impl.PlatformStructImpl#getMember <em>Member</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PlatformStructImpl extends PlatformDataTypeImpl implements PlatformStruct
{
  /**
   * The cached value of the '{@link #getMember() <em>Member</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMember()
   * @generated
   * @ordered
   */
  protected EList<PlatformStructMember> member;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PlatformStructImpl()
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
    return UddlPackage.Literals.PLATFORM_STRUCT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<PlatformStructMember> getMember()
  {
    if (member == null)
    {
      member = new EObjectContainmentEList<PlatformStructMember>(PlatformStructMember.class, this, UddlPackage.PLATFORM_STRUCT__MEMBER);
    }
    return member;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case UddlPackage.PLATFORM_STRUCT__MEMBER:
        return ((InternalEList<?>)getMember()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case UddlPackage.PLATFORM_STRUCT__MEMBER:
        return getMember();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case UddlPackage.PLATFORM_STRUCT__MEMBER:
        getMember().clear();
        getMember().addAll((Collection<? extends PlatformStructMember>)newValue);
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
      case UddlPackage.PLATFORM_STRUCT__MEMBER:
        getMember().clear();
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
      case UddlPackage.PLATFORM_STRUCT__MEMBER:
        return member != null && !member.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //PlatformStructImpl
