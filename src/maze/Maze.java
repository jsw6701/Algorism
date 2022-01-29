package maze;

public class Maze {
    private static int N = 8;
    private static int[][] maze = {
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0, 1, 0, 0},
    };

    private static final int PATHWAY_COLOUR = 0; // 아직 지나가지 않은 통로
    private static final int WALL_COLOUR = 1; // 벽
    private static final int BLOCKED_COLOUR = 2; // 가봤지만 정답은 아닌 통로
    private static final int PATH_COLOUR = 3; // 정답 통로

    public static boolean findMazePath(int x, int y){
        if(x<0 || y<0 || x>=N || y>=N){ //범위 밖
            return false;
        }
        else if(maze[x][y] != PATHWAY_COLOUR){
            return false;
        }
        else if(x==N-1 && y==N-1){ //출구
            return true;
        }
        else{
            maze[x][y] = PATH_COLOUR; // 정답통로로 먼저 바꿈
            //서 -> 북 -> 동 -> 남 순서
            if(findMazePath(x-1, y) || findMazePath(x, y+1) || findMazePath(x+1, y) || findMazePath(x, y-1)){
                return true;
            }
            maze[x][y] = BLOCKED_COLOUR; // 서북동서에 다 없으면 막힌 통로로 바꿈
            return false;
        }
    }
    public static void printMaze() {
        // 2차원 배열 출력 메서드
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    public static void main(String[] args){
        printMaze();
        findMazePath(0, 0);
        printMaze();
    }
}



