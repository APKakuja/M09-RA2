public class Forquilla {

    private int forquilla;
    private boolean enUs;


    public Forquilla(int forquilla) {

        this.forquilla = forquilla;
        this.enUs = false;
    }
    
    public int getForquilla() {
        return forquilla;
    }

    public boolean isenUs() { 
        return this.enUs;
     }

     public void setEnUs(boolean enUs) { 
        this.enUs = enUs; 
    }

}