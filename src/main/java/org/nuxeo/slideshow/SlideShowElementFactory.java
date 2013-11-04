/**
 * 
 */

package org.nuxeo.slideshow;

import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.adapter.DocumentAdapterFactory;

/**
 * @author ldoguin
 */
public class SlideShowElementFactory implements DocumentAdapterFactory {

    @Override
    public Object getAdapter(DocumentModel doc, Class<?> itf) {
        if (doc.hasFacet("Picture")) {
            return new SlideShowElement(doc);
        } else {
            return null;
        }
    }
}
