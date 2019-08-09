/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dev.navids.soottutorial;

import dev.navids.soottutorial.visual.Visualizer;
import soot.*;
import soot.jimple.toolkits.callgraph.Edge;
import soot.options.Options;
import soot.toolkits.graph.ClassicCompleteUnitGraph;
import soot.toolkits.graph.UnitGraph;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.Iterator;

public class App {

    public static void setupSoot(){
        G.reset();
        String sourcePath = System.getProperty("user.dir") + "/demo/one";
        String mainClassPath = sourcePath + "/A.java";
        Options.v().set_process_dir(Collections.singletonList(sourcePath));
        Options.v().set_allow_phantom_refs(true);
        Options.v().set_whole_program(true);
        Options.v().set_soot_classpath(sourcePath);
//        Options.v().set_src_prec(Options.src_prec_J);
        Options.v().set_output_format(Options.output_format_jimple);
//        Options.v().set_output_format(Options.output_format_jimple);

//        Options.v().set_soot_classpath(sourcePath);


        Scene.v().loadNecessaryClasses();

        PackManager.v().runPacks();

    }

    public static void main(String[] args) {
        setupSoot();
        SootClass mainClass = Scene.v().getMainClass();
        SootMethod sm = mainClass.getMethodByName("multiply");
        UnitGraph ug = new ClassicCompleteUnitGraph(sm.getActiveBody());

        Visualizer.v().addUnitGraph(ug);

//        sm = mainClass.getMethodByName("getSumOneToN");
//        ug = new ClassicCompleteUnitGraph(sm.getActiveBody());
//        Visualizer.v().addUnitGraph(ug);
//
        Visualizer.v().addCallGraph(Scene.v().getCallGraph());

        Visualizer.v().draw();
        System.out.print("s");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Visualizer.v().close();
    }
}
