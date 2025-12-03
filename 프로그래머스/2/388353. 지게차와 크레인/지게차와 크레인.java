import java.util.*;
class Solution {
        static int [] x= {-1,0,1,0};
    static int[] y= {0,1,0,-1};
   public static int solution(String[] storage, String[] requests) {
        int answer = 0;

        String[] cpp = new String[storage.length+2];
        int len = storage[0].length() + 2;
        String str = "";
        for (int i = 0; i < len; i++) {
            str += "0";
        }
        cpp[0] = str;
        int idx = 1;
        for (int i = 0; i < storage.length; i++) {
            cpp[idx++] = "0"+storage[i] +"0";
        }
        cpp[cpp.length-1] = str;

        int col = cpp[0].length();
        int row = cpp.length;
        String[][] board = new String[row][col];
        for (int i = 0; i < row; i++) {
            String[] split = cpp[i].split("");
            for (int j = 0; j < col; j++) {
                board[i][j] = split[j];
            }
        }
        for (int i = 0; i < requests.length; i++) {
            String request = requests[i];
            if(request.length()==1){
                basic(board, request);
            }else {
                crane(board, request);
            }
        }

        for (int i = 1; i < board[0].length-1; i++) {
            for (int j = 1; j < board.length-1; j++) {
                if(!board[j][i].equals("0")){
                    answer ++;
                }
            }
        }
        return answer;
    }

    public static boolean[][]  markOuterZero(String[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        if(board[0][0].equals("0")){
            visited[0][0] = true;
            queue.add(new int[]{0,0});
        }
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int ni = cur[0] + x[k];
                int nj = cur[1] + y[k];
                if (ni < 0 || ni >= row || nj < 0 || nj >= col) continue;
                if(board[ni][nj].equals("0") && !visited[ni][nj]){
                    visited[ni][nj] = true;
                    queue.add(new int[]{ni, nj});
                }
            }

        }
        return visited;
    }
    public static void basic(String[][] board , String req){
        int col = board[0].length;
        int row = board.length;

        boolean[][] visited = markOuterZero(board);
        List<int[]> removeTarget = new ArrayList<>();
        for (int i = 1; i < row-1; i++) {
            for (int j = 1; j < col-1; j++) {
                if(!board[i][j].equals(req)) continue;

                for (int k = 0; k < 4; k++) {
                    int ni = i + x[k];
                    int nj = j + y[k];
                    if (ni < 0 || ni >= row || nj < 0 || nj >= col) continue;
                    if(board[ni][nj].equals("0") && visited[ni][nj]){
                        removeTarget.add(new int[]{i,j});
                        visited[ni][nj] = true;
                        break;
                    }
                }
            }
        }
        for (int [] arr : removeTarget) {
            board[arr[0]][arr[1]] = "0";
        }
    }
    public static void crane(String[][] board , String req){
        int col = board[0].length;
        int row = board.length;
        char c = req.charAt(0);
        for (int i = 1; i < row-1; i++) {
            for (int j = 1; j < col-1; j++) {
                if(board[i][j].equals(String.valueOf(c))) {
                    board[i][j] = "0";
                }
            }
        }
    }
}