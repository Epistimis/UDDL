/*
 * generated by Xtext 2.30.0
 */
/*
 * Copyright (c) 2022, 2023 Epistimis LLC (http://www.epistimis.com) and others.
 */
package com.epistimis.uddl.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;

import com.epistimis.uddl.ui.hover.UddlDispatchingEObjectTextHover;
import com.epistimis.uddl.ui.hover.UddlEObjectDocumentationProvider;
import com.epistimis.uddl.ui.hover.UddlEObjectHoverProvider;

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
public class UddlUiModule extends AbstractUddlUiModule {

	public UddlUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	public Class<? extends IEObjectHover> bindIEObjectHover() {
		return UddlDispatchingEObjectTextHover.class;
	}
	
	public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return UddlEObjectHoverProvider.class;
	}
	
    public Class<? extends IEObjectDocumentationProvider> bindIEObjectDocumentationProvider() {
        return UddlEObjectDocumentationProvider.class;
    }
}
