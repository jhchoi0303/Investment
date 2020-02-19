/*

문제
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.



*/

#include<cstdio>
#include<queue>
using namespace std;

struct Point {
	int x;
	int y;
};

int dist[100][100];
int a[100][100];

int dx[] = { 1, -1, 0, 0 };
int dy[] = { 0, 0, 1, -1 };



int main() {
	int n, m;
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%1d", &a[i][j]);
		}
	}

	queue<Point> q;
	dist[0][0] = 1;
	q.push({0,0});
	
	while (!q.empty()) {
		Point current = q.front();
		q.pop();
		if (current.x==n-1 &&current.y== m-1) {
			printf("%d",dist[n-1][m-1]);
		}
		for (int i =0; i<4; i++) {
			int nx =current.x+dx[i]; int ny =current.y+dy[i];
			if (nx>=0 && nx<n && ny>=0 && ny<m && a[nx][ny] 
			&& dist[nx][ny] == 0) {
				if (a[nx][ny]) {
					q.push({nx,ny});
					a[nx][ny] = 0;
					dist[nx][ny] = dist[current.x][current.y] + 1;
				}
			}
		}
	}
}
