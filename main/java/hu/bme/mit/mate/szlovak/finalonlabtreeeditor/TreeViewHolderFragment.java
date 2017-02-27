package hu.bme.mit.mate.szlovak.finalonlabtreeeditor;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;

import java.util.Iterator;

import emf.okosgyar.model.okosGyar.provider.AlkatreszItemProvider;
import hu.bme.mit.mate.szlovak.okosgyar.Alkatresz;
import hu.bme.mit.mate.szlovak.okosgyar.Hordozo;
import hu.bme.mit.mate.szlovak.okosgyar.OkosGyar;
import hu.bme.mit.mate.szlovak.okosgyar.Robot;


public class TreeViewHolderFragment extends Fragment {
    public AndroidTreeView tView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_tree, null, false);
        final ViewGroup containerView = (ViewGroup) rootView.findViewById(R.id.container);
        final TreeNode root = TreeNode.root();
        /*TreeNode robot1;
        TreeNode robot2;
        TreeNode hordozo1;
        TreeNode hordozo2;
        TreeNode alkatresz1;
        TreeNode alkatresz2;
        TreeNode alkatresz3;*/
        TreeNode ogy1;

        LoadGyarEMF loader = new LoadGyarEMF();
        OkosGyar ogy = loader.load();
        System.out.println(ogy.getNev());

        ogy1 = new TreeNode(new IconTreeItemHolder.IconTreeItem(1, ogy.getNev())).setViewHolder(new ProfileHolder(getActivity()));

        /*robot1 = new TreeNode(new IconTreeItemHolder.IconTreeItem(1, "Robot " +  ogy.getRobot().get(0).getId())).setViewHolder(new ProfileHolder(getActivity()));
        robot2 = new TreeNode(new IconTreeItemHolder.IconTreeItem(1, "Robot " +  ogy.getRobot().get(1).getId())).setViewHolder(new ProfileHolder(getActivity()));
        ogy1.setExpanded(true);
        hordozo1 = new TreeNode(new IconTreeItemHolder.IconTreeItem(1, "Hordozo " + ogy.getRobot().get(0).getHordozo().get(0).getId())).setViewHolder(new ProfileHolder(getActivity()));
        hordozo2 = new TreeNode(new IconTreeItemHolder.IconTreeItem(1, "Hordozo " + ogy.getRobot().get(1).getHordozo().get(0).getId())).setViewHolder(new ProfileHolder(getActivity()));

        alkatresz1 = new TreeNode("Alkatresz, suly:  " + ogy.getRobot().get(0).getHordozo().get(0).getAlkatresz().get(0).getSuly() +
                                "kg, nev: " + ogy.getRobot().get(0).getHordozo().get(0).getAlkatresz().get(0).getNev());
        alkatresz2 = new TreeNode("Alkatresz, suly:  " + ogy.getRobot().get(0).getHordozo().get(0).getAlkatresz().get(1).getSuly() +
                                "kg, nev: " + ogy.getRobot().get(0).getHordozo().get(0).getAlkatresz().get(1).getNev());
        alkatresz3 = new TreeNode("Alkatresz, suly:  " + ogy.getRobot().get(1).getHordozo().get(0).getAlkatresz().get(0).getSuly() +
                                 "kg, nev: " + ogy.getRobot().get(1).getHordozo().get(0).getAlkatresz().get(0).getNev());
        */

        //ogy1.addChild(robot1);
        for (Iterator<Robot> iterator = ogy.getRobot().iterator(); iterator.hasNext(); ) {
            Robot r = iterator.next();
            TreeNode robot = new TreeNode(new IconTreeItemHolder.IconTreeItem(1, "Robot " + r.getId())).setViewHolder(new ProfileHolder(getActivity()));
            ogy1.addChild(robot);
            //System.out.println("Id of robot: " + r.getId());
            for (Iterator<Hordozo> iterator1 = r.getHordozo().iterator(); iterator1.hasNext(); ) {
                Hordozo h = iterator1.next();
                TreeNode hordozo = new TreeNode(new IconTreeItemHolder.IconTreeItem(1, "Hordozo " + h.getId())).setViewHolder(new ProfileHolder(getActivity()));
                robot.addChild(hordozo);
                //System.out.println("Id of robot: " + r.getId() + " Id of Hordozo: " + h.getId());

                for (Iterator<Alkatresz> iterator2 = h.getAlkatresz().iterator(); iterator2.hasNext(); ) {
                    Alkatresz a = iterator2.next();
                    TreeNode alkatresz = new TreeNode("Alkatresz, suly:  " + a.getSuly() +
                            "kg, nev: " + a.getNev());
                    hordozo.addChild(alkatresz);

                    // System.out.println("Id of robot: "+ r.getId() + " Id of Hordozo: " + h.getId() + " Alkatresz sulya: "
                    //         + a.getSuly() + "kg Alkatresz neve: " + a.getNev());
                }
            }
        }

        /*
        hordozo1.addChildren(alkatresz1, alkatresz2);
        hordozo2.addChildren(alkatresz3);
        robot1.addChild(hordozo1);
        robot2.addChild(hordozo2);

        ogy1.addChildren(robot1, robot2);
        */
        root.addChild(ogy1);
        /*
        alkatresz1.setSelectable(false);
        alkatresz2.setSelectable(false);
        alkatresz3.setSelectable(false);
        hordozo1.setSelectable(false);
        hordozo2.setSelectable(false);
        robot1.setSelectable(false);
        robot2.setSelectable(false);
        */

        tView = new AndroidTreeView(getActivity(), root);
        containerView.addView(tView.getView());

        return rootView;
    }
}
