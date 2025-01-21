/**
 * Grupo de Trabajo:
 * Santiago Cordero Quirós 24472
 * Juan Pablo Salguero 24374
 * Diego Gudiel 24451
 */

public class Blender implements IBlender{
    private int speed;
    private boolean full;
    private final int MAX_SPEED = 10;

    public Blender(){
        this.speed = 0;
        this.full = false;
    }

    public int GetSpeed() {
        return this.speed;
    }

    public int getMaxSpeed(){
        return this.MAX_SPEED;
    }

    public boolean IsFull(){
        return this.full;
    }

    public void Fill() {
        this.full = true;
    }

    public void Empty() {
        this.full = false;
    }

    public void SpeedUp() {
        if (this.speed < MAX_SPEED) {
            this.speed++;
        }
    }

    public void SpeedDown() {
        if (this.speed > 0) {
            this.speed--;
        }
    }
}
