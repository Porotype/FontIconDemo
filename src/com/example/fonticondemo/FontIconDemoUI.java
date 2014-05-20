package com.example.fonticondemo;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("fonticondemo")
public class FontIconDemoUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = FontIconDemoUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        final Button button = new Button("Bookmark");
        layout.addComponent(button);

        // add font icon
        button.setIcon(FontAwesome.BOOKMARK);

        // add stylename to allow styling
        button.addStyleName("redicon");

        final Label label = new Label();
        layout.addComponent(label);

        // label should display HTML
        label.setContentMode(ContentMode.HTML);
        // add a font icon in the middle of the text
        label.setValue("Press the " + FontAwesome.BOOKMARK.getHtml()
                + " button to bookmark.");

        /*
         * Using customized font icon
         */
        final Button icoMoonButton = new Button("IcoMoon bookmark");
        layout.addComponent(icoMoonButton);
        icoMoonButton.setIcon(IcoMoon.RIBBON);
    }

}