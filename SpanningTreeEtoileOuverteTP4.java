import visidia.simulation.SimulationConstants;
import visidia.simulation.process.algorithm.LC0_Algorithm;
import visidia.simulation.process.algorithm.LC1_Algorithm;
import visidia.simulation.process.edgestate.MarkedState;

/**
 *
 * @author Charbel
 */
public class SpanningTreeEtoileOuverteTP4 extends LC1_Algorithm{


    @Override
    public String getDescription() {
        return "Etoile ouverte";
        
    }

    @Override
    protected void beforeStart() {
    	
        this.setLocalProperty("label", vertex.getLabel());
        
        
        
    }

    @Override
    protected void onStarCenter() {
    	
        if(this.getLocalProperty("label").equals("N")) {
        	int index = hasActiveNeighbor();
        	if(index>=0) {
        		this.setLocalProperty("label","A");
        		this.setDoorState(new MarkedState(true), index);
        	}
        	
        }
               
        
    }

	private int hasActiveNeighbor() {
		for(int i = 0; i < getActiveDoors().size(); i++) {
    		int numPort = getActiveDoors().get(i);
    		if(this.getNeighborProperty(numPort, "label").equals("A")) {
    			return i;
    		}
    		
    	}
		return -1;
	}

    @Override
    public Object clone() {
        return new SpanningTreeEtoileOuverteTP4();
    }
    
   
    
}
