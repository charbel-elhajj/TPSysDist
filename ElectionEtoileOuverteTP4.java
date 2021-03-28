import visidia.simulation.SimulationConstants;
import visidia.simulation.process.algorithm.LC0_Algorithm;
import visidia.simulation.process.algorithm.LC1_Algorithm;
import visidia.simulation.process.edgestate.MarkedState;

/**
 *
 * @author Charbel
 */
public class ElectionEtoileOuverteTP4 extends LC1_Algorithm{
	String etatsVoisins[];
	int fatherDoor;

    @Override
    public String getDescription() {
        return "Etoile ouverte Election";
        
    }

    @Override
    protected void beforeStart() {
    	
        this.setLocalProperty("label", vertex.getLabel());
        
        
        
    }

    @Override
    protected void onStarCenter() {
    	
        if(this.getLocalProperty("label").equals("N")) {
        	int count = getNNeigborCount();
        	if(count==0) {
        		this.setLocalProperty("label","E");

        	}
        	else if(count == 1) {
        		this.setLocalProperty("label","F");
        	
        	}
        	
        }
               
        
    }

	private int getNNeigborCount() {
		int counter = 0;
		for(int i = 0; i < getActiveDoors().size(); i++) {
    		int numPort = getActiveDoors().get(i);
    		if(this.getNeighborProperty(numPort, "label").equals("N")) {
    			counter++;
    		}
    		
    	}
		return counter;
	}

    @Override
    public Object clone() {
        return new ElectionEtoileOuverteTP4();
    }
    
   
    
}
