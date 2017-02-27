package hu.bme.mit.mate.szlovak.finalonlabtreeeditor;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import java.util.Map;

import hu.bme.mit.mate.szlovak.okosgyar.OkosGyar;
import hu.bme.mit.mate.szlovak.okosgyar.OkosGyarPackage;

public class LoadGyarEMF {
    public OkosGyar load() {
        OkosGyarPackage.eINSTANCE.eClass();

        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("okosgyar", new XMIResourceFactoryImpl());

        ResourceSet resSet = new ResourceSetImpl();
        //File sdcard = Environment.getExternalStorageDirectory();
        // Resource resource = resSet.getResource(URI.createURI("/storage/emulated/0/onlab/MyOkosGyar.okosgyar"), true);
        // if(resource == null){
        Resource resource = resSet.getResource(URI.createURI("/sdcard/okosgyar/myokosgyar.okosgyar"), true);
        // }

        OkosGyar ogy = (OkosGyar) resource.getContents().get(0);
        return ogy;
    }
}
