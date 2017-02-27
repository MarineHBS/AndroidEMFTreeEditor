package hu.bme.mit.mate.szlovak.finalonlabtreeeditor;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import hu.bme.mit.mate.szlovak.okosgyar.Alkatresz;
import hu.bme.mit.mate.szlovak.okosgyar.Hordozo;
import hu.bme.mit.mate.szlovak.okosgyar.OkosGyar;
import hu.bme.mit.mate.szlovak.okosgyar.Robot;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        File sdcard = Environment.getExternalStorageDirectory();
        //String rootPath= sdcard.getPath() + "/onlab";
        File file = new File(sdcard, "/onlab/MyOkosGyar.okosgyar");
        StringBuilder text = new StringBuilder();
        TextView tester = (TextView) findViewById(R.id.tester);


        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
        }
        catch (IOException e) {
        }

        TreeNode root = TreeNode.root();
        TreeNode parent = new TreeNode("Asd");
        root.addChild(parent);

        AndroidTreeView tView = new AndroidTreeView(MainActivity.this, root);

        //Intent i = new Intent(MainActivity.this, SingleFragmentActivity.class);
        //MainActivity.this.startActivity(i);
        /*
        LoadGyarEMF loader = new LoadGyarEMF();
        OkosGyar ogy = loader.load();
        System.out.println(ogy.getNev());




        for(Iterator<Robot> iterator = ogy.getRobot().iterator(); iterator.hasNext();){
            Robot r = iterator.next();
            System.out.println("Id of robot: " + r.getId());
            for(Iterator<Hordozo> iterator1 = r.getHordozo().iterator(); iterator1.hasNext();){
                Hordozo h = iterator1.next();
                System.out.println("Id of robot: " + r.getId() + " Id of Hordozo: " + h.getId());
                for(Iterator<Alkatresz> iterator2 = h.getAlkatresz().iterator(); iterator2.hasNext();){
                    Alkatresz a = iterator2.next();
                    System.out.println("Id of robot: "+ r.getId() + " Id of Hordozo: " + h.getId() + " Alkatresz sulya: "
                            + a.getSuly() + "kg Alkatresz neve: " + a.getNev());
                }
            }
        }*/

        //System.out.println(text);


        tester.setText(text);

    }
}
