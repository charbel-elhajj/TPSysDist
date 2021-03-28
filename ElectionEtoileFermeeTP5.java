import visidia.simulation.SimulationConstants;
import visidia.simulation.process.algorithm.LC0_Algorithm;
import visidia.simulation.process.algorithm.LC1_Algorithm;
import visidia.simulation.process.algorithm.LC2_Algorithm;
import visidia.simulation.process.edgestate.MarkedState;

/**
 *
 * @author Charbel
 */
public class ElectionEtoileFermeeTP5 extends LC2_Algorithm{

    @Override
    public String getDescription() {
        return "Etoile fermee election";
        
    }

    @Override
    protected void beforeStart() {
    	
        this.setLocalProperty("label", vertex.getLabel());
        this.setLocalProperty("counter", vertex.getDegree());
        putProperty("Affichage", getLocalProperty("counter") ,SimulationConstants.PropertyStatus.DISPLAYED);
        
    }

    @Override
    protected void onStarCenter() {
    	
        if(this.getLocalProperty("label").equals("N")) {
        	int count = (int)getLocalProperty("counter");
        	if(count == 0) {
        		this.setLocalProperty("label","E");
        	}
        	else {
        		int removedCount = 0;
        		for(int i = 0; i < getActiveDoors().size(); i++) {
            		int numPort = getActiveDoors().get(i);
            		
            		if(this.getNeighborProperty(numPort, "label").equals("N")
            				&&(int)this.getNeighborProperty(numPort, "counter") == 1) {
            			this.setNeighborProperty(numPort, "label","F");
            			removedCount++;
            		}
            		
            	}
        		this.setLocalProperty("counter", (count - removedCount));
        	}
        	
        	
        	
        }
        else if(this.getLocalProperty("label").equals("F")||this.getLocalProperty("label").equals("E")) {
        	this.localTermination();
        }
        
        putProperty("Affichage", getLocalProperty("counter") ,SimulationConstants.PropertyStatus.DISPLAYED);       
        
    }


    @Override
    public Object clone() {
        return new ElectionEtoileFermeeTP5();
    }
    
   
    
   
    
}
