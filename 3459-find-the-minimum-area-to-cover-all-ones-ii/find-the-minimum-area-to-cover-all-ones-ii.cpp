class Solution {
public:
    // Function to calculate the minimum area of rectangle enclosing all ones in a submatrix 
    long long ma(vector<vector<int>>& grid, int st_i, int en_i, int st_j, int en_j) {
        long long top = -1, bottom = -1, left = -1, right = -1;
        
        for(int i=st_i;i<=en_i;i++)
        {
            for(int j=st_j;j<=en_j;j++)
            {
                if(grid[i][j]==1)
                {
                    if(top==-1) top=i;
                    bottom=i;
                }
            }
        } // n*m
        
        for(int i=st_j;i<=en_j;i++)
        {
            for(int j=st_i;j<=en_i;j++)
            {
                if(grid[j][i]==1)
                {
                    if(left==-1) left=i;
                    right=i;
                }
            }
        } //n*m
        
        long long area = (right-left+1)*(bottom-top+1);
        return area;
    }
    
    int minimumSum(vector<vector<int>>& grid) {
        long long i, j, m = grid.size(), n = grid[0].size(), ans = 1e9, a1, a2, a3;

        // Case 1
        for (int i = 0; i < m; i++) {
            a1 = ma(grid, 0, i, 0, n-1);
            for (int j = 0; j < n; j++) {       
                a2 = ma(grid, i+1, m-1, 0, j);
                a3 = ma(grid, i+1, m-1, j+1, n-1);
                ans = min(ans, a1+a2+a3);
            }
        }

        // Case 2
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {       
                a1 = ma(grid, 0, i, 0, j);
                a2 = ma(grid, 0, i, j+1, n-1);
                a3 = ma(grid, i+1, m-1, 0, n-1);  
                ans = min(ans, a1+a2+a3);   
            }
        }

        // Case 3
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {        
                a1 = ma(grid, 0, m-1, 0, j);
                a2 = ma(grid, 0, i, j+1, n-1);
                a3 = ma(grid, i+1, m-1, j+1, n-1);    
                ans = min(ans, a1+a2+a3);
            }
        }

        // Case 4
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {   
                a1 = ma(grid, 0, i, 0, j);
                a2 = ma(grid, i+1, m-1, 0, j);    
                a3 = ma(grid, 0, m-1, j+1, n-1);
                ans = min(ans, a1+a2+a3);
            }
        }

        // Case 5
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                a1 = ma(grid, 0, m - 1, 0, i);
                a2 = ma(grid, 0, m - 1, i + 1, j);
                a3 = ma(grid, 0, m - 1, j + 1, n - 1);
                ans = min(ans, a1 + a2 + a3);
            }
        }

        // Case 6
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                a1 = ma(grid, 0, i, 0, n - 1);
                a2 = ma(grid, i + 1, j, 0, n - 1);
                a3 = ma(grid, j + 1, m - 1, 0, n - 1);
                ans = min(ans, a1 + a2 + a3);
            }
        }
        
        return ans;
    }
};