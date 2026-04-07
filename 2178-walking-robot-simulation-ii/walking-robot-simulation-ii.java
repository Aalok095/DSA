class Robot {
    int idx = 0;
    boolean moved = false;
    List<int[]> pos = new ArrayList<>(); // {x,y,dir}
    public Robot(int width, int height) { // perimeter pe travel kar raha bkl robot
        // Bottom row (left to right) - East (0)
        for(int x=0;x<width;x++) pos.add(new int[]{x,0,0});

        // Right column (bottom to top) - North (1)
        for(int y=1;y<height;y++) pos.add(new int[]{width-1,y,1});

        // Top row (right to left) - West (2)
        for(int x=width-2;x>=0;x--) pos.add(new int[]{x,height-1,2});

        // Left column (top to bottom) - South (3)
        for(int y=height-2;y>0;y--) pos.add(new int[]{0,y,3});

        // Handle corner case for (0,0) after movement
        pos.get(0)[2] = 3; // ek round maar ke aaya hai matlab
    }
    
    public void step(int num) {
        moved = true;
        idx = (idx+num)%pos.size();
    }
    
    public int[] getPos() {
        return new int[]{pos.get(idx)[0],pos.get(idx)[1]};
    }
    
    public String getDir() {
        if (!moved) return "East";

        int dir = pos.get(idx)[2];

        if (dir == 0) return "East";
        else if (dir == 1) return "North";
        else if (dir == 2) return "West";
        return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */