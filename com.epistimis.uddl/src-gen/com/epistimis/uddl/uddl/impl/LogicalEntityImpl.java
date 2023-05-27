/**
 * generated by Xtext 2.30.0
 * Copyright (c) 2022, 2023 Epistimis LLC (http://www.epistimis.com) and others.
 */
package com.epistimis.uddl.uddl.impl;

import com.epistimis.uddl.uddl.ConceptualEntity;
import com.epistimis.uddl.uddl.LogicalComposition;
import com.epistimis.uddl.uddl.LogicalEntity;
import com.epistimis.uddl.uddl.UddlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Logical Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.epistimis.uddl.uddl.impl.LogicalEntityImpl#getSpecializes <em>Specializes</em>}</li>
 *   <li>{@link com.epistimis.uddl.uddl.impl.LogicalEntityImpl#getRealizes <em>Realizes</em>}</li>
 *   <li>{@link com.epistimis.uddl.uddl.impl.LogicalEntityImpl#getComposition <em>Composition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LogicalEntityImpl extends LogicalComposableElementImpl implements LogicalEntity
{
  /**
   * The cached value of the '{@link #getSpecializes() <em>Specializes</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpecializes()
   * @generated
   * @ordered
   */
  protected LogicalEntity specializes;

  /**
   * The cached value of the '{@link #getRealizes() <em>Realizes</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRealizes()
   * @generated
   * @ordered
   */
  protected ConceptualEntity realizes;

  /**
   * The cached value of the '{@link #getComposition() <em>Composition</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComposition()
   * @generated
   * @ordered
   */
  protected EList<LogicalComposition> composition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LogicalEntityImpl()
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
    return UddlPackage.Literals.LOGICAL_ENTITY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LogicalEntity getSpecializes()
  {
    if (specializes != null && specializes.eIsProxy())
    {
      InternalEObject oldSpecializes = (InternalEObject)specializes;
      specializes = (LogicalEntity)eResolveProxy(oldSpecializes);
      if (specializes != oldSpecializes)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UddlPackage.LOGICAL_ENTITY__SPECIALIZES, oldSpecializes, specializes));
      }
    }
    return specializes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalEntity basicGetSpecializes()
  {
    return specializes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSpecializes(LogicalEntity newSpecializes)
  {
    LogicalEntity oldSpecializes = specializes;
    specializes = newSpecializes;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UddlPackage.LOGICAL_ENTITY__SPECIALIZES, oldSpecializes, specializes));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ConceptualEntity getRealizes()
  {
    if (realizes != null && realizes.eIsProxy())
    {
      InternalEObject oldRealizes = (InternalEObject)realizes;
      realizes = (ConceptualEntity)eResolveProxy(oldRealizes);
      if (realizes != oldRealizes)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UddlPackage.LOGICAL_ENTITY__REALIZES, oldRealizes, realizes));
      }
    }
    return realizes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConceptualEntity basicGetRealizes()
  {
    return realizes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRealizes(ConceptualEntity newRealizes)
  {
    ConceptualEntity oldRealizes = realizes;
    realizes = newRealizes;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UddlPackage.LOGICAL_ENTITY__REALIZES, oldRealizes, realizes));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<LogicalComposition> getComposition()
  {
    if (composition == null)
    {
      composition = new EObjectContainmentEList<LogicalComposition>(LogicalComposition.class, this, UddlPackage.LOGICAL_ENTITY__COMPOSITION);
    }
    return composition;
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
      case UddlPackage.LOGICAL_ENTITY__COMPOSITION:
        return ((InternalEList<?>)getComposition()).basicRemove(otherEnd, msgs);
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
      case UddlPackage.LOGICAL_ENTITY__SPECIALIZES:
        if (resolve) return getSpecializes();
        return basicGetSpecializes();
      case UddlPackage.LOGICAL_ENTITY__REALIZES:
        if (resolve) return getRealizes();
        return basicGetRealizes();
      case UddlPackage.LOGICAL_ENTITY__COMPOSITION:
        return getComposition();
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
      case UddlPackage.LOGICAL_ENTITY__SPECIALIZES:
        setSpecializes((LogicalEntity)newValue);
        return;
      case UddlPackage.LOGICAL_ENTITY__REALIZES:
        setRealizes((ConceptualEntity)newValue);
        return;
      case UddlPackage.LOGICAL_ENTITY__COMPOSITION:
        getComposition().clear();
        getComposition().addAll((Collection<? extends LogicalComposition>)newValue);
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
      case UddlPackage.LOGICAL_ENTITY__SPECIALIZES:
        setSpecializes((LogicalEntity)null);
        return;
      case UddlPackage.LOGICAL_ENTITY__REALIZES:
        setRealizes((ConceptualEntity)null);
        return;
      case UddlPackage.LOGICAL_ENTITY__COMPOSITION:
        getComposition().clear();
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
      case UddlPackage.LOGICAL_ENTITY__SPECIALIZES:
        return specializes != null;
      case UddlPackage.LOGICAL_ENTITY__REALIZES:
        return realizes != null;
      case UddlPackage.LOGICAL_ENTITY__COMPOSITION:
        return composition != null && !composition.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //LogicalEntityImpl
