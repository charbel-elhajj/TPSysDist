import visidia.simulation.SimulationConstants;
import visidia.simulation.process.algorithm.LC0_Algorithm;
import visidia.simulation.process.algorithm.LC1_Algorithm;
import visidia.simulation.process.algorithm.LC2_Algorithm;
import visidia.simulation.process.edgestate.MarkedState;

/**
 *
 * @author Charbel
 */
public class SpanningTreeEtoileFermeeTP5 extends LC2_Algorithm{

    @Override
    public String getDescription() {
        return "Etoile fermee arbre recouvrant";
        
    }

    @Override
    protected void beforeStart() {
    	
        this.setLocalProperty("label", vertex.getLabel());
        
        
        
    }

    @Override
    protected void onStarCenter() {
    	
        if(this.getLocalProperty("label").equals("A")) {
        	int inactiveCounter = 0;
        	for(int i = 0; i < getActiveDoors().size(); i++) {
        		int numPort = getActiveDoors().get(i);
        		if(this.getNeighborProperty(numPort, "label").equals("N")) {
        			this.setNeighborProperty(numPort, "label","A");
        			this.setDoorState(new MarkedState(true), numPort);
        			inactiveCounter++;
        		}
        		        		
        	}
        	if(inactiveCounter == 0) {
        		this.localTermination();
        	}
        	
        }
               
        
    }

	

    @Override
    public Object clone() {
        return new SpanningTreeEtoileFermeeTP5();
    }
    
   
    
}
