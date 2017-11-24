package org.altervista.growworkinghard.jswmm;

import oms3.annotations.Execute;
import oms3.annotations.Finalize;
import oms3.annotations.Initialize;

class Routing {

    AbstractCrossSectionData crossSection;

    AbstractRoutingSolver routingSolver;

    @Initialize
    private void initialize() {
        if ( inputData != null ) {
            //Manage SWMMobject to fill fields of the class

        }
        if (circular){
            crossSection = new CircularCrossSectionData();
        }
        if (backwardsEuler){
            routingSolver = new BackwardEulerMethodRouting();
        }
    }

    @Execute
    public void run(){
        //for deltaT
        routingSolver.upgradeNodeHead();
        crossSection.evaluateGeometricData();
        routingMethod();
    }

    @Finalize
    private void updateSWMMobject() {
            //Manage SWMMobject to fill fields of the class

    }

    private void routingMethod(){
        //  for each Qi
        routingSolver.upgradeDischarge();
    }
}
