class Solution {
    public double angleClock(int h, int m) {
        double ma = 6.0 * m;// min angle 
        double ha = 30.0 * (h % 12) + 0.5 * m;// hour angle
        double diff = Math.abs(ha - ma);
        return Math.min(diff, 360.0 - diff);
    }
}