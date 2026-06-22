package net.CoffeDino.testmod.player;

public class ReaperSoulData {

    private int soulStacks = 0;
    private long lastGainTime = 0;

    public int getSoulStacks() {
        return soulStacks;
    }

    public void setSoulStacks(int stacks) {
        this.soulStacks = stacks;
    }

    public void addStack(int maxStacks) {
        if (soulStacks < maxStacks) {
            soulStacks++;
        }
    }

    public long getLastGainTime() {
        return lastGainTime;
    }

    public void setLastGainTime(long time) {
        this.lastGainTime = time;
    }
}
