package World;

import com.sun.javafx.geom.transform.BaseTransform;

import java.util.Random;

/**
 * @Author: Zhang Yuxin
 * @Date: 2018/2/23
 */
public class Location {
    int coldownsize = 1;
    int colupsize = 2;
    int rowdownsize = 1;
    int rowupsize = 2;
    int col;
    int row;
//    int [][] location = new int[1000][1000];


    public Location(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
public void setsize(int colup,int rowup,int coldown,int rowdown){
        this.rowdownsize = rowdown;
        this.rowupsize = rowup;
        this.coldownsize = coldown;
        this.colupsize = colup;
}
public int[] getsize(){
    int[] size = new int[3];
    size[1] = colupsize;
    size[2] = rowupsize;
    return size;
}
    void InitialLoc() {
        Random randomcol = new Random();
        int RandLocCol = randomcol.nextInt(3);
        this.col = RandLocCol + 1;
        Random randomrow = new Random();
        int RandLocRow = randomrow.nextInt(3);
        this.row = RandLocRow + 1;
    }

    boolean IsSame(Location location) {
        int rowin = location.getRow();
        int colin = location.getCol();
        if (this.row == rowin && this.col == colin) {
            return true;
        } else {
            return false;
        }
    }

    void ChangeLoc() {
        ChangeCol();
        ChangeRow();
        if (this.col > 3 || this.row > 3) {
            InitialLoc();
        }
    }

    void ChangeCol() {
        if (col == coldownsize) {
            Random random = new Random();
            int proba = random.nextInt(2);
            if (proba == 0) {
                this.col++;
            }
        } else if (col == colupsize) {
            Random random = new Random();
            int proba = random.nextInt(2);
            if (proba == 0) {
                this.col--;
            }
        } else {
            Random randcol = new Random();
            int rand = randcol.nextInt(3);
            switch (rand) {
                case 0:
                    this.col--;
                    break;
                case 1:
                    this.col++;
                    break;
                case 2:
                    break;
            }
        }
    }

    void ChangeRow() {
        if (row == rowdownsize) {
            Random rand1 = new Random();
            int rand1_1 = rand1.nextInt(2);
            if (rand1_1 == 0) {
                this.row++;
            }
        } else if (row == rowupsize) {
            if (row == rowdownsize) {
                Random rand1 = new Random();
                int rand1_1 = rand1.nextInt(2);
                if (rand1_1 == 0) {
                    this.row--;
                }
            } else {
                Random randrow = new Random();
                int rand = randrow.nextInt(3);
                switch (rand) {
                    case 0:
                        this.row--;
                        break;
                    case 1:
                        this.row++;
                        break;
                    case 2:
                        break;
                }
            }
        }
    }
}