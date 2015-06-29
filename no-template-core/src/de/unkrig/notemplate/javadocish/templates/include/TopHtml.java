
/*
 * No-Template - an extremely light-weight templating framework
 *
 * Copyright (c) 2015, Arno Unkrig
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of conditions and the
 *       following disclaimer.
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
 *       following disclaimer in the documentation and/or other materials provided with the distribution.
 *    3. The name of the author may not be used to endorse or promote products derived from this software without
 *       specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package de.unkrig.notemplate.javadocish.templates.include;

import java.text.SimpleDateFormat;

import de.unkrig.commons.nullanalysis.Nullable;
import de.unkrig.notemplate.NoTemplate;
import de.unkrig.notemplate.javadocish.Options;

/**
 * Renders the "top" of a JAVADOCish page (ending with "{@code <body>}").
 */
public
class TopHtml extends NoTemplate {

    /**
     * Renders the "top" of a JAVADOCish page (ending with "{@code <body>}").
     *
     * @param windowTitle The text for the {@code <html><head><title>} element
     */
    public void
    render(String windowTitle, Options options, @Nullable String stylesheetLink) {

        this.l(
"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">",
"<!-- NewPage -->",
"<html lang=\"de\">",
"<head>"
        );

        // "Generator / generation date" HTML comment.
        if (!options.noTimestamp) {
            this.l(
"<!-- Generated by " + options.generator + (options.noTimestamp ? "" : " on " + options.generationDate) + " -->"
            );
        }

        // HTML window title.
        this.l(
"<title>" + windowTitle + (options.windowTitle == null ? "" : " (" + options.windowTitle + ")") + "</title>"
        );

        // Generation date meta entry.
        if (!options.noTimestamp) {
            this.l(
"<meta name=\"date\" content=\"" + new SimpleDateFormat("yyyy-MM-dd").format(options.generationDate) + "\">"
            );
        }

        // Include stylesheet.
        if (stylesheetLink != null) {
            this.l(
"<link rel=\"stylesheet\" type=\"text/css\" href=\"" + stylesheetLink + "\" title=\"Style\">"
            );
        }

        this.l(
"</head>",
"<body>"
        );
    }
}
