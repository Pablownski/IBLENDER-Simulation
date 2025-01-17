/**
 * Grupo de Trabajo:
 * Santiago Cordero Quirós 24472
 * Juan Pablo Salguero 24374
 * Diego Gudiel 24451
 */

public class Blender implements IBlender {
    public int speed;
    public boolean full;
    public final int MAX_SPEED = 10;

    public Blender(){
        this.speed = 0;
        this.full = false;
    }

    public int GetSpeed() {
        return this.speed;
    }

    public boolean isFull(){
        return this.full;
    }

    public void Fill(){
        if (this.full){
            return;
        }else{
            this.full = true;
        }
    }

    public void Empty(){
        if (!this.full){
            return;
        }else{
            this.full = false;
        }
    }


}
